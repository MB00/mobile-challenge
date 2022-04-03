package com.example.brexmobilechallenge.ui.transactionlist.inject

import com.example.brexmobilechallenge.ui.transactionlist.interactor.TransactionListInteractor
import com.example.brexmobilechallenge.ui.transactionlist.interactor.TransactionListInteractorImpl
import com.example.brexmobilechallenge.ui.transactionlist.router.TransactionListRouter
import com.example.brexmobilechallenge.ui.transactionlist.router.TransactionListRouterImpl
import com.example.brexmobilechallenge.ui.transactionlist.viewmodel.TransactionListViewModel
import com.example.commonui.factory.ViewModelProviderFactory
import com.example.logic.repository.ApiDataRepository
import dagger.Module
import dagger.Provides

@Module
class TransactionListActivityModule {

    @Provides
    internal fun provideInteractor(
        apiDataRepository: ApiDataRepository
    ): TransactionListInteractor {
        return TransactionListInteractorImpl(apiDataRepository)
    }

    @Provides
    internal fun provideRouter(
    ): TransactionListRouter {
        return TransactionListRouterImpl()
    }

    @Provides
    internal fun provideViewModel(
        interactor: TransactionListInteractor,
        router: TransactionListRouter
    ): ViewModelProviderFactory<TransactionListViewModel> {
        return object : ViewModelProviderFactory<TransactionListViewModel>() {
            override fun create(): TransactionListViewModel {
                return TransactionListViewModel(interactor, router)
            }
        }
    }

}