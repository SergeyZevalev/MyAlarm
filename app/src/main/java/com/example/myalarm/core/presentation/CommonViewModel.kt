package com.example.myalarm.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.myalarm.presentation.CommonUiModel

interface CommonViewModel<T> {

    fun getItemList()
    fun removeItem(id: Int)
    fun addItem()
    fun changeItemStatus(id: Int)
    fun observeList(owner: LifecycleOwner, observer: Observer<List<CommonUiModel<T>>>)
}