package com.yaman.utils.interfaces


interface CalenderResponseListener<T> {
    fun onTimeResponse(response: T?)

    fun onDateTimeStamp(response: T?)
}