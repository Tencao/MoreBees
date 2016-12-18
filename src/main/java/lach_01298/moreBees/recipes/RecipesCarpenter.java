package lach_01298.moreBees.recipes;

import com.google.common.collect.ImmutableMap;

import forestry.api.recipes.RecipeManagers;
import forestry.apiculture.PluginApiculture;
import forestry.apiculture.items.EnumHoneyComb;
import forestry.apiculture.items.EnumPollenCluster;
import forestry.core.PluginCore;
import forestry.core.fluids.Fluids;
import forestry.core.utils.OreDictUtil;
import lach_01298.moreBees.item.MoreBeesItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipesCarpenter 
{
	private static MoreBeesItems MBI;
	
	public static void registerRecipes()
	{
		RecipeManagers.carpenterManager.addRecipe(50, Fluids.FOR_HONEY.getFluid(1000), null, new ItemStack(MoreBeesItems.frameSweet),
				"SSS", "SFS", "SSS",
				'F', PluginApiculture.items.frameUntreated,
				'S', Items.STICK);
		
		RecipeManagers.carpenterManager.addRecipe(100, Fluids.ICE.getFluid(1000), null, new ItemStack(MoreBeesItems.frameCooled),
				"SCS", "CFC", "SCS",
				'F', PluginApiculture.items.frameImpregnated,
				'S', Items.STICK,
				'C',OreDictUtil.INGOT_COPPER);
		
		RecipeManagers.carpenterManager.addRecipe(100, Fluids.SHORT_MEAD.getFluid(1000), null, new ItemStack(MoreBeesItems.frameMutating),
				"RSR", "SFS", "RSR",
				'F', PluginApiculture.items.frameImpregnated,
				'S', Blocks.SOUL_SAND,
				'R',PluginApiculture.items.royalJelly);
		
		
	}
}
