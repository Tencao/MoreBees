
package lach_01298.moreBees.block;

import javax.annotation.Nonnull;

import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.EnumBeeType;
import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IHiveDrop;
import forestry.api.apiculture.IHiveTile;
import forestry.api.apiculture.hives.IHiveRegistry.HiveType;
import forestry.api.core.Tabs;
import forestry.apiculture.ModuleApiculture;
import forestry.apiculture.tiles.TileHive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import lach_01298.moreBees.MoreBees;
import lach_01298.moreBees.hives.MoreBeesHiveType;
import lach_01298.moreBees.item.ItemModelProvider;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class BlockHive extends BlockContainer implements ItemModelProvider {
	private static final PropertyEnum<MoreBeesHiveType> HIVE_TYPES = PropertyEnum.create("hive", MoreBeesHiveType.class);
	private static String name;

	public BlockHive(String name) {
		super(Material.WOOD);

		BlockHive.name = name;
		setLightLevel(0.4f);
		setHardness(2.5f);
		setCreativeTab(Tabs.tabApiculture);
		setHarvestLevel("scoop", 0);
		setDefaultState(this.blockState.getBaseState().withProperty(HIVE_TYPES, MoreBeesHiveType.ROCK));
		setUnlocalizedName(name);
		setRegistryName(name);

	}

	@Override
	public TileEntity createNewTileEntity(@Nonnull World worldIn, int meta) {
		return new TileHive();
	}

	@Override
	@Nonnull
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, HIVE_TYPES);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(HIVE_TYPES).getMeta();
	}

	@Override
	@Nonnull
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(HIVE_TYPES, MoreBeesHiveType.VALUES[meta]);
	}

	public IBlockState getStateForType(@Nonnull MoreBeesHiveType type) {
		return getDefaultState().withProperty(HIVE_TYPES, type);
	}


	@Override
	public void onBlockClicked(World world, BlockPos pos, EntityPlayer player) {
		super.onBlockClicked(world, pos, player);
		TileEntity tile = world.getTileEntity(pos);
		if (tile instanceof IHiveTile) {
			IHiveTile hive = (IHiveTile) tile;
			hive.onAttack(world, pos, player);
		}
	}

	@Override
	public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		boolean canHarvest = canHarvestBlock(world, pos, player);
		TileEntity tile = world.getTileEntity(pos);
		if (tile instanceof IHiveTile) {
			IHiveTile hive = (IHiveTile) tile;
			hive.onBroken(world, pos, player, canHarvest);
		}
	}

	public String getNameFromMeta(int meta) {
		return HiveType.VALUES[meta].getName();
	}

	@Override
	@Nonnull
	public List<ItemStack> getDrops(@Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull IBlockState state, int fortune) {
		List<ItemStack> drops = new ArrayList<>();

		Random random = world instanceof World ? ((World) world).rand : RANDOM;

		List<IHiveDrop> hiveDrops = getDropsForHive(getMetaFromState(state));
		Collections.shuffle(hiveDrops);

		// Grab a princess
		int tries = 0;
		boolean hasPrincess = false;
		while (tries <= 10 && !hasPrincess) {
			tries++;

			for (IHiveDrop drop : hiveDrops) {
				if (random.nextDouble() < drop.getChance(world, pos, fortune)) {
					IBee bee = drop.getBeeType(world, pos);
					if (random.nextFloat() < drop.getIgnobleChance(world, pos, fortune)) {
						bee.setIsNatural(false);
					}

					ItemStack princess = BeeManager.beeRoot.getMemberStack(bee, EnumBeeType.PRINCESS);
					drops.add(princess);
					hasPrincess = true;
					break;
				}
			}
		}

		// Grab drones
		for (IHiveDrop drop : hiveDrops) {
			if (random.nextDouble() < drop.getChance(world, pos, fortune)) {
				IBee bee = drop.getBeeType(world, pos);
				ItemStack drone = BeeManager.beeRoot.getMemberStack(bee, EnumBeeType.DRONE);
				drops.add(drone);
				break;
			}
		}

		// Grab anything else on offer
		for (IHiveDrop drop : hiveDrops) {
			if (random.nextDouble() < drop.getChance(world, pos, fortune)) {
				drops.addAll(drop.getExtraItems(world, pos, fortune));
				break;
			}
		}

		return drops;
	}

	private static List<IHiveDrop> getDropsForHive(int meta) {
		String hiveName = getHiveNameForMeta(meta);
		if (hiveName.isEmpty()) {
			return Collections.emptyList();
		}
		return ModuleApiculture.getHiveRegistry().getDrops(hiveName);
	}

	private static String getHiveNameForMeta(int meta) {
		return MoreBeesHiveType.VALUES[meta].getHiveUid();
	}

	@Nonnull
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public void registerItemModel(Item itemBlock) {
		MoreBees.proxy.registerItemRenderer(itemBlock, 0, name);

	}


}