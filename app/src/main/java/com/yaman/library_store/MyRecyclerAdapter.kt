package com.yaman.library_store

import com.yaman.library_store.databinding.DataItemBinding
import com.yaman.recycler_views.BaseViewHolder
import com.yaman.recycler_views.GenericAdapter

class MyRecyclerAdapter : GenericAdapter<DataItem>(layoutId = R.layout.data_item) {

    override fun onBindViewHold(holder: BaseViewHolder<DataItem>, position: Int) {
        val binding = holder.binding as DataItemBinding
        binding.test = getItem(position)
    }

}

