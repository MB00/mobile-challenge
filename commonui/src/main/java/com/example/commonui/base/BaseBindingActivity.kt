package com.example.commonui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.example.commonui.BR
import com.example.commonui.factory.ViewModelProviderFactory
import javax.inject.Inject

abstract class BaseBindingActivity<B : ViewDataBinding, V : BaseViewModel<*, *>> : BaseActivity() {

    var binding: B? = null
        private set

    var viewModel: V? = null
        private set

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory<V>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModel()
        initBinding()
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, layout())
        setBindingVariables(binding)
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass())
        (viewModel?.router as? BaseRouter)?.setActivity(this)
    }

    private fun setBindingVariables(binding: B?) {
        binding?.setVariable(BR.viewModel, viewModel)
    }

    @LayoutRes
    protected abstract fun layout(): Int

    protected abstract fun viewModelClass(): Class<V>
}