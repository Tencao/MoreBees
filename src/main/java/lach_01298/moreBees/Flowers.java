package lach_01298.moreBees;

import java.util.Locale;

import forestry.api.apiculture.FlowerManager;
import forestry.apiculture.flowers.FlowerProvider;
import forestry.core.genetics.alleles.IAlleleValue;

public enum Flowers implements IAlleleValue<FlowerProvider> 
{
	ORE(Register.FlowerOre, true),
	DIAMOND(Register.FlowerDiamond,true),
	EMERALD(Register.FlowerEmerald,true),
	REDSTONE(Register.FlowerRedstone,true),
	URANIUM(Register.FlowerUranium,true),
	WATER(Register.FlowerWater),
	TNT(Register.FlowerTNT, true),
	SLIME(Register.FlowerSlime,true);

	private final FlowerProvider value;
	private final boolean dominant;

	Flowers(String flowerType) 
	{
		this(flowerType, false);
	}

	Flowers(String flowerType, boolean dominant) 
	{
		String lowercaseName = toString().toLowerCase(Locale.ENGLISH);
		this.value = new FlowerProvider(flowerType, "for.flowers." + lowercaseName);
		this.dominant = dominant;
	}


	@Override
	public FlowerProvider getValue() 
	{
		
		return value;
	}

	@Override
	public boolean isDominant() 
	{
		
		return dominant;
	}
}