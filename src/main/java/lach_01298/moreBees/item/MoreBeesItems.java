package lach_01298.moreBees.item;


import lach_01298.moreBees.util.*;
import forestry.api.core.Tabs;
import forestry.apiculture.items.ItemHiveFrame;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class MoreBeesItems 
{

	public static BasicItem CombRock;
	public static BasicItem CombDirt;
	public static BasicItem CombWither;
	public static BasicItem CombSlime;
	public static BasicItem DiamondFrag;
	public static BasicItem EmeraldFrag;
	public static ShinyItem NetherFrag;
	//ore dic items
	public static BasicItem DustIron;
	public static BasicItem DustCopper;
	public static BasicItem DustTin;
	public static BasicItem DustGold;
	public static BasicItem DustSilver;
	public static BasicItem DustLead;
	public static BasicItem DustAluminium;
	
	//frames
	public static ItemFrame frameSweet;
	public static ItemFrame frameCooled;
	public static ItemFrame frameMutating;

	
	public static void initItems() 
	{
		
		if(Config.enableFrames)
		{
			frameSweet = register(new ItemFrame(120, 1.1f, 2.5f, 1.0f, 0.5f, "frameSweet"));
			frameCooled = register(new ItemFrame(300, 2.0f, 3.5f, 0.8f, 0.25f, "frameCooled"));
			frameMutating = register(new ItemFrame(240, 1.5f, 0.9f, 1.0f, 3.0f, "frameMutating"));
		}
		CombRock = register(new BasicItem("CombRock").setCreativeTab(Tabs.tabApiculture));
		CombDirt = register(new BasicItem("CombDirt").setCreativeTab(Tabs.tabApiculture));
		CombWither = register(new BasicItem("CombWither").setCreativeTab(Tabs.tabApiculture));
		CombSlime = register(new BasicItem("CombSlime").setCreativeTab(Tabs.tabApiculture));
		
		DiamondFrag = registerOreItem(new BasicItem("diamondFragment").setCreativeTab(Tabs.tabApiculture),"nuggetDiamond");
		EmeraldFrag = registerOreItem(new BasicItem("emeraldFragment").setCreativeTab(Tabs.tabApiculture),"nuggetEmerald");
		NetherFrag = register(new ShinyItem("nether_starFragment").setCreativeTab(Tabs.tabApiculture));
		
		//ore dic items
		if(LoadMods.enableIronDust)
		{
			DustIron = registerOreItem(new BasicItem("dustIron").setCreativeTab(CreativeTabs.MATERIALS),"dustIron");
		}
		if(LoadMods.enableCopperDust)
		{
			DustCopper = registerOreItem(new BasicItem("dustCopper").setCreativeTab(CreativeTabs.MATERIALS),"dustCopper");
		}
		if(LoadMods.enableTinDust)
		{
			DustTin = registerOreItem(new BasicItem("dustTin").setCreativeTab(CreativeTabs.MATERIALS),"dustTin");
		}
		if(LoadMods.enableGoldDust)
		{
			DustGold = registerOreItem(new BasicItem("dustGold").setCreativeTab(CreativeTabs.MATERIALS),"dustGold");
		}
		//addon ore dic items
		if((OreDictionary.getOres("dustLead").isEmpty()) && LoadMods.enableLead)
		{
			DustLead = registerOreItem(new BasicItem("dustLead").setCreativeTab(CreativeTabs.MATERIALS),"dustLead");
		}
		if((OreDictionary.getOres("dustSilver").isEmpty()) && LoadMods.enableSilver)
		{
			DustSilver = registerOreItem(new BasicItem("dustSilver").setCreativeTab(CreativeTabs.MATERIALS),"dustSilver");
		}
		if((OreDictionary.getOres("dustAluminum").isEmpty()) && LoadMods.enableAluminium)
		{
			DustAluminium = registerOreItem(new BasicItem("dustAluminium").setCreativeTab(CreativeTabs.MATERIALS),"dustAluminum");
		}
		
		
		
	}

	
	


	private static <T extends Item> T register(T item) 
	{
		GameRegistry.register(item);

		if (item instanceof ItemModelProvider) 
		{
			((ItemModelProvider) item).registerItemModel(item);
		}

		return  item;
	}
	
	private static <T extends Item> T registerOreItem(T item,String oreDicName) 
	{
		GameRegistry.register(item);
		OreDictionary.registerOre(oreDicName, item);

		if (item instanceof ItemModelProvider) 
		{
			((ItemModelProvider) item).registerItemModel(item);
		}

		return  item;
	}
}
