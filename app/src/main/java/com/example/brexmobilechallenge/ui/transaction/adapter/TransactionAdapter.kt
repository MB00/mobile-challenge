package com.example.brexmobilechallenge.ui.transaction.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brexmobilechallenge.R
import com.example.logic.model.Transaction

class TransactionAdapter(private val transactionList: ArrayList<Transaction>) :
    RecyclerView.Adapter<TransactionViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val titleTextView: TextView
//        val categoryTextView: TextView
//
//        init {
//            titleTextView = view.findViewById(R.id.textView)
//        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_transaction, viewGroup, false)

        return TransactionViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: TransactionViewHolder, position: Int) {

        val transaction = transactionList[position]

        //viewHolder.titleTextView.text = transaction.title
        //viewHolder.categoryTextView = transaction.category

//        transactionList[position].apply {
//            viewHolder.titleTextView.text = title
//            viewHolder.categoryTextView = category
//        }
    }

    override fun getItemCount() = transactionList.size

}