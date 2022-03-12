package com.yaman.network_utils

import android.app.Dialog
import android.content.Context
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView


class NoInternetDialog(private val context: Context,private val message: String) {

    init {
        showDialog(context,message)
    }

    private fun showDialog(context: Context, msg: String) {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_view)

        dialog.findViewById<TextView>(R.id.text_dialog).text = msg

        val dialogButton: Button = dialog.findViewById(R.id.btn_dialog) as Button

        dialogButton.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }
}