package com.example.brexmobilechallenge.ui.categorylist.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.brexmobilechallenge.ui.categorylist.interactor.CategoryListInteractor
import com.example.brexmobilechallenge.ui.categorylist.router.CategoryListRouter
import com.example.commonui.base.BaseViewModel
import com.example.commonui.extensions.disposedBy
import com.example.logic.model.UserCategory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class CategoryListViewModel (
    interactor: CategoryListInteractor,
    router: CategoryListRouter
) : BaseViewModel<CategoryListInteractor, CategoryListRouter>(interactor, router) {

    val isLoading = ObservableBoolean(false)
    val isDataLoaded = ObservableBoolean(false)
    val errorMessage = ObservableField<String>()
    val categoryList = ObservableArrayList<UserCategory>()
    val currentCategory = ObservableField<UserCategory>()
    val newCategory = MutableLiveData<UserCategory>()

    init {
        getCategories()
    }

    fun getCategories() {
        isLoading.set(true)
        interactor.getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    Timber.d("brex category list SUCCESS = $it")
                    categoryList.addAll(it)
                    isLoading.set(false)
                    isDataLoaded.set(true)
                },
                onError = {
                    Timber.d("brex category list FAILURE = $it")
                    errorMessage.set(it.message)
                    isLoading.set(false)
                }
            )
            .disposedBy(disposables)
    }

    fun setCategory(category: String) {
        newCategory.value = UserCategory("0", category)
    }

    fun goBack() = router.goBack()

}
