package com.yaman.dependency_injection_using_hilt_android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yaman.dependency_injection_using_hilt_android.LogApplication
import com.yaman.dependency_injection_using_hilt_android.R
import com.yaman.dependency_injection_using_hilt_android.navigator.AppNavigator
import com.yaman.dependency_injection_using_hilt_android.navigator.Screens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Main activity of the application.
 *
 * Container for the Buttons & Logs fragments. This activity simply tracks clicks on buttons.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: AppNavigator

    /* Without DI */
    //    private lateinit var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Without DI */
//        navigator = (applicationContext as LogApplication).serviceLocator.provideNavigator(this)

        if (savedInstanceState == null) {
            navigator.navigateTo(Screens.BUTTONS)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }
}
