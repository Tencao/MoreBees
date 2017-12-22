package com.tencao.morebees.proxy

import net.minecraft.item.Item

internal open class CommonProxy {

    open fun registerItemRenderer(item: Item, meta: Int, id: String) {}
}