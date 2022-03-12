package com.yaman.library_store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_acitivity)
        val myRecyclerAdapter = MyRecyclerAdapter()
        findViewById<RecyclerView>(R.id.rvView).adapter = myRecyclerAdapter
    }
}