package com.example.myalarm.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import com.example.myalarm.core.presentation.CommonCommunication

class BaseCommunication<E> : CommonCommunication<E> {

    private val listLiveData = MutableLiveData<ArrayList<CommonUiModel<E>>>()

    private lateinit var diffResult: DiffUtil.DiffResult

    override fun observeList(owner: LifecycleOwner, observer: Observer<List<CommonUiModel<E>>>) {
        listLiveData.observe(owner, observer)
    }

    override fun showItemList(list: List<CommonUiModel<E>>) {
        val callback = CommonDiffUtilCallback(listLiveData.value ?: emptyList(), list)
        diffResult = DiffUtil.calculateDiff(callback)
        listLiveData.value = ArrayList(list)
    }

    override fun getList() = listLiveData.value ?: emptyList()

    override fun getDiffRes() = diffResult
}