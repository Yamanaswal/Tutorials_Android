package com.yaman.library_tools.app_utils.core_utils

import android.util.Log

object LogUtils {

    var isDebuggable = true

    fun e(tag: String, message: String) {
        if (isDebuggable) {
            Log.e(tag, message)
        }
    }

    fun i(tag: String, message: String) {
        if (isDebuggable) {
            Log.i(tag, message)
        }
    }

    fun d(tag: String, message: String) {
        if (isDebuggable) {
            Log.d(tag, message)
        }
    }

    fun w(tag: String, message: String) {
        if (isDebuggable) {
            Log.w(tag, message)
        }
    }

}