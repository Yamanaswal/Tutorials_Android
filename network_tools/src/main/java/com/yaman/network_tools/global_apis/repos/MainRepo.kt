package com.yaman.network_tools.global_apis.repos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yaman.network_tools.global_apis.models.ApiResponse
import com.yaman.network_tools.global_apis.models.DirectionApiResponse
import com.yaman.network_tools.global_apis.models.VerifyOtp
import com.yaman.network_tools.global_apis.services.ApiService
import com.yaman.retrofit.RetrofitClient
import retrofit2.create
import java.net.ConnectException
import java.util.*

class MainRepos  {

    /*** Class Name - TAG ***/
    private val tag = "MainRepo"

    private var BASE_URL: String = "https://maps.googleapis.com/maps/api/"

    /*******************************************************************************
     * Api Service - Create Service
     * ****************************************************************************/
    private var apiService: ApiService = RetrofitClient.buildClient(BASE_URL)?.create(ApiService::class.java)!!


    /********************************************************************************
     * Mutable And LiveData ApiResponse - Defined Here
     * ******************************************************************************/

    private val errorMutableLiveData = MutableLiveData<ERROR>()

    val errorLiveDataGoogleRepo: LiveData<ERROR>
        get() = errorMutableLiveData

    private val googleDirectionMutableLiveData =
        MutableLiveData<ApiResponse<DirectionApiResponse>>()

    val googleDirectionLiveData: LiveData<ApiResponse<DirectionApiResponse>>
        get() = googleDirectionMutableLiveData

    private val sendOtpMutableLiveData =
        MutableLiveData<ApiResponse<Objects>>()

    val sendOtpSmg91LiveData: LiveData<ApiResponse<Objects>>
        get() = sendOtpMutableLiveData

    private val verifyOtpMutableLiveData =
        MutableLiveData<ApiResponse<VerifyOtp>>()

    val verifyOtpSmg91LiveData: LiveData<ApiResponse<VerifyOtp>>
        get() = verifyOtpMutableLiveData


    /**********************************************************************************
     * Api Methods - Defined Here
     * *******************************************************************************/

    suspend fun googleDirectionApi(key: String, origin: String, destination: String, waypoints: String?,avoid: String?,units: String?,language: String?,transit_mode: String?, transit_routing_preference: String?) {
        try {
            val response = apiService.googleDirectionApi(key, origin, destination, waypoints, avoid , units , language , transit_mode , transit_routing_preference)

            googleDirectionMutableLiveData.postValue(
                ApiResponse(
                    response = response.body(),
                    errorBody = response.errorBody(),
                    error = response.message(),
                    code = response.code()
                )
            )

        } catch (e: Exception) {
            Log.e(tag, "Exception (localizedMessage) -> driverListApi: ${e.localizedMessage}")
            Log.e(tag, "Exception (message) -> driverListApi: ${e.message}")
            if (e is ConnectException) {
                errorMutableLiveData.postValue(ERROR.ConnectException)
            }
        }
    }



    suspend fun sendOTPSmg91(
        authkey: String,
        mobile: String,
        template_id: String?,
        otp_length: String?
    ) {
        try {
            val response = apiService.sendOTP(authkey, mobile, template_id, otp_length)

            sendOtpMutableLiveData.postValue(
                ApiResponse(
                    response = response.body(),
                    errorBody = response.errorBody(),
                    error = response.message(),
                    code = response.code()
                )
            )


        } catch (e: Exception) {
            Log.e(tag, "Exception (localizedMessage) -> sendOTP: ${e.localizedMessage}")
            Log.e(tag, "Exception (message) -> sendOTP: ${e.message}")
            if (e is ConnectException) {
                errorMutableLiveData.postValue(ERROR.ConnectException)
            }
        }
    }


    suspend fun verifyOTPSmg91(
        authkey: String,
        mobile: String,
        otp: String?
    ) {
        try {
            val response = apiService.verifyOTP(authkey, mobile, otp)

            verifyOtpMutableLiveData.postValue(
                ApiResponse(
                    response = response.body(),
                    errorBody = response.errorBody(),
                    error = response.message(),
                    code = response.code()
                )
            )

        } catch (e: Exception) {
            Log.e(tag, "Exception (localizedMessage) -> sendOTP: ${e.localizedMessage}")
            Log.e(tag, "Exception (message) -> sendOTP: ${e.message}")
            if (e is ConnectException) {
                errorMutableLiveData.postValue(ERROR.ConnectException)
            }
        }
    }

}


enum class ERROR {
    ConnectException,
}