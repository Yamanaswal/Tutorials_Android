package com.yaman.library_tools.app_utils.pickers

import android.app.DatePickerDialog
import android.content.Context
import android.util.Log
import android.widget.DatePicker
import java.text.SimpleDateFormat
import java.util.*

private const val TAG = "Pickers"

fun openDatePicker(
    context: Context,
    startYear: Int = Calendar.getInstance()[Calendar.YEAR],
    startMonth: Int = Calendar.getInstance()[Calendar.MONTH],
    startDay: Int = Calendar.getInstance()[Calendar.DAY_OF_MONTH],
    minDate: Long = Calendar.getInstance().timeInMillis,
    maxDate: Long = Calendar.getInstance().timeInMillis,
    isMinDate: Boolean = false,
    isMaxDate: Boolean = false,
    dateFormat: String = "dd-MM-yyyy",
    listener: (dayOfMonth: Int, monthOfYear: Int, year: Int) -> Unit
) {

    //Define Picker
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
            try {
                val dateInput = SimpleDateFormat("dd-MM-yyyy",Locale.getDefault())
                val dateOutput = SimpleDateFormat("dd-MM-yyyy",Locale.getDefault())

            } catch (e: Exception) {
                Log.e(TAG, "openDatePicker: ", )
            }
            listener(dayOfMonth, monthOfYear + 1, year)
        }, startYear, startMonth, startDay
    )


    //No Min Date.
    if (isMinDate) {
        datePickerDialog.datePicker.minDate = minDate
    }

    if (isMaxDate) {
        datePickerDialog.datePicker.maxDate = maxDate
    }

    datePickerDialog.show()
}


