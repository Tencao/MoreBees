package lach_01298.moreBees.recipes;

import lach_01298.moreBees.Registry;
import lach_01298.moreBees.item.MoreBeesItems;
import net.minecraft.init.Items;

public class RecipesCrafting
{


	private static MoreBeesItems MBI;

	public static void registerRecipes(Registry registry)
	{
		Registry.addShapelessOreRecipe("diamond", Items.DIAMOND, MoreBeesItems.DiamondFrag, MoreBeesItems.DiamondFrag, MoreBeesItems.DiamondFrag, MoreBeesItems.DiamondFrag, MoreBeesItems.DiamondFrag, MoreBeesItems.DiamondFrag, MoreBeesItems.DiamondFrag, MoreBeesItems.DiamondFrag, MoreBeesItems.DiamondFrag);
		Registry.addShapelessOreRecipe("emerald", Items.EMERALD, MoreBeesItems.EmeraldFrag, MoreBeesItems.EmeraldFrag, MoreBeesItems.EmeraldFrag, MoreBeesItems.EmeraldFrag, MoreBeesItems.EmeraldFrag, MoreBeesItems.EmeraldFrag, MoreBeesItems.EmeraldFrag, MoreBeesItems.EmeraldFrag, MoreBeesItems.EmeraldFrag);
		//GameRegistry.addShapelessRecipe(new ItemStack(Items.NETHER_STAR),MBI.NetherFrag,MBI.NetherFrag,MBI.NetherFrag,MBI.NetherFrag);
	}



}