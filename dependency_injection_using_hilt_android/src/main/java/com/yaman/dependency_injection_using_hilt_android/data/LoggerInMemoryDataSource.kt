package com.yaman.dependency_injection_using_hilt_android.data

import android.os.Handler
import android.os.Looper
import dagger.hilt.android.scopes.ActivityScoped
import java.util.LinkedList
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Data manager class that handles data manipulation between the database and the UI.
 */
@ActivityScoped
class LoggerInMemoryDataSource @Inject constructor(private val logDao: LogDao) : LoggerDataSource {

    private val logs = LinkedList<Log>()

    override fun addLog(msg: String) {
        logs.addFirst(Log(msg, System.currentTimeMillis()))
    }

    override fun getAllLogs(callback: (List<Log>) -> Unit) {
        callback(logs)
    }

    override fun removeLogs() {
        logs.clear()
    }
}
