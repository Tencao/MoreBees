package lach_01298.moreBees.genetics;

import forestry.api.apiculture.IAlleleBeeSpecies;
import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.apiculture.IJubilanceProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class WitherSkullJubilance implements IJubilanceProvider {

	@Override
	public boolean isJubilant(@Nonnull IAlleleBeeSpecies species, @Nonnull IBeeGenome genome, @Nonnull IBeeHousing housing) {
		World world = housing.getWorldObj();
		BlockPos pos = housing.getCoordinates();

		TileEntity tile;
		do {
			pos = pos.up();
			tile = world.getTileEntity(pos);
		} while (tile instanceof IBeeHousing && pos.getY() > 0);

        return (tile instanceof TileEntitySkull && ((TileEntitySkull) tile).getSkullType() == 1);
	}

}