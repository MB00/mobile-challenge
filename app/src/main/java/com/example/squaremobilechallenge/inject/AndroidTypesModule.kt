package com.example.squaremobilechallenge.inject

import com.example.squaremobilechallenge.ui.employeelist.inject.EmployeeListActivityModule
import com.example.squaremobilechallenge.ui.employeelist.view.EmployeeListActivity
import com.example.squaremobilechallenge.ui.main.inject.MainActivityModule
import com.example.squaremobilechallenge.ui.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidTypesModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [EmployeeListActivityModule::class])
    internal abstract fun bindEmployeeListActivity(): EmployeeListActivity

}