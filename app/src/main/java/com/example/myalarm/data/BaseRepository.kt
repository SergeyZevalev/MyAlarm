package com.example.myalarm.data

import com.example.myalarm.core.customDatabase.ItemDataBase
import com.example.myalarm.core.data.CommonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BaseRepository<T>(
    private val dataBase: ItemDataBase<T>,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : CommonRepository<T> {

    override suspend fun addItem(item: T) = withContext(dispatcher) {
        dataBase.addItem(item)
    }

    override suspend fun removeItem(id: Int) = withContext(dispatcher) {
        dataBase.removeItem(id)
    }

    override suspend fun getItemList() = withContext(dispatcher) {
        dataBase.getData()
    }

    override suspend fun changeStatus(id: Int) = withContext(dispatcher) {
        dataBase.changeItemStatus(id)
    }

}