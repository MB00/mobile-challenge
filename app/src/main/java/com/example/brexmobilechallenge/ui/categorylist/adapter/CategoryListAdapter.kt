package com.example.brexmobilechallenge.ui.categorylist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.brexmobilechallenge.BR
import com.example.brexmobilechallenge.databinding.ItemCategoryBinding
import com.example.brexmobilechallenge.ui.categorylist.viewmodel.CategoryListViewModel
import com.example.commonui.base.BaseViewHolder
import com.example.logic.model.UserCategory

class CategoryListAdapter(
    private val categoryList: List<UserCategory>,
    private val viewModel: CategoryListViewModel
) : RecyclerView.Adapter<BaseViewHolder<ItemCategoryBinding>>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder<ItemCategoryBinding> {
        val inflater = LayoutInflater.from(viewGroup.context)
        return BaseViewHolder(ItemCategoryBinding.inflate(inflater, viewGroup, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ItemCategoryBinding>, position: Int) {
        val category = categoryList[position]
        holder.binding.setVariable(BR.item, category)
        holder.binding.setVariable(BR.viewModel, viewModel)
        holder.binding.categoryImageView.visibility = View.GONE
    }

    override fun getItemCount() = categoryList.size

}