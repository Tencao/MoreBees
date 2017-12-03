package lach_01298.moreBees.recipes;

import lach_01298.moreBees.item.MoreBeesItems;
import lach_01298.moreBees.util.LoadMods;
import lach_01298.moreBees.util.OreDicPreferences;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipesSmelting 
{

	
	private static MoreBeesItems MBI;
	
	public static void registerRecipes()
	{
		
		if(LoadMods.enableIronDust)
		{
			GameRegistry.addSmelting(MoreBeesItems.DustIron, new ItemStack(Items.IRON_INGOT), 0.7f);
		}
		if (LoadMods.enableGoldDust) {

			GameRegistry.addSmelting(MoreBeesItems.DustGold, new ItemStack(Items.GOLD_INGOT), 0.7f);
		}
		if (LoadMods.enableCopperDust) {
			GameRegistry.addSmelting(MoreBeesItems.DustCopper,OreDicPreferences.get("ingotCopper", 1), 0.7f);
		}
		if (LoadMods.enableTinDust) {
			GameRegistry.addSmelting(MoreBeesItems.DustTin,OreDicPreferences.get("ingotTin", 1), 0.7f);
		}
		
		if(LoadMods.enableLead && MoreBeesItems.MBILead)
		{
			GameRegistry.addSmelting(MoreBeesItems.DustLead, OreDicPreferences.get("ingotLead",1), 0.7f);
		}
		if(LoadMods.enableSilver && MoreBeesItems.MBISilver)
		{
			
			GameRegistry.addSmelting(MoreBeesItems.DustSilver, OreDicPreferences.get("ingotSilver",1), 0.7f);
		}
		if(LoadMods.enableAluminium && MoreBeesItems.MBIAluminium)
		{
		GameRegistry.addSmelting(MoreBeesItems.DustAluminium, OreDicPreferences.get("ingotAluminum",1), 0.7f);
		}
		
		if(LoadMods.enableNickel && MoreBeesItems.MBINickel)
		{
		GameRegistry.addSmelting(MoreBeesItems.DustNickel, OreDicPreferences.get("ingotNickel",1), 0.7f);
		}
		if(LoadMods.enablePlatinum && MoreBeesItems.MBIPlatinum)
		{
		GameRegistry.addSmelting(MoreBeesItems.DustPlatinum, OreDicPreferences.get("ingotPlatinum",1), 0.7f);
		}
		if(LoadMods.enableIridium && MoreBeesItems.MBIIridium)
		{
		GameRegistry.addSmelting(MoreBeesItems.DustIridium, OreDicPreferences.get("ingotIridium",1), 0.7f);
		}
	}
	
	
	
}
