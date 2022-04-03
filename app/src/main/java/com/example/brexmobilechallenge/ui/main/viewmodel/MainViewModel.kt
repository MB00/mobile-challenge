package com.example.brexmobilechallenge.ui.main.viewmodel

import com.example.brexmobilechallenge.ui.main.interactor.MainInteractor
import com.example.brexmobilechallenge.ui.main.router.MainRouter
import com.example.commonui.base.BaseViewModel

class MainViewModel(
    interactor: MainInteractor,
    router: MainRouter
) : BaseViewModel<MainInteractor, MainRouter>(interactor, router) {

    fun launchTransactionsScreen() = router.launchTransactionsScreen()

}