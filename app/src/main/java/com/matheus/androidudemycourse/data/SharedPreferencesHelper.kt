package com.matheus.androidudemycourse.data

import android.content.Context
import com.matheus.androidudemycourse.R

const val FILE_PREFERENCE = "filePreference"

class SharedPreferencesHelper(private val context: Context) {

    private val sharedPreferences =
        context.getSharedPreferences(FILE_PREFERENCE, Context.MODE_PRIVATE)

    fun saveStringOnPreferences(key: String, value: String) = sharedPreferences.edit().run {
        putString(key, value)
        apply()
    }

    fun getStringFromPreferences(key: String) = sharedPreferences.run {
        getString(key,context.getString(R.string.empty_string) )
    }
}