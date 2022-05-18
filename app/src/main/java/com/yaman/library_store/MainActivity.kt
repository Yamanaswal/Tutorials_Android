package com.yaman.library_store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.yaman.global_apis.view_models.GoogleApiViewModel
import com.yaman.global_apis.view_models.Smg91ViewModel
import com.yaman.network_utils.ErrorHandler
import com.yaman.popup_dialogs.DialogData
import com.yaman.popup_dialogs.PopUpDialogOneButtonIos
import com.yaman.progress_dialog.ProgressAnimatedDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progress = ProgressAnimatedDialog()

        val key = "AIzaSyBY9xpoud_-neFU4lbPpkH_P4hbw51jdOk"

        val googleApiViewModel = ViewModelProvider(this)[GoogleApiViewModel::class.java]
        val smg91ViewModel = ViewModelProvider(this)[Smg91ViewModel::class.java]

        findViewById<Button>(R.id.openDialog).setOnClickListener {
//            progress.show(supportFragmentManager,"asd")
            val popUpDialog = PopUpDialogOneButtonIos(DialogData(getString(R.string.app_name))) { status ->

            }
            popUpDialog.show(supportFragmentManager, "popUpDialog")
        }

        findViewById<Button>(R.id.closeDialog).setOnClickListener {

        }

        findViewById<Button>(R.id.openRV).setOnClickListener {

        }


        val editText = findViewById<EditText>(R.id.editTextId)

        val list = ArrayList<String>()
        list.add("Yaman")
        list.add("Aswal")
        list.add("Test")
        list.add("MainUser")
        list.add("user")
        list.add("USER")

        editText.addTextChangedListener {
            Log.e("TAG", "onCreate: ${it.toString()}")
        }


    }

}