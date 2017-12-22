package com.tencao.morebees.util

import net.minecraft.item.ItemStack
import net.minecraftforge.oredict.OreDictionary

object OreDictUtil {

    fun getOreStack(name: String): ItemStack{
        return OreDictionary.getOres(name).firstOrNull()?: ItemStack.EMPTY
    }
}