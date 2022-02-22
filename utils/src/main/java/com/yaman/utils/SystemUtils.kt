package com.yaman.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.provider.Settings
import java.util.*

/**  Get Device Id **/
@SuppressLint("HardwareIds")
fun getDeviceId(context: Context): String? {
    return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
}


/**  Device Type  (Mobile or Tablet) **/
fun getDeviceType(context: Context): String {
    return if ((context.resources.configuration.screenLayout
                and Configuration.SCREENLAYOUT_SIZE_MASK)
        >= Configuration.SCREENLAYOUT_SIZE_LARGE
    ) {
        "Tablet"
    } else {
        "Mobile"
    }
}



/**  Show Date and Time Interval (e.g. minute,seconds,months and year ago.) **/
fun getDateDifferenceFromCurrentDate(date: Date): String? {
    val now: Calendar = Calendar.getInstance()
    val then: Calendar = Calendar.getInstance()
    now.time = Date()
    then.time = date

    // Get the represented date in milliseconds
    val nowMs: Long = now.timeInMillis
    val thenMs: Long = then.timeInMillis

    // Calculate difference in milliseconds
    val diff = nowMs - thenMs

    // Calculate difference in seconds
    val diffMinutes = diff / (60 * 1000)
    val diffHours = diff / (60 * 60 * 1000)
    val diffDays = diff / (24 * 60 * 60 * 1000)

    //show date timeline.
    return if (diffMinutes < 60) {
        if (diffMinutes == 1L) "$diffMinutes minute ago" else "$diffMinutes minutes ago"
    } else if (diffHours < 24) {
        if (diffHours == 1L) "$diffHours hour ago" else "$diffHours hours ago"
    } else if (diffDays < 30) {
        if (diffDays == 1L) "$diffDays day ago" else "$diffDays days ago"
    } else if (diffDays / 30 in 2..11) {
        java.lang.String.format(Locale.getDefault(), "%d months ago", diffDays / 30)
    } else if (diffDays / 365 > 1) {
        java.lang.String.format(Locale.getDefault(), "%d years ago", diffDays / 365)
    } else {
        "a long time ago.."
    }
}




