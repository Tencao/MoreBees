package com.tencao.morebees;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = MBCore.MODID, name = "morebees/MoreBees", category = "morebees")
public class ModConfig {

    public static General general = new General();
    public static WorldGen worldGen = new WorldGen();
    public static Bees bees = new Bees();

    /**
     * All Config Classes
     */
    public static class General {
        @Config.Comment("Set to false to disable More Bees frames e.g. mutating frame.")
        public boolean enableFrames = true;
    }

    public static class WorldGen {
        @Config.Comment("Set to false to disable the generation of rock hives.")
        public boolean genHives = true;
        @Config.Comment("Set to false to disable the generation of ore veins around rock hives.")
        public boolean genHiveFlowers = true;
        @Config.Comment("Sets the worldgen spawn chance for rock hives")
        @Config.RangeDouble(min = 0.0, max = 100.0)
        public double rockHiveSpawnRate = 2.0;
        @Config.Comment("A list of Dims to ignore world gen")
        public int[] rockDimBlackList = {};
    }

    public static class Bees {
        @Config.Comment("The Multipler for the chance of mutation e.g. 0.5 is half as likely 2.0 is twice as likely")
        @Config.RangeDouble(min  = 0.0, max = 100.0)
        public double mutationMultipler = 2.0;
    }

    /**
     * Inner Class to handle Reloading of the recipes
     */
    @Mod.EventBusSubscriber
    static class ConfigurationHolder {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(MBCore.MODID)) {
                ConfigManager.load(MBCore.MODID, Config.Type.INSTANCE);
            }
        }
    }
}
