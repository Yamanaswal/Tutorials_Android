package com.yaman.jetpackpractice.data.remote

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.yaman.jetpackpractice.BuildConfig
import com.yaman.jetpackpractice.data.models.EncryptionData
import com.yaman.jetpackpractice.data.models.User
import com.yaman.jetpackpractice.data.remote.RetrofitClient.getRetrofitInstance
import com.yaman.jetpackpractice.utils.AES
import retrofit2.Response

object NetworkService {

    suspend fun userLoginAuthentication(context: Context,encryptionData : EncryptionData): Response<String> {
        val networkInterface: NetworkInterface = getRetrofitInstance(context).create(NetworkInterface::class.java)
        val dateGson = Gson().toJson(encryptionData)
        val dateStr: String = AES.encrypt(dateGson, context)
        return networkInterface.userLoginAuthentication(dateStr)
    }

}



