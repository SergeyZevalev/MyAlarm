package com.example.myalarm.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myalarm.R
import com.example.myalarm.core.presentation.ListChanges

class CommonDataRecyclerAdapter<T>(
    private val communicator: ListChanges<T>
) : RecyclerView.Adapter<CommonDataViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonDataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.base_item, parent, false)
        return CommonDataViewHolder(view)
    }

    override fun getItemCount() = communicator.getList().size

    override fun onBindViewHolder(holder: CommonDataViewHolder, position: Int) {
        holder.bind
    }
}