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
			GameRegistry.addSmelting(MBI.DustIron, new ItemStack(Items.IRON_INGOT), 0.7f);
		}
		if (LoadMods.enableGoldDust) {

			GameRegistry.addSmelting(MBI.DustGold, new ItemStack(Items.GOLD_INGOT), 0.7f);
		}
		if (LoadMods.enableCopperDust) {
			GameRegistry.addSmelting(MBI.DustCopper,OreDicPreferences.get("ingotCopper", 1), 0.7f);
		}
		if (LoadMods.enableTinDust) {
			GameRegistry.addSmelting(MBI.DustTin,OreDicPreferences.get("ingotTin", 1), 0.7f);
		}
		
		if(LoadMods.enableLead && MBI.MBILead)
		{
			GameRegistry.addSmelting(MBI.DustLead, OreDicPreferences.get("ingotLead",1), 0.7f);
		}
		if(LoadMods.enableSilver && MBI.MBISilver)
		{
			
			GameRegistry.addSmelting(MBI.DustSilver, OreDicPreferences.get("ingotSilver",1), 0.7f);
		}
		if(LoadMods.enableAluminium && MBI.MBIAluminium)
		{
		GameRegistry.addSmelting(MBI.DustAluminium, OreDicPreferences.get("ingotAluminum",1), 0.7f);
		}
		
		if(LoadMods.enableNickel && MBI.MBINickel)
		{
		GameRegistry.addSmelting(MBI.DustNickel, OreDicPreferences.get("ingotNickel",1), 0.7f);
		}
		if(LoadMods.enablePlatinum && MBI.MBIPlatinum)
		{
		GameRegistry.addSmelting(MBI.DustPlatinum, OreDicPreferences.get("ingotPlatinum",1), 0.7f);
		}
		if(LoadMods.enableIridium && MBI.MBIIridium)
		{
		GameRegistry.addSmelting(MBI.DustIridium, OreDicPreferences.get("ingotIridium",1), 0.7f);
		}
	}
	
	
	
}
