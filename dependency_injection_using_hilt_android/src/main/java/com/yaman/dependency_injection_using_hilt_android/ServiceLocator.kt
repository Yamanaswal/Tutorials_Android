
package com.yaman.dependency_injection_using_hilt_android

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.room.Room
import com.yaman.dependency_injection_using_hilt_android.data.AppDatabase
import com.yaman.dependency_injection_using_hilt_android.data.LoggerLocalDataSource
import com.yaman.dependency_injection_using_hilt_android.navigator.AppNavigator
import com.yaman.dependency_injection_using_hilt_android.navigator.AppNavigatorImpl
import com.yaman.dependency_injection_using_hilt_android.util.DateFormatter

class ServiceLocator(applicationContext: Context) {

    private val logsDatabase = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java,
        "logging.db"
    ).build()

    val loggerLocalDataSource = LoggerLocalDataSource(logsDatabase.logDao())

    fun provideDateFormatter() = DateFormatter()  //replace by -  @Inject constructor()

    fun provideNavigator(activity: FragmentActivity): AppNavigator {
        return AppNavigatorImpl(activity)
    }
}
