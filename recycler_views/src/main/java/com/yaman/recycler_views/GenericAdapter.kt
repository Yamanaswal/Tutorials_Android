package com.yaman.recycler_views

import androidx.recyclerview.widget.RecyclerView

import android.view.ViewGroup


abstract class GenericAdapter<T>() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //Custom List
    private var items = mutableListOf<T>()

    //Custom Methods
    abstract fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    abstract fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: T,position : Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBindViewHolder(holder, items[position],position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateList(list: MutableList<T>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun addNewList(list: MutableList<T>) {
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun getItem(position: Int): T {
        return items[position]
    }

}