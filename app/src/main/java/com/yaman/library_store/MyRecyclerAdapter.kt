package com.yaman.library_store

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yaman.recycler_views.GenericAdapter
import com.yaman.recycler_views.GenericAdapterMultiView

class MyRecyclerAdapter : GenericAdapter<String>() {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: String, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

}



class MyRVMultiView : GenericAdapterMultiView<String>() {



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: String, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

}