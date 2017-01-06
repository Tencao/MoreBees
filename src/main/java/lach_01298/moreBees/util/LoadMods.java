package lach_01298.moreBees.util;

import java.io.PrintStream;

import lach_01298.moreBees.util.Log;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;

import org.apache.logging.log4j.Level;

public class LoadMods
{
	public static boolean enableLead = false;
	public static boolean enableSilver = false;
	public static boolean enableUranium = false;
	public static boolean enableIC2 = false;
	public static boolean enableIronDust = false;
	public static boolean enableCopperDust = false;
	public static boolean enableTinDust = false;
	public static boolean enableGoldDust = false;
	public static boolean enableAluminium = false;
	public static boolean enableSulfur = false;
	public static boolean enableRuby = false;
	public static boolean enableSapphire = false;
	public static boolean enableTinkers = false;
	public static boolean enableIC2Classic = false;
	public static boolean enableResonating = false;
	public static boolean enableOsmium = false;
	public static boolean enableDraconium = false;
	public static boolean enableCertusQuartz = false;
	public static boolean enableYellorite;

	public static void loadMods()
	{

		
		if(OreDictionary.getOres("dustIron").isEmpty())
		{
			enableIronDust = true;
		}
		if(OreDictionary.getOres("dustGold").isEmpty())
		{
			enableGoldDust = true;
		}
		if(OreDictionary.getOres("dustCopper").isEmpty())
		{
			enableCopperDust = true;
		}
		if(OreDictionary.getOres("dustTin").isEmpty())
		{
			enableTinDust = true;
		}
		if(!OreDictionary.getOres("dustSulfur").isEmpty())
		{
			enableSulfur = true;
		}
		if(!OreDictionary.getOres("ingotLead").isEmpty())
		{
			enableLead = true;
		}
		if(!OreDictionary.getOres("ingotSilver").isEmpty())
		{
			enableSilver = true;
		}
		if(!OreDictionary.getOres("oreUranium").isEmpty())
		{
			enableUranium = true;
		}
		if(!OreDictionary.getOres("ingotAluminum").isEmpty())
		{
			enableAluminium = true;
		}
		if(Loader.isModLoaded("deepresonance"))
		{
			enableResonating = true;
			Log.log(Level.INFO,"Loaded Deep Resonance fetures");
		}
		if(Loader.isModLoaded("bigreactors"))
		{
			//enableYellorite = true;
			Log.log( Level.INFO,  "Loaded Extreme Reactors fetures");
		}
		if(!OreDictionary.getOres( "dustCertusQuartz").isEmpty())
		{
			enableCertusQuartz = true;
			Log.log( Level.INFO, "Loaded Applied Energistics fetures");
		}
		if(!OreDictionary.getOres("dustDraconium").isEmpty())
		{
			enableDraconium = true;
			Log.log((Level) Level.INFO, "Loaded Draconic Evolution fetures");
		}
		if(Loader.isModLoaded("IC2"))
		{
			try
			{
				enableIC2 = true;
				Log.log(Level.INFO, "Loaded Industrialcraft2 fetures");
			}
			catch(Exception e)
			{
				Log.log(Level.INFO, "Could not load Industrialcraft2 fetures");
				e.printStackTrace(System.err);
			}
		}
		if(Loader.isModLoaded("IC2-Classic-Spmod"))
		{
			try
			{
				enableIC2Classic = true;
				Log.log(Level.INFO, "Loaded Industrialcraft2 classic fetures");
			}
			catch(Exception e)
			{
				Log.log(Level.INFO, "Could not load Industrialcraft2 classic fetures");
				e.printStackTrace(System.err);
			}
		}
		if(Loader.isModLoaded("tconstruct"))
		{
			try
			{
				enableTinkers = true;
				Log.log(Level.INFO, "Loaded tinkers construct fetures");
			}
			catch(Exception e)
			{
				Log.log(Level.INFO, "Could not load tinkers construct fetures");
				e.printStackTrace(System.err);
			}
		}
		Log.log(Level.INFO, "Loaded More Bees modCompat fetures");
	}

	public static void loadLateMods() 
	{
		
		if(!OreDictionary.getOres("dustOsmium").isEmpty())
		{
			enableOsmium = true;
			Log.log(Level.INFO, "Loaded Mekanism fetures");
		}
		if(!OreDictionary.getOres("gemRuby").isEmpty())
		{
			enableRuby = true;
		}
		if(!OreDictionary.getOres("gemSapphire").isEmpty())
		{
			enableSapphire = true;
		}
		Log.log(Level.INFO, "Loaded More Bees modCompat fetures for late registering mods");
	}
}
