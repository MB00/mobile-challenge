package com.example.squaremobilechallenge.ui.main.viewmodel

import com.example.squaremobilechallenge.ui.main.interactor.MainInteractor
import com.example.squaremobilechallenge.ui.main.router.MainRouter
import com.example.commonui.base.BaseViewModel

class MainViewModel(
    interactor: MainInteractor,
    router: MainRouter
) : BaseViewModel<MainInteractor, MainRouter>(interactor, router) {

    fun launchEmployeeListScreen() = router.launchEmployeeListScreen()

}