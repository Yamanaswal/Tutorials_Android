package com.yaman.global_apis.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaman.global_apis.models.VerifyOtp
import com.yaman.global_apis.retrofit.ApiResponse
import com.yaman.global_apis.retrofit.ERROR
import com.yaman.global_apis.retrofit.MainRepos
import kotlinx.coroutines.launch

class Smg91ViewModel : ViewModel() {

    private val smg91Repo = MainRepos()

    /*********************
     * Live Data
     * *******************/

    val errorInApi: LiveData<ERROR>
        get() = smg91Repo.errorLiveDataGoogleRepo

    val smg91VerifyResponse: LiveData<ApiResponse<VerifyOtp>>
        get() = smg91Repo.verifyOtpSmg91LiveData

    /*********************
     * Methods
     * *******************/

    fun callSendSmsSmg91Api(
        authkey: String,
        mobile: String,
        template_id: String?,
        otp_length: String?
    ) {
        viewModelScope.launch {
            smg91Repo.sendOTPSmg91(
              authkey,
                mobile,
                template_id,
                otp_length
            )
        }
    }

    fun callVerifyOtpSmg91Api(
        authkey: String,
        mobile: String,
        otp: String?
    ) {
        viewModelScope.launch {
            smg91Repo.verifyOTPSmg91(
                authkey,
                mobile,
                otp
            )
        }
    }


}