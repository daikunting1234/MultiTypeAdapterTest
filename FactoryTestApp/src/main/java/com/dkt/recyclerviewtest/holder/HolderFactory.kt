package com.dkt.recyclerviewtest.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dkt.recyclerviewtest.R
import com.dkt.recyclerviewtest.model.CardTypes
import java.lang.Exception

/**
 * @author: daikunting
 * @date: 2020/7/26
 */
object HolderFactory {
    fun getHolder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(viewType) {
            CardTypes.CARD_TYPE_ME ->
                LeftViewHolder(inflater.inflate(R.layout.left_item, parent, false))
            CardTypes.CARD_TYPE_OTHERS ->
                RightViewHolder(inflater.inflate(R.layout.right_item, parent, false))
            CardTypes.CARD_TYPE_TIME ->
                TimeViewHolder(inflater.inflate(R.layout.time_item, parent, false))
            else ->
                throw Exception("MessageAdapter type invalid")
        }
    }
}