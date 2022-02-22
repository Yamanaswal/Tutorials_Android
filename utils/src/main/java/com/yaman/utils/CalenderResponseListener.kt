package com.yaman.utils


interface CalenderResponseListener<T> {
    fun onTimeResponse(response: T?)

    fun onDateTimeStamp(response: T?)
}