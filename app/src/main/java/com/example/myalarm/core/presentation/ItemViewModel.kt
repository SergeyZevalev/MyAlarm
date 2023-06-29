package com.example.myalarm.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface ItemViewModel<T> {

    fun getItemList()
    fun removeItem()
    fun addItem()
    fun changeItemStatus(item: T)
    fun observeList(owner: LifecycleOwner, observer: Observer<T>)
}