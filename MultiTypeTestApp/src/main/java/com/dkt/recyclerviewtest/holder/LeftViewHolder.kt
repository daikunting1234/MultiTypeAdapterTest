package com.dkt.recyclerviewtest.holder

import android.view.View
import com.dkt.recyclerviewtest.holder.base.BaseViewHolder
import com.dkt.recyclerviewtest.model.MessageModel
import kotlinx.android.synthetic.main.left_item.view.*

/**
 * @author: daikunting
 * @date: 2020/7/23
 */
class LeftViewHolder(itemView: View) : BaseViewHolder<MessageModel>(itemView) {
    override fun bindData(data: MessageModel) {
        itemView.left_text.text = data.message
    }
}