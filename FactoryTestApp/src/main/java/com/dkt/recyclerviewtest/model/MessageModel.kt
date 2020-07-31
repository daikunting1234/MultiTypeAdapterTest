package com.dkt.recyclerviewtest.model

/**
 * @author: daikunting
 * @date: 2020/7/23
 */
class MessageModel (val isMe: Boolean, val message: String): ICardModel {
    override fun getCardType(): Int {
        if (isMe) {
            return CardTypes.CARD_TYPE_ME
        }
        return CardTypes.CARD_TYPE_OTHERS
    }
}