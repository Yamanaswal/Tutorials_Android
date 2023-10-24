package com.yaman.library_tools.app_utils.ui_utils

import androidx.fragment.app.FragmentManager
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*
import java.text.SimpleDateFormat


class DatePickerMaterial(
    val type: DatePickerType = DatePickerType.DATE_PICKER,
    private var titleText: CharSequence = "Select Date",
    constraintsEnable: Boolean = false,
    private var dateFormat: String = "dd-MM-yyyy",
    private var openMonth: Int = Calendar.JANUARY,
    private var startMonth: Int = Calendar.JANUARY,
    private var endMonth: Int = Calendar.DECEMBER,
    private val todayForwardSelectable: Boolean = false,
    private val todayBackwardSelectable: Boolean = false,
    private val inputMode: Int = MaterialDatePicker.INPUT_MODE_CALENDAR,
    private val selectedDate: Long = MaterialDatePicker.todayInUtcMilliseconds(),
    private val selectMonth: Long = MaterialDatePicker.thisMonthInUtcMilliseconds(),
    val listener: (positive: String, negative: Unit?) -> Unit
) {


    private var datePickerBuilder = MaterialDatePicker.Builder.datePicker()
    var dateRangePickerBuilder = MaterialDatePicker.Builder.dateRangePicker()
    private lateinit var materialDatePicker: MaterialDatePicker<Long>
    private lateinit var materialRangeDatePicker: MaterialDatePicker<Pair<Long, Long>>

    // Build constraints.
    private val constraintsBuilder = CalendarConstraints.Builder()

    private fun initPicker() {
        when (type) {
            DatePickerType.DATE_PICKER -> {
                datePickerBuilder
                    .setSelection(selectedDate)
                    .setTitleText(titleText)
                    .setInputMode(inputMode)
                    .setCalendarConstraints(constraintsBuilder.build())

                materialDatePicker = datePickerBuilder.build()
            }
            DatePickerType.DAY_RANGE_PICKER -> {
                dateRangePickerBuilder
                    .setSelection(Pair(selectMonth, selectedDate))
                    .setTitleText(titleText)
                    .setInputMode(inputMode)
                    .setCalendarConstraints(constraintsBuilder.build())

                materialRangeDatePicker = dateRangePickerBuilder.build()
            }
        }
    }

    /**
     * Show Date Picker.
     * */
    fun show(fragmentManager: FragmentManager, tag: String) {
        try {
            when (type) {
                DatePickerType.DATE_PICKER -> {
                    materialDatePicker.show(fragmentManager, tag)
                }
                DatePickerType.DAY_RANGE_PICKER -> {
                    materialRangeDatePicker.show(fragmentManager, tag)
                }
            }

            //INIT Callbacks.
            setupCallbacks()

        } catch (e: Exception) {
            LogUtils.e("DatePickerMaterial - show: ", e.localizedMessage?.toString() ?: "Error...")
        }
    }

    private fun setupCallbacks() {

        when (type) {
            DatePickerType.DATE_PICKER -> {
                materialDatePicker.addOnPositiveButtonClickListener {
                    // Respond to positive button click.
                    val calendar = Calendar.getInstance()
                    calendar.timeInMillis = it

                    listener(
                        SimpleDateFormat(
                            dateFormat,
                            Locale.getDefault()
                        ).format(calendar.time), null
                    )

                }

                materialDatePicker.addOnNegativeButtonClickListener {
                    // Respond to negative button click.
                    listener("cancel", null)
                }

            }
            DatePickerType.DAY_RANGE_PICKER -> {

                materialRangeDatePicker.addOnPositiveButtonClickListener {
                    // Respond to positive button click.
                }

                materialRangeDatePicker.addOnNegativeButtonClickListener {
                    // Respond to negative button click.
                }

            }
        }

    }


    private fun setCalendarConstraints() {

        // To open picker at a default month:
        setDefaultMonth()

        // To constrain the calendar to the beginning to the end of this year:
        setCalenderSelectionRange()


        setDateValidations()


        constraintsBuilder.build()
    }

    private fun setDateValidations() {
        if (todayForwardSelectable) {
            constraintsBuilder.setValidator(DateValidatorPointForward.now())
        }

        if (todayBackwardSelectable) {
            constraintsBuilder.setValidator(DateValidatorPointBackward.now())
        }

    }

    private fun setCalenderSelectionRange() {
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        val today = MaterialDatePicker.todayInUtcMilliseconds()

        calendar.timeInMillis = today
        calendar[Calendar.MONTH] = startMonth
        val startMonth = calendar.timeInMillis

        calendar.timeInMillis = today
        calendar[Calendar.MONTH] = endMonth
        val endMonth = calendar.timeInMillis

        constraintsBuilder.setStart(startMonth).setEnd(endMonth)
    }

    private fun setDefaultMonth() {
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        calendar[Calendar.MONTH] = openMonth
        val monthLong = calendar.timeInMillis
        constraintsBuilder.setOpenAt(monthLong)
    }


    init {
        if (constraintsEnable) {
            setCalendarConstraints()
        }
        initPicker()
    }

}

enum class DatePickerType {
    DATE_PICKER, DAY_RANGE_PICKER
}