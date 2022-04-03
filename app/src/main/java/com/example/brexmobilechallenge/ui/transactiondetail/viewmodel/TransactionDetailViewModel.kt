package com.example.brexmobilechallenge.ui.transactiondetail.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.example.brexmobilechallenge.ui.categorylist.view.CategoryListActivity
import com.example.brexmobilechallenge.ui.transactiondetail.interactor.TransactionDetailInteractor
import com.example.brexmobilechallenge.ui.transactiondetail.router.TransactionDetailRouter
import com.example.commonui.base.BaseViewModel
import com.example.commonui.extensions.disposedBy
import com.example.logic.model.Transaction
import com.example.logic.model.UserCategory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class TransactionDetailViewModel(
    interactor: TransactionDetailInteractor,
    router: TransactionDetailRouter
) : BaseViewModel<TransactionDetailInteractor, TransactionDetailRouter>(interactor, router) {

    val isLoading = ObservableBoolean(false)
    val isDataLoaded = ObservableBoolean(false)
    val errorMessage = ObservableField<String>()
    val transaction = ObservableField<Transaction>()
    val transactionId = ObservableField<String>()
    val currentCategory = ObservableField<UserCategory>()

    init {
        if (currentCategory.get()?.name.isNullOrEmpty()) {
            currentCategory.set(UserCategory("0", CategoryListActivity.DEFAULT_CATEGORY))
        }
    }

    fun getTransactionDetails(id: String) {
        transactionId.set(id)
        isLoading.set(true)
        interactor.getTransactionDetails(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    Timber.d("brex transaction detail SUCCESS = $it")
                    transaction.set(it)
                    isLoading.set(false)
                    isDataLoaded.set(true)
                },
                onError = {
                    Timber.d("brex transaction detail FAILURE = $it")
                    errorMessage.set(it.message)
                    isLoading.set(false)
                }
            )
            .disposedBy(disposables)
    }

    fun openWebsiteUrl(url: String) = router.openWebsiteUrl(url)

    fun launchCategoryPicker() = router.launchCategoryPicker(currentCategory.get()?.name!!)

    fun goBack() = router.goBack()

}
