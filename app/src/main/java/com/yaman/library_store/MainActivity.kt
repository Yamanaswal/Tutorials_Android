package com.yaman.library_store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.yaman.progress_dialog.ProgressAnimatedDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progress = ProgressAnimatedDialog()

        findViewById<Button>(R.id.openDialog).setOnClickListener {
            progress.show(supportFragmentManager,"asd")
        }

    }
}