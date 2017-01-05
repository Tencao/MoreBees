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
		if(OreDictionary.getOres((String) "dustIron").isEmpty())
		{
			enableIronDust = true;
		}
		if(OreDictionary.getOres((String) "dustGold").isEmpty())
		{
			enableGoldDust = true;
		}
		if(OreDictionary.getOres((String) "dustCopper").isEmpty())
		{
			enableCopperDust = true;
		}
		if(OreDictionary.getOres((String) "dustTin").isEmpty())
		{
			enableTinDust = true;
		}
		if(!OreDictionary.getOres((String) "dustSulfur").isEmpty())
		{
			enableSulfur = true;
		}
		if(!OreDictionary.getOres((String) "ingotLead").isEmpty())
		{
			enableLead = true;
		}
		if(!OreDictionary.getOres((String) "ingotSilver").isEmpty())
		{
			enableSilver = true;
		}
		if(!OreDictionary.getOres((String) "oreUranium").isEmpty())
		{
			enableUranium = true;
		}
		if(!OreDictionary.getOres((String) "ingotAluminum").isEmpty())
		{
			enableAluminium = true;
		}
		if(!OreDictionary.getOres((String) "oreResonating").isEmpty())
		{
			enableResonating = true;
			Log.log((Level) Level.INFO, (String) "Loaded Deep Resonance fetures");
		}
		if(!OreDictionary.getOres((String) "oreYellorite").isEmpty())
		{
			enableYellorite = true;
			Log.log((Level) Level.INFO, (String) "Loaded Extreme Reactors fetures");
		}
		if(!OreDictionary.getOres((String) "dustCertusQuartz").isEmpty())
		{
			enableCertusQuartz = true;
			Log.log((Level) Level.INFO, (String) "Loaded Applied Energistics fetures");
		}
		if(!OreDictionary.getOres((String) "dustDraconium").isEmpty())
		{
			enableDraconium = true;
			Log.log((Level) Level.INFO, (String) "Loaded Draconic Evolution fetures");
		}
		if(Loader.isModLoaded((String) "IC2"))
		{
			try
			{
				enableIC2 = true;
				Log.log((Level) Level.INFO, (String) "Loaded Industrialcraft2 fetures");
			}
			catch(Exception e)
			{
				Log.log((Level) Level.INFO, (String) "Could not load Industrialcraft2 fetures");
				e.printStackTrace(System.err);
			}
		}
		if(Loader.isModLoaded((String) "IC2-Classic-Spmod"))
		{
			try
			{
				enableIC2Classic = true;
				Log.log((Level) Level.INFO, (String) "Loaded Industrialcraft2 classic fetures");
			}
			catch(Exception e)
			{
				Log.log((Level) Level.INFO, (String) "Could not load Industrialcraft2 classic fetures");
				e.printStackTrace(System.err);
			}
		}
		if(Loader.isModLoaded((String) "tconstruct"))
		{
			try
			{
				enableTinkers = true;
				Log.log((Level) Level.INFO, (String) "Loaded tinkers construct fetures");
			}
			catch(Exception e)
			{
				Log.log((Level) Level.INFO, (String) "Could not load tinkers construct fetures");
				e.printStackTrace(System.err);
			}
		}
		Log.log((Level) Level.INFO, (String) "Loaded More Bees modCompat fetures");
	}

	public static void loadLateMods() {
		if(!OreDictionary.getOres((String) "dustOsmium").isEmpty())
		{
			enableOsmium = true;
			Log.log((Level) Level.INFO, (String) "Loaded Mekanism fetures");
		}
		if(!OreDictionary.getOres((String) "gemRuby").isEmpty())
		{
			enableRuby = true;
		}
		if(!OreDictionary.getOres((String) "gemSapphire").isEmpty())
		{
			enableSapphire = true;
		}
		Log.log((Level) Level.INFO, (String) "Loaded More Bees modCompat fetures for late registering mods");
	}
}
