package com.example.brexmobilechallenge.ui.transaction.router

interface TransactionRouter {
    fun launchTransactionDetailScreen()
    fun launchChangeCategoryScreen()
    fun openWebsiteUrl(url: String)
}