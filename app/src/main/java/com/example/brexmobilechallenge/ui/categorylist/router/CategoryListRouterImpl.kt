package com.example.brexmobilechallenge.ui.categorylist.router

import com.example.commonui.base.BaseRouter

class CategoryListRouterImpl : CategoryListRouter, BaseRouter() {

    override fun goBack() {
        finishActivity()
    }

}