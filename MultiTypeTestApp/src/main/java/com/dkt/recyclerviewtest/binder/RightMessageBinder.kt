package com.dkt.recyclerviewtest.binder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dkt.recyclerviewtest.R
import com.dkt.recyclerviewtest.binder.base.BaseItemViewBinder
import com.dkt.recyclerviewtest.holder.RightViewHolder
import com.dkt.recyclerviewtest.model.MessageModel

/**
 * @author: daikunting
 * @date: 2020/7/26
 */
class RightMessageBinder: BaseItemViewBinder<MessageModel, RightViewHolder>() {
    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): RightViewHolder {
        return RightViewHolder(inflater.inflate(R.layout.right_item, parent, false))
    }
}