package com.example.myalarm.core.data

interface CommonDataModelMapper<T> {

    fun map(id: Int, time: Int, week: MutableMap<Int, Boolean>, activated: Boolean): T
}