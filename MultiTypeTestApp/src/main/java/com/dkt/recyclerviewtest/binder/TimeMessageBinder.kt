package com.dkt.recyclerviewtest.binder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dkt.recyclerviewtest.R
import com.dkt.recyclerviewtest.binder.base.BaseItemViewBinder
import com.dkt.recyclerviewtest.holder.TimeViewHolder
import com.dkt.recyclerviewtest.model.MessageTimeModel

/**
 * @author: daikunting
 * @date: 2020/7/26
 */
class TimeMessageBinder: BaseItemViewBinder<MessageTimeModel, TimeViewHolder>() {
    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): TimeViewHolder {
        return TimeViewHolder(inflater.inflate(R.layout.time_item, parent, false))
    }
}