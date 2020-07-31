package com.dkt.recyclerviewtest.binder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dkt.recyclerviewtest.R
import com.dkt.recyclerviewtest.binder.base.BaseItemViewBinder
import com.dkt.recyclerviewtest.holder.LeftViewHolder
import com.dkt.recyclerviewtest.model.MessageModel

/**
 * @author: daikunting
 * @date: 2020/7/26
 */
class LeftMessageBinder: BaseItemViewBinder<MessageModel, LeftViewHolder>() {
    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): LeftViewHolder {
        return LeftViewHolder(inflater.inflate(R.layout.left_item, parent, false))
    }
}