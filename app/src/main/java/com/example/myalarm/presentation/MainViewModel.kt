package com.example.myalarm.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myalarm.core.domain.CommonInteractor
import com.example.myalarm.core.presentation.CommonCommunication
import com.example.myalarm.core.presentation.CommonViewModel
import com.example.myalarm.core.presentation.ListChanges
import com.example.myalarm.domain.CommonItem
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel<T>(
    private val interactor: CommonInteractor<T>,
    private val communication: CommonCommunication<T>,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel(), CommonViewModel<T>, ListChanges<T> {

    override fun getList() = communication.getList()

    override fun getDiffRes() = communication.getDiffRes()

    override fun getItemList() {
        viewModelScope.launch(dispatcher) {
            showList()
        }
    }

    override fun removeItem(id: Int) {
        viewModelScope.launch(dispatcher) {
            interactor.removeItem(id)
        }
    }

    override fun addItem() {
        //TODO
    }

    override fun observeList(owner: LifecycleOwner, observer: Observer<List<CommonUiModel<T>>>) {
        communication.observeList(owner, observer)
    }

    override fun changeItemStatus(id: Int) {
        viewModelScope.launch(dispatcher) {
            interactor.changeStatus(id)
            showList()
        }
    }

    private suspend fun showList() = communication.showItemList(interactor.getItemList().toUiList())
}

fun <T> List<CommonItem<T>>.toUiList() = map {it.map()}