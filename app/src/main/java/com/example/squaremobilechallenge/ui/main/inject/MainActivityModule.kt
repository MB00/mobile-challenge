package com.example.squaremobilechallenge.ui.main.inject

import com.example.squaremobilechallenge.ui.main.interactor.MainInteractor
import com.example.squaremobilechallenge.ui.main.interactor.MainInteractorImpl
import com.example.squaremobilechallenge.ui.main.router.MainRouter
import com.example.squaremobilechallenge.ui.main.router.MainRouterImpl
import com.example.squaremobilechallenge.ui.main.viewmodel.MainViewModel
import com.example.commonui.factory.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    internal fun provideInteractor(
    ): MainInteractor {
        return MainInteractorImpl()
    }

    @Provides
    internal fun provideRouter(
    ): MainRouter {
        return MainRouterImpl()
    }

    @Provides
    internal fun provideViewModel(
        interactor: MainInteractor,
        router: MainRouter
    ): ViewModelProviderFactory<MainViewModel> {
        return object : ViewModelProviderFactory<MainViewModel>() {
            override fun create(): MainViewModel {
                return MainViewModel(interactor, router)
            }
        }
    }

}