package com.example.brexmobilechallenge.ui.transactionlist.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brexmobilechallenge.ui.transactionlist.adapter.TransactionListAdapter
import com.example.brexmobilechallenge.ui.transactionlist.viewmodel.TransactionListViewModel
import com.example.logic.model.Transaction

@BindingAdapter(value=["transactionList", "transactionViewModel"])
fun bindTransactionList(
    recyclerView: RecyclerView,
    transactionList: List<Transaction>,
    viewModel: TransactionListViewModel
) {
    recyclerView.apply {
        adapter = TransactionListAdapter(viewModel.transactionList, viewModel)
        adapter = TransactionListAdapter(transactionList, viewModel)
        layoutManager = LinearLayoutManager(context)
    }
}