package com.example.myalarm.presentation

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.example.myalarm.R

class AlarmInputWatcher(
    private val europeFormat: Boolean,
    private val hoursInput: Boolean,
    private val editText: EditText,
    private val context: Context
) :
    TextWatcher {

    private val patternEuropeHours = 0..11
    private val patternUsualHours = 0..23
    private val patternMinutes = 0..59

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        val europeHours = europeFormat && hoursInput
        val hoursFormat = hoursInput
        val europeFormatHourError = R.string.europe_format_error
        val usualFormatHourError = R.string.usual_format_error
        val minutesFormatError = R.string.minutes_format_error

        if (europeHours && !patternEuropeHours.contains(s.toString().toInt())) {
            editText.error = context.resources.getString(europeFormatHourError)
        } else if (hoursFormat && !patternUsualHours.contains(s.toString().toInt())) {
            editText.error = context.resources.getString(usualFormatHourError)
        } else if (!patternMinutes.contains(s.toString().toInt())) {
            editText.error = context.resources.getString(minutesFormatError)
        }


    }
}