package com.tencao.morebees.hives

import com.tencao.morebees.Config
import forestry.api.apiculture.hives.IHiveGen
import forestry.core.utils.BlockUtil
import net.minecraft.block.Block
import net.minecraft.block.state.IBlockState
import net.minecraft.init.Blocks
import net.minecraft.util.EnumFacing
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import java.util.*

enum class HiveGen(private val type: GenType, vararg groundBlocks: Block) : IHiveGen {
    ROCK(GenType.GROUND, Blocks.STONE){

        override fun isValidLocation(world: World, pos: BlockPos): Boolean {
            return if (!Config.worldGen.rockDimBlackList.contains(world.provider.dimension))
                checkValidLocation(world, pos)
            else false
        }
    };

    private val groundMaterials = HashSet<net.minecraft.block.material.Material>()

    enum class GenType{
        GROUND,
        TREE
    }

    override fun canReplace(blockState: IBlockState, world: World, pos: BlockPos): Boolean {
        return BlockUtil.canReplace(blockState, world, pos)
    }

    fun checkValidLocation(world: World, pos: BlockPos): Boolean{
        return if (type == GenType.TREE)
            checkTreeLocation(world, pos)
        else checkGroundLocation(world, pos)
    }

    fun checkGroundLocation(world: World, pos: BlockPos):Boolean{
        val groundBlockState = world.getBlockState(pos.down())
        val groundBlockMaterial = groundBlockState.material
        return groundMaterials.contains(groundBlockMaterial)
    }

    fun checkTreeLocation(world: World, pos: BlockPos): Boolean{
        val posAbove = pos.up()
        val blockStateAbove = world.getBlockState(posAbove)
        if (!forestry.apiculture.worldgen.HiveGen.isTreeBlock(blockStateAbove, world, posAbove)) {
            return false
        }
        // not a good location if right on top of something
        val posBelow = pos.down()
        val blockStateBelow = world.getBlockState(posBelow)
        return canReplace(blockStateBelow, world, posBelow)
    }

    override fun getPosForHive(world: World, x: Int, z: Int): BlockPos?{
        if (type == GenType.GROUND)
            return getGroundGen(world, x, z)
        if (type == GenType.TREE)
            return getTreeGen(world, x, z)
        return null
    }

    fun getGroundGen(world: World, x: Int, z: Int): BlockPos?{
        // get to the ground
        val topPos = world.getHeight(BlockPos(x, 0, z))
        if (topPos.y == 0) {
            return null
        }

        val pos = BlockPos.MutableBlockPos(topPos)

        var blockState = world.getBlockState(pos)
        while (forestry.apiculture.worldgen.HiveGen.isTreeBlock(blockState, world, pos) || canReplace(blockState, world, pos)) {
            pos.move(EnumFacing.DOWN)
            if (pos.y <= 0) {
                return null
            }
            blockState = world.getBlockState(pos)
        }

        return pos.up()

    }

    fun getTreeGen(world: World, x: Int, z: Int): BlockPos?{
        // get top leaf block
        val topPos = world.getHeight(BlockPos(x, 0, z)).down()
        if (topPos.y <= 0) {
            return null
        }

        var blockState = world.getBlockState(topPos)
        if (!isTreeBlock(blockState, world, topPos)) {
            return null
        }

        // get to the bottom of the leaves
        val pos = BlockPos.MutableBlockPos(topPos)
        do {
            pos.move(EnumFacing.DOWN)
            blockState = world.getBlockState(pos)
        } while (forestry.apiculture.worldgen.HiveGen.isTreeBlock(blockState, world, pos))

        return pos.toImmutable()

    }

    fun isTreeBlock(blockState: IBlockState, world: World, pos: BlockPos): Boolean {
        val block = blockState.block
        return block.isLeaves(blockState, world, pos) || block.isWood(world, pos)
    }

    init {
        groundBlocks
                .map { it.defaultState }
                .mapTo(groundMaterials) { it.material }
    }
}