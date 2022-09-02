package com.yaman.network_tools.network_utils

object RetrofitService {

    fun <S> createService(baseUrl:String, serviceClass: Class<S>): S {
        return RetrofitClient.getAPIClient(baseUrl)!!.create(serviceClass)
    }

}
