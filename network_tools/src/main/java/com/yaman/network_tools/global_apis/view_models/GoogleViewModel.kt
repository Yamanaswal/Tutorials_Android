package com.yaman.network_tools.global_apis.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaman.network_tools.global_apis.models.DirectionApiResponse
import com.yaman.network_tools.global_apis.models.ApiResponse
import com.yaman.network_tools.global_apis.repos.ERROR
import com.yaman.network_tools.global_apis.repos.MainRepos
import kotlinx.coroutines.launch

class GoogleApiViewModel : ViewModel() {

    private val googleRepo = MainRepos()

    /*********************
     * Live Data
     * *******************/

    val errorInApi: LiveData<ERROR>
        get() = googleRepo.errorLiveDataGoogleRepo


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