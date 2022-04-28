package com.yaman.global_apis.retrofit

import com.yaman.global_apis.models.DirectionApiResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    /*
    * Google - Direction Api
    * */
    @GET("directions/json")
    suspend fun googleDirectionApi(
        @Query("key") key: String,
        @Query("origin") origin: String,
        @Query("destination") destination: String,
        @Query(value = "waypoints",encoded = true) waypoints: String?,
        @Query(value = "avoid",encoded = true) avoid: String?,
        @Query(value = "units",encoded = true) units: String?,
        @Query(value = "language",encoded = true) language: String?,
        @Query(value = "transit_mode",encoded = true) transit_mode: String?,
        @Query(value = "transit_routing_preference",encoded = true) transit_routing_preference: String?
    ) : Response<DirectionApiResponse>

    
}