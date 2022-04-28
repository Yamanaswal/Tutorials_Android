package com.yaman.global_apis.retrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yaman.global_apis.models.DirectionApiResponse
import com.yaman.network_utils.R
import java.net.ConnectException

class GoogleRepo  {

    /*** Class Name - TAG ***/
    private val tag = "MainRepo"

    /*******************************************************************************
     * Api Service - Create Service
     * ****************************************************************************/
    private var apiService: ApiService = RetrofitServiceGeneratorGoogle.createService(serviceClass = ApiService::class.java)

    /********************************************************************************
     * Mutable And LiveData ApiResponse - Defined Here
     * ******************************************************************************/

    private val errorMutableLiveData = MutableLiveData<ERROR>()

    val errorLiveData: LiveData<ERROR>
        get() = errorMutableLiveData

    private val googleDirectionMutableLiveData =
        MutableLiveData<ApiResponse<DirectionApiResponse>>()

    val googleDirectionLiveData: LiveData<ApiResponse<DirectionApiResponse>>
        get() = googleDirectionMutableLiveData


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



}


enum class ERROR {
    ConnectException,
}