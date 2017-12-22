package com.tencao.morebees.proxy

import com.tencao.morebees.MBCore
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraftforge.client.model.ModelLoader

internal class ClientProxy : CommonProxy() {

    override fun registerItemRenderer(item: Item, meta: Int, id: String) {
        ModelLoader.setCustomModelResourceLocation(item, meta, ModelResourceLocation(MBCore.MODID + ":" + id, "inventory"))
    }
}