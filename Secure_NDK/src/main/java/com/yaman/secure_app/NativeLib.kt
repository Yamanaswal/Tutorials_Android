package com.yaman.secure_app

class NativeLib {

    /**
     * A native method that is implemented by the 'secure_ndk' native library,
     * which is packaged with this application.
     */
    external fun baseUrl(): String
    external fun databaseKey(): String

    companion object {
        // Used to load the 'secure_ndk' library on application startup.
        init {
            System.loadLibrary("secure_ndk")
        }
    }
}