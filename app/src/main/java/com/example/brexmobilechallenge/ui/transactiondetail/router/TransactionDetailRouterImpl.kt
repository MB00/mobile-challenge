package com.example.brexmobilechallenge.ui.transactiondetail.router

import android.os.Bundle
import com.example.brexmobilechallenge.ui.categorylist.view.CategoryListActivity
import com.example.brexmobilechallenge.ui.transactiondetail.view.TransactionDetailActivity
import com.example.commonui.base.BaseRouter

class TransactionDetailRouterImpl : TransactionDetailRouter, BaseRouter() {

    override fun launchCategoryPicker(currentCategory: String) {
        val bundle = Bundle().apply {
            putString(TransactionDetailActivity.CATEGORY_NAME, currentCategory)
        }
        launchActivityForResult(CategoryListActivity::class.java, bundle)
    }

    override fun openWebsiteUrl(url: String) = openUrl(url)

    override fun goBack() {
        finishActivity()
    }

}