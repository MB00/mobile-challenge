package com.example.squaremobilechallenge.ui.employeelist.view

import com.example.squaremobilechallenge.R
import com.example.squaremobilechallenge.ui.employeelist.viewmodel.EmployeeListViewModel
import com.example.commonui.base.BaseBindingActivity
import com.example.squaremobilechallenge.databinding.ActivityEmployeeListBinding

class EmployeeListActivity : BaseBindingActivity<ActivityEmployeeListBinding, EmployeeListViewModel>() {

    override fun layout() = R.layout.activity_employee_list

    override fun viewModelClass() = EmployeeListViewModel::class.java

}