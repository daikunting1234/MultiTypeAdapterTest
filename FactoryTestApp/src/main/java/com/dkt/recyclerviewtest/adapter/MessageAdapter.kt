package com.dkt.recyclerviewtest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dkt.recyclerviewtest.holder.*
import com.dkt.recyclerviewtest.model.ICardModel

/**
 * @author: daikunting
 * @date: 2020/7/26
 */
class MessageAdapter(context: Context) : RecyclerView.Adapter<BaseViewHolder>(){
    private var dataList = emptyList<ICardModel>()
    private var inflater : LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return HolderFactory.getHolder(inflater, parent, viewType)
    }

    override fun getItemViewType(position: Int): Int {
        return dataList[position].getCardType()
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bindData(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setItems(items: List<ICardModel>) {
        dataList = items
        notifyDataSetChanged()
    }
}