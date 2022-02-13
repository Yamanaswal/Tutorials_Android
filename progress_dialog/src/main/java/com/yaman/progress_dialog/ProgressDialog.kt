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
import androidx.fragment.app.FragmentManager
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.LottieCompositionFactory
import com.airbnb.lottie.LottieTask
import com.yaman.progress_dialog.databinding.ProgressItemBinding

class ProgressDialog() : DialogFragment() {

    private lateinit var binding: ProgressItemBinding

    fun constructor()  {

    }

//    private val progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    init {
        println("Init")
    }

    override fun show(manager: FragmentManager, tag: String?) {
        super.show(manager, tag)
    }

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
        showDialog()
        return binding.root
    }

    private fun showDialog() {
        binding.orderDeliveryAnim.speed = 1F
        binding.orderDeliveryAnim.playAnimation()
    }

    fun hideDialog() {
        binding.orderDeliveryAnim.pauseAnimation()
        dismiss()
    }

}