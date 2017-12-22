package com.tencao.morebees.hives

import com.tencao.morebees.Config
import com.tencao.morebees.ObjRegistry
import com.tencao.morebees.bees.BeeSpecies
import forestry.api.apiculture.IBeeGenome
import forestry.api.apiculture.hives.HiveManager
import forestry.api.apiculture.hives.IHiveDescription
import forestry.api.apiculture.hives.IHiveGen
import forestry.api.core.BiomeHelper
import forestry.api.core.EnumHumidity
import forestry.api.core.EnumTemperature
import forestry.api.genetics.AlleleManager
import net.minecraft.block.state.IBlockState
import net.minecraft.init.Blocks
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.biome.Biome
import net.minecraftforge.common.BiomeDictionary
import java.util.*

enum class HiveDescription constructor(hiveType: HiveTypes, private val genChance: Float, beeTemplate: BeeSpecies, private val hiveGen: IHiveGen) : IHiveDescription {

    ROCK(HiveTypes.ROCK, 2.0f, BeeSpecies.ROCK, HiveManager.genHelper.ground(Blocks.STONE)) {

        override fun isGoodBiome(biome: Biome): Boolean {

            return !BiomeHelper.isBiomeHellish(biome) && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.END)
        }

        override fun postGen(world: World, rand: Random, pos: BlockPos) {

            super.postGen(world, rand, pos)
            if (Config.worldGen.genHiveFlowers) {
                postGenFlowers(world, rand, pos, OreStates)
            }
        }
    };

    private val blockState: IBlockState = ObjRegistry.hive.getStateForType(hiveType)
    private val beeGenome: IBeeGenome = beeTemplate.genome

    override fun getHiveGen(): IHiveGen {
        return hiveGen
    }

    override fun getBlockState(): IBlockState {
        return blockState
    }

    override fun isGoodBiome(biome: Biome): Boolean {
        return !BiomeHelper.isBiomeHellish(biome)
    }

    override fun isGoodHumidity(humidity: EnumHumidity): Boolean {

        val idealHumidity = beeGenome.primary.humidity
        val humidityTolerance = beeGenome.toleranceHumid
        return AlleleManager.climateHelper.isWithinLimits(humidity, idealHumidity, humidityTolerance)
    }

    override fun isGoodTemperature(temperature: EnumTemperature): Boolean {
        val idealTemperature = beeGenome.primary.temperature
        val temperatureTolerance = beeGenome.toleranceTemp
        return AlleleManager.climateHelper.isWithinLimits(temperature, idealTemperature, temperatureTolerance)
    }

    override fun getGenChance(): Float {
        return genChance
    }

    override fun postGen(world: World, rand: Random, pos: BlockPos) {

    }

    companion object {

        private val groundGen = HiveManager.genHelper.ground(Blocks.STONE)
        private val OreStates = ArrayList<IBlockState>()


        init {
            OreStates.addAll(Blocks.COAL_ORE.blockState.validStates)
            OreStates.addAll(Blocks.IRON_ORE.blockState.validStates)

        }

        protected fun postGenFlowers(world: World, rand: Random, hivePos: BlockPos, flowerStates: List<IBlockState>) {
            var plantedCount = 0
            for (i in 0..9) {
                val xOffset = rand.nextInt(8) - 4
                val zOffset = rand.nextInt(8) - 4
                var blockPos: BlockPos? = hivePos.add(xOffset, 0, zOffset)
                if (xOffset == 0 && zOffset == 0 || !world.isBlockLoaded(blockPos!!)) {
                    continue
                }

                blockPos = groundGen.getPosForHive(world, blockPos.x, blockPos.z)
                if (blockPos == null) {
                    continue
                }

                val state = flowerStates[rand.nextInt(flowerStates.size)]
                val block = state.block
                if (!block.canPlaceBlockAt(world, blockPos)) {
                    continue
                }

                world.setBlockState(blockPos, state)
                plantedCount++
                if (plantedCount >= 5) {
                    break
                }
            }
        }
    }
}