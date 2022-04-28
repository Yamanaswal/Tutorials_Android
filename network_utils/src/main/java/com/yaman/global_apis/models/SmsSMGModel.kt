package com.yaman.global_apis.models

import com.google.gson.annotations.SerializedName

data class VerifyOtp(
    @SerializedName("message")
    val message: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("code")
    val code: String,
)
