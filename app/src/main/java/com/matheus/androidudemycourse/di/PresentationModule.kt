package com.matheus.androidudemycourse.di

import com.matheus.androidudemycourse.feature.my_annotations.MyAnnotationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        MyAnnotationsViewModel(
            sharedPreferencesHelper = get()
        )
    }
}