package com.example.myalarm.core.data

import com.example.myalarm.customDatabase.Alarm

interface CommonRepository<T> {

    suspend fun addItem(item: T)
    suspend fun removeItem(id: Int)
    suspend fun getItemList(): List<Alarm>
    suspend fun changeStatus(id: Int) : Alarm
}