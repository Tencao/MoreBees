package com.tencao.morebees.blocks

import com.tencao.morebees.MBCore
import com.tencao.morebees.hives.HiveTypes
import com.tencao.morebees.items.ItemModelProvider
import forestry.api.apiculture.BeeManager
import forestry.api.apiculture.EnumBeeType
import forestry.api.apiculture.IHiveDrop
import forestry.api.apiculture.IHiveTile
import forestry.api.core.Tabs
import forestry.apiculture.ModuleApiculture
import forestry.apiculture.tiles.TileHive
import net.minecraft.block.Block
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.block.properties.PropertyEnum
import net.minecraft.block.state.BlockStateContainer
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumBlockRenderType
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World
import java.util.*

class BlockHive(name: String) : BlockContainer(Material.WOOD), ItemModelProvider {

    init {
        BlockHive.name = name
        setLightLevel(0.4f)
        setHardness(2.5f)
        setCreativeTab(Tabs.tabApiculture)
        setHarvestLevel("scoop", 0)
        defaultState = this.blockState.baseState.withProperty<HiveTypes, HiveTypes>(HIVE_TYPES, HiveTypes.ROCK)
        unlocalizedName = name
        setRegistryName(name)

    }

    override fun createNewTileEntity(worldIn: World, meta: Int): TileEntity? {
        return TileHive()
    }

    override fun createBlockState(): BlockStateContainer {
        return BlockStateContainer(this, HIVE_TYPES)
    }

    override fun getMetaFromState(state: IBlockState): Int {
        return state.getValue<HiveTypes>(HIVE_TYPES).meta
    }

    override fun getStateFromMeta(meta: Int): IBlockState {
        return defaultState.withProperty<HiveTypes, HiveTypes>(HIVE_TYPES, HiveTypes.values()[meta])
    }

    fun getStateForType(type: HiveTypes): IBlockState {
        return defaultState.withProperty<HiveTypes, HiveTypes>(HIVE_TYPES, type)
    }


    override fun onBlockClicked(world: World?, pos: BlockPos?, player: EntityPlayer?) {
        super.onBlockClicked(world, pos, player)
        val tile = world!!.getTileEntity(pos!!)
        if (tile is IHiveTile) {
            val hive = tile as IHiveTile?
            hive!!.onAttack(world, pos, player!!)
        }
    }

    override fun onBlockHarvested(world: World?, pos: BlockPos?, state: IBlockState?, player: EntityPlayer?) {
        val canHarvest = canHarvestBlock(world!!, pos!!, player!!)
        val tile = world.getTileEntity(pos)
        if (tile is IHiveTile) {
            val hive = tile as IHiveTile?
            hive!!.onBroken(world, pos, player, canHarvest)
        }
    }

    override fun getDrops(world: IBlockAccess, pos: BlockPos, state: IBlockState, fortune: Int): List<ItemStack> {
        val drops = ArrayList<ItemStack>()

        val random = if (world is World) world.rand else Block.RANDOM

        val hiveDrops = getDropsForHive(getMetaFromState(state))
        Collections.shuffle(hiveDrops)

        // Grab a princess
        var tries = 0
        var hasPrincess = false
        while (tries <= 10 && !hasPrincess) {
            tries++

            for (drop in hiveDrops) {
                if (random.nextDouble() < drop.getChance(world, pos, fortune)) {
                    val bee = drop.getBeeType(world, pos)
                    if (random.nextFloat() < drop.getIgnobleChance(world, pos, fortune)) {
                        bee.setIsNatural(false)
                    }

                    val princess = BeeManager.beeRoot.getMemberStack(bee, EnumBeeType.PRINCESS)
                    drops.add(princess)
                    hasPrincess = true
                    break
                }
            }
        }

        // Grab drones
        for (drop in hiveDrops) {
            if (random.nextDouble() < drop.getChance(world, pos, fortune)) {
                val bee = drop.getBeeType(world, pos)
                val drone = BeeManager.beeRoot.getMemberStack(bee, EnumBeeType.DRONE)
                drops.add(drone)
                break
            }
        }

        // Grab anything else on offer
        for (drop in hiveDrops) {
            if (random.nextDouble() < drop.getChance(world, pos, fortune)) {
                drops.addAll(drop.getExtraItems(world, pos, fortune))
                break
            }
        }

        return drops
    }

    override fun getRenderType(state: IBlockState?): EnumBlockRenderType {
        return EnumBlockRenderType.MODEL
    }

    override fun registerItemModel(item: Item) {
        MBCore.proxy.registerItemRenderer(item, 0, name)
    }

    companion object {
        val HIVE_TYPES: PropertyEnum<HiveTypes> = PropertyEnum.create<HiveTypes>("hive", HiveTypes::class.java)
        private var name: String = ""

        private fun getDropsForHive(meta: Int): List<IHiveDrop> {
            val hiveName = getHiveNameForMeta(meta)
            return if (hiveName.isEmpty()) {
                emptyList()
            } else ModuleApiculture.getHiveRegistry().getDrops(hiveName)
        }

        private fun getHiveNameForMeta(meta: Int): String {
            return HiveTypes.values()[meta].hiveUid
        }
    }


}