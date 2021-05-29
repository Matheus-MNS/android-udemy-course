package com.matheus.androidudemycourse.data

import android.content.Context

const val FILE_PREFERENCE = "filePreference"

class SharedPreferencesHelper(context: Context) {

    private val sharedPreferences =
        context.getSharedPreferences(FILE_PREFERENCE, Context.MODE_PRIVATE)

    fun saveStringOnPreferences(key: String, value: String) = sharedPreferences.edit().run {
        putString(key, value)
        apply()
    }

    fun getStringFromPreferences(key: String) = sharedPreferences.run {
        getString(key, null)
    }
}