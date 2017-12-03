package lach_01298.moreBees.recipes;

import com.google.common.collect.ImmutableMap;

import forestry.api.recipes.RecipeManagers;
import forestry.apiculture.ModuleApiculture;
import forestry.core.ModuleCore;
import lach_01298.moreBees.item.MoreBeesItems;
import lach_01298.moreBees.util.LoadMods;
import lach_01298.moreBees.util.OreDicPreferences;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipesCentrifuge
{
	private static MoreBeesItems MBI;

	public static void registerRecipes()
	{
		RecipeManagers.centrifugeManager.addRecipe(20, new ItemStack(MoreBeesItems.CombDirt), ImmutableMap.of(
				ModuleCore.getItems().beeswax.getItemStack(), 1.0f,
				new ItemStack(Blocks.DIRT), 0.9f));



		if(LoadMods.enableIC2 && !LoadMods.enableIC2Classic)
		{
			RecipeManagers.centrifugeManager.addRecipe(20, new ItemStack(MoreBeesItems.CombRock), ImmutableMap.of(
					ModuleCore.getItems().beeswax.getItemStack(), 1.0f,
					new ItemStack(Blocks.STONE,1,1), 0.5f,
					new ItemStack(Blocks.STONE,1,3), 0.5f,
					new ItemStack(Blocks.STONE,1,5), 0.5f,
					OreDicPreferences.get("dustStone", 1), 0.9f));
		}
		else
		{
			RecipeManagers.centrifugeManager.addRecipe(20, new ItemStack(MoreBeesItems.CombRock), ImmutableMap.of(
					ModuleCore.getItems().beeswax.getItemStack(), 1.0f,
					new ItemStack(Blocks.COBBLESTONE), 0.9f,
					new ItemStack(Blocks.STONE,1,1), 0.5f,
					new ItemStack(Blocks.STONE,1,3), 0.5f,
					new ItemStack(Blocks.STONE,1,5), 0.5f));
		}


		RecipeManagers.centrifugeManager.addRecipe(20, new ItemStack(MoreBeesItems.CombWither), ImmutableMap.of(
				ModuleCore.getItems().refractoryWax.getItemStack(), 1.0f,
				new ItemStack(Items.BONE), 0.9f,
				new ItemStack(Items.COAL), 0.7f));



		RecipeManagers.centrifugeManager.addRecipe(20, new ItemStack(MoreBeesItems.CombSlime), ImmutableMap.of(
				ModuleCore.getItems().beeswax.getItemStack(), 1.0f,
				new ItemStack(Items.SLIME_BALL), 0.9f));


		RecipeManagers.centrifugeManager.addRecipe(20, new ItemStack(MoreBeesItems.CombMetallic), ImmutableMap.of(
				ModuleCore.getItems().beeswax.getItemStack(), 0.8f,
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.5f,
				new ItemStack(MoreBeesItems.PropolisMetallic), 0.5f));

		RecipeManagers.centrifugeManager.addRecipe(20, new ItemStack(MoreBeesItems.CombCrystal), ImmutableMap.of(
				ModuleCore.getItems().beeswax.getItemStack(), 0.8f,
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.5f,
				new ItemStack(MoreBeesItems.PropolisCrystal), 0.5f));


		RecipeManagers.centrifugeManager.addRecipe(10, new ItemStack(MoreBeesItems.PropolisCrystal), ImmutableMap.of(
				ModuleApiculture.getItems().propolis.getItemStack(), 0.3f,
				new ItemStack(MoreBeesItems.GrainsCrystal), 0.6f,
				new ItemStack(MoreBeesItems.GrainsCrystal), 0.3f));

		RecipeManagers.centrifugeManager.addRecipe(10, new ItemStack(MoreBeesItems.PropolisMetallic), ImmutableMap.of(
				ModuleApiculture.getItems().propolis.getItemStack(), 0.3f,
				new ItemStack(MoreBeesItems.GrainsMetallic), 0.6f,
				new ItemStack(MoreBeesItems.GrainsMetallic), 0.3f));
	}
}