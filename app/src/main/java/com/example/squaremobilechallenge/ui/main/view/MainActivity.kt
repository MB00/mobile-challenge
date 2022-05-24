package com.example.squaremobilechallenge.ui.main.view

import android.os.Bundle
import com.example.squaremobilechallenge.R
import com.example.squaremobilechallenge.databinding.ActivityMainBinding
import com.example.squaremobilechallenge.ui.main.viewmodel.MainViewModel
import com.example.commonui.base.BaseBindingActivity

class MainActivity : BaseBindingActivity<ActivityMainBinding, MainViewModel>() {

    override fun layout() = R.layout.activity_main

    override fun viewModelClass() = MainViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel?.launchEmployeeListScreen()
    }

}