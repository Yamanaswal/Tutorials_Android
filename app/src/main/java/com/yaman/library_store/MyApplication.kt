package com.yaman.library_store

import android.app.Application
import com.yaman.library_store.realm_db.RealmDb
import com.yaman.network_tools.network_utils.RetrofitClient
import io.realm.Realm

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}