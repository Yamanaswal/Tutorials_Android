package com.yaman.utils

import android.app.DatePickerDialog
import android.content.Context
import android.util.Log
import android.widget.DatePicker
import java.util.*

const val TAG = "Pickers"

fun openDatePicker(
    context: Context,
    startYear: Int = Calendar.getInstance()[Calendar.YEAR],
    startMonth: Int = Calendar.getInstance()[Calendar.MONTH],
    startDay: Int = Calendar.getInstance()[Calendar.DAY_OF_MONTH],
    minDate: Long = Calendar.getInstance().timeInMillis,
    isMinDate: Boolean = false,
    listener: (dayOfMonth:Int, monthOfYear:Int,year:Int) -> Unit
) {

    //Define Picker
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
            Log.w(TAG, "onDateSet: $year$monthOfYear$dayOfMonth")
            listener(dayOfMonth, monthOfYear + 1, year)
        }, startYear, startMonth, startDay
    )


    //No Min Date.
    if (isMinDate) {
        datePickerDialog.datePicker.minDate = minDate
    }

    datePickerDialog.show()
}


