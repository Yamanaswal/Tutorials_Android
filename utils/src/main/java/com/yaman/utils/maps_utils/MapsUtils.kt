package com.yaman.utils.maps_utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


object MapsUtils {

    /**
     * Get Marker Icon From Vector Assets
     * */
    fun bitmapDescriptorFromVector(context: Context, vectorResId: Int): BitmapDescriptor? {
        return ContextCompat.getDrawable(context, vectorResId)?.run {
            setBounds(0, 0, intrinsicWidth, intrinsicHeight)
            val bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888)
            draw(Canvas(bitmap))
            BitmapDescriptorFactory.fromBitmap(bitmap)
        }
    }

    /**
     * Get Marker - (MarkerOptions)
     * */
    fun markerOptions(markerLatLng: LatLng, title: String, icon: BitmapDescriptor = BitmapDescriptorFactory.defaultMarker(), draggable: Boolean): MarkerOptions {
        return MarkerOptions()
            .position(markerLatLng)
            .icon(icon)
            .title(title)
            .draggable(draggable)
    }




}

