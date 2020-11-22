package com.assessment.nytimes.presentation.main

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.assessment.nytimes.BR
import com.assessment.nytimes.R
import com.assessment.nytimes.databinding.MainActivityBinding
import com.assessment.nytimes.presentation.base.BaseActivity

class MainActivity : BaseActivity<MainActivityBinding, MainViewModel>() {

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.main_activity

    override val viewModel: Class<MainViewModel>
        get() = MainViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeToolBar()
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.fragment_container_view).navigateUp()
    }

    private fun initializeToolBar() {
        setSupportActionBar(viewDataBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment

        navHostFragment.findNavController()
            .addOnDestinationChangedListener { _, destination, _ ->
                title = destination.label
            }
    }
}
