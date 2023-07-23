package com.example.myalarm.presentation

import android.widget.CheckedTextView
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.DrawableRes
import com.example.myalarm.R
import com.example.myalarm.core.presentation.DayActiveClickListener
import com.example.myalarm.core.presentation.FavoriteItemClickListener

abstract class CommonUiModel<E>(
    private val id: Int,
    private val time: Int,
    private val week: List<Boolean>
) {

    protected fun text() = "$time"
    fun same(model: CommonUiModel<E>) =
        model.javaClass == this.javaClass && model.id == id

    @DrawableRes
    protected abstract fun getIconResId() : Int

    fun show(textView: TextView, imageButton: ImageButton) {
        textView.text = text()
        imageButton.setImageResource(getIconResId())
    }

    fun checkedDays(dayList: List<CheckedTextView>) {
        week.forEachIndexed { index, b ->  dayList[index].isChecked = b}
    }

    fun change(listener: FavoriteItemClickListener) {
        listener.change(id)
    }

    fun changeDayActive(index: Int, listener: DayActiveClickListener) {
        listener.changeDayActive(index, id)
    }
}

class FavoriteUiModel<E>(
    private val id: Int,
    private val time: Int,
    private val week: List<Boolean>
) : CommonUiModel<E>(id, time, week) {
    override fun getIconResId() = R.drawable.ic_activated_alarm
}

class BaseUiModel<E>(
    private val id: Int,
    private val time: Int,
    private val week: List<Boolean>
) : CommonUiModel<E>(id, time, week) {
    override fun getIconResId() = R.drawable.ic_deactivated_alarm
}