package com.tencao.morebees

import com.tencao.morebees.blocks.BlockHive
import com.tencao.morebees.events.MBRegistry
import forestry.api.apiculture.EnumBeeChromosome
import forestry.api.apiculture.FlowerManager
import forestry.api.apiculture.IAlleleBeeEffect
import forestry.api.genetics.AlleleManager
import forestry.api.genetics.IAlleleFlowers
import forestry.apiculture.flowers.FlowerRegistry
import forestry.apiculture.genetics.alleles.AlleleEffectPotion
import net.minecraft.block.Block
import net.minecraft.init.Blocks
import net.minecraft.init.MobEffects
import net.minecraftforge.oredict.OreDictionary

object MBBlocks {

    val hive: BlockHive = BlockHive("hive")
    const val FlowerOre = "Ore"
    const val FlowerRedstone = "Redstone"
    const val FlowerUranium = "Uranium"
    const val FlowerWater = "Water"
    const val FlowerTNT = "TNT"
    private const val FlowerType = "flowers"
    const val FlowerSlime = "Slime"
    const val FlowerDiamond = "Diamond"
    const val FlowerEmerald = "Emerald"
    val effectWither: IAlleleBeeEffect = AlleleEffectPotion("Wither", true, MobEffects.WITHER, 400)
    val effectRadiation: IAlleleBeeEffect = AlleleEffectPotion("Radiation", true, MobEffects.HUNGER, 400)
    val effectSlimy: IAlleleBeeEffect = AlleleEffectPotion("Slimy", true, MobEffects.JUMP_BOOST, 400)
    val FlowerTypeOre: IAlleleFlowers = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerOre, Flowers.ORE.value, true, EnumBeeChromosome.FLOWER_PROVIDER)

    val FlowerTypeRedstone: IAlleleFlowers = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerRedstone, Flowers.REDSTONE.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
    val FlowerTypeDiamond: IAlleleFlowers = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerDiamond, Flowers.DIAMOND.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
    val FlowerTypeEmerald: IAlleleFlowers = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerEmerald, Flowers.EMERALD.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
    val FlowerTypeUranium: IAlleleFlowers = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerUranium, Flowers.URANIUM.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
    val FlowerTypeWater: IAlleleFlowers = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerWater, Flowers.WATER.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
    val FlowerTypeTNT: IAlleleFlowers = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerTNT, Flowers.TNT.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
    val FlowerTypeSlime: IAlleleFlowers = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerSlime, Flowers.SLIME.value, true, EnumBeeChromosome.FLOWER_PROVIDER)

    fun init() {
        MBRegistry.registerBlock(hive)
    }

    fun lateInit(){
        //Register Flowers
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

        //Register Genes
        AlleleManager.alleleRegistry.registerAllele(effectWither, EnumBeeChromosome.EFFECT)
        AlleleManager.alleleRegistry.registerAllele(effectRadiation, EnumBeeChromosome.EFFECT)
        AlleleManager.alleleRegistry.registerAllele(effectSlimy, EnumBeeChromosome.EFFECT)


    }
}