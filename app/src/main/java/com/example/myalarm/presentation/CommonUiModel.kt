package com.example.myalarm.presentation

import androidx.annotation.DrawableRes
import com.example.myalarm.R

abstract class CommonUiModel<E>(
    private val id: Int,
    private val time: Int,
    private val week: MutableMap<Int, Boolean>
) {

    protected fun text() = "$time"
    @DrawableRes
    protected abstract fun getIconResId() : Int
}

class FavoriteUiModel<E>(
    private val id: Int,
    private val time: Int,
    private val week: MutableMap<Int, Boolean>
) : CommonUiModel<E>(id, time, week) {
    override fun getIconResId() = R.drawable.ic_activated_alarm
}

class BaseUiModel<E>(
    private val id: Int,
    private val time: Int,
    private val week: MutableMap<Int, Boolean>
) : CommonUiModel<E>(id, time, week) {
    override fun getIconResId() = R.drawable.ic_deactivated_alarm
}