package com.dkt.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dkt.recyclerviewtest.adapter.MessageAdapter
import com.dkt.recyclerviewtest.model.MessageModel
import com.dkt.recyclerviewtest.model.MessageTimeModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val dataTemplate = listOf(
        MessageModel(true, "你瞅啥啊瞅啥啊"),
        MessageModel(false, "瞅你咋的咋的啊"),
        MessageModel(true, "你再瞅一下试试"),
        MessageModel(false, "试试就试试"),
        MessageTimeModel("3分钟前"),
        MessageModel(true, "你瞅啥啊瞅啥啊"),
        MessageModel(false, "瞅你咋的咋的啊"),
        MessageModel(true, "你再瞅一下试试"),
        MessageModel(false, "试试就试试"),
        MessageTimeModel("1分钟前"),
        MessageModel(true, "你瞅啥啊瞅啥啊"),
        MessageModel(false, "瞅你咋的咋的啊"),
        MessageModel(true, "你再瞅一下试试"),
        MessageModel(false, "试试就试试"),
        MessageTimeModel("2分钟前"))

    var dataList = mutableListOf<Any>().apply { addAll(dataTemplate) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init adapter
        rec_view.layoutManager = LinearLayoutManager(this)
        val myAdapter = MessageAdapter(this)

        //set adapter
        rec_view.adapter = myAdapter

        //load more
        rec_view.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if(!recyclerView.canScrollVertically(1)) {
                        dataList.addAll(dataTemplate)
                        myAdapter.setItems(dataList)
                    }
                }
            }
        })

        //refresh
        refresh_layout.setOnRefreshListener {
            dataList = mutableListOf<Any>().apply { addAll(dataTemplate) }
            myAdapter.setItems(dataList)
            refresh_layout.isRefreshing = false
        }

        //init data
        myAdapter.setItems(dataList)
    }

}