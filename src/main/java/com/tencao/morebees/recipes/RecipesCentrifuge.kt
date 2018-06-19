package com.tencao.morebees.recipes

import com.google.common.collect.ImmutableMap
import com.tencao.morebees.MBItems
import com.tencao.morebees.util.OreDictUtil
import forestry.api.recipes.RecipeManagers
import forestry.apiculture.ModuleApiculture
import forestry.core.ModuleCore
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.Loader

object RecipesCentrifuge {

    fun registerRecipes() {
        RecipeManagers.centrifugeManager.addRecipe(20, ItemStack(MBItems.CombDirt), ImmutableMap.of(
                ModuleCore.getItems().beeswax.itemStack, 1.0f,
                ItemStack(Blocks.DIRT), 0.9f))

        if (Loader.isModLoaded("IC2")) {
            RecipeManagers.centrifugeManager.addRecipe(20, ItemStack(MBItems.CombRock), ImmutableMap.of(
                    ModuleCore.getItems().beeswax.itemStack, 1.0f,
                    ItemStack(Blocks.STONE, 1, 1), 0.5f,
                    ItemStack(Blocks.STONE, 1, 3), 0.5f,
                    ItemStack(Blocks.STONE, 1, 5), 0.5f,
                    OreDictUtil.getOreStack("dustStone"), 0.9f))
        }
        if (Loader.isModLoaded("IC2-Classic-Spmod")){
            RecipeManagers.centrifugeManager.addRecipe(20, ItemStack(MBItems.CombRock), ImmutableMap.of(
                    ModuleCore.getItems().beeswax.itemStack, 1.0f,
                    ItemStack(Blocks.COBBLESTONE), 0.9f,
                    ItemStack(Blocks.STONE, 1, 1), 0.5f,
                    ItemStack(Blocks.STONE, 1, 3), 0.5f,
                    ItemStack(Blocks.STONE, 1, 5), 0.5f))
        }

        RecipeManagers.centrifugeManager.addRecipe(20, ItemStack(MBItems.CombWither), ImmutableMap.of(
                ModuleCore.getItems().refractoryWax.itemStack, 1.0f,
                ItemStack(Items.BONE), 0.9f,
                ItemStack(Items.COAL), 0.7f))

        RecipeManagers.centrifugeManager.addRecipe(20, ItemStack(MBItems.CombSlime), ImmutableMap.of(
                ModuleCore.getItems().beeswax.itemStack, 1.0f,
                ItemStack(Items.SLIME_BALL), 0.9f))


        RecipeManagers.centrifugeManager.addRecipe(20, ItemStack(MBItems.CombMetallic), ImmutableMap.of(
                ModuleCore.getItems().beeswax.itemStack, 0.8f,
                ModuleApiculture.getItems().honeyDrop.itemStack, 0.5f,
                ItemStack(MBItems.PropolisMetallic), 0.5f))

        RecipeManagers.centrifugeManager.addRecipe(20, ItemStack(MBItems.CombCrystal), ImmutableMap.of(
                ModuleCore.getItems().beeswax.itemStack, 0.8f,
                ModuleApiculture.getItems().honeyDrop.itemStack, 0.5f,
                ItemStack(MBItems.PropolisCrystal), 0.5f))

        RecipeManagers.centrifugeManager.addRecipe(20, ItemStack(MBItems.CombSpectrite), ImmutableMap.of(
                ModuleCore.getItems().beeswax.itemStack, 0.8f,
                ModuleApiculture.getItems().honeyDrop.itemStack, 0.5f,
                ItemStack(MBItems.PropolisSpectrite), 0.35f))

        RecipeManagers.centrifugeManager.addRecipe(10, ItemStack(MBItems.PropolisCrystal), ImmutableMap.of(
                ModuleApiculture.getItems().propolis.itemStack, 0.3f,
                ItemStack(MBItems.GrainsCrystal), 0.6f,
                ItemStack(MBItems.GrainsCrystal), 0.3f))

        RecipeManagers.centrifugeManager.addRecipe(10, ItemStack(MBItems.PropolisMetallic), ImmutableMap.of(
                ModuleApiculture.getItems().propolis.itemStack, 0.3f,
                ItemStack(MBItems.GrainsMetallic), 0.6f,
                ItemStack(MBItems.GrainsMetallic), 0.3f))

        RecipeManagers.centrifugeManager.addRecipe(10, ItemStack(MBItems.PropolisSpectrite), ImmutableMap.of(
                ModuleApiculture.getItems().propolis.itemStack, 0.3f,
                ItemStack(MBItems.GrainsSpectrite), 0.5f,
                ItemStack(MBItems.GrainsSpectrite), 0.2f))
    }
}