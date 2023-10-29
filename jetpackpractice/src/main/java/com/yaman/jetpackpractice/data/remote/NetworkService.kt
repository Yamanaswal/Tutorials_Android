package com.yaman.jetpackpractice.data.remote

import android.content.Context
import com.google.gson.Gson
import com.yaman.jetpackpractice.data.models.BaseResponse
import com.yaman.jetpackpractice.data.models.EncryptionData
import com.yaman.jetpackpractice.data.models.user.UserResponse
import com.yaman.jetpackpractice.data.remote.RetrofitClient.getRetrofitInstance
import com.yaman.jetpackpractice.utils.AES
import org.json.JSONObject

object NetworkService {

    suspend fun userLoginAuthentication(
        context: Context,
        encryptionData: EncryptionData
    ): BaseResponse {
        val networkInterface: NetworkInterface = getRetrofitInstance(context).create(NetworkInterface::class.java)
        val dateGson = Gson().toJson(encryptionData)
        val dateStr: String = AES.encrypt(dateGson, context)
        val response = networkInterface.userLoginAuthentication(dateStr)
        val jsonString = AES.decrypt(
            response.body(),
            AES.generatekeyAPI(context),
            AES.generateVectorAPI(context)
        )
        val resJson = JSONObject(jsonString)
        return Gson().fromJson(resJson.toString(),UserResponse::class.java)
    }

}



