package com.yaman.network_tools.network_utils
//
//import android.content.Context
//import android.util.Log
//import androidx.annotation.DrawableRes
//import com.google.gson.Gson
//import androidx.appcompat.app.AlertDialog
//import com.yaman.network_tools.R
//import com.yaman.network_tools.global_apis.retrofit.ApiResponse
//import java.lang.Exception
//
//class ErrorHandler<T>(private val context: Context, private val alertTitle: String?) {
//
//    fun <S> error(apiResponse: ApiResponse<T>,errorClass: Class<S>) {
//
//        try {
//            Log.e("ErrorHandler: error: ", "code: ${apiResponse.code}")
//            Log.e("ErrorHandler: error: ", "message: ${apiResponse.error}")
//            val errBody = Gson().fromJson(apiResponse.errorBody?.string(), errorClass)
//            Log.e("TAG", "error: $errBody")
//
//            val alertMsg = "Network Status Code: ${apiResponse.code} \n Network Message: ${apiResponse.error} \n Network Error Response: $errBody"
//            showAlert(alertMsg,R.drawable.about_us_red)
//
//        } catch (e: Exception) {
//            Log.e("ErrorHandler: error: ", "Exception : ${e.localizedMessage}")
//            Log.e("ErrorHandler: error: ", "Exception : ${e.message}")
//        }
//    }
//
//    private fun showAlert(message: String,@DrawableRes icon: Int) {
//
//        AlertDialog.Builder(context)
//            .setTitle(alertTitle)
//            .setMessage(message)
//            // Specifying a listener allows you to take an action before dismissing the dialog.
//            // The dialog is automatically dismissed when a dialog button is clicked.
//            .setPositiveButton(
//                R.string.ok
//            ) { dialog, _ ->
//                dialog.dismiss()
//                // Continue with delete operation
//            } // A null listener allows the button to dismiss the dialog and take no further action.
//            .setIcon(icon)
//            .show()
//    }
//
//
//}
//
