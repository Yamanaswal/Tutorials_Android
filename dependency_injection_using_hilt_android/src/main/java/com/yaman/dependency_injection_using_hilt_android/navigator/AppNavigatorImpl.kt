
package com.yaman.dependency_injection_using_hilt_android.navigator

import androidx.fragment.app.FragmentActivity
import com.yaman.dependency_injection_using_hilt_android.R
import com.yaman.dependency_injection_using_hilt_android.ui.ButtonsFragment
import com.yaman.dependency_injection_using_hilt_android.ui.LogsFragment
import javax.inject.Inject

/**
 * Navigator implementation.
 */
class AppNavigatorImpl @Inject constructor(private val activity: FragmentActivity) : AppNavigator {

    override fun navigateTo(screen: Screens) {
        val fragment = when (screen) {
            Screens.BUTTONS -> ButtonsFragment()
            Screens.LOGS -> LogsFragment()
        }

        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(fragment::class.java.canonicalName)
            .commit()
    }
}
