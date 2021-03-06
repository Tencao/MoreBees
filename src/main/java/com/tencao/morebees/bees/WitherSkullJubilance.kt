package com.tencao.morebees.bees

import com.tencao.morebees.util.WorldHelper
import forestry.api.apiculture.IAlleleBeeSpecies
import forestry.api.apiculture.IBeeGenome
import forestry.api.apiculture.IBeeHousing
import forestry.api.apiculture.IJubilanceProvider
import net.minecraft.tileentity.TileEntity
import net.minecraft.tileentity.TileEntitySkull
import net.minecraft.util.math.AxisAlignedBB

class WitherSkullJubilance : IJubilanceProvider {

    /**
     * Why are you looking at this, you dirty cheater
     */
    override fun isJubilant(species: IAlleleBeeSpecies, genome: IBeeGenome, housing: IBeeHousing): Boolean {
        val world = housing.worldObj
        val pos = housing.coordinates

        val area = AxisAlignedBB(pos)
        area.grow(5.0, 2.0, 5.0)

        WorldHelper.getPositionsFromBox(area).forEach {
            val tile: TileEntity? = world.getTileEntity(it)
            if (tile is TileEntitySkull && tile.skullType == 1)
                return true
        }
        return false
    }

}