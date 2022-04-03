package com.example.brexmobilechallenge.inject

import com.example.brexmobilechallenge.ui.categorylist.inject.CategoryListActivityModule
import com.example.brexmobilechallenge.ui.categorylist.view.CategoryListActivity
import com.example.brexmobilechallenge.ui.main.view.MainActivity
import com.example.brexmobilechallenge.ui.main.inject.MainActivityModule
import com.example.brexmobilechallenge.ui.transactiondetail.inject.TransactionDetailActivityModule
import com.example.brexmobilechallenge.ui.transactiondetail.view.TransactionDetailActivity
import com.example.brexmobilechallenge.ui.transactionlist.inject.TransactionListActivityModule
import com.example.brexmobilechallenge.ui.transactionlist.view.TransactionListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidTypesModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [TransactionListActivityModule::class])
    internal abstract fun bindTransactionListActivity(): TransactionListActivity

    @ContributesAndroidInjector(modules = [TransactionDetailActivityModule::class])
    internal abstract fun bindTransactionDetailActivity(): TransactionDetailActivity

    @ContributesAndroidInjector(modules = [CategoryListActivityModule::class])
    internal abstract fun bindCategoryListActivity(): CategoryListActivity

}