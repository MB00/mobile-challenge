package com.example.brexmobilechallenge.ui.transactionlist.router

import android.os.Bundle
import com.example.brexmobilechallenge.ui.transactiondetail.view.TransactionDetailActivity
import com.example.commonui.base.BaseRouter

class TransactionListRouterImpl : TransactionListRouter, BaseRouter() {

    override fun launchTransactionDetailScreen(transactionId: String) {
        val bundle = Bundle().apply {
            putString(TransactionDetailActivity.TRANSACTION_ID, transactionId)
        }
        launchActivity(TransactionDetailActivity::class.java, bundle)
    }
}