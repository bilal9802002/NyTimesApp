package com.assessment.nytimes.presentation.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.assessment.nytimes.utils.NavigationCommand
import com.assessment.nytimes.utils.SingleLiveEvent

open class BaseViewModel(context: Application) : AndroidViewModel(context) {

    val navigationCommands = SingleLiveEvent<NavigationCommand>()

    val hideKeyboard = MutableLiveData<Boolean>()

}