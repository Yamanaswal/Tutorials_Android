package com.yaman.library_tools

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.util.Log
import com.google.android.gms.maps.model.LatLng
import java.util.*

private const val TAG = "LocationUtilsLibrary"

//TODO - get Location By Lat and Long.
fun getAddressFromLatLng(context: Context, latitude: Double, longitude: Double): Address? {
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



/**
 * Method to decode polyline points
 */
fun decodePolyline(encoded: String): List<LatLng> {
    try {
        val poly = ArrayList<LatLng>()
        var index = 0
        val len = encoded.length
        var lat = 0
        var lng = 0
        while (index < len) {
            var b: Int
            var shift = 0
            var result = 0
            do {
                b = encoded[index++].code - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlat = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lat += dlat
            shift = 0
            result = 0
            do {
                b = encoded[index++].code - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlng = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lng += dlng
            val latLng = LatLng((lat.toDouble() / 1E5), (lng.toDouble() / 1E5))
            poly.add(latLng)
        }
        return poly
    }catch (e: Exception){
        Log.e(TAG, "decodePolyline: ${e.localizedMessage}")
    }
    return ArrayList<LatLng>()
}



