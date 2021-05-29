package com.matheus.androidudemycourse.app

import android.app.Application
import com.matheus.androidudemycourse.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                dataModule
            ).androidContext(applicationContext)
        }
    }

}