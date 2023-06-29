package com.example.myalarm.customDatabase

import com.example.myalarm.core.data.CommonDataModelMapper
import com.example.myalarm.domain.CommonItem

data class Alarm(
    private var id: Int,
    private var time: Int,
    private val volume: Int,
    private val week: MutableMap<Int, Boolean>,
    private val song: Any,
    private var activated: Boolean
) {
    fun setNotifiedId(id: Int) {
        this.id = id
    }

    fun changeStatus() {
        this.activated = !activated
    }

    fun compareId(id: Int) = this.id == id

    fun <T> map(mapper: CommonDataModelMapper<CommonItem<T>>) =
        mapper.map(id, time, week, activated)

}