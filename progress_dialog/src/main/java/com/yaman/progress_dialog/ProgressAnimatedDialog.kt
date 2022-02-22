package com.yaman.progress_dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.yaman.progress_dialog.databinding.ProgressItemBinding


class ProgressAnimatedDialog() : DialogFragment() {

    private lateinit var binding: ProgressItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.progress_item,
            container,
            false
        )
        // Set transparent background and no title
        if (dialog != null && dialog?.window != null) {
            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
            dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE);
        }

        Glide.with(requireContext()).asGif().load(R.drawable.scooter_anim).into(binding.orderDeliveryAnim)

        return binding.root
    }


}