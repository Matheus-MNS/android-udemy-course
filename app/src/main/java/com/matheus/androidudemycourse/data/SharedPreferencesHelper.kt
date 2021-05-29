package com.matheus.androidudemycourse.data

import android.content.Context
import android.content.SharedPreferences
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.feature.my_annotations.FILE_PREFERENCE
import com.matheus.androidudemycourse.feature.my_annotations.NOTE_KEY

class SharedPreferencesHelper(context: Context) {

    private lateinit var sharedPreferences: SharedPreferences

}

//private fun getSharedPreference() {
//    sharedPreferences = requireActivity().getSharedPreferences(FILE_PREFERENCE, 0)
//    if (sharedPreferences.contains(NOTE_KEY)) {
//        val recoveryNote =
//            sharedPreferences.getString(NOTE_KEY, getString(R.string.note_not_found))
//
//        if (recoveryNote != null) {
//            binding.annotationsTextInput.setText(recoveryNote)
//        }
//    }
//}
//
//private fun saveSharedPreferences() {
//    val note = binding.annotationsTextInput.text.toString()
//
//    sharedPreferences = requireActivity().getSharedPreferences(FILE_PREFERENCE, 0)
//    sharedPreferences.edit().apply {
//        putString(NOTE_KEY, note)
//        apply()
//    }
}