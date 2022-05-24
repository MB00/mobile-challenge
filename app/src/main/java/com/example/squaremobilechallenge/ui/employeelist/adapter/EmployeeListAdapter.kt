package com.example.squaremobilechallenge.ui.employeelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.squaremobilechallenge.BR
import com.example.squaremobilechallenge.ui.employeelist.viewmodel.EmployeeListViewModel
import com.example.commonui.base.BaseViewHolder
import com.example.logic.model.Employee
import com.example.squaremobilechallenge.databinding.ItemEmployeeBinding

class EmployeeListAdapter(
    private val employeeList: List<Employee>,
    private val viewModel: EmployeeListViewModel
) : RecyclerView.Adapter<BaseViewHolder<ItemEmployeeBinding>>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder<ItemEmployeeBinding> {
        val inflater = LayoutInflater.from(viewGroup.context)
        return BaseViewHolder(ItemEmployeeBinding.inflate(inflater, viewGroup, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ItemEmployeeBinding>, position: Int) {
        val employee = employeeList[position]
        holder.binding.setVariable(BR.item, employee)
        holder.binding.setVariable(BR.viewModel, viewModel)
    }

    override fun getItemCount() = employeeList.size

}