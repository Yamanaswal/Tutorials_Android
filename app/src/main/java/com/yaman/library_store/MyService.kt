package com.yaman.library_store

import android.content.Intent
import android.util.Log
import com.yaman.library_tools.app_utils.generic_services.GenericService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MyService : GenericService(serviceType = START_STICKY, true) {

    override fun onServiceStart(intent: Intent?, flags: Int, startId: Int) {

        CoroutineScope(Dispatchers.IO).launch {
            getLocations()
        }

    }

    private suspend fun getLocations() {
        delay(5000)
        Log.e("TAG", "onServiceStart: ")

        // Send Data Broadcast Receiver.
        val map = HashMap<String,Any>()
        map["Status"] = true
        map["Location"] = "lat,lng"
        setServiceData(serviceName = "GPSLocationUpdates", serviceData = map)
    }


}