package com.example.brexmobilechallenge.ui.transactionlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.brexmobilechallenge.BR
import com.example.brexmobilechallenge.databinding.ItemTransactionBinding
import com.example.brexmobilechallenge.ui.transactionlist.viewmodel.TransactionListViewModel
import com.example.commonui.base.BaseViewHolder
import com.example.logic.model.Transaction

class TransactionListAdapter(
    private val transactionList: List<Transaction>,
    private val viewModel: TransactionListViewModel
) : RecyclerView.Adapter<BaseViewHolder<ItemTransactionBinding>>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder<ItemTransactionBinding> {
        val inflater = LayoutInflater.from(viewGroup.context)
        return BaseViewHolder(ItemTransactionBinding.inflate(inflater, viewGroup, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ItemTransactionBinding>, position: Int) {
        val transaction = transactionList[position]
        holder.binding.setVariable(BR.item, transaction)
        holder.binding.setVariable(BR.viewModel, viewModel)
    }

    override fun getItemCount() = transactionList.size

}