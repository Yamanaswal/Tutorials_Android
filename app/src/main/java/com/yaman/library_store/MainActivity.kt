package com.yaman.library_store

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.yaman.global_apis.retrofit.GoogleApiViewModel
import com.yaman.location_services.GpsUtils
import com.yaman.location_services.OnGpsListener
import com.yaman.popup_dialogs.DialogData
import com.yaman.popup_dialogs.PopUpDialogWithTwoButtonIos
import com.yaman.progress_dialog.ProgressAnimatedDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progress = ProgressAnimatedDialog()

        val key = "AIzaSyBY9xpoud_-neFU4lbPpkH_P4hbw51jdOk"

        val googleApiViewModel = ViewModelProvider(this)[GoogleApiViewModel::class.java]

        findViewById<Button>(R.id.openDialog).setOnClickListener {
//            progress.show(supportFragmentManager,"asd")
            val popUpDialog = PopUpDialogWithTwoButtonIos(DialogData(getString(R.string.app_name),"")) {}
            popUpDialog.show(supportFragmentManager,"popUpDialog")
        }

        findViewById<Button>(R.id.closeDialog).setOnClickListener {
            GpsUtils(this).turnGPSOn(onGpsListener = object : OnGpsListener {
                override fun gpsStatus(isGPSEnable: Boolean) {
                    Log.e("TAG", "gpsStatus: $isGPSEnable", )
                }
            })

            googleApiViewModel.callGoogleDirectionApi(key,"28.657160479655932, 77.35388117122676","28.600910140889273, 77.39402538932049")



        }

        findViewById<Button>(R.id.openRV).setOnClickListener {
            startActivity(Intent(this,RecyclerViewScreen::class.java))
        }



    }

}