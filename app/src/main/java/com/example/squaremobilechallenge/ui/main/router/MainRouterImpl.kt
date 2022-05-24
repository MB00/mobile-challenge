package com.example.squaremobilechallenge.ui.main.router

import com.example.commonui.base.BaseRouter
import com.example.squaremobilechallenge.ui.employeelist.view.EmployeeListActivity

class MainRouterImpl : MainRouter, BaseRouter() {

    override fun launchEmployeeListScreen() {
        launchActivity(EmployeeListActivity::class.java)
    }

}