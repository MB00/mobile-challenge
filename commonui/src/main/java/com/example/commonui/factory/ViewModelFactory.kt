package com.example.commonui.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.commonui.base.BaseViewModel

abstract class ViewModelProviderFactory<VM : BaseViewModel<*, *>> : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return create() as T
    }

    protected abstract fun create(): VM
}