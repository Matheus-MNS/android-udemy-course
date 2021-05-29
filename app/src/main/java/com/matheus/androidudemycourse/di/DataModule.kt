package com.matheus.androidudemycourse.di

import com.matheus.androidudemycourse.data.SharedPreferencesHelper
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    single { SharedPreferencesHelper(androidApplication()) }
}