package com.tencao.morebees

import forestry.apiculture.flowers.FlowerProvider
import forestry.core.genetics.alleles.IAlleleValue
import java.util.*

enum class Flowers constructor(flowerType: String, private val dominant: Boolean = false) : IAlleleValue<FlowerProvider> {
    ORE(MBBlocks.FlowerOre, true),
    DIAMOND(MBBlocks.FlowerDiamond, true),
    EMERALD(MBBlocks.FlowerEmerald, true),
    REDSTONE(MBBlocks.FlowerRedstone, true),
    URANIUM(MBBlocks.FlowerUranium, true),
    WATER(MBBlocks.FlowerWater),
    TNT(MBBlocks.FlowerTNT, true),
    SLIME(MBBlocks.FlowerSlime, true);

    private val value: FlowerProvider = FlowerProvider(flowerType, "for.flowers." + name.toLowerCase(Locale.ENGLISH))

    override fun getValue(): FlowerProvider {
        return value
    }

    override fun isDominant(): Boolean {
        return dominant
    }
}