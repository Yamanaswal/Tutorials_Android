package com.yaman.network_tools.socket_utils

import android.util.Log
import io.socket.client.IO
import io.socket.client.Socket

object SocketUtil {

    private val tag = "SocketUtil : "
    private lateinit var mSocket: Socket

    fun initSocket(url: String,mOptions: IO.Options) {
        try {
            mSocket = IO.socket(url,mOptions)
            mSocket.connect()
        } catch (e: Exception) {
            Log.e(tag, "Exception: $e")
        }
    }

    fun connectSocket() {
        mSocket.connect()
        Log.e(tag, "connectSocket: ${mSocket.connected()}")
    }

    fun disconnectSocket(closeSocket: Boolean = true) {
        mSocket.disconnect()
        Log.e(tag, "disconnectSocket: ${mSocket.connected()}")
        if (closeSocket) {
            mSocket.close()
        }
    }

    fun emitSocket(event: String, data: String) {
        mSocket.emit(event, data)
    }

    fun getSocket(): Socket {
        return mSocket
    }

}