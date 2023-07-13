package com.example.myalarm.core.data

interface CommonDataModelMapper<T> {

    fun map(id: Int, time: Int, week: List<Boolean>, activated: Boolean): T
}