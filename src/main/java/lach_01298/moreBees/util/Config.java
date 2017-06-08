package lach_01298.moreBees.util;

import org.apache.logging.log4j.Level;

import lach_01298.moreBees.CommonProxy;
import net.minecraftforge.common.config.Configuration;

public class Config
{

	private static String beeNote = " NOTE:this stops being able to get all bees useing this bee by noncreative means i.e. Breeding.";

	// defaults
	private static final String CATEGORY_GENERAL = "general";
	public static boolean enableFrames = true;

	private static final String CATEGORY_WORLD_GEN = "world Gen";
	public static boolean genHives = true;
	public static boolean genHiveFlowers = true;

	private static final String CATEGORY_BEES = "bees";
	public static boolean netherStarBees = true;
	public static boolean witherBees = true;
	public static boolean diamondBees = true;
	public static boolean apocalypticBees = true;

	public static boolean uranicBees = true;
	public static boolean iridiumBees = true;
	public static boolean radioactiveBees = true;
	public static boolean yelloriteBees = true;
	public static boolean resonatingBees = true;
	public static boolean certusQuartzBees = true;
	public static boolean draconicBees = true;

	public static boolean tinkersSlimeBees = true;
	public static boolean tinkersMetalBees = true;

	public static float mutationMultipler = 1.0f;

	public static void readConfig()
	{
		Configuration cfg = CommonProxy.config;
		try
		{
			cfg.load();
			initGeneralConfig(cfg);
			initWordGenConfig(cfg);
			initBeesConfig(cfg);
		}
		catch(Exception e)
		{
			Log.log(Level.ERROR, "Problem loading config file!", e);
		}
		finally
		{
			if(cfg.hasChanged())
			{
				cfg.save();
			}
		}
	}

	private static void initGeneralConfig(Configuration cfg)
	{
		cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
		enableFrames = cfg.getBoolean("enableFrames", CATEGORY_GENERAL, enableFrames, "Set to false to disable More Bees frames e.g. mutating frame.");

	}

	private static void initWordGenConfig(Configuration cfg)
	{
		cfg.addCustomCategoryComment(CATEGORY_WORLD_GEN, "World Generation configuration");

		genHives = cfg.getBoolean("genHives", CATEGORY_WORLD_GEN, genHives, "Set to false to disable the generation of rock hives.");
		genHiveFlowers = cfg.getBoolean("genHiveFlowers", CATEGORY_WORLD_GEN, genHiveFlowers, "Set to false to disable the generation of ore veins around rock hives.");


	}
	private static void initBeesConfig(Configuration cfg)
	{
		cfg.addCustomCategoryComment(CATEGORY_BEES, "Bee configuration");

		netherStarBees = cfg.getBoolean("netherStarBees", CATEGORY_BEES, netherStarBees, "Set to false to disable Wither Bees.");
		witherBees = cfg.getBoolean("witherBees", CATEGORY_BEES, witherBees, "Set to false to disable Withering Bees."+beeNote);
		diamondBees = cfg.getBoolean("diamondBees", CATEGORY_BEES, diamondBees, "Set to false to disable Diamond Bees.");
		apocalypticBees = cfg.getBoolean("apocalypticBees", CATEGORY_BEES, apocalypticBees, "Set to false to disable Apocalyptic Bees."+beeNote);
		uranicBees = cfg.getBoolean("uranicBees", CATEGORY_BEES, uranicBees, "Set to false to disable Uranic Bees.");
		iridiumBees = cfg.getBoolean("iridiumBees", CATEGORY_BEES, iridiumBees, "Set to false to disable Irdium Bees.");
		yelloriteBees = cfg.getBoolean("yelloriteBees", CATEGORY_BEES, yelloriteBees, "Set to false to disable Yellorite Bees.");
		resonatingBees = cfg.getBoolean("resonatingBees", CATEGORY_BEES, resonatingBees, "Set to false to disable Resonating Bees.");
		radioactiveBees = cfg.getBoolean("radioactiveBees", CATEGORY_BEES, radioactiveBees, "Set to false to disable Radioactive Bees."+beeNote);
		certusQuartzBees = cfg.getBoolean("certzBees", CATEGORY_BEES, certusQuartzBees, "Set to false to disable Certus Quartz Bees.");
		draconicBees = cfg.getBoolean("draconicBees", CATEGORY_BEES, draconicBees, "Set to false to disable Draconic Bees.");
		tinkersSlimeBees = cfg.getBoolean("tinkersSlimeBees", CATEGORY_BEES, tinkersSlimeBees, "Set to false to disable TinkersConstructs Slime Bees. i.e. blue, purple, magma");
		tinkersMetalBees = cfg.getBoolean("tinkersMetalBees", CATEGORY_BEES, tinkersMetalBees, "Set to false to disable TinkersConstructs Metal Bees. i.e. cobalt, ardite");
		mutationMultipler = cfg.getFloat("mutationMultipler", CATEGORY_BEES, mutationMultipler, 0.0f, 100.0f, "The Multipler for the chance of mutation e.g. 0.5 is half as likely 2.0 is twice as likely");

	}
}