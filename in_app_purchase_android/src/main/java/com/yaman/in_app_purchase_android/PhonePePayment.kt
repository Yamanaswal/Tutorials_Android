package com.yaman.in_app_purchase_android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.phonepe.intent.sdk.api.B2BPGRequestBuilder
import com.phonepe.intent.sdk.api.PhonePe
import com.phonepe.intent.sdk.api.PhonePeInitException
import com.phonepe.intent.sdk.api.UPIApplicationInfo
import com.phonepe.intent.sdk.api.models.PhonePeEnvironment


class PhonePePayment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_phone_pe_payment)
        val string_signature = PhonePe.getPackageSignature()
        PhonePe.init(this, PhonePeEnvironment.UAT,"PGTESTPAYUAT","")

        try {
//            PhonePe.setFlowId("Unique Id of the user") // Recommended, not mandatory , An alphanumeric string without any special character
            val upiApps : List<UPIApplicationInfo>  = PhonePe.getUpiApps()
            upiApps.forEach {
                Log.e("UPIApplicationInfo: ", "onCreate: " + it.packageName)
            }
        } catch (exception: PhonePeInitException) {
            exception.printStackTrace();
        }

        val b2BPGRequest = B2BPGRequestBuilder()
            .setData(base64Body)
            .setChecksum(checksum)
            .setUrl(apiEndPoint)
            .build()

        //For SDK call below function
        try {
            startActivityForResult(PhonePe.getImplicitIntent(this, b2BPGRequest, "input package name of upi app to be opened")!!,B2B_PG_REQUEST_CODE)
        } catch(e: PhonePeInitException){
            Log.e("TAG", "onCreate: " + e.localizedMessage)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == B2B_PG_REQUEST_CODE) {

            /*This callback indicates only about completion of UI flow.
            Inform your server to make the transaction
            status call to get the status. Update your app with the
            success/failure status.*/
        }
    }

    private val B2B_PG_REQUEST_CODE = 777
    private val base64Body = "eyJtZXJjaGFudElkIjpudWxsLCJtZXJjaGFudFRyYW5zYWN0aW9uSWQiOiIzNDlmNWM4ZDk1MjJiOGI5NTM1MDFkNTU2YWJlYjY4OCIsImFtb3VudCI6MTUwMDAsInJlZGlyZWN0VXJsIjpudWxsLCJyZWRpcmVjdE1vZGUiOiJQT1NUIiwiY2FsbGJhY2tVcmwiOm51bGwsIm1vYmlsZU51bWJlciI6Ijg2MTkwODYyNDgiLCJtZXNzYWdlIjoiQ291cnNlIElEICA9IDIzNTcgLCBBUFBfSUQgPSAxMjAgVXNlciBpZCA9IDg4NTUwOSBUeXBlID0gUHJpbWFyeSIsImVtYWlsIjoibWFuaXNoQGFwcHNxdWFkaC5jb20iLCJzaG9ydE5hbWUiOiJNYW5pc2giLCJwYXltZW50SW5zdHJ1bWVudCI6eyJ0eXBlIjoiUEFZX1BBR0UifX0="
    private val checksum = "980da2786630b103e8092b7b86f0ea98bc4fb57fdb18ce253bb60b65d3961de2###1"
    private val apiEndPoint = "/pg/v1/pay"
}