package com.example.myalarm.core.domain

import com.example.myalarm.domain.CommonItem

interface CommonInteractor<T> {

    suspend fun addItem(item: T)
    suspend fun removeItem(id: Int)
    suspend fun getItemList() : List<CommonItem<T>>
    suspend fun changeStatus(id: Int) : CommonItem<T>
}