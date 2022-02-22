package com.yaman.location_services

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.util.Log
import java.io.IOException
import java.util.*

const val TAG = "LocationUtilsLibrary"

//TODO - get Location By Lat and Long.
fun getAddressFromLatLng(context: Context?, latitude: Double, longitude: Double): Address? {
    //Set Address
    try {
        val geocoder = Geocoder(context, Locale.getDefault())
        val addresses: List<Address>? = geocoder.getFromLocation(latitude, longitude, 1)
        if (addresses != null && addresses.isNotEmpty()) {
            val address: String = addresses[0].getAddressLine(0) // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            val city: String = addresses[0].locality
            val state: String = addresses[0].adminArea
            val country: String = addresses[0].countryName
            val postalCode: String = addresses[0].postalCode
            val phone = addresses[0].phone
            val premises = addresses[0].premises
            val subLocality = addresses[0].subLocality
            val extras = addresses[0].extras
            val knownName: String = addresses[0].featureName // Only if available else return NULL
            Log.d(TAG, "getAddress:  address: $address")
            Log.d(TAG, "getAddress:  country: $country")
            Log.d(TAG, "getAddress:  city: $city")
            Log.d(TAG, "getAddress:  state: $state")
            Log.d(TAG, "getAddress:  postalCode: $phone")
            Log.d(TAG, "getAddress:  knownName: $premises")
            Log.d(TAG, "getAddress:  knownName: $postalCode")
            Log.d(TAG, "getAddress:  knownName: $subLocality")
            Log.d(TAG, "getAddress:  knownName: $extras")
            Log.d(TAG, "getAddress:  knownName: $knownName")
            return addresses[0]
        }
    } catch (e: Exception) {
        Log.e(TAG, "getAddressFromLatLng: ${e.localizedMessage}")
        Log.e(TAG, "getAddressFromLatLng: ${e.message}")
    }
    return null
}


