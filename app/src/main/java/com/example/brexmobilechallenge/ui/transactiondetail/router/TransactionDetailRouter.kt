package com.example.brexmobilechallenge.ui.transactiondetail.router

interface TransactionDetailRouter {
    fun launchCategoryPicker(currentCategory: String)
    fun openWebsiteUrl(url: String)
    fun goBack()
}