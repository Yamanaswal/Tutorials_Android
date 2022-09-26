package com.yaman.library_store.room_db

import android.content.Context
import androidx.room.*

/**
 * Database Builder.
 * */
object RoomDatabaseBuilder {

    fun initBuilder(context: Context, databaseName: String): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, databaseName
        ).fallbackToDestructiveMigration().build()
    }

}

/**
 * Database Main
 * */
@Database(entities = [User::class, Test::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}



