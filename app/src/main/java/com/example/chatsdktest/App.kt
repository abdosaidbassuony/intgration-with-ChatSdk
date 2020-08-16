package com.example.chatsdktest

import android.app.Application
import com.example.chatsdktest.framework.di.dataSourceModule
import com.example.chatsdktest.framework.di.interActorsModule
import com.example.chatsdktest.framework.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            // Koin Android logger
            androidLogger()
            // inject Android context
            androidContext(this@App)
            // use modules
            modules(
             listOf(viewModelModule, dataSourceModule, interActorsModule)
            )
        }
    }
}