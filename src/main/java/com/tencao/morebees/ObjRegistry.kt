package com.tencao.morebees

import com.tencao.morebees.bees.BeeSpecies
import com.tencao.morebees.blocks.BlockHive
import com.tencao.morebees.events.MBRegistry
import com.tencao.morebees.hives.HiveDescription
import com.tencao.morebees.hives.HiveTypes
import com.tencao.morebees.items.BasicItem
import com.tencao.morebees.items.ItemFrame
import forestry.api.apiculture.EnumBeeChromosome
import forestry.api.apiculture.FlowerManager
import forestry.api.apiculture.IAlleleBeeEffect
import forestry.api.core.Tabs
import forestry.api.genetics.AlleleManager
import forestry.api.genetics.IAlleleFlowers
import forestry.apiculture.ModuleApiculture
import forestry.apiculture.flowers.FlowerRegistry
import forestry.apiculture.genetics.BeeDefinition
import forestry.apiculture.genetics.HiveDrop
import forestry.apiculture.genetics.alleles.AlleleEffectPotion
import forestry.apiculture.items.EnumHoneyComb
import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.init.Blocks
import net.minecraft.init.MobEffects
import net.minecraft.item.ItemStack
import net.minecraftforge.oredict.OreDictionary

object ObjRegistry {
    const val FlowerOre = "Ore"
    const val FlowerRedstone = "Redstone"
    const val FlowerUranium = "Uranium"
    const val FlowerWater = "Water"
    const val FlowerTNT = "TNT"
    const val FlowerType = "flowers"
    const val FlowerSlime = "Slime"
    const val FlowerDiamond = "Diamond"
    const val FlowerEmerald = "Emerald"
    lateinit var effectWither: IAlleleBeeEffect
    lateinit var effectRadiation: IAlleleBeeEffect
    lateinit var effectSlimy: IAlleleBeeEffect
    lateinit var FlowerTypeOre: IAlleleFlowers

    lateinit var FlowerTypeRedstone: IAlleleFlowers
    lateinit var FlowerTypeDiamond: IAlleleFlowers
    lateinit var FlowerTypeEmerald: IAlleleFlowers
    lateinit var FlowerTypeUranium: IAlleleFlowers
    lateinit var FlowerTypeWater: IAlleleFlowers
    lateinit var FlowerTypeTNT: IAlleleFlowers
    lateinit var FlowerTypeSlime: IAlleleFlowers
    val hive: BlockHive = BlockHive("hive")

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

    fun registerAll(){
        registerItems()
        registerGenes()
        registerFlowers()
    }

    fun registerBlocks() {
        MBRegistry.registerBlock(hive)
    }

    fun registerItems() {

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
        MBRegistry.registerOreItem(CombSpectrite, "beeComb")

        MBRegistry.registerOreItem(DiamondFrag, "nuggetDiamond")
        MBRegistry.registerOreItem(EmeraldFrag, "nuggetEmerald")
        MBRegistry.register(NetherFrag)

        MBRegistry.register(PropolisMetallic)
        MBRegistry.register(PropolisCrystal)
        MBRegistry.register(PropolisSpectrite)
        MBRegistry.register(GrainsMetallic)
        MBRegistry.register(GrainsCrystal)
        MBRegistry.register(GrainsSpectrite)

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
        if (OreDictionary.getOres("dustSpectrite").isNotEmpty()) {
            MBRegistry.register(SpectriteFrag)
            MBISpectrite = true
        }

    }

    fun registerFlowers() {
        val flowerRegistry = FlowerManager.flowerRegistry as FlowerRegistry
        flowerRegistry.registerAcceptableFlower(Blocks.COAL_ORE, FlowerOre)
        flowerRegistry.registerAcceptableFlower(Blocks.IRON_ORE, FlowerOre)
        flowerRegistry.registerAcceptableFlower(Blocks.REDSTONE_ORE, FlowerRedstone)
        flowerRegistry.registerAcceptableFlower(Blocks.REDSTONE_BLOCK, FlowerRedstone)
        flowerRegistry.registerAcceptableFlower(Blocks.DIAMOND_ORE, FlowerDiamond)
        flowerRegistry.registerAcceptableFlower(Blocks.DIAMOND_BLOCK, FlowerDiamond)
        flowerRegistry.registerAcceptableFlower(Blocks.EMERALD_ORE, FlowerEmerald)
        flowerRegistry.registerAcceptableFlower(Blocks.EMERALD_BLOCK, FlowerEmerald)
        flowerRegistry.registerAcceptableFlower(Blocks.WATERLILY, FlowerWater)
        flowerRegistry.registerAcceptableFlower(Blocks.TNT, FlowerTNT)
        flowerRegistry.registerAcceptableFlower(Blocks.SLIME_BLOCK, FlowerSlime)
        OreDictionary.getOres("oreCopper").forEach { flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(it.item), FlowerOre) }
        OreDictionary.getOres("oreTin").forEach { flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(it.item), FlowerOre) }
        OreDictionary.getOres("blockSlime").forEach { flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(it.item), FlowerSlime) }
        OreDictionary.getOres("oreUranium").forEach { flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(it.item), FlowerUranium) }
        OreDictionary.getOres("oreResonating").forEach { flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(it.item), FlowerUranium) }
        OreDictionary.getOres("oreYellorite").forEach { flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(it.item), FlowerUranium) }
        flowerRegistry.registerAcceptableFlower(Blocks.CHORUS_FLOWER, FlowerManager.FlowerTypeEnd)
    }

    fun registerGenes() {
        FlowerTypeOre = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerOre, Flowers.ORE.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
        FlowerTypeRedstone = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerRedstone, Flowers.REDSTONE.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
        FlowerTypeDiamond = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerDiamond, Flowers.DIAMOND.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
        FlowerTypeEmerald = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerEmerald, Flowers.EMERALD.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
        FlowerTypeWater = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerWater, Flowers.WATER.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
        FlowerTypeTNT = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerTNT, Flowers.TNT.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
        FlowerTypeUranium = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerUranium, Flowers.URANIUM.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
        FlowerTypeSlime = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerSlime, Flowers.SLIME.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
        effectWither = AlleleEffectPotion("Wither", true, MobEffects.WITHER, 400)
        AlleleManager.alleleRegistry.registerAllele(effectWither, EnumBeeChromosome.EFFECT)
        effectRadiation = AlleleEffectPotion("Radiation", true, MobEffects.HUNGER, 400)
        AlleleManager.alleleRegistry.registerAllele(effectRadiation, EnumBeeChromosome.EFFECT)
        effectSlimy = AlleleEffectPotion("Slimy", true, MobEffects.JUMP_BOOST, 400)
        AlleleManager.alleleRegistry.registerAllele(effectSlimy, EnumBeeChromosome.EFFECT)
    }

    fun registerHives() {
        if (ModConfig.worldGen.genHives) {
            ModuleApiculture.getHiveRegistry().registerHive(HiveTypes.ROCK.hiveUid, HiveDescription.ROCK)
            val honeyComb = ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.HONEY, 1)
            val rockComb = ItemStack(CombRock)
            ModuleApiculture.getHiveRegistry().addDrops(HiveTypes.ROCK.hiveUid, HiveDrop(0.8, BeeSpecies.ROCK, rockComb).setIgnobleShare(0.7),
                    HiveDrop(0.03, BeeDefinition.VALIANT, honeyComb))
        }

    }
}