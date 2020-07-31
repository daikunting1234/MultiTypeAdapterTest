package com.dkt.recyclerviewtest.model

/**
 * @author: daikunting
 * @date: 2020/7/26
 */
class MessageTimeModel (val time: String): ICardModel {
    override fun getCardType(): Int {
        return CardTypes.CARD_TYPE_TIME
    }
}