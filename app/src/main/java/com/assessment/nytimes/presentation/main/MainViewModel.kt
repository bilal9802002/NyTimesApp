package com.assessment.nytimes.presentation.main

import android.app.Application
import com.assessment.nytimes.presentation.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(private val context: Application) : BaseViewModel(context)