package com.tencao.morebees.recipes

import com.google.common.collect.ImmutableMap
import com.tencao.morebees.ObjRegistry
import com.tencao.morebees.util.OreDictUtil
import forestry.api.recipes.RecipeManagers
import forestry.apiculture.PluginApiculture
import forestry.core.PluginCore
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.Loader

object RecipesCentrifuge {

    fun registerRecipes() {
        RecipeManagers.centrifugeManager.addRecipe(20, ItemStack(ObjRegistry.CombDirt), ImmutableMap.of(
                PluginCore.getItems().beeswax.itemStack, 1.0f,
                ItemStack(Blocks.DIRT), 0.9f))

        if (Loader.isModLoaded("IC2")) {
            RecipeManagers.centrifugeManager.addRecipe(20, ItemStack(ObjRegistry.CombRock), ImmutableMap.of(
                    PluginCore.getItems().beeswax.itemStack, 1.0f,
                    ItemStack(Blocks.STONE, 1, 1), 0.5f,
                    ItemStack(Blocks.STONE, 1, 3), 0.5f,
                    ItemStack(Blocks.STONE, 1, 5), 0.5f,
                    OreDictUtil.getOreStack("dustStone"), 0.9f))
        }
        if (Loader.isModLoaded("IC2-Classic-Spmod")){
            RecipeManagers.centrifugeManager.addRecipe(20, ItemStack(ObjRegistry.CombRock), ImmutableMap.of(
                    PluginCore.getItems().beeswax.itemStack, 1.0f,
                    ItemStack(Blocks.COBBLESTONE), 0.9f,
                    ItemStack(Blocks.STONE, 1, 1), 0.5f,
                    ItemStack(Blocks.STONE, 1, 3), 0.5f,
                    ItemStack(Blocks.STONE, 1, 5), 0.5f))
        }

        RecipeManagers.centrifugeManager.addRecipe(20, ItemStack(ObjRegistry.CombWither), ImmutableMap.of(
                PluginCore.getItems().refractoryWax.itemStack, 1.0f,
                ItemStack(Items.BONE), 0.9f,
                ItemStack(Items.COAL), 0.7f))

        RecipeManagers.centrifugeManager.addRecipe(20, ItemStack(ObjRegistry.CombSlime), ImmutableMap.of(
                PluginCore.getItems().beeswax.itemStack, 1.0f,
                ItemStack(Items.SLIME_BALL), 0.9f))


        RecipeManagers.centrifugeManager.addRecipe(20, ItemStack(ObjRegistry.CombMetallic), ImmutableMap.of(
                PluginCore.getItems().beeswax.itemStack, 0.8f,
                PluginApiculture.getItems().honeyDrop.itemStack, 0.5f,
                ItemStack(ObjRegistry.PropolisMetallic), 0.5f))

        RecipeManagers.centrifugeManager.addRecipe(20, ItemStack(ObjRegistry.CombCrystal), ImmutableMap.of(
                PluginCore.getItems().beeswax.itemStack, 0.8f,
                PluginApiculture.getItems().honeyDrop.itemStack, 0.5f,
                ItemStack(ObjRegistry.PropolisCrystal), 0.5f))

        RecipeManagers.centrifugeManager.addRecipe(20, ItemStack(ObjRegistry.CombSpectrite), ImmutableMap.of(
                PluginCore.getItems().beeswax.itemStack, 0.8f,
                PluginApiculture.getItems().honeyDrop.itemStack, 0.5f,
                ItemStack(ObjRegistry.PropolisSpectrite), 0.35f))

        RecipeManagers.centrifugeManager.addRecipe(10, ItemStack(ObjRegistry.PropolisCrystal), ImmutableMap.of(
                PluginApiculture.getItems().propolis.itemStack, 0.3f,
                ItemStack(ObjRegistry.GrainsCrystal), 0.6f,
                ItemStack(ObjRegistry.GrainsCrystal), 0.3f))

        RecipeManagers.centrifugeManager.addRecipe(10, ItemStack(ObjRegistry.PropolisMetallic), ImmutableMap.of(
                PluginApiculture.getItems().propolis.itemStack, 0.3f,
                ItemStack(ObjRegistry.GrainsMetallic), 0.6f,
                ItemStack(ObjRegistry.GrainsMetallic), 0.3f))

        RecipeManagers.centrifugeManager.addRecipe(10, ItemStack(ObjRegistry.PropolisSpectrite), ImmutableMap.of(
                PluginApiculture.getItems().propolis.itemStack, 0.3f,
                ItemStack(ObjRegistry.GrainsSpectrite), 0.5f,
                ItemStack(ObjRegistry.GrainsSpectrite), 0.2f))
    }
}