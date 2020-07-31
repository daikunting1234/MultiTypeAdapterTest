package com.dkt.recyclerviewtest.holder

import android.view.View
import com.dkt.recyclerviewtest.holder.base.BaseViewHolder
import com.dkt.recyclerviewtest.model.MessageTimeModel
import kotlinx.android.synthetic.main.time_item.view.*

/**
 * @author: daikunting
 * @date: 2020/7/26
 */
class TimeViewHolder(itemView: View) : BaseViewHolder<MessageTimeModel>(itemView) {
    override fun bindData(data: MessageTimeModel) {
        itemView.time.text = data.time
    }
}