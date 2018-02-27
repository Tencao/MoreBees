package com.tencao.morebees.util

import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos

object WorldHelper {

    /**
     * Wrapper around BlockPos.getAllInBox() with an AABB
     * Note that this is inclusive of all positions in the AABB!
     */
    fun getPositionsFromBox(box: AxisAlignedBB): Iterable<BlockPos> {
        return BlockPos.getAllInBox(BlockPos(box.minX, box.minY, box.minZ), BlockPos(box.maxX, box.maxY, box.maxZ))
    }
}