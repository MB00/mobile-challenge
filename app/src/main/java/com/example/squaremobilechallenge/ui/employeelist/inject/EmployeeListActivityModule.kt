package com.example.squaremobilechallenge.ui.employeelist.inject

import com.example.squaremobilechallenge.ui.employeelist.interactor.EmployeeListInteractor
import com.example.squaremobilechallenge.ui.employeelist.interactor.EmployeeListInteractorImpl
import com.example.squaremobilechallenge.ui.employeelist.router.EmployeeListRouter
import com.example.squaremobilechallenge.ui.employeelist.router.EmployeeListRouterImpl
import com.example.squaremobilechallenge.ui.employeelist.viewmodel.EmployeeListViewModel
import com.example.commonui.factory.ViewModelProviderFactory
import com.example.logic.repository.ApiDataRepository
import dagger.Module
import dagger.Provides

@Module
class EmployeeListActivityModule {

    @Provides
    internal fun provideInteractor(
        apiDataRepository: ApiDataRepository
    ): EmployeeListInteractor {
        return EmployeeListInteractorImpl(apiDataRepository)
    }

    @Provides
    internal fun provideRouter(): EmployeeListRouter {
        return EmployeeListRouterImpl()
    }

    @Provides
    internal fun provideViewModel(
        interactor: EmployeeListInteractor,
        router: EmployeeListRouter
    ): ViewModelProviderFactory<EmployeeListViewModel> {
        return object : ViewModelProviderFactory<EmployeeListViewModel>() {
            override fun create(): EmployeeListViewModel {
                return EmployeeListViewModel(interactor, router)
            }
        }
    }

}