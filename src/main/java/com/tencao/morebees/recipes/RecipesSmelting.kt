package com.tencao.morebees.recipes

import com.tencao.morebees.MBItems
import com.tencao.morebees.util.OreDictUtil
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.registry.GameRegistry

object RecipesSmelting {

    fun registerRecipes() {

        GameRegistry.addSmelting(MBItems.DustIron, ItemStack(Items.IRON_INGOT), 0.7f)
        GameRegistry.addSmelting(MBItems.DustGold, ItemStack(Items.GOLD_INGOT), 0.7f)
        GameRegistry.addSmelting(MBItems.DustCopper, OreDictUtil.getOreStack("ingotCopper"), 0.7f)
        GameRegistry.addSmelting(MBItems.DustTin, OreDictUtil.getOreStack("ingotTin"), 0.7f)
        if (MBItems.MBILead)
            GameRegistry.addSmelting(MBItems.DustLead, OreDictUtil.getOreStack("ingotLead"), 0.7f)
        if (MBItems.MBISilver)
            GameRegistry.addSmelting(MBItems.DustSilver, OreDictUtil.getOreStack("ingotSilver"), 0.7f)
        if (MBItems.MBIAluminium)
            GameRegistry.addSmelting(MBItems.DustAluminium, OreDictUtil.getOreStack("ingotAluminum"), 0.7f)
        if (MBItems.MBINickel)
            GameRegistry.addSmelting(MBItems.DustNickel, OreDictUtil.getOreStack("ingotNickel"), 0.7f)
        if (MBItems.MBIPlatinum)
            GameRegistry.addSmelting(MBItems.DustPlatinum, OreDictUtil.getOreStack("ingotPlatinum"), 0.7f)
        if (MBItems.MBIIridium)
            GameRegistry.addSmelting(MBItems.DustIridium, OreDictUtil.getOreStack("ingotIridium"), 0.7f)

    }

}
