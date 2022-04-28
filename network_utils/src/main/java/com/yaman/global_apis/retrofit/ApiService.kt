package com.yaman.global_apis.retrofit

import com.yaman.global_apis.models.DirectionApiResponse
import com.yaman.global_apis.models.VerifyOtp
import retrofit2.Response
import retrofit2.http.*
import java.util.*

interface ApiService {

    /**
    * Google - Direction Api
    ***/
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

    /**
     * SMG 91 - Send OTP
     ***/
    @GET("https://api.msg91.com/api/v5/otp?")
    suspend fun sendOTP(
        @Query("authkey") authKey: String,
        @Query("mobile") mobileNumber: String,
        @Query("template_id") templateId: String?,
        @Query("otp_length") otpLength: String?
    ): Response<Objects>


    /**
     * SMG 91 - Verify OTP
     ***/
    @GET("https://api.msg91.com/api/v5/otp/verify?")
    suspend fun verifyOTP(
        @Query("authkey") authKey: String,
        @Query("mobile") mobile: String,
        @Query("otp") otp: String?
    ): Response<VerifyOtp>


}