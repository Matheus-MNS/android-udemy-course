package com.matheus.androidudemycourse.feature.my_annotations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matheus.androidudemycourse.data.SharedPreferencesHelper

const val NOTE_KEY = "note"

class MyAnnotationsViewModel(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : ViewModel() {

    val note: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        note.value = sharedPreferencesHelper.getStringFromPreferences(NOTE_KEY)
    }

    fun saveStringOnPreferences(string: String) {
        if (string.isNotEmpty()) {
            sharedPreferencesHelper.saveStringOnPreferences(NOTE_KEY, string)
        }
    }
}