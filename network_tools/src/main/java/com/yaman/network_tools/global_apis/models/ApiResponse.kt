package com.yaman.network_tools.global_apis.models

import okhttp3.ResponseBody

data class ApiResponse<T>(
    var response: T?,
    var errorBody: ResponseBody?,
    var error: String?,
    var code: Int
)


