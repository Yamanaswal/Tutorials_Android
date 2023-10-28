package com.yaman.jetpackpractice.data.remote

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.yaman.jetpackpractice.BuildConfig
import com.yaman.jetpackpractice.data.models.User
import com.yaman.jetpackpractice.utils.AES
import com.yaman.jetpackpractice.utils.Const
import com.yaman.jetpackpractice.utils.PrefConstants
import com.yaman.jetpackpractice.utils.PreferencesUtil
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private var retrofit: Retrofit? = null

    fun getRetrofitInstance(context: Context): Retrofit {
        if (retrofit == null) {

            val user = Gson().fromJson(
                PreferencesUtil.getStringPreference(context, PrefConstants.USER_DATA),
                User::class.java
            )

            val httpClient = OkHttpClient.Builder()
            val requestInterceptor = Interceptor { chain: Interceptor.Chain ->
                try {
                    val original = chain.request()

                    val requestBuilder: Request = original.newBuilder()
                        .header(Const.USER_ID, user.id ?: "")
                        .header(Const.DEVICE_TYPE, "1")
                        .header(Const.JWT, user.jwt ?: "")
                        ////                    .removeHeader("User-Agent")
                        ////                    .addHeader("User-Agent", "okhttp/4.9.1")
                        .header(Const.LANG, user.lang ?: "")
                        .header(Const.VERSION, user.version ?: "")
                        .header(Const.AUTHORIZATION, BuildConfig.Bearer + "_" + BuildConfig.API_ID)
                        .header(Const.APP_ID,  BuildConfig.API_ID)
                        .build()

                    chain.proceed(requestBuilder)
                } catch (e: Exception) {
                    e.localizedMessage?.let { Log.e("Request: getRetrofitInstance: ", it) }
                    throw Exception("\"Request: getRetrofitInstance: \" + e.localizedMessage")
                }
            }

            val responseInterceptor = Interceptor { chain: Interceptor.Chain ->
                try {// Intercept the response
                    val originalResponse = chain.proceed(chain.request())
                    // Decrypt the response here
                    val decryptedResponse: String = AES.decrypt(originalResponse.body!!.string(),
                        AES.generatekeyAPI(context), AES.generateVectorAPI(context))
                    // Build a new response with the decrypted content
                    val newResponse = originalResponse.newBuilder()
                        .body(ResponseBody.create(originalResponse.body!!.contentType(), decryptedResponse))

                    newResponse.build()
                } catch (e: Exception) {
                    e.localizedMessage?.let { Log.e("Request: getRetrofitInstance: ", it) }
                    throw Exception("\"Response: getRetrofitInstance: \" + e.localizedMessage")
                }
            }

            httpClient
                .addInterceptor(requestInterceptor)
                .addInterceptor(responseInterceptor)
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .build()

            val logging = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            } else {
                logging.setLevel(HttpLoggingInterceptor.Level.NONE)
            }
            httpClient.addInterceptor(logging)

            retrofit = Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .client(httpClient.build())
                .build()

            return retrofit!!
        }
        return retrofit!!
    }


}
