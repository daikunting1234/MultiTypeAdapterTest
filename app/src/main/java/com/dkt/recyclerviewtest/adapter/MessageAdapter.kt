package com.dkt.recyclerviewtest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dkt.recyclerviewtest.R
import com.dkt.recyclerviewtest.model.CardTypes
import com.dkt.recyclerviewtest.model.MessageModel
import com.dkt.recyclerviewtest.model.MessageTimeModel
import kotlinx.android.synthetic.main.left_item.view.*
import kotlinx.android.synthetic.main.right_item.view.*
import kotlinx.android.synthetic.main.time_item.view.*
import java.lang.Exception

/**
 * @author: daikunting
 * @date: 2020/7/26
 */
class MessageAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var dataList = emptyList<Any>()
    private var inflater : LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            CardTypes.CARD_TYPE_ME ->
                MessageHolder(inflater.inflate(R.layout.left_item, parent, false))
            CardTypes.CARD_TYPE_OTHERS ->
                MessageHolder(inflater.inflate(R.layout.right_item, parent, false))
            CardTypes.CARD_TYPE_TIME ->
                MessageHolder(inflater.inflate(R.layout.time_item, parent, false))
            else ->
                throw Exception("MessageAdapter type invalid")
        }
    }

    override fun getItemViewType(position: Int): Int {
        val model = dataList[position]
        if (model is MessageModel) {
            return if (model.isMe) {
                CardTypes.CARD_TYPE_ME
            } else {
                CardTypes.CARD_TYPE_OTHERS
            }
        } else if (model is MessageTimeModel) {
            return CardTypes.CARD_TYPE_TIME
        }
        return -1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = dataList[position]
        if (model is MessageModel) {
            if (model.isMe) {
                holder.itemView.left_text.text = model.message
            } else {
                holder.itemView.right_text.text = model.message
            }
        } else if (model is MessageTimeModel) {
            holder.itemView.time.text = model.time
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setItems(items: List<Any>) {
        dataList = items
        notifyDataSetChanged()
    }
}