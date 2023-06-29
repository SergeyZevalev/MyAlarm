package com.example.myalarm.core.customDatabase

import com.example.myalarm.customDatabase.Alarm

interface ItemDataBase<T> {

    fun getData() : List<Alarm>
    fun addItem(item: T)
    fun removeItem(id: Int)
    fun notifyDataChanges()
    fun changeItemStatus(id: Int): Alarm
}