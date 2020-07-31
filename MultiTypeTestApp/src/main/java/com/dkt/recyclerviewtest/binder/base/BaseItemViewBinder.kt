package com.dkt.recyclerviewtest.binder.base

import com.dkt.recyclerviewtest.holder.base.BaseViewHolder
import me.drakeet.multitype.ItemViewBinder

/**
 * @author: daikunting
 * @date: 2020/7/26
 */
abstract class BaseItemViewBinder<M, VH : BaseViewHolder<M>>: ItemViewBinder<M, VH>() {
    override fun onBindViewHolder(holder: VH, model: M) {
        holder.bindData(model)
    }
}