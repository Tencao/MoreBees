package lach_01298.moreBees.item;


import lach_01298.moreBees.Registry;
import lach_01298.moreBees.util.*;
import forestry.api.core.Tabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.oredict.OreDictionary;

public class MoreBeesItems
{

	public static BasicItem CombRock;
	public static BasicItem CombDirt;
	public static BasicItem CombWither;
	public static BasicItem CombSlime;
	public static BasicItem CombMetallic;
	public static BasicItem CombCrystal;
	public static BasicItem DiamondFrag;
	public static BasicItem EmeraldFrag;
	public static ShinyItem NetherFrag;
	public static BasicItem PropolisMetallic;
	public static BasicItem PropolisCrystal;
	public static BasicItem GrainsMetallic;
	public static BasicItem GrainsCrystal;

	//ore dic items
	public static BasicItem DustIron;
	public static BasicItem DustCopper;
	public static BasicItem DustTin;
	public static BasicItem DustGold;
	public static BasicItem DustSilver;
	public static BasicItem DustLead;
	public static BasicItem DustAluminium;
	public static BasicItem DustNickel;
	public static BasicItem DustPlatinum;
	public static BasicItem DustIridium;
	
	public static boolean MBIGold = false;
	public static boolean MBISilver = false;
	public static boolean MBILead = false;
	public static boolean MBIAluminium = false;
	public static boolean MBINickel = false;
	public static boolean MBIPlatinum = false;
	public static boolean MBIIridium = false;

	//frames
	public static ItemFrame frameSweet;
	public static ItemFrame frameCooled;
	public static ItemFrame frameMutating;


	public static void initItems(Registry registry)
	{

		if(Config.enableFrames)
		{
			frameSweet = registry.register(new ItemFrame(120, 1.1f, 2.5f, 1.0f, 0.5f, "frameSweet"));
			frameCooled = registry.register(new ItemFrame(300, 2.0f, 3.5f, 0.8f, 0.25f, "frameCooled"));
			frameMutating = registry.register(new ItemFrame(240, 1.5f, 0.9f, 1.0f, 3.0f, "frameMutating"));
		}
		CombRock = registry.registerOreItem(new BasicItem("CombRock").setCreativeTab(Tabs.tabApiculture),"beeComb");
		CombDirt = registry.registerOreItem(new BasicItem("CombDirt").setCreativeTab(Tabs.tabApiculture),"beeComb");
		CombWither = registry.registerOreItem(new BasicItem("CombWither").setCreativeTab(Tabs.tabApiculture),"beeComb");
		CombSlime = registry.registerOreItem(new BasicItem("CombSlime").setCreativeTab(Tabs.tabApiculture),"beeComb");
		CombMetallic = registry.registerOreItem(new BasicItem("CombMetallic").setCreativeTab(Tabs.tabApiculture),"beeComb");
		CombCrystal = registry.registerOreItem(new BasicItem("CombCrystal").setCreativeTab(Tabs.tabApiculture),"beeComb");

		DiamondFrag = registry.registerOreItem(new BasicItem("diamondFragment").setCreativeTab(Tabs.tabApiculture),"nuggetDiamond");
		EmeraldFrag = registry.registerOreItem(new BasicItem("emeraldFragment").setCreativeTab(Tabs.tabApiculture),"nuggetEmerald");
		NetherFrag = registry.register(new ShinyItem("nether_starFragment").setCreativeTab(Tabs.tabApiculture));

		PropolisMetallic = registry.register(new BasicItem("propolisMetallic").setCreativeTab(Tabs.tabApiculture));
		PropolisCrystal = registry.register(new BasicItem("propolisCrystal").setCreativeTab(Tabs.tabApiculture));
		GrainsMetallic = registry.register(new BasicItem("grainMetallic").setCreativeTab(Tabs.tabApiculture));
		GrainsCrystal = registry.register(new BasicItem("grainCrystal").setCreativeTab(Tabs.tabApiculture));

		//ore dic items
		if(LoadMods.enableIronDust)
		{
			DustIron = registry.registerOreItem(new BasicItem("dustIron").setCreativeTab(CreativeTabs.MATERIALS),"dustIron");
		}
		if(LoadMods.enableCopperDust)
		{
			DustCopper = registry.registerOreItem(new BasicItem("dustCopper").setCreativeTab(CreativeTabs.MATERIALS),"dustCopper");
		}
		if(LoadMods.enableTinDust)
		{
			DustTin = registry.registerOreItem(new BasicItem("dustTin").setCreativeTab(CreativeTabs.MATERIALS),"dustTin");
		}
		if(LoadMods.enableGoldDust)
		{
			DustGold = registry.registerOreItem(new BasicItem("dustGold").setCreativeTab(CreativeTabs.MATERIALS),"dustGold");
		}
		//addon ore dic items
		if((OreDictionary.getOres("dustLead").isEmpty()) && LoadMods.enableLead)
		{
			DustLead = registry.registerOreItem(new BasicItem("dustLead").setCreativeTab(CreativeTabs.MATERIALS),"dustLead");
			MBILead = true;
		}
		if((OreDictionary.getOres("dustSilver").isEmpty()) && LoadMods.enableSilver)
		{
			DustSilver = registry.registerOreItem(new BasicItem("dustSilver").setCreativeTab(CreativeTabs.MATERIALS),"dustSilver");
			MBISilver = true;
		}
		if((OreDictionary.getOres("dustAluminum").isEmpty()) && LoadMods.enableAluminium)
		{
			DustAluminium = registry.registerOreItem(new BasicItem("dustAluminium").setCreativeTab(CreativeTabs.MATERIALS),"dustAluminum");
			MBIAluminium = true;
		}
		if((OreDictionary.getOres("dustNickel").isEmpty()) && LoadMods.enableNickel)
		{
			DustNickel = registry.registerOreItem(new BasicItem("dustNickel").setCreativeTab(CreativeTabs.MATERIALS),"dustNickel");
			MBINickel = true;
		}
		if((OreDictionary.getOres("dustPlatinum").isEmpty()) && LoadMods.enablePlatinum)
		{
			DustPlatinum = registry.registerOreItem(new BasicItem("dustPlatinum").setCreativeTab(CreativeTabs.MATERIALS),"dustPlatinum");
			MBIPlatinum = true;
		}
		if((OreDictionary.getOres("dustIridium").isEmpty()) && LoadMods.enableIridium)
		{
			DustIridium = registry.registerOreItem(new BasicItem("dustIridium").setCreativeTab(CreativeTabs.MATERIALS),"dustIridium");
			MBIIridium = true;
		}
	}
}
