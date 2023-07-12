package com.example.myalarm.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import com.example.myalarm.presentation.CommonUiModel

interface CommonCommunication<E>: ListChanges<E> {

    fun observeList(owner: LifecycleOwner, observer: Observer<List<CommonUiModel<E>>>)
    fun showItemList(list: List<CommonUiModel<E>>)
}

interface ListChanges<E>{

    fun getList(): List<CommonUiModel<E>>
    fun getDiffRes() : DiffUtil.DiffResult
}