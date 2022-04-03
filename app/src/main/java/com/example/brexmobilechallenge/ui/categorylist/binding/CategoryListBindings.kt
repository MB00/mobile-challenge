package com.example.brexmobilechallenge.ui.categorylist.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brexmobilechallenge.ui.categorylist.adapter.CategoryListAdapter
import com.example.brexmobilechallenge.ui.categorylist.viewmodel.CategoryListViewModel
import com.example.logic.model.UserCategory

@BindingAdapter(value=["categoryList", "categoryViewModel"])
fun bindCategoryList(
    recyclerView: RecyclerView,
    categoryList: List<UserCategory>,
    viewModel: CategoryListViewModel
) {
    recyclerView.apply {
        adapter = CategoryListAdapter(categoryList, viewModel)
        layoutManager = LinearLayoutManager(context)
    }
}