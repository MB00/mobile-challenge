package com.example.brexmobilechallenge.ui.transactiondetail.view

import android.content.Intent
import android.os.Bundle
import com.example.brexmobilechallenge.R
import com.example.brexmobilechallenge.databinding.ActivityTransactionDetailBinding
import com.example.brexmobilechallenge.ui.categorylist.view.CategoryListActivity
import com.example.brexmobilechallenge.ui.transactiondetail.viewmodel.TransactionDetailViewModel
import com.example.commonui.base.BaseBindingActivity
import com.example.logic.model.UserCategory

class TransactionDetailActivity : BaseBindingActivity<ActivityTransactionDetailBinding, TransactionDetailViewModel>() {

    override fun layout() = R.layout.activity_transaction_detail

    override fun viewModelClass() = TransactionDetailViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent.extras?.getString(TRANSACTION_ID)?.let {
            viewModel?.getTransactionDetails(it)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            data?.getStringExtra(CategoryListActivity.NEW_CATEGORY)?.let {
                viewModel?.currentCategory?.set(UserCategory("0", it))
            }
        }

    }

    companion object {
        const val TRANSACTION_ID = "transactionId"
        const val CATEGORY_NAME = "categoryName"
    }

}