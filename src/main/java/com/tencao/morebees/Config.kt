package com.tencao.morebees

import net.minecraftforge.common.config.Config
import net.minecraftforge.common.config.ConfigManager
import net.minecraftforge.fml.client.event.ConfigChangedEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@Config(modid = MBCore.MODID, name = "morebees/MoreBees", category = "morebees")
object Config {

    val general = General
    val worldGen = WorldGen
    val bees = Bees

    object General {
        @Config.Comment("Set to false to disable More Bees frames e.g. mutating frame.")
        var enableFrames = true
    }

    object WorldGen {
        @Config.Comment("Set to false to disable the generation of rock hives.")
        var genHives = true
        @Config.Comment("Set to false to disable the generation of ore veins around rock hives.")
        var genHiveFlowers = true
        @Config.Comment("Sets the worldgen spawn chance for rock hives")
        var rockHiveSpawnRate = 2.0
        @Config.Comment("A list of Dims to ignore world gen")
        var rockDimBlackList = arrayListOf<Int>()
    }

    object Bees {
        @Config.Comment("The Multipler for the chance of mutation e.g. 0.5 is half as likely 2.0 is twice as likely")
        @Config.RangeDouble(min  = 0.0, max = 100.0)
        var mutationMultipler = 1.0
    }

    /**
     * Inner Class to handle Reloading of the recipes
     */
    @Mod.EventBusSubscriber
    internal object ConfigurationHolder {
        @SubscribeEvent
        fun onConfigChanged(event: ConfigChangedEvent.OnConfigChangedEvent) {
            if (event.modID == MBCore.MODID) {
                ConfigManager.load(MBCore.MODID, Config.Type.INSTANCE)
            }
        }
    }
}