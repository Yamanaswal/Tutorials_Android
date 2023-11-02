package com.yaman.jetpackpractice.view_model

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaman.jetpackpractice.data.models.EncryptionData
import com.yaman.jetpackpractice.data.remote.NetworkService
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private var loginResponseMutable = MutableLiveData<String>()

    val loginResponse: LiveData<String>
        get() = loginResponseMutable

    private var errorResponseMutable = MutableLiveData<String>()

    val errorResponseLivedata: LiveData<String>
        get() = errorResponseMutable

    fun loginApiCall(context: Context) {

        viewModelScope.launch {
            val encryptionData = EncryptionData()

            encryptionData.mobile = "9868700646"
            encryptionData.password = "password"
            encryptionData.device_id = "deviceId"
            encryptionData.is_social = "0"
            encryptionData.c_code = "91"
            encryptionData.device_token = "123124124241"

            val response = NetworkService.userLoginAuthentication(context, encryptionData)
            Log.e("response", "loginApiCall: ${response.message}")
//            if (response.status) {
////                loginResponseMutable.postValue(response.body())
//            } else {
//                errorResponseMutable.postValue(response.message())
//            }
        }
    }
}