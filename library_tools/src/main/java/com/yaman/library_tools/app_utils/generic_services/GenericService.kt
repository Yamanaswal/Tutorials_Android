package com.yaman.library_tools.app_utils.generic_services

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class GenericService(
    private val serviceType: Int = START_NOT_STICKY,
    private val showNotification: Boolean = true,
) : Service() {

    abstract fun onServiceStart(intent: Intent?, flags: Int, startId: Int)

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        CoroutineScope(Dispatchers.IO).launch {
            Log.e(_TAG, "onStartCommand: ")
            Log.e(_TAG, "onStartCommand: intent: " + intent.toString())
            Log.e(_TAG, "onStartCommand: flags: $flags")
            Log.e(_TAG, "onStartCommand: startId: $startId")
            onServiceStart(intent, flags, startId)
            startForeground()
        }

        return serviceType
    }

    fun setServiceData(serviceName: String?, serviceData: HashMap<String, Any>) {
        if (serviceName != null) {
            val intentData = Intent(serviceName)

            serviceData.forEach {

                when (it.value) {
                    is String -> {
                        intentData.putExtra(it.key, it.value as String)
                    }
                    is Int -> {
                        intentData.putExtra(it.key, it.value as Int)
                    }
                    is Boolean -> {
                        intentData.putExtra(it.key, it.value as Boolean)
                    }
                    is CharSequence -> {
                        intentData.putExtra(it.key, it.value as CharSequence)
                    }
                    is Long -> {
                        intentData.putExtra(it.key, it.value as Long)
                    }
                    is Double -> {
                        intentData.putExtra(it.key, it.value as Double)
                    }
                    is Float -> {
                        intentData.putExtra(it.key, it.value as Float)
                    }
                }

            }

            sendBroadcast(intentData)
        } else {
            Log.e("setServiceData: ", "intentName is an null object.")
        }
    }

    fun startForeground() {

        if (showNotification) {
            val channelId = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createNotificationChannel()
            } else {
                // If earlier version channel ID is not used
                // https://developer.android.com/reference/android/support/v4/app/NotificationCompat.Builder.html#NotificationCompat.Builder(android.content.Context)
                ""
            }

            val notificationBuilder = NotificationCompat.Builder(this, channelId)
            val notification = notificationBuilder
                .setOngoing(true)
                .setPriority(NotificationCompat.PRIORITY_MIN)
                .setCategory(Notification.CATEGORY_SERVICE)

            val notificationBuild = notification.build()
            startForeground(101, notificationBuild)
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(
        default: Boolean = true,
        notificationChannel: NotificationChannel? = null
    ): String {

        val channelId = "channel_id"

        if (default) {
            val channelName = "Foreground Service"

            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_HIGH,
            )

            channel.lockscreenVisibility = Notification.VISIBILITY_PRIVATE

            val service = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            service.createNotificationChannel(channel)

            return channelId
        } else {

            val service = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (notificationChannel != null) {
                service.createNotificationChannel(notificationChannel)
            }

            return channelId
        }

    }


    override fun onCreate() {
        super.onCreate()
        Log.e(_TAG, "onCreate: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(_TAG, "onDestroy: ")
    }


    override fun onBind(intent: Intent?): IBinder? {
        Log.e(_TAG, "onBind: ")
        return null
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.e(_TAG, "onUnbind: ")
        return super.onUnbind(intent)
    }

    override fun onRebind(intent: Intent?) {
        Log.e(_TAG, "onRebind: ")
        super.onRebind(intent)
    }

    companion object {
        const val _TAG = "GenericService"
    }
}