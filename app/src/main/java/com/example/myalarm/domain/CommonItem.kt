package com.example.myalarm.domain

import com.example.myalarm.core.Mapper
import com.example.myalarm.presentation.BaseUiModel
import com.example.myalarm.presentation.CommonUiModel
import com.example.myalarm.presentation.FavoriteUiModel

class CommonItem<E>(
    private val id: Int,
    private val time: Int,
    private val week: List<Boolean>,
    private val activated: Boolean
) : Mapper<CommonUiModel<E>> {
    override fun map(): CommonUiModel<E> =
        if (activated) FavoriteUiModel (id, time, week)
        else BaseUiModel(id, time, week)
}