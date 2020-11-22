package com.assessment.nytimes.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity(),
    HasAndroidInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewDataBinding: T
        private set

    val injectedViewModel: V by lazy { ViewModelProvider(this, viewModelFactory).get(viewModel) }

    @get:LayoutRes
    abstract val bindingVariable: Int

    @get:LayoutRes
    abstract val layoutId: Int

    abstract val viewModel: Class<V>

    override fun onCreate(savedInstanceState: Bundle?) {
        initializeDependencyInjection()
        super.onCreate(savedInstanceState)
        initializeDateBinding()
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return fragmentDispatchingAndroidInjector
    }

    private fun initializeDateBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        viewDataBinding.setVariable(bindingVariable, injectedViewModel)
        viewDataBinding.executePendingBindings()
    }

    private fun initializeDependencyInjection() {
        AndroidInjection.inject(this)
    }
}