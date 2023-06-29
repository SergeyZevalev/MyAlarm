package com.example.myalarm.customDatabase

import com.example.myalarm.core.customDatabase.ItemDataBase

class CustomAlarmDataBase: ItemDataBase<Alarm> {

    private val alarmList: MutableList<Alarm> = mutableListOf()

    override fun getData() = alarmList

    override fun addItem(item: Alarm) {
        alarmList.add(item)
        notifyDataChanges()
    }

    override fun removeItem(id: Int) {
        val found = alarmList.find { it.compareId(id) }
        alarmList.remove(found)
        notifyDataChanges()
    }

    override fun notifyDataChanges() {
        alarmList.forEachIndexed { index, alarm ->
            alarm.setNotifiedId(index)
        }

    }

    override fun changeItemStatus(id: Int): Alarm {
        val found = alarmList.find { it.compareId(id) }
        found!!.changeStatus()
        return found
    }

}