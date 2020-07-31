package com.dkt.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dkt.recyclerviewtest.binder.LeftMessageBinder
import com.dkt.recyclerviewtest.binder.RightMessageBinder
import com.dkt.recyclerviewtest.binder.TimeMessageBinder
import com.dkt.recyclerviewtest.holder.TimeViewHolder
import com.dkt.recyclerviewtest.model.MessageModel
import com.dkt.recyclerviewtest.model.MessageTimeModel
import kotlinx.android.synthetic.main.activity_main.*
import me.drakeet.multitype.MultiTypeAdapter

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
        val myAdapter = MultiTypeAdapter(dataList.toList())

        myAdapter.register(MessageTimeModel::class.java, TimeMessageBinder())

        myAdapter.register(MessageModel::class.java).to(
            LeftMessageBinder(), RightMessageBinder()
        ).withLinker { _, data ->
            return@withLinker if (data.isMe) 0 else 1
        }

//        与上面的方式任选一种
//        myAdapter.register(MessageModel::class.java).to(
//            LeftMessageBinder(), RightMessageBinder())
//            .withClassLinker { _, data ->
//                if (data.isMe) LeftMessageBinder::class.java else RightMessageBinder::class.java
//            }

        //set adapter
        rec_view.adapter = myAdapter

        //load more
        rec_view.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if(!recyclerView.canScrollVertically(1)) {
                        dataList.addAll(dataTemplate)
                        myAdapter.items = dataList.toList()
                        myAdapter.notifyDataSetChanged()
                    }
                }
            }
        })

        //refresh
        refresh_layout.setOnRefreshListener {
            dataList = mutableListOf<Any>().apply { addAll(dataTemplate) }
            myAdapter.items = dataList.toList()
            myAdapter.notifyDataSetChanged()
            refresh_layout.isRefreshing = false
        }
    }
}