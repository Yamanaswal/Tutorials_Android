package com.yaman.global_apis.retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaman.global_apis.models.DirectionApiResponse
import kotlinx.coroutines.launch

class GoogleApiViewModel : ViewModel() {

    private val googleRepo = GoogleRepo()


    /*********************
     * Live Data
     * *******************/

    val googleDirectionApiResponse: LiveData<ApiResponse<DirectionApiResponse>>
        get() = googleRepo.googleDirectionLiveData


    /*********************
     * Methods
     * *******************/

    fun callGoogleDirectionApi(
        key: String,
        origin: String,
        destination: String,
        waypoints: String? = null,
        avoid: String? = null,
        units: String? = "metric",
        language: String? = "en",
        transit_mode: String? = null,
        transit_routing_preference: String? = null
    ) {
        viewModelScope.launch {
            googleRepo.googleDirectionApi(
                key,
                origin,
                destination,
                waypoints,
                avoid,
                units,
                language,
                transit_mode,
                transit_routing_preference
            )
        }
    }


}