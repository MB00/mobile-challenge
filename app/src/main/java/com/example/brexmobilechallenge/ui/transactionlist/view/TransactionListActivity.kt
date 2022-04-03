package com.example.brexmobilechallenge.ui.transactionlist.view

import android.os.Bundle
import com.example.brexmobilechallenge.R
import com.example.brexmobilechallenge.databinding.ActivityTransactionListBinding
import com.example.brexmobilechallenge.ui.transactionlist.viewmodel.TransactionListViewModel
import com.example.commonui.base.BaseBindingActivity

class TransactionListActivity : BaseBindingActivity<ActivityTransactionListBinding, TransactionListViewModel>() {

    override fun layout() = R.layout.activity_transaction_list

    override fun viewModelClass() = TransactionListViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

}