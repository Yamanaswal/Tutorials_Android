package com.yaman.popup_dialogs

import android.app.Activity
import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri


/** Open Dialog For App Version. ***/
fun openForceUpdateDialog(
    context: Context,
    message: String,
    forceFullUpdate: Boolean,
    listener: (Boolean) -> Unit
) {
    val activity = context as Activity

    if (!activity.isFinishing) {
        val builder = AlertDialog.Builder(context)

        builder.setTitle("New Update Available.")
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton(
                "Ok"
            ) { dialogInterface: DialogInterface?, _: Int ->
                dialogInterface?.dismiss()
                updateFromPlayStore(activity)
            }
            .setNegativeButton(
                "Cancel"
            ) { dialogInterface: DialogInterface?, _: Int ->
                dialogInterface?.dismiss()
                if (forceFullUpdate) {
                    context.finish()
                } else {
                    listener(true)
                }
            }

        val forceUpdateAlertDialog = builder.create()
        forceUpdateAlertDialog.show()
    }
}


/** Update from PlayStore. ***/
private fun updateFromPlayStore(context: Context) {
    val uri = Uri.parse("market://details?id=" + context.packageName)
    val goToMarket = Intent(Intent.ACTION_VIEW, uri)
    // To count with Play market back-stack, After pressing back button,
    // to taken back to our application, we need to add following flags to intent.
    goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
    try {
        context.startActivity(goToMarket)
        (context as Activity).finish()
    } catch (e: ActivityNotFoundException) {
        context.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=" + context.packageName)
            )
        )
    }
}