package com.example.brexmobilechallenge.ui.transaction.router

import com.example.brexmobilechallenge.ui.transaction.view.TransactionDetailActivity
import com.example.commonui.base.BaseRouter

class TransactionRouterImpl : TransactionRouter, BaseRouter() {

    override fun launchTransactionDetailScreen() {
        launchActivity(TransactionDetailActivity::class.java)
    }

    override fun launchChangeCategoryScreen() {
        // dialog fragment
    }

    override fun openWebsiteUrl(url: String) = openUrl(url)

}