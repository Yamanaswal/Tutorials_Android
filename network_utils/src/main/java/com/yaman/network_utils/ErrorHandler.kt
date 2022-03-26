package com.yaman.network_utils

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import okhttp3.ResponseBody
import androidx.appcompat.app.AlertDialog
import com.google.gson.annotations.SerializedName
import java.lang.Exception

class ErrorHandler(private val context: Context,private val alertTitle:String?, ) {

    fun error(code: Int, errorBody: ResponseBody?, message: String?) {

        try {
            Log.e("ErrorHandler: error: ", "code: $code")
            Log.e("ErrorHandler: error: ", "message: $message")
            val errBody : ErrorResponse? = Gson().fromJson(errorBody?.string(),ErrorResponse::class.java)
            Log.e("TAG", "error: $errBody")

            val alertMsg = "Network Status: $code \n Network Message: $message \n Network Error Response: $errBody"
            showAlert(alertMsg)

        }catch (e: Exception){
            Log.e("ErrorHandler: error: ", "Exception : ${e.localizedMessage}")
            Log.e("ErrorHandler: error: ", "Exception : ${e.message}")
        }
    }

    private fun showAlert(message: String) {

        AlertDialog.Builder(context)
            .setTitle(alertTitle)
            .setMessage(message)
            // Specifying a listener allows you to take an action before dismissing the dialog.
            // The dialog is automatically dismissed when a dialog button is clicked.
            .setPositiveButton(
                R.string.ok
            ) { dialog, which ->
                dialog.dismiss()
                // Continue with delete operation
            } // A null listener allows the button to dismiss the dialog and take no further action.
            .setIcon(R.drawable.about_us_red)
            .show()
    }


    data class ErrorResponse(

        @SerializedName("status")
        val status: Int,

        @SerializedName("message")
        val message: String,

        @SerializedName("data")
        val data: ErrorResponseData = ErrorResponseData()
    )


    class ErrorResponseData {}


}

