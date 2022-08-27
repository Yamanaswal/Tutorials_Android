package com.yaman.library_tools.app_utils.generic_services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ServiceReceiver(val listener: (Intent?) -> Unit) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        listener(intent)
    }

}