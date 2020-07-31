package com.dkt.recyclerviewtest.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dkt.recyclerviewtest.model.MessageModel

/**
 * @author: daikunting
 * @date: 2020/7/23
 */
abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bindData(data: Any)
}