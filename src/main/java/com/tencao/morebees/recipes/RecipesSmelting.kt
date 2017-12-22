package com.tencao.morebees.recipes

import com.tencao.morebees.ObjRegistry
import com.tencao.morebees.util.OreDictUtil
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.registry.GameRegistry

object RecipesSmelting {

    fun registerRecipes() {

        GameRegistry.addSmelting(ObjRegistry.DustIron, ItemStack(Items.IRON_INGOT), 0.7f)
        GameRegistry.addSmelting(ObjRegistry.DustGold, ItemStack(Items.GOLD_INGOT), 0.7f)
        GameRegistry.addSmelting(ObjRegistry.DustCopper, OreDictUtil.getOreStack("ingotCopper"), 0.7f)
        GameRegistry.addSmelting(ObjRegistry.DustTin, OreDictUtil.getOreStack("ingotTin"), 0.7f)
        if (ObjRegistry.MBILead)
            GameRegistry.addSmelting(ObjRegistry.DustLead, OreDictUtil.getOreStack("ingotLead"), 0.7f)
        if (ObjRegistry.MBISilver)
            GameRegistry.addSmelting(ObjRegistry.DustSilver, OreDictUtil.getOreStack("ingotSilver"), 0.7f)
        if (ObjRegistry.MBIAluminium)
            GameRegistry.addSmelting(ObjRegistry.DustAluminium, OreDictUtil.getOreStack("ingotAluminum"), 0.7f)
        if (ObjRegistry.MBINickel)
            GameRegistry.addSmelting(ObjRegistry.DustNickel, OreDictUtil.getOreStack("ingotNickel"), 0.7f)
        if (ObjRegistry.MBIPlatinum)
            GameRegistry.addSmelting(ObjRegistry.DustPlatinum, OreDictUtil.getOreStack("ingotPlatinum"), 0.7f)
        if (ObjRegistry.MBIIridium)
            GameRegistry.addSmelting(ObjRegistry.DustIridium, OreDictUtil.getOreStack("ingotIridium"), 0.7f)

    }

}
