package com.yaman.popup_dialogs

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.yaman.progress_dialog.R
import com.yaman.progress_dialog.databinding.PopupDialogBinding

class PopUpDialogTwoButtonIos(private val dataDialog: DialogData, val listener: (status: Boolean) -> Unit) : DialogFragment() {

    private lateinit var binding: PopupDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.popup_dialog,
            container,
            false
        )
        // Set transparent background and no title
        if (dialog != null && dialog?.window != null) {
            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
            dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE);
        }

        binding.dialogData = dataDialog

        binding.okButton.setOnClickListener {
            listener(true)
        }

        binding.cancelButton.setOnClickListener {
            listener(false)
            dismiss()
        }

        return binding.root
    }


}

