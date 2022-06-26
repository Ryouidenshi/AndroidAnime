package com.example.android_final.ui.question

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuestionViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is questions Fragment"
    }
    val text: LiveData<String> = _text

}