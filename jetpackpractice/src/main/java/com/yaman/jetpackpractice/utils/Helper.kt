package com.yaman.jetpackpractice.utils

import android.content.Context
import android.content.pm.PackageManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.yaman.jetpackpractice.data.models.user.User
import com.yaman.jetpackpractice.utils.PreferencesUtil.getStringPreference

object Helper {

    fun getVersionCode(activity: Context): Int {
        var version = 0
        try {
            val pInfo = activity.packageManager.getPackageInfo(activity.packageName, 0)
            version = pInfo.versionCode
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return version
    }

    fun getUserData(context: Context): User? {
        val userString = getStringPreference(context, PrefConstants.USER_DATA)
        return if (!userString.isNullOrEmpty()) {
            val user = Gson().fromJson(userString, User::class.java)
            user
        }else {
            null
        }
    }

}