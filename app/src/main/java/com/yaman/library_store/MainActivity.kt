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
import com.yaman.popup_dialogs.openForceUpdateDialog
import com.yaman.progress_dialog.ProgressAnimatedDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}