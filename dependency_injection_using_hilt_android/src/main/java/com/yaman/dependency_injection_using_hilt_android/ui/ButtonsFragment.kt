package com.yaman.dependency_injection_using_hilt_android.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.yaman.dependency_injection_using_hilt_android.R
import com.yaman.dependency_injection_using_hilt_android.data.LoggerDataSource
import com.yaman.dependency_injection_using_hilt_android.data.LoggerLocalDataSource
import com.yaman.dependency_injection_using_hilt_android.di.InMemoryLogger
import com.yaman.dependency_injection_using_hilt_android.navigator.AppNavigator
import com.yaman.dependency_injection_using_hilt_android.navigator.Screens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Fragment that displays buttons whose interactions are recorded.
 */
@AndroidEntryPoint
class ButtonsFragment : Fragment() {

/*    @Inject
    lateinit var logger: LoggerLocalDataSource*/

    @InMemoryLogger
    @Inject
    lateinit var logger: LoggerDataSource

    @Inject
    lateinit var navigator: AppNavigator

    /* Without DI */
    /*private lateinit var logger: LoggerLocalDataSource
    private lateinit var navigator: AppNavigator*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /*
                populateFields(context)*/
    }

    /*    private fun populateFields(context: Context) {
            logger = (context.applicationContext as LogApplication).serviceLocator.loggerLocalDataSource

            navigator = (context.applicationContext as LogApplication).serviceLocator.provideNavigator(
                requireActivity()
            )
        }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.button1).setOnClickListener {
            logger.addLog("Interaction with 'Button 1'")
        }

        view.findViewById<Button>(R.id.button2).setOnClickListener {
            logger.addLog("Interaction with 'Button 2'")
        }

        view.findViewById<Button>(R.id.button3).setOnClickListener {
            logger.addLog("Interaction with 'Button 3'")
        }

        view.findViewById<Button>(R.id.all_logs).setOnClickListener {
            navigator.navigateTo(Screens.LOGS)
        }

        view.findViewById<Button>(R.id.delete_logs).setOnClickListener {
            logger.removeLogs()
        }
    }
}
