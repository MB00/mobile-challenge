package com.example.brexmobilechallenge.ui.main.router

import com.example.brexmobilechallenge.ui.transactionlist.view.TransactionListActivity
import com.example.commonui.base.BaseRouter

class MainRouterImpl : MainRouter, BaseRouter() {

    override fun launchTransactionsScreen() {
        launchActivity(TransactionListActivity::class.java)
    }

}