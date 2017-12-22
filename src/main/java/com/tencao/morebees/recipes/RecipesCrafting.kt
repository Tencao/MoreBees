package com.tencao.morebees.recipes

import com.tencao.morebees.ObjRegistry
import com.tencao.morebees.events.GameRegistry
import net.minecraft.init.Items

object RecipesCrafting {

    fun registerRecipes() {
        GameRegistry.addShapelessOreRecipe("diamond", Items.DIAMOND, ObjRegistry.DiamondFrag, ObjRegistry.DiamondFrag, ObjRegistry.DiamondFrag, ObjRegistry.DiamondFrag, ObjRegistry.DiamondFrag, ObjRegistry.DiamondFrag, ObjRegistry.DiamondFrag, ObjRegistry.DiamondFrag, ObjRegistry.DiamondFrag)
        GameRegistry.addShapelessOreRecipe("emerald", Items.EMERALD, ObjRegistry.EmeraldFrag, ObjRegistry.EmeraldFrag, ObjRegistry.EmeraldFrag, ObjRegistry.EmeraldFrag, ObjRegistry.EmeraldFrag, ObjRegistry.EmeraldFrag, ObjRegistry.EmeraldFrag, ObjRegistry.EmeraldFrag, ObjRegistry.EmeraldFrag)
        //GameRegistry.addShapelessRecipe(new ItemStack(Items.NETHER_STAR),MBI.NetherFrag,MBI.NetherFrag,MBI.NetherFrag,MBI.NetherFrag);
    }
}