package com.example.myalarm.data

import com.example.myalarm.core.data.CommonDataModelMapper
import com.example.myalarm.domain.CommonItem

class BaseDataModelMapper<E> : CommonDataModelMapper<CommonItem<E>> {
    override fun map(
        id: Int,
        time: Int,
        week: List<Boolean>,
        activated: Boolean
    ) = CommonItem<E>(id, time, week, activated)


}