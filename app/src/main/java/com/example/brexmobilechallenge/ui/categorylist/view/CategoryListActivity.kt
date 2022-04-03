package com.example.brexmobilechallenge.ui.categorylist.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.brexmobilechallenge.R
import com.example.brexmobilechallenge.databinding.ActivityCategoryListBinding
import com.example.brexmobilechallenge.ui.categorylist.viewmodel.CategoryListViewModel
import com.example.brexmobilechallenge.ui.transactiondetail.view.TransactionDetailActivity
import com.example.commonui.base.BaseBindingActivity
import com.example.logic.model.UserCategory

class CategoryListActivity : BaseBindingActivity<ActivityCategoryListBinding, CategoryListViewModel>() {

    override fun layout() = R.layout.activity_category_list

    override fun viewModelClass() = CategoryListViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent.extras?.getString(TransactionDetailActivity.CATEGORY_NAME)?.let {
            viewModel?.currentCategory?.set(UserCategory("0", it))
        }

        viewModel?.newCategory?.observeForever {
            val returnIntent = Intent().apply {
                putExtra(NEW_CATEGORY, it.name)
            }
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }

    companion object {
        const val DEFAULT_CATEGORY = "Miscellaneous"
        const val NEW_CATEGORY = "new_category"
    }

}