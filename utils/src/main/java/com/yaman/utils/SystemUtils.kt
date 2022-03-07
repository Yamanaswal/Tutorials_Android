package com.yaman.utils

import android.annotation.SuppressLint
import android.app.Service
import android.content.Context
import android.content.DialogInterface
import android.content.res.Configuration
import android.os.IBinder
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AlertDialog
import com.yaman.utils.interfaces.AlertDialogInterfaces
import com.yaman.utils.models.SettingDialogData
import java.util.*

/**  Get Device Id  **/
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


/**  Close Keyboard (binding.getRoot().getWindowToken() => windowToken) **/
fun closeKeyboard(context: Context, windowToken: IBinder) {
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}

/**  Open Keyboard (requireView()) **/
fun openKeyboard(context: Context, view: View) {
    val inputMethodManager =
        context.getSystemService(Service.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInputFromInputMethod(view.windowToken, 0)
}


/**  Date to TimeStamp (String) Conversion. **/
fun convertDateToTimestamp(date: String): String {
    val timestamp = date.split("-".toRegex()).toTypedArray()
    val calendar = Calendar.getInstance()
    calendar.clear()
    calendar.timeZone = TimeZone.getTimeZone("UTC")
    calendar[timestamp[0].toInt(), timestamp[1].toInt() - 1] = timestamp[2].toInt()
    return (calendar.timeInMillis / 1000).toString()
}


/**
 * Showing Alert Dialog with Settings option
 * Navigates user to app settings
 * NOTE: Keep proper title and message depending on your app
 */
private fun showSettingsDialog(
    context: Context,
    settingDialogData: SettingDialogData,
    alertDialogInterfaces: AlertDialogInterfaces
) {
    Log.d("TAG", "showSettingsDialog: Started")
    val builder = AlertDialog.Builder(context)
    builder.setTitle(settingDialogData.title + " (Need Permissions)")
    builder.setMessage(settingDialogData.message + " needs permission to use this feature. You can grant them in app settings.")
    builder.setPositiveButton("Goto settings") { dialog: DialogInterface, which: Int ->
        alertDialogInterfaces.onAlertClick(true)
        dialog.cancel()
    }
    builder.setNegativeButton("Cancel") { dialog: DialogInterface, which: Int ->
        alertDialogInterfaces.onAlertClick(false)
        dialog.cancel()
    }
    builder.show()
}

