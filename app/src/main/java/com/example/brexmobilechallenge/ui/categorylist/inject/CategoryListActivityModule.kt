package com.example.brexmobilechallenge.ui.categorylist.inject

import com.example.brexmobilechallenge.ui.categorylist.interactor.CategoryListInteractor
import com.example.brexmobilechallenge.ui.categorylist.interactor.CategoryListInteractorImpl
import com.example.brexmobilechallenge.ui.categorylist.router.CategoryListRouter
import com.example.brexmobilechallenge.ui.categorylist.router.CategoryListRouterImpl
import com.example.brexmobilechallenge.ui.categorylist.viewmodel.CategoryListViewModel
import com.example.commonui.factory.ViewModelProviderFactory
import com.example.logic.repository.ApiDataRepository
import dagger.Module
import dagger.Provides

@Module
class CategoryListActivityModule {

    @Provides
    internal fun provideInteractor(
        apiDataRepository: ApiDataRepository
    ): CategoryListInteractor {
        return CategoryListInteractorImpl(apiDataRepository)
    }

    @Provides
    internal fun provideRouter(): CategoryListRouter {
        return CategoryListRouterImpl()
    }

    @Provides
    internal fun provideViewModel(
        interactor: CategoryListInteractor,
        router: CategoryListRouter
    ): ViewModelProviderFactory<CategoryListViewModel> {
        return object : ViewModelProviderFactory<CategoryListViewModel>() {
            override fun create(): CategoryListViewModel {
                return CategoryListViewModel(interactor, router)
            }
        }
    }

}