package lach_01298.moreBees.hives;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import lach_01298.moreBees.Register;
import lach_01298.moreBees.Genetics.BeeSpecies;
import lach_01298.moreBees.block.BlockHive;
import lach_01298.moreBees.block.MoreBeesBlocks;
import lach_01298.moreBees.util.Config;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.hives.HiveManager;
import forestry.api.apiculture.hives.IHiveDescription;
import forestry.api.apiculture.hives.IHiveGen;
import forestry.api.core.BiomeHelper;
import forestry.api.core.EnumHumidity;
import forestry.api.core.EnumTemperature;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.EnumTolerance;

public enum MoreBeesHiveDescription implements IHiveDescription 
{

	ROCK(MoreBeesHiveType.ROCK, 2.0f, BeeSpecies.ROCK, HiveManager.genHelper.ground(Blocks.STONE)) 
	{
		
		public boolean isGoodBiome(Biome biome) 
		{
			
			return !BiomeHelper.isBiomeHellish(biome)&&!BiomeDictionary.hasType(biome, BiomeDictionary.Type.END);
		}

		@Override
		public void postGen(World world, Random rand, BlockPos pos) 
		{
			
			super.postGen(world, rand, pos);
			if(Config.genHiveFlowers)
			{
			postGenFlowers(world, rand, pos, OreStates);
			}
		}
	};

	private static final IHiveGen groundGen = HiveManager.genHelper.ground(Blocks.STONE);
	private static final List<IBlockState> OreStates = new ArrayList();
	

	static 
	{
		OreStates.addAll(Blocks.COAL_ORE.getBlockState().getValidStates());
		OreStates.addAll(Blocks.IRON_ORE.getBlockState().getValidStates());
	
	}

	private final IBlockState blockState;
	private final float genChance;
	private final IBeeGenome beeGenome;
	private final IHiveGen hiveGen;

	MoreBeesHiveDescription(MoreBeesHiveType hiveType, float genChance, BeeSpecies beeTemplate, IHiveGen hiveGen) 
	{
		this.blockState = MoreBeesBlocks.hive.getStateForType(hiveType);
		this.genChance = genChance;
		this.beeGenome = beeTemplate.getGenome();
		this.hiveGen = hiveGen;
	}

	@Override
	public IHiveGen getHiveGen() 
	{
		return hiveGen;
	}

	@Override
	public IBlockState getBlockState() 
	{
		return blockState;
	}

	@Override
	public boolean isGoodBiome(Biome biome) 
	{
		return !BiomeHelper.isBiomeHellish(biome);
	}

	@Override
	public boolean isGoodHumidity(EnumHumidity humidity) 
	{
		
		EnumHumidity idealHumidity = beeGenome.getPrimary().getHumidity();
		EnumTolerance humidityTolerance = beeGenome.getToleranceHumid();
		return AlleleManager.climateHelper.isWithinLimits(humidity, idealHumidity, humidityTolerance);
	}

	@Override
	public boolean isGoodTemperature(EnumTemperature temperature) 
	{
		EnumTemperature idealTemperature = beeGenome.getPrimary().getTemperature();
		EnumTolerance temperatureTolerance = beeGenome.getToleranceTemp();
		return AlleleManager.climateHelper.isWithinLimits(temperature, idealTemperature, temperatureTolerance);
	}

	@Override
	public float getGenChance() 
	{
		return genChance;
	}

	@Override
	public void postGen(World world, Random rand, BlockPos pos) 
	{

	}

	protected static void postGenFlowers(World world, Random rand, BlockPos hivePos, List<IBlockState> flowerStates) 
	{
		int plantedCount = 0;
		for (int i = 0; i < 10; i++) {
			int xOffset = rand.nextInt(8) - 4;
			int zOffset = rand.nextInt(8) - 4;
			BlockPos blockPos = hivePos.add(xOffset, 0, zOffset);
			if ((xOffset == 0 && zOffset == 0) || !world.isBlockLoaded(blockPos)) {
				continue;
			}

			blockPos = groundGen.getPosForHive(world, blockPos.getX(), blockPos.getZ());
			if (blockPos == null) 
			{
				continue;
			}

			IBlockState state = flowerStates.get(rand.nextInt(flowerStates.size()));
			Block block = state.getBlock();
			if (!block.canPlaceBlockAt(world, blockPos)) 
			{
				continue;
			}
		
			world.setBlockState(blockPos, state);
			plantedCount++;
			if (plantedCount >= 5) {
				break;
			}
		}
	}
}
