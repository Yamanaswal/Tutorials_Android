package com.yaman.recycler_views
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.databinding.DataBindingUtil
//import androidx.recyclerview.widget.RecyclerView
//
//
//class ExpandableRecyclerViewAdapter(private val layoutId:Int) : GenericAdapter<String>() {
//
//    private var lastPos: Int = -1
//
//    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
//        val view: View = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: String, position: Int) {
//       singleSelection(position)
//    }
//
//
//    private fun singleSelection(position: Int) {
//        //First Time
//        if(lastPos == -1){
//            lastPos = position
//            notifyItemChanged(position)
//        }
//        else{
//            if(lastPos == position){
//                notifyItemChanged(position)
//                lastPos = position
//            }else{
//                notifyItemChanged(lastPos)
//                lastPos = position
//                notifyItemChanged(position)
//            }
//        }
//    }
//
//}
//
//
//
