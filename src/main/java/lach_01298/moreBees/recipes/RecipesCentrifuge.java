package lach_01298.moreBees.recipes;

import com.google.common.collect.ImmutableMap;

import forestry.api.recipes.RecipeManagers;
import forestry.apiculture.PluginApiculture;
import forestry.apiculture.items.EnumHoneyComb;
import forestry.core.PluginCore;
import lach_01298.moreBees.item.MoreBeesItems;
import lach_01298.moreBees.util.LoadMods;
import lach_01298.moreBees.util.OreDicPreferences;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipesCentrifuge
{
	private static MoreBeesItems MBI;

	public static void registerRecipes()
	{
		RecipeManagers.centrifugeManager.addRecipe(20, new ItemStack(MBI.CombDirt), ImmutableMap.of(
				PluginCore.items.beeswax.getItemStack(), 1.0f,
				new ItemStack(Blocks.DIRT), 0.9f));



		if(LoadMods.enableIC2 && !LoadMods.enableIC2Classic)
		{
			RecipeManagers.centrifugeManager.addRecipe(20, new ItemStack(MBI.CombRock), ImmutableMap.of(
					PluginCore.items.beeswax.getItemStack(), 1.0f,
					new ItemStack(Blocks.STONE,1,1), 0.5f,
					new ItemStack(Blocks.STONE,1,3), 0.5f,
					new ItemStack(Blocks.STONE,1,5), 0.5f,
					OreDicPreferences.get("dustStone", 1), 0.9f));
		}
		else
		{
			RecipeManagers.centrifugeManager.addRecipe(20, new ItemStack(MBI.CombRock), ImmutableMap.of(
					PluginCore.items.beeswax.getItemStack(), 1.0f,
					new ItemStack(Blocks.COBBLESTONE), 0.9f,
					new ItemStack(Blocks.STONE,1,1), 0.5f,
					new ItemStack(Blocks.STONE,1,3), 0.5f,
					new ItemStack(Blocks.STONE,1,5), 0.5f));
		}


		RecipeManagers.centrifugeManager.addRecipe(20, new ItemStack(MBI.CombWither), ImmutableMap.of(
				PluginCore.items.refractoryWax.getItemStack(), 1.0f,
				new ItemStack(Items.BONE), 0.9f,
				new ItemStack(Items.COAL), 0.7f));



		RecipeManagers.centrifugeManager.addRecipe(20, new ItemStack(MBI.CombSlime), ImmutableMap.of(
				PluginCore.items.beeswax.getItemStack(), 1.0f,
				new ItemStack(Items.SLIME_BALL), 0.9f));


		RecipeManagers.centrifugeManager.addRecipe(20, new ItemStack(MBI.CombMetallic), ImmutableMap.of(
				PluginCore.items.beeswax.getItemStack(), 0.8f,
				PluginApiculture.items.honeyDrop.getItemStack(), 0.5f,
				new ItemStack(MBI.PropolisMetallic), 0.5f));

		RecipeManagers.centrifugeManager.addRecipe(20, new ItemStack(MBI.CombCrystal), ImmutableMap.of(
				PluginCore.items.beeswax.getItemStack(), 0.8f,
				PluginApiculture.items.honeyDrop.getItemStack(), 0.5f,
				new ItemStack(MBI.PropolisCrystal), 0.5f));


		RecipeManagers.centrifugeManager.addRecipe(20, new ItemStack(MBI.PropolisCrystal), ImmutableMap.of(
				PluginApiculture.items.propolis.getItemStack(), 0.3f,
				new ItemStack(MBI.GrainsCrystal), 0.6f));

		RecipeManagers.centrifugeManager.addRecipe(20, new ItemStack(MBI.PropolisMetallic), ImmutableMap.of(
				PluginApiculture.items.propolis.getItemStack(), 0.3f,
				new ItemStack(MBI.GrainsMetallic), 0.6f));
	}
}