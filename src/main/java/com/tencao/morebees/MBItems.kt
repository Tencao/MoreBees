package com.tencao.morebees

import com.tencao.morebees.events.MBRegistry
import com.tencao.morebees.items.BasicItem
import com.tencao.morebees.items.ItemFrame
import forestry.api.core.Tabs
import net.minecraft.creativetab.CreativeTabs
import net.minecraftforge.oredict.OreDictionary

object MBItems {

    val CombRock: BasicItem = BasicItem("CombRock").setCreativeTab(Tabs.tabApiculture)
    val CombDirt: BasicItem = BasicItem("CombDirt").setCreativeTab(Tabs.tabApiculture)
    val CombWither: BasicItem = BasicItem("CombWither").setCreativeTab(Tabs.tabApiculture)
    val CombSlime: BasicItem = BasicItem("CombSlime").setCreativeTab(Tabs.tabApiculture)
    val CombMetallic: BasicItem = BasicItem("CombMetallic").setCreativeTab(Tabs.tabApiculture)
    val CombCrystal: BasicItem = BasicItem("CombCrystal").setCreativeTab(Tabs.tabApiculture)
    val CombSpectrite: BasicItem = BasicItem("CombSpectrite").setCreativeTab(Tabs.tabApiculture).setEffect(true) as BasicItem
    val DiamondFrag: BasicItem = BasicItem("diamondFragment").setCreativeTab(Tabs.tabApiculture)
    val EmeraldFrag: BasicItem = BasicItem("emeraldFragment").setCreativeTab(Tabs.tabApiculture)
    val NetherFrag: BasicItem = BasicItem("nether_starFragment").setCreativeTab(Tabs.tabApiculture).setEffect(true) as BasicItem
    val SpectriteFrag: BasicItem = BasicItem("spectriteFragment").setCreativeTab(Tabs.tabApiculture).setEffect(true) as BasicItem
    val PropolisMetallic: BasicItem = BasicItem("propolisMetallic").setCreativeTab(Tabs.tabApiculture)
    val PropolisCrystal: BasicItem = BasicItem("propolisCrystal").setCreativeTab(Tabs.tabApiculture)
    val PropolisSpectrite: BasicItem = BasicItem("propolisSpectrite").setCreativeTab(Tabs.tabApiculture).setEffect(true) as BasicItem
    val GrainsMetallic: BasicItem = BasicItem("grainMetallic").setCreativeTab(Tabs.tabApiculture)
    val GrainsCrystal: BasicItem = BasicItem("grainCrystal").setCreativeTab(Tabs.tabApiculture)
    val GrainsSpectrite: BasicItem = BasicItem("grainSpectrite").setCreativeTab(Tabs.tabApiculture).setEffect(true) as BasicItem

    //ore dic items
    val DustIron: BasicItem = BasicItem("dustIron").setCreativeTab(CreativeTabs.MATERIALS)
    val DustCopper: BasicItem = BasicItem("dustCopper").setCreativeTab(CreativeTabs.MATERIALS)
    val DustTin: BasicItem = BasicItem("dustTin").setCreativeTab(CreativeTabs.MATERIALS)
    val DustGold: BasicItem = BasicItem("dustGold").setCreativeTab(CreativeTabs.MATERIALS)
    val DustSilver: BasicItem = BasicItem("dustSilver").setCreativeTab(CreativeTabs.MATERIALS)
    val DustLead: BasicItem = BasicItem("dustLead").setCreativeTab(CreativeTabs.MATERIALS)
    val DustAluminium: BasicItem = BasicItem("dustAluminium").setCreativeTab(CreativeTabs.MATERIALS)
    val DustNickel: BasicItem = BasicItem("dustNickel").setCreativeTab(CreativeTabs.MATERIALS)
    val DustPlatinum: BasicItem = BasicItem("dustPlatinum").setCreativeTab(CreativeTabs.MATERIALS)
    val DustIridium: BasicItem = BasicItem("dustIridium").setCreativeTab(CreativeTabs.MATERIALS)

    var MBISilver = false
    var MBILead = false
    var MBIAluminium = false
    var MBINickel = false
    var MBIPlatinum = false
    var MBIIridium = false
    var MBISpectrite = false

    //frames
    val frameSweet: ItemFrame = ItemFrame(120, 1.1f, 2.5f, 1.0f, 0.5f, "frameSweet")
    val frameCooled: ItemFrame = ItemFrame(300, 2.0f, 3.5f, 0.8f, 0.25f, "frameCooled")
    val frameMutating: ItemFrame = ItemFrame(240, 1.5f, 0.9f, 1.0f, 3.0f, "frameMutating")

    fun init(){
        if (ModConfig.general.enableFrames) {
            MBRegistry.register(frameSweet)
            MBRegistry.register(frameCooled)
            MBRegistry.register(frameMutating)
        }
        MBRegistry.registerOreItem(CombRock, "beeComb")
        MBRegistry.registerOreItem(CombDirt, "beeComb")
        MBRegistry.registerOreItem(CombWither, "beeComb")
        MBRegistry.registerOreItem(CombSlime, "beeComb")
        MBRegistry.registerOreItem(CombMetallic, "beeComb")
        MBRegistry.registerOreItem(CombCrystal, "beeComb")
        //MBRegistry.registerOreItem(CombSpectrite, "beeComb")

        MBRegistry.registerOreItem(DiamondFrag, "nuggetDiamond")
        MBRegistry.registerOreItem(EmeraldFrag, "nuggetEmerald")
        MBRegistry.register(NetherFrag)

        MBRegistry.register(PropolisMetallic)
        MBRegistry.register(PropolisCrystal)
        //MBRegistry.register(PropolisSpectrite)
        MBRegistry.register(GrainsMetallic)
        MBRegistry.register(GrainsCrystal)
        //MBRegistry.register(GrainsSpectrite)

        MBRegistry.registerOreItem(DustIron, "dustIron")
        MBRegistry.registerOreItem(DustCopper, "dustCopper")
        MBRegistry.registerOreItem(DustTin, "dustTin")
        MBRegistry.registerOreItem(DustGold, "dustGold")
        //addon ore dic items
        if (OreDictionary.getOres("dustLead").isNotEmpty()) {
            MBRegistry.registerOreItem(DustLead, "dustLead")
            MBILead = true
        }
        if (OreDictionary.getOres("dustSilver").isNotEmpty()) {
            MBRegistry.registerOreItem(DustSilver, "dustSilver")
            MBISilver = true
        }
        if (OreDictionary.getOres("dustAluminum").isNotEmpty()) {
            MBRegistry.registerOreItem(DustAluminium, "dustAluminum")
            MBIAluminium = true
        }
        if (OreDictionary.getOres("dustNickel").isNotEmpty()) {
            MBRegistry.registerOreItem(DustNickel, "dustNickel")
            MBINickel = true
        }
        if (OreDictionary.getOres("dustPlatinum").isNotEmpty()) {
            MBRegistry.registerOreItem(DustPlatinum, "dustPlatinum")
            MBIPlatinum = true
        }
        if (OreDictionary.getOres("dustIridium").isNotEmpty()) {
            MBRegistry.registerOreItem(DustIridium, "dustIridium")
            MBIIridium = true
        }
        /*
        if (OreDictionary.getOres("dustSpectrite").isNotEmpty()) {
            MBRegistry.register(SpectriteFrag)
            MBISpectrite = true
        }*/

    }

}