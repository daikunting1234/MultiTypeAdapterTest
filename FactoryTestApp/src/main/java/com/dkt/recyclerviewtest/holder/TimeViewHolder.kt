package com.dkt.recyclerviewtest.holder

import android.view.View
import com.dkt.recyclerviewtest.model.CardTypes
import com.dkt.recyclerviewtest.model.MessageTimeModel
import kotlinx.android.synthetic.main.time_item.view.*

/**
 * @author: daikunting
 * @date: 2020/7/26
 */
class TimeViewHolder(itemView: View) : BaseViewHolder(itemView) {
    override fun bindData(data: Any) {
        if (data !is MessageTimeModel) {
            return
        }
        itemView.time.text = data.time
    }
}