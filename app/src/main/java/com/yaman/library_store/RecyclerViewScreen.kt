package com.yaman.library_store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_acitivity)

        val list = mutableListOf<DataItem>()
        list.add(DataItem(1, "Test Name 1"))
        list.add(DataItem(2, "Test Name 2"))
        list.add(DataItem(3, "Test Name 3"))
        list.add(DataItem(5, "Test Name 4"))
        list.add(DataItem(6, "Test Name 5"))
        list.add(DataItem(2, "Test Name 6"))
        list.add(DataItem(12, "Test Name 7"))
        list.add(DataItem(4, "Test Name 8"))
        list.add(DataItem(5, "Test Name 9"))
        list.add(DataItem(112, "Test Name 10"))

        val myRecyclerAdapter = MyRecyclerAdapter()
        findViewById<RecyclerView>(R.id.rvView).adapter = myRecyclerAdapter
        myRecyclerAdapter.updateList(list = list)


        findViewById<Button>(R.id.buttonPanel).setOnClickListener {
            val list2 = mutableListOf<DataItem>()
            list2.add(DataItem(112, "Test Name +11 Add more"))
            list2.add(DataItem(115, "Test Name +12 Add more"))
            list2.add(DataItem(115, "Test Name +13 Add more"))
            myRecyclerAdapter.addMoreList(list2)
        }


        findViewById<Button>(R.id.buttonPanel2).setOnClickListener {
            val list2 = mutableListOf<DataItem>()
            list2.add(DataItem(112, "Test Name ------ Updated"))
            list2.add(DataItem(17, "Test Name -1"))
            list2.add(DataItem(18, "Test Name -1"))
            list2.add(DataItem(13, "Test Name -3"))
            list2.add(DataItem(122, "Test Name -1323"))
            myRecyclerAdapter.updateList(list2)
        }

        myRecyclerAdapter.removeItem(0)

    }
}

data class DataItem(val id: Int, val name: String)
