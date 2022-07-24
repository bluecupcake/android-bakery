package com.bluecupcake.androidbakary.presentation.application

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ApplicationViewModel : ViewModel() {

    private val _actionBarTitle = MutableLiveData<String?>()
    val actionBarTitle: LiveData<String?> = _actionBarTitle // change to getter

    fun changeActionBarTitle(title: String?) {
        _actionBarTitle.value = title
    }
}