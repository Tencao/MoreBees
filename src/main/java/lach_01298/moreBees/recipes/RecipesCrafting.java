package lach_01298.moreBees.recipes;

import lach_01298.moreBees.Registry;
import lach_01298.moreBees.item.MoreBeesItems;
import net.minecraft.init.Items;

public class RecipesCrafting
{


	private static MoreBeesItems MBI;

	public static void registerRecipes(Registry registry)
	{
		registry.addShapelessOreRecipe("diamond", Items.DIAMOND, MBI.DiamondFrag,MBI.DiamondFrag,MBI.DiamondFrag,MBI.DiamondFrag,MBI.DiamondFrag,MBI.DiamondFrag,MBI.DiamondFrag,MBI.DiamondFrag,MBI.DiamondFrag);
		registry.addShapelessOreRecipe("emerald", Items.EMERALD, MBI.EmeraldFrag,MBI.EmeraldFrag,MBI.EmeraldFrag,MBI.EmeraldFrag,MBI.EmeraldFrag,MBI.EmeraldFrag,MBI.EmeraldFrag,MBI.EmeraldFrag,MBI.EmeraldFrag);
		//GameRegistry.addShapelessRecipe(new ItemStack(Items.NETHER_STAR),MBI.NetherFrag,MBI.NetherFrag,MBI.NetherFrag,MBI.NetherFrag);
	}



}