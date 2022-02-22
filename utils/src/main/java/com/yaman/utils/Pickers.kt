package com.yaman.utils

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Context
import android.util.Log
import android.widget.DatePicker
import java.util.*
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.widget.TimePicker


const val TAG = "Pickers Library"

class DefaultPickers() {

    fun openDatePicker(
        context: Context,
        calenderResponseListener: CalenderResponseListener<Any>
    ) {
        val currentYear: Int
        val currentMonth: Int
        val currentDay: Int

        val calendar: Calendar = Calendar.getInstance()

        currentYear = calendar.get(Calendar.YEAR)
        currentMonth = calendar.get(Calendar.MONTH)
        currentDay = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            context,
            { view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                Log.w(TAG, "onDateSet: $year$monthOfYear$dayOfMonth")
                calenderResponseListener.onDateTimeStamp(year + monthOfYear + dayOfMonth)
            }, currentYear, currentMonth, currentDay
        )
        datePickerDialog.datePicker.minDate = calendar.timeInMillis
        datePickerDialog.show()
    }


    fun openTimePicker(
        context: Context?,
        calenderResponseListener: CalenderResponseListener<Any?>
    ) {
        // Get Current Time
        val hour: Int
        val minute: Int
        val calendar = Calendar.getInstance()
        hour = calendar[Calendar.HOUR_OF_DAY]
        minute = calendar[Calendar.MINUTE]

        // Launch Time Picker Dialog
        val timePickerDialog = TimePickerDialog(
            context,
            { view: TimePicker?, hourOfDay: Int, minuteOfHour: Int ->
                Log.w(TAG, "openTimePicker: $hourOfDay$minuteOfHour")
                calenderResponseListener.onTimeResponse(hourOfDay + minuteOfHour)
            }, hour, minute, false
        )
        timePickerDialog.show()
    }


}





