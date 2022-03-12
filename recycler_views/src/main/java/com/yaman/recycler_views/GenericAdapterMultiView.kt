package com.yaman.recycler_views

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/** Generic Adapter For Homogenous Recycler View */
abstract class GenericAdapterMultiView<T>() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //Custom List
    private var items = mutableListOf<T>()

    //Custom Methods
    abstract fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    abstract fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: T, position : Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return onCreateViewHolder(parent)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBindViewHolder(holder, items[position], position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateList(list: MutableList<T>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun addMoreList(list: MutableList<T>) {
        val currentSize = this.items.size
        this.items.addAll(list)
        val newSize = this.items.size
        notifyItemRangeChanged(currentSize,newSize)
    }

    fun getItem(position: Int): T {
        return items[position]
    }

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
