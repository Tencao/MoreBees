package com.tencao.morebees.items

import net.minecraft.item.Item

interface ItemModelProvider {

    fun registerItemModel(item: Item)
}