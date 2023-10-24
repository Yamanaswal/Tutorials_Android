package com.yaman.dependency_injection_using_hilt_android

import android.app.Application
import com.yaman.dependency_injection_using_hilt_android.data.LoggerDataSource
import com.yaman.dependency_injection_using_hilt_android.di.DatabaseLogger
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class LogApplication : Application() {

    @DatabaseLogger
    @Inject
    lateinit var logger: LoggerDataSource

    /* Without DI */
/*    lateinit var serviceLocator: ServiceLocator

    override fun onCreate() {
        super.onCreate()
        serviceLocator = ServiceLocator(applicationContext)
    }*/
}
