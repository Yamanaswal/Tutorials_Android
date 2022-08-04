package com.yaman.library_tools.app_utils.generic_recycler_view.recycler_view_utils

import GenericAdapter
import android.widget.BaseAdapter
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("setAdapter")
fun setAdapter(
    recyclerView: RecyclerView,
    adapter: GenericAdapter<Any>,
) {
    adapter.let {
        recyclerView.adapter = it
    }
}

