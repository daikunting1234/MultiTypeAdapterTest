package com.dkt.recyclerviewtest.holder

import android.view.View
import com.dkt.recyclerviewtest.model.CardTypes
import com.dkt.recyclerviewtest.model.MessageModel
import kotlinx.android.synthetic.main.right_item.view.*

/**
 * @author: daikunting
 * @date: 2020/7/23
 */
class RightViewHolder(itemView: View) : BaseViewHolder(itemView) {
    override fun bindData(data: Any) {
        if (data !is MessageModel) {
            return
        }
        itemView.right_text.text = data.message
    }
}