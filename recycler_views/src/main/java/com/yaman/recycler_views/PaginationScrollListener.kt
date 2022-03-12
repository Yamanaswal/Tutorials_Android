package com.yaman.recycler_views

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class PaginationScrollListener(var layoutManager: LinearLayoutManager) :
    RecyclerView.OnScrollListener() {

    abstract fun isLastPage(): Boolean

    abstract fun isLoading(): Boolean

    abstract fun loadMoreItems()

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        //Show Item In Visible
        val visibleItemCount = layoutManager.childCount

        //Total Items in Recycler View
        val totalItemCount = layoutManager.itemCount

        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

        if (!isLoading() && !isLastPage()) {
            if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0) {
                loadMoreItems()
            }
        }
    }
}