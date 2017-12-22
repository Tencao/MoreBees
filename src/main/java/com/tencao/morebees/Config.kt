package com.tencao.morebees

import net.minecraftforge.common.config.Config

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
    }

    object Bees {
        @Config.Comment("The Multipler for the chance of mutation e.g. 0.5 is half as likely 2.0 is twice as likely")
        @Config.RangeDouble(min  = 0.0, max = 100.0)
        var mutationMultipler = 1.0
    }
}