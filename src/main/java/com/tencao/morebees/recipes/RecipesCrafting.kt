package com.tencao.morebees.recipes

import com.tencao.morebees.ObjRegistry
import com.tencao.morebees.events.MBRegistry
import net.minecraft.init.Items

object RecipesCrafting {

    fun registerRecipes() {
        MBRegistry.addShapelessOreRecipe("diamond", Items.DIAMOND, ObjRegistry.DiamondFrag, ObjRegistry.DiamondFrag, ObjRegistry.DiamondFrag, ObjRegistry.DiamondFrag, ObjRegistry.DiamondFrag, ObjRegistry.DiamondFrag, ObjRegistry.DiamondFrag, ObjRegistry.DiamondFrag, ObjRegistry.DiamondFrag)
        MBRegistry.addShapelessOreRecipe("emerald", Items.EMERALD, ObjRegistry.EmeraldFrag, ObjRegistry.EmeraldFrag, ObjRegistry.EmeraldFrag, ObjRegistry.EmeraldFrag, ObjRegistry.EmeraldFrag, ObjRegistry.EmeraldFrag, ObjRegistry.EmeraldFrag, ObjRegistry.EmeraldFrag, ObjRegistry.EmeraldFrag)
        //MBRegistry.addShapelessRecipe(new ItemStack(Items.NETHER_STAR),MBI.NetherFrag,MBI.NetherFrag,MBI.NetherFrag,MBI.NetherFrag);
    }
}