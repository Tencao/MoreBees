package com.tencao.morebees

import forestry.apiculture.flowers.FlowerProvider
import forestry.core.genetics.alleles.IAlleleValue
import java.util.*

enum class Flowers constructor(flowerType: String, private val dominant: Boolean = false) : IAlleleValue<FlowerProvider> {
    ORE(ObjRegistry.FlowerOre, true),
    DIAMOND(ObjRegistry.FlowerDiamond, true),
    EMERALD(ObjRegistry.FlowerEmerald, true),
    REDSTONE(ObjRegistry.FlowerRedstone, true),
    URANIUM(ObjRegistry.FlowerUranium, true),
    WATER(ObjRegistry.FlowerWater),
    TNT(ObjRegistry.FlowerTNT, true),
    SLIME(ObjRegistry.FlowerSlime, true);

    private val value: FlowerProvider = FlowerProvider(flowerType, "for.flowers." + name.toLowerCase(Locale.ENGLISH))

    override fun getValue(): FlowerProvider {
        return value
    }

    override fun isDominant(): Boolean {
        return dominant
    }
}