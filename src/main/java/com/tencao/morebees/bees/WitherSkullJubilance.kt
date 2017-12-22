package com.tencao.morebees.bees

import forestry.api.apiculture.IAlleleBeeSpecies
import forestry.api.apiculture.IBeeGenome
import forestry.api.apiculture.IBeeHousing
import forestry.api.apiculture.IJubilanceProvider
import net.minecraft.tileentity.TileEntity
import net.minecraft.tileentity.TileEntitySkull

class WitherSkullJubilance : IJubilanceProvider {

    override fun isJubilant(species: IAlleleBeeSpecies, genome: IBeeGenome, housing: IBeeHousing): Boolean {
        val world = housing.worldObj
        var pos = housing.coordinates

        var tile: TileEntity?
        do {
            pos = pos.up()
            tile = world.getTileEntity(pos)
        } while (tile is IBeeHousing && pos.y > 0)

        return tile is TileEntitySkull && tile.skullType == 1
    }

}