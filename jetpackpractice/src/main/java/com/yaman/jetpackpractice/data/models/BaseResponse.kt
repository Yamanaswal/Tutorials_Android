package com.yaman.jetpackpractice.data.models

import com.google.gson.annotations.SerializedName

interface BaseResponse {

    @set:SerializedName("status")
    var status: Boolean

    @set:SerializedName("message")
    var message: String

    @set:SerializedName("time")
    var time: Int

    @set:SerializedName("interval")
    var interval: Int

    @set:SerializedName("limit")
    var limit: Int

    @set:SerializedName("cd_time")
    var cdTime: Int


}
