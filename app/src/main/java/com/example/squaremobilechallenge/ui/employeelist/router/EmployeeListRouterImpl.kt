package com.example.squaremobilechallenge.ui.employeelist.router

import com.example.commonui.base.BaseRouter

class EmployeeListRouterImpl : EmployeeListRouter, BaseRouter() {

    override fun goBack() {
        finishActivity()
    }

}