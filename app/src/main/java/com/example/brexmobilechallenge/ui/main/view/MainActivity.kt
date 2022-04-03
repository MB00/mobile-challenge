package com.example.brexmobilechallenge.ui.main.view

import android.os.Bundle
import com.example.brexmobilechallenge.R
import com.example.brexmobilechallenge.databinding.ActivityMainBinding
import com.example.brexmobilechallenge.ui.main.viewmodel.MainViewModel
import com.example.commonui.base.BaseBindingActivity

class MainActivity : BaseBindingActivity<ActivityMainBinding, MainViewModel>() {

    override fun layout() = R.layout.activity_main

    override fun viewModelClass() = MainViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel?.launchTransactionsScreen()
    }

}