package com.yaman.realm

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration


object RealmDb {

    private const val realmName: String = "MyProject.db"

    private val config: RealmConfiguration = RealmConfiguration.Builder()
        .name(realmName)
        .schemaVersion(1)
        .allowQueriesOnUiThread(false)
        .deleteRealmIfMigrationNeeded()
        .build()

    fun getRealmInstance(): Realm {
        return Realm.getInstance(config)
    }

}

