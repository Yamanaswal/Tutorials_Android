package com.yaman.library_store

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.yaman.location_services.GpsUtils
import com.yaman.location_services.OnGpsListener
import com.yaman.progress_dialog.ProgressAnimatedDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progress = ProgressAnimatedDialog()

        findViewById<Button>(R.id.openDialog).setOnClickListener {
            progress.show(supportFragmentManager,"asd")
        }

        findViewById<Button>(R.id.closeDialog).setOnClickListener {
            GpsUtils(this).turnGPSOn(onGpsListener = object : OnGpsListener {
                override fun gpsStatus(isGPSEnable: Boolean) {
                    Log.e("TAG", "gpsStatus: $isGPSEnable", )
                }
            })
        }

        findViewById<Button>(R.id.openRV).setOnClickListener {
            startActivity(Intent(this,RecyclerViewScreen::class.java))
        }

    }


}