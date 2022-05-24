package com.example.squaremobilechallenge.ui.employeelist.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.logic.model.Employee
import com.example.squaremobilechallenge.ui.employeelist.adapter.EmployeeListAdapter
import com.example.squaremobilechallenge.ui.employeelist.viewmodel.EmployeeListViewModel

@BindingAdapter(value=["employeeList", "employeeListViewModel"])
fun bindEmployeeList(
    recyclerView: RecyclerView,
    employeeList: List<Employee>,
    viewModel: EmployeeListViewModel
) {
    recyclerView.apply {
        adapter = EmployeeListAdapter(employeeList, viewModel)
        layoutManager = LinearLayoutManager(context)
    }
}

@BindingAdapter(value=["refreshEmployeeList"])
fun bindRefreshEmployeeList(
    layout: SwipeRefreshLayout,
    viewModel: EmployeeListViewModel
) {
    layout.setOnRefreshListener {
        viewModel.getEmployees()
        layout.isRefreshing = false
    }
}