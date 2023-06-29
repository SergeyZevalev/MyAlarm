package com.example.myalarm.domain

import com.example.myalarm.core.data.CommonDataModelMapper
import com.example.myalarm.core.data.CommonRepository
import com.example.myalarm.core.domain.CommonInteractor

class BaseInteractor<E>(
    private val repository: CommonRepository<E>,
    private val mapper: CommonDataModelMapper<CommonItem<E>>
) : CommonInteractor<E> {
    override suspend fun addItem(item: E) {
        repository.addItem(item)
    }

    override suspend fun removeItem(id: Int) {
        repository.removeItem(id)
    }

    override suspend fun getItemList(): List<CommonItem<E>> =
        repository.getItemList().map {
            it.map(mapper)
        }


    override suspend fun changeStatus(id: Int): CommonItem<E> =
        repository.changeStatus(id).map(mapper)

}