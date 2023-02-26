package com.yaman.library_tools.app_utils.generic_recycler_view.recycler_view_utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yaman.library_tools.app_utils.generic_recycler_view.recycler_view_homogenous.adapters.GenericAdapter

@BindingAdapter("setAdapter")
fun setAdapter(
    recyclerView: RecyclerView,
    adapter: GenericAdapter<Any>,
) {
    adapter.let {
        recyclerView.adapter = it
    }
}

