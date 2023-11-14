package com.yaman.jetpackpractice.view_model

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaman.jetpackpractice.data.models.BaseResponse
import com.yaman.jetpackpractice.data.models.EncryptionData
import com.yaman.jetpackpractice.data.remote.NetworkService
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private var loginResponseMutable = MutableLiveData<BaseResponse>()

    val loginResponseLiveData: LiveData<BaseResponse>
        get() = loginResponseMutable

    private var errorResponseMutable = MutableLiveData<String>()

    val errorResponseLivedata: LiveData<String>
        get() = errorResponseMutable

    fun loginApiCall(context: Context, encryptionData: EncryptionData = EncryptionData()) {

        viewModelScope.launch {

            val response = NetworkService.userLoginAuthentication(context, encryptionData)
            Log.e("response", "loginApiCall: ${response.message}")
            if (response.status) {
                loginResponseMutable.postValue(response)
            } else {
                errorResponseMutable.postValue(response.message)
            }
        }
    }
}