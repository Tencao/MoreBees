package com.tencao.morebees

import com.tencao.morebees.bees.BeeSpecies
import com.tencao.morebees.events.MBRegistry
import com.tencao.morebees.proxy.CommonProxy
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.FMLCommonHandler
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.io.File

@Mod(modid = MBCore.MODID, name = "MoreBees", version = MBCore.VERSION, dependencies = MBCore.DEPS)
object MBCore {
    const val MODID = "morebees"
    const val VERSION = "1.11.2-2.0.0"
    const val DEPS = "required-after:forge@[13.20.1.2386,);" +
            "required-after:forgelin@[1.6.0,);" +
            "required-after:forestry@[5.3.4.225,);"

    @SidedProxy(clientSide = "com.tencao.morebees.proxy.ClientProxy", serverSide = "com.tencao.morebees.proxy.CommonProxy")
    internal lateinit var proxy: CommonProxy
    lateinit var configDirectory: File

    val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic
    @Mod.InstanceFactory
    fun shenanigan() = this


    @Mod.EventHandler
    fun preInit(e: FMLPreInitializationEvent) {
        configDirectory = File(e.modConfigurationDirectory, "morebees")
        configDirectory.mkdirs()
        MinecraftForge.EVENT_BUS.register(MBRegistry)
    }

    @Mod.EventHandler
    fun init(e: FMLInitializationEvent) {
        MBRegistry.registerRecipes()
        BeeSpecies.initBees()
        ObjRegistry.registerHives()
    }

    @Mod.EventHandler
    fun postInit(e: FMLPostInitializationEvent) {

    }
}