package com.example.brexmobilechallenge.ui.transactionlist.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.example.brexmobilechallenge.ui.transactionlist.interactor.TransactionListInteractor
import com.example.brexmobilechallenge.ui.transactionlist.router.TransactionListRouter
import com.example.commonui.base.BaseViewModel
import com.example.commonui.extensions.disposedBy
import com.example.logic.model.Transaction
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class TransactionListViewModel(
    interactor: TransactionListInteractor,
    router: TransactionListRouter
) : BaseViewModel<TransactionListInteractor, TransactionListRouter>(interactor, router) {

    val isLoading = ObservableBoolean(false)
    val isDataLoaded = ObservableBoolean(false)
    val errorMessage = ObservableField<String>()
    val transactionList = ObservableArrayList<Transaction>()

    init {
        getTransactions()
    }

    fun getTransactions() {
        isLoading.set(true)
        interactor.getTransactions()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    Timber.d("brex transaction list SUCCESS = $it")
                    transactionList.addAll(it)
                    isLoading.set(false)
                    isDataLoaded.set(true)
                },
                onError = {
                    Timber.d("brex transaction list FAILURE = $it")
                    errorMessage.set(it.message)
                    isLoading.set(false)
                }
            )
            .disposedBy(disposables)
    }

    fun launchTransactionDetailScreen(transactionId: String) = router.launchTransactionDetailScreen(transactionId)
}
