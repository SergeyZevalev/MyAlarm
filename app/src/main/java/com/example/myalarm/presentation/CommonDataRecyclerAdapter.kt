package com.example.myalarm.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myalarm.R
import com.example.myalarm.core.presentation.DayActiveClickListener
import com.example.myalarm.core.presentation.FavoriteItemClickListener
import com.example.myalarm.core.presentation.ListChanges

class CommonDataRecyclerAdapter<T>(
    private val communicator: ListChanges<T>,
    private val listener: FavoriteItemClickListener,
    private val changeDayListener: DayActiveClickListener
) : RecyclerView.Adapter<CommonDataViewHolder<T>>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonDataViewHolder<T> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.base_item, parent, false)
        return CommonDataViewHolder(view, listener, changeDayListener)
    }

    override fun getItemCount() = communicator.getList().size

    override fun onBindViewHolder(holder: CommonDataViewHolder<T>, position: Int) {
        holder.bind(communicator.getList()[position])
    }

    fun update(){
        communicator.getDiffRes().dispatchUpdatesTo(this)
    }
}