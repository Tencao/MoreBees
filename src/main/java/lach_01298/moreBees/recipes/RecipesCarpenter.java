package lach_01298.moreBees.recipes;

import forestry.api.recipes.RecipeManagers;
import forestry.apiculture.ModuleApiculture;
import forestry.core.ModuleCore;
import forestry.core.fluids.Fluids;
import forestry.core.utils.OreDictUtil;
import lach_01298.moreBees.item.MoreBeesItems;
import lach_01298.moreBees.util.OreDicPreferences;
import lach_01298.moreBees.util.LoadMods;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class RecipesCarpenter
{
	private static MoreBeesItems MBI;

	public static void registerRecipes()
	{
		//frames
		RecipeManagers.carpenterManager.addRecipe(50, Fluids.FOR_HONEY.getFluid(1000), ItemStack.EMPTY, new ItemStack(MoreBeesItems.frameSweet),
				"SSS", "SFS", "SSS",
				'F', ModuleApiculture.getItems().frameUntreated,
				'S', Items.STICK);

		RecipeManagers.carpenterManager.addRecipe(100, Fluids.ICE.getFluid(1000), ItemStack.EMPTY, new ItemStack(MoreBeesItems.frameCooled),
				"SCS", "CFC", "SCS",
				'F', ModuleApiculture.getItems().frameImpregnated,
				'S', Items.STICK,
				'C',OreDictUtil.INGOT_COPPER);

		RecipeManagers.carpenterManager.addRecipe(100, Fluids.SHORT_MEAD.getFluid(1000), ItemStack.EMPTY, new ItemStack(MoreBeesItems.frameMutating),
				"RSR", "SFS", "RSR",
				'F', ModuleApiculture.getItems().frameImpregnated,
				'S', Blocks.SOUL_SAND,
				'R', ModuleApiculture.getItems().royalJelly);

		//grains
			//crystal
		RecipeManagers.carpenterManager.addRecipe(20, new FluidStack(FluidRegistry.WATER, 500), ItemStack.EMPTY, new ItemStack(Items.QUARTZ),
				" G ", "G G", " G ",
				'G', MoreBeesItems.GrainsCrystal);
		RecipeManagers.carpenterManager.addRecipe(20, new FluidStack(FluidRegistry.WATER, 500), ItemStack.EMPTY, new ItemStack(Items.REDSTONE),
				"G G", "   ", "G G",
				'G', MoreBeesItems.GrainsCrystal);
		RecipeManagers.carpenterManager.addRecipe(60, new FluidStack(FluidRegistry.WATER, 1000), ItemStack.EMPTY, new ItemStack(MoreBeesItems.EmeraldFrag),
				"G G", "GGG", "G G",
				'G', MoreBeesItems.GrainsCrystal);

		RecipeManagers.carpenterManager.addRecipe(40, new FluidStack(FluidRegistry.WATER, 1000), ItemStack.EMPTY, new ItemStack(ModuleCore.getItems().apatite),
				"G G", " G ", "G G",
				'G', MoreBeesItems.GrainsCrystal);
		
			
		//metal
		RecipeManagers.carpenterManager.addRecipe(25, new FluidStack(FluidRegistry.WATER, 500), ItemStack.EMPTY, OreDicPreferences.get("dustIron", 1),
				" G ", "G G", "   ",
				'G', MoreBeesItems.GrainsMetallic);
		RecipeManagers.carpenterManager.addRecipe(25, new FluidStack(FluidRegistry.WATER, 500), ItemStack.EMPTY, OreDicPreferences.get("dustCopper", 1),
				"   ", "G G", " G ",
				'G', MoreBeesItems.GrainsMetallic);
		RecipeManagers.carpenterManager.addRecipe(30, new FluidStack(FluidRegistry.WATER, 500), ItemStack.EMPTY, OreDicPreferences.get("dustTin", 1),
				" G ", "G G", " G ",
				'G', MoreBeesItems.GrainsMetallic);
		RecipeManagers.carpenterManager.addRecipe(40, new FluidStack(FluidRegistry.WATER, 1000), ItemStack.EMPTY, OreDicPreferences.get("dustGold", 1),
				"G G", "GGG", "G G",
				'G', MoreBeesItems.GrainsMetallic);
		if (LoadMods.enableSilver)
		{
			RecipeManagers.carpenterManager.addRecipe(35, new FluidStack(FluidRegistry.WATER, 1000), ItemStack.EMPTY, OreDicPreferences.get("dustSilver", 1),
					"G G", " G ", "G G",
					'G', MoreBeesItems.GrainsMetallic);
		}
		if (LoadMods.enableLead)
		{
			RecipeManagers.carpenterManager.addRecipe(30, new FluidStack(FluidRegistry.WATER, 750), ItemStack.EMPTY, OreDicPreferences.get("dustLead", 1),
					" G ", "GGG", " G ",
					'G', MoreBeesItems.GrainsMetallic);
	    }
		if (LoadMods.enableAluminium)
		{
			RecipeManagers.carpenterManager.addRecipe(30, new FluidStack(FluidRegistry.WATER, 750), ItemStack.EMPTY, OreDicPreferences.get("dustAluminum", 1),
					"G G", "   ", "G G",
					'G', MoreBeesItems.GrainsMetallic);
	    }
		if (LoadMods.enableOsmium)
		{
			RecipeManagers.carpenterManager.addRecipe(30, new FluidStack(FluidRegistry.WATER, 750), ItemStack.EMPTY, OreDicPreferences.get("dustOsmium", 1),
					"GGG", "   ", "G G",
					'G', MoreBeesItems.GrainsMetallic);
		}
	
		if (LoadMods.enableNickel)
		{
			RecipeManagers.carpenterManager.addRecipe(30, new FluidStack(FluidRegistry.WATER, 750), ItemStack.EMPTY, OreDicPreferences.get("dustNickel", 1),
					"G G", "G G", "G G",
					'G', MoreBeesItems.GrainsMetallic);
		}
		

		//fragments
			RecipeManagers.carpenterManager.addRecipe(600, new FluidStack(FluidRegistry.LAVA, 4000), ItemStack.EMPTY, new ItemStack(Items.NETHER_STAR),
					"FF", "FF",
					'F', MoreBeesItems.NetherFrag);
	}
	
}
