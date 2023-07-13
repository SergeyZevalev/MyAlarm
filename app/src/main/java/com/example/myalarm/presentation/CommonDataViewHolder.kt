package com.example.myalarm.presentation

import android.view.View
import android.widget.CheckedTextView
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myalarm.R
import com.example.myalarm.core.presentation.FavoriteItemClickListener

class CommonDataViewHolder<E>(view: View, private val listener: FavoriteItemClickListener) : RecyclerView.ViewHolder(view) {

    private val changeButton = itemView.findViewById<ImageButton>(R.id.alarmActivationButton)
    private val settingsButton = itemView.findViewById<ImageButton>(R.id.alarmItemSettingsButton)
    private val time = itemView.findViewById<TextView>(R.id.alarmTime)
    private val days = listOf(
        R.id.buttonMonday, R.id.buttonTuesday, R.id.buttonWednesday, R.id.buttonThursday,
        R.id.buttonFriday, R.id.buttonSaturday, R.id.buttonSunday
    ).map { itemView.findViewById<CheckedTextView>(it) }


    fun bind(model: CommonUiModel<E>) {
        changeButton.setOnClickListener {
            model.change(listener)
        }
        model.show(time, changeButton)
        model.checkedDays(days)
        days.forEachIndexed{ index, it ->
            it.setOnClickListener {  }
        }
    }
}