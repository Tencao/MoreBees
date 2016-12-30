package lach_01298.moreBees;

import java.io.File;

import lach_01298.moreBees.util.Config;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy 
{
	public static Configuration config;

	public void registerProxies() 
	{
	
		
	}
	public void registerItemRenderer(Item item, int meta, String id) 
	{
	}
	 // Config instance
 
    public void preInit(FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), MoreBees.MOD_ID+".cfg"));
        Config.readConfig();

       
    }

    

    public void postInit(FMLPostInitializationEvent e) {
        if (config.hasChanged()) {
            config.save();
        }
    }
}
