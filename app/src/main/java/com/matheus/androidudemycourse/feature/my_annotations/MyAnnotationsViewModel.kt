package com.matheus.androidudemycourse.feature.my_annotations

import androidx.lifecycle.ViewModel
import com.matheus.androidudemycourse.data.SharedPreferencesHelper

const val NOTE_KEY = "note"

class MyAnnotationsViewModel(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : ViewModel() {

    private val saveStringState:

    fun saveStringOnPreferences(string: String) {
        if (string.isNotEmpty()) {
            sharedPreferencesHelper.saveStringOnPreferences(NOTE_KEY, string)
        } else {

        }
    }

    fun getStringFromPreferences(): String? {

        return sharedPreferencesHelper.getStringFromPreferences(NOTE_KEY)
    }

//    private fun validateEmpty() {
//        if (binding.annotationsTextInput.text.isNullOrEmpty()) {
//            snackBar(requireView(), R.string.empty_field, Snackbar.LENGTH_LONG)
//        } else {
//            saveSharedPreferences()
//            snackBar(requireView(), R.string.save_annotations, Snackbar.LENGTH_LONG)
//        }
//    }
}