package lach_01298.moreBees;

import lach_01298.moreBees.Genetics.BeeSpecies;
import lach_01298.moreBees.block.MoreBeesBlocks;
import lach_01298.moreBees.item.MoreBeesItems;
import lach_01298.moreBees.recipes.RecipesCarpenter;
import lach_01298.moreBees.recipes.RecipesCentrifuge;
import lach_01298.moreBees.recipes.RecipesCrafting;
import lach_01298.moreBees.recipes.RecipesSmelting;
import lach_01298.moreBees.util.LoadMods;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MoreBees.MOD_ID, name = "More Bees", version = MoreBees.VERSION, acceptedMinecraftVersions = MoreBees.MCVERSION ,
	dependencies = "required-after:forestry;after:IndustrialCraft2;after:mekanism;after:draconicevolution;after:bigreactors;after:railcraft;after:techreborn")
public class MoreBees
{
	public static final String MOD_ID = "morebees";
	public static final String VERSION = "1.12.1-1.4.2";
	public static final String MCVERSION = "1.12.1";
	@Mod.Instance(value = "morebees")
	public static MoreBees instance;
	@SidedProxy(clientSide = "lach_01298.moreBees.ClientProxy", serverSide = "lach_01298.moreBees.CommonProxy")
	public static CommonProxy proxy;

	public static Registry registry = new Registry();
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(registry);
		proxy.preInit(event);
		LoadMods.loadMods();
		System.out.println(event.getEventType());
		MoreBeesItems.initItems(registry);
		MoreBeesBlocks.init(registry);
		RecipesCrafting.registerRecipes(registry);
		
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
	
		LoadMods.loadMods();
		System.out.println(event.getEventType());
		RecipesSmelting.registerRecipes();
		RecipesCentrifuge.registerRecipes();
		RecipesCarpenter.registerRecipes();
		Register.RegisterGenes();
		Register.RegisterFlowers();
		BeeSpecies.initBees();
		Register.RegisterHives();
		
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);

	}
}