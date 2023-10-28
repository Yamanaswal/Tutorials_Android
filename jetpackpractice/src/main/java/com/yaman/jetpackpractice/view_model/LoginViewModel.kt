package com.yaman.jetpackpractice.view_model

import android.content.Context
import android.service.autofill.UserData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaman.jetpackpractice.data.models.EncryptionData
import com.yaman.jetpackpractice.data.remote.NetworkService
import com.yaman.jetpackpractice.utils.ResponseCallback
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
            val response = NetworkService.userLoginAuthentication(context, encryptionData)
            if (response.isSuccessful) {
                loginResponseMutable.postValue(response.body())
            } else {
                errorResponseMutable.postValue(response.message())
            }
        }
    }
}