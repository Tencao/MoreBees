package lach_01298.moreBees.recipes;

import lach_01298.moreBees.item.MoreBeesItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipesCrafting
{


	private static MoreBeesItems MBI;

	public static void registerRecipes()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(Items.DIAMOND), MBI.DiamondFrag,MBI.DiamondFrag,MBI.DiamondFrag,MBI.DiamondFrag,MBI.DiamondFrag,MBI.DiamondFrag,MBI.DiamondFrag,MBI.DiamondFrag,MBI.DiamondFrag);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.EMERALD), MBI.EmeraldFrag,MBI.EmeraldFrag,MBI.EmeraldFrag,MBI.EmeraldFrag,MBI.EmeraldFrag,MBI.EmeraldFrag,MBI.EmeraldFrag,MBI.EmeraldFrag,MBI.EmeraldFrag);
		//GameRegistry.addShapelessRecipe(new ItemStack(Items.NETHER_STAR),MBI.NetherFrag,MBI.NetherFrag,MBI.NetherFrag,MBI.NetherFrag);
	}



}