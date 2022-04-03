package com.example.brexmobilechallenge.ui.transactiondetail.inject

import com.example.brexmobilechallenge.ui.transactiondetail.interactor.TransactionDetailInteractor
import com.example.brexmobilechallenge.ui.transactiondetail.interactor.TransactionDetailInteractorImpl
import com.example.brexmobilechallenge.ui.transactiondetail.router.TransactionDetailRouter
import com.example.brexmobilechallenge.ui.transactiondetail.router.TransactionDetailRouterImpl
import com.example.brexmobilechallenge.ui.transactiondetail.viewmodel.TransactionDetailViewModel
import com.example.commonui.factory.ViewModelProviderFactory
import com.example.logic.repository.ApiDataRepository
import dagger.Module
import dagger.Provides

@Module
class TransactionDetailActivityModule {

    @Provides
    internal fun provideInteractor(
        apiDataRepository: ApiDataRepository
    ): TransactionDetailInteractor {
        return TransactionDetailInteractorImpl(apiDataRepository)
    }

    @Provides
    internal fun provideRouter(
    ): TransactionDetailRouter {
        return TransactionDetailRouterImpl()
    }

    @Provides
    internal fun provideViewModel(
        interactor: TransactionDetailInteractor,
        router: TransactionDetailRouter
    ): ViewModelProviderFactory<TransactionDetailViewModel> {
        return object : ViewModelProviderFactory<TransactionDetailViewModel>() {
            override fun create(): TransactionDetailViewModel {
                return TransactionDetailViewModel(interactor, router)
            }
        }
    }

}