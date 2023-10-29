package com.yaman.jetpackpractice.data.remote

import android.content.Context
import com.google.gson.Gson
import com.yaman.jetpackpractice.BuildConfig
import com.yaman.jetpackpractice.data.models.user.User
import com.yaman.jetpackpractice.utils.Const
import com.yaman.jetpackpractice.utils.Helper.getVersionCode
import com.yaman.jetpackpractice.utils.PrefConstants
import com.yaman.jetpackpractice.utils.PreferencesUtil
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {

    private var user: User? = null
    private var retrofit: Retrofit? = null

    fun getRetrofitInstance(context: Context): Retrofit {
        if (retrofit == null) {

            if (PreferencesUtil.getStringPreference(
                    context,
                    PrefConstants.USER_DATA
                ) != null && PreferencesUtil.getStringPreference(context, PrefConstants.USER_DATA)!!.isNotEmpty()
            ) {
                user = Gson().fromJson(
                    PreferencesUtil.getStringPreference(context, PrefConstants.USER_DATA),
                    User::class.java
                )
            }


            val httpClient = OkHttpClient.Builder()

            //Request Handler
            val requestInterceptor = Interceptor { chain: Interceptor.Chain ->
                val original = chain.request()

                val requestBuilder: Request = original.newBuilder()
                    .header(Const.USER_ID, if (user != null) user!!.id ?: "" else "")
                    .header(Const.DEVICE_TYPE, "1")
                    .header(Const.JWT, if (user != null) user!!.jwt ?: "" else "")
                    .removeHeader("User-Agent")
                    .addHeader("User-Agent", "okhttp/4.9.1")
                    .header(Const.LANG, if (user != null) user!!.lang ?: "" else "")
                    .header(Const.VERSION, getVersionCode(context).toString())
                    .header(Const.AUTHORIZATION, BuildConfig.Bearer + "_" + BuildConfig.API_ID)
                    .header(Const.APP_ID, BuildConfig.API_ID)
                    .build()

                chain.proceed(requestBuilder)
            }

      /*      //Response Handler
            val responseInterceptor = Interceptor { chain: Interceptor.Chain ->

                Log.i("", "===============DECRYPTING RESPONSE===============")

                val originalResponse = chain.proceed(chain.request())
                var decryptedString: String? = null

                val newResponse: Response.Builder = originalResponse.newBuilder()
                var contentType: String? = originalResponse.header("Content-Type")
                if (TextUtils.isEmpty(contentType)) contentType = "application/json"

                try {
                    // Decrypt the response here
                    decryptedString = AES.decrypt(
                        originalResponse.body!!.string(),
                        AES.generatekeyAPI(context), AES.generateVectorAPI(context)
                    )

                    Log.i("Response string => %s", decryptedString)
                    val jsonObject = JSONObject(decryptedString)

                } catch (e: Exception) {
                    decryptedString = originalResponse.body!!.toString()
                }


                // Build a new response with the decrypted content
                originalResponse
            }
*/


            httpClient
                .addInterceptor(requestInterceptor)
//                .addInterceptor(responseInterceptor)
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
