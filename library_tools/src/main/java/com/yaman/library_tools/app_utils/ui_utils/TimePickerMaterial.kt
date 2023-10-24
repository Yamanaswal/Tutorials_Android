package com.yaman.library_tools.app_utils.ui_utils

import android.content.Context
import android.text.format.DateFormat
import androidx.fragment.app.FragmentManager
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.*

class TimePickerMaterial(
    val context: Context,
    private val timeFormat: Int = TimeFormat.CLOCK_12H,
    private val isSystemLocaleFormat: Boolean = false,
    private val hour: Int = 12,
    private val minute: Int = 10,
    private val titleText: CharSequence = "Select Time",
    private val inputMode: Int = MaterialTimePicker.INPUT_MODE_KEYBOARD,
    val listener: (positive: String, negative: Unit?) -> Unit
) {

    private val materialTimePickerBuilder = MaterialTimePicker.Builder()
    private lateinit var materialTimePicker: MaterialTimePicker
    private var clockFormat = TimeFormat.CLOCK_12H

    /**
     * Initialize Time Picker.
     * */
    private fun initPicker() {
        /** Initialize Time Format. */
        clockFormat = timeFormat

        materialTimePickerBuilder
            .setTimeFormat(clockFormat)
            .setHour(hour)
            .setMinute(minute)
            .setTitleText(titleText)
            .setInputMode(inputMode)

        /**
         * You can use either TimeFormat.CLOCK_12H or TimeFormat.CLOCK_24H, depending on the locale of the device:
         * */
        if (isSystemLocaleFormat) {
            val isSystem24Hour = DateFormat.is24HourFormat(context)
            clockFormat = if (isSystem24Hour) TimeFormat.CLOCK_24H else TimeFormat.CLOCK_12H
            materialTimePickerBuilder.setTimeFormat(clockFormat)
        }

        /**
         * Build Time Picker.
         * */
        materialTimePicker = materialTimePickerBuilder.build()
    }

    /**
     * Show Time Picker.
     * */
    fun show(fragmentManager: FragmentManager, tag: String) {
        try {
            materialTimePicker.show(fragmentManager, tag)

            //INIT Callbacks.
            setupCallbacks()

        } catch (e: Exception) {
            LogUtils.e("TimePickerMaterial - show: ", e.localizedMessage?.toString() ?: "Error...")
        }
    }


    private fun setupCallbacks() {
        materialTimePicker.addOnPositiveButtonClickListener {

            if (clockFormat == TimeFormat.CLOCK_12H) {
                listener(
                    convertTime24To12("${materialTimePicker.hour}:${materialTimePicker.minute}"),
                    null
                )
            } else {
                val simpleDateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
                val date =
                    simpleDateFormat.parse("${materialTimePicker.hour}:${materialTimePicker.minute}")
                listener(simpleDateFormat.format(date!!), null)
            }

            materialTimePicker.dismiss()
        }

        materialTimePicker.addOnNegativeButtonClickListener {
            listener("${materialTimePicker.hour}:${materialTimePicker.minute}", null)
            materialTimePicker.dismiss()
        }

//        materialTimePicker.addOnCancelListener {
//            listener("${materialTimePicker.hour}:${materialTimePicker.minute}",null,null,null)
//        }

//        materialTimePicker.addOnDismissListener {
//            listener("${materialTimePicker.hour}:${materialTimePicker.minute}",null,null,null)
//        }

    }


    init {
        initPicker()
    }

}