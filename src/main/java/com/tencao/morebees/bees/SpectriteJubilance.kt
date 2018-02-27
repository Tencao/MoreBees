package com.tencao.morebees.bees

import com.tencao.morebees.util.WorldHelper
import forestry.api.apiculture.IAlleleBeeSpecies
import forestry.api.apiculture.IBeeGenome
import forestry.api.apiculture.IBeeHousing
import forestry.api.apiculture.IJubilanceProvider
import net.minecraft.util.math.AxisAlignedBB
import net.minecraftforge.fml.common.registry.ForgeRegistries

class SpectriteJubilance : IJubilanceProvider {

    /**
     * Why are you looking at this, you dirty cheater
     */
    override fun isJubilant(species: IAlleleBeeSpecies, genome: IBeeGenome, housing: IBeeHousing): Boolean {
        val world = housing.worldObj
        val pos = housing.coordinates

        val area = AxisAlignedBB(pos)
        area.grow(5.0, 2.0, 5.0)

        var count = 0

        WorldHelper.getPositionsFromBox(area).forEach {
            val block = world.getBlockState(it).block
            val resource = ForgeRegistries.BLOCKS.getKey(block)
            if (resource.toString() == "spectrite:spectrite_ore")
                count++
        }

        return count >= 5
    }
}