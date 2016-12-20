package lach_01298.moreBees;

import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.apiculture.FlowerManager;
import forestry.api.apiculture.IAlleleBeeEffect;
import forestry.api.apiculture.IHiveDrop;
import forestry.api.apiculture.hives.IHiveDescription;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAllele;
import forestry.api.genetics.IAlleleFactory;
import forestry.api.genetics.IAlleleFlowers;
import forestry.api.genetics.IAlleleRegistry;
import forestry.api.genetics.IChromosomeType;
import forestry.api.genetics.IFlowerProvider;
import forestry.api.genetics.IFlowerRegistry;
import forestry.apiculture.PluginApiculture;
import forestry.apiculture.flowers.FlowerProvider;
import forestry.apiculture.flowers.FlowerRegistry;
import forestry.apiculture.genetics.BeeDefinition;
import forestry.apiculture.genetics.HiveDrop;
import forestry.apiculture.genetics.IBeeDefinition;
import forestry.apiculture.genetics.alleles.AlleleEffectPotion;
import forestry.apiculture.items.EnumHoneyComb;
import forestry.apiculture.items.ItemHoneyComb;
import forestry.apiculture.items.ItemRegistryApiculture;
import forestry.apiculture.worldgen.HiveRegistry;
import java.util.List;
import lach_01298.moreBees.Flowers;
import lach_01298.moreBees.Genetics.BeeSpecies;
import lach_01298.moreBees.block.BlockHive;
import lach_01298.moreBees.hives.MoreBeesHiveDescription;
import lach_01298.moreBees.hives.MoreBeesHiveType;
import lach_01298.moreBees.item.BasicItem;
import lach_01298.moreBees.item.MoreBeesItems;
import lach_01298.moreBees.util.LoadMods;
import lach_01298.moreBees.util.OreDicPreferences;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.oredict.OreDictionary;

public class Register
{
	public static final String FlowerOre = "Ore";
	public static final String FlowerDiamond = "Diamond";
	public static final String FlowerEmerald = "Emerald";
	public static final String FlowerRedstone = "Redstone";
	public static final String FlowerUranium = "Uranium";
	public static final String FlowerWater = "Water";
	public static final String FlowerTNT = "TNT";
	public static final String FlowerType = "flowers";
	public static final String FlowerSlime = "Slime";
	public static IAlleleBeeEffect effectWither;
	public static IAlleleBeeEffect effectRadiation;
	public static IAlleleBeeEffect effectSlimey;
	public static IAlleleFlowers FlowerTypeOre;
	public static IAlleleFlowers FlowerTypeDiamond;
	public static IAlleleFlowers FlowerTypeEmerald;
	public static IAlleleFlowers FlowerTypeRedstone;
	public static IAlleleFlowers FlowerTypeUranium;
	public static IAlleleFlowers FlowerTypeWater;
	public static IAlleleFlowers FlowerTypeTNT;
	public static IAlleleFlowers FlowerTypeSlime;
	public static BlockHive beeHive;
	
	private static final String MOD_ID = MoreBees.MOD_ID;

	public static void RegisterFlowers()
	{

		FlowerRegistry flowerRegistry = (FlowerRegistry) FlowerManager.flowerRegistry;
		flowerRegistry.registerAcceptableFlower(Blocks.COAL_ORE, FlowerOre);
		flowerRegistry.registerAcceptableFlower(Blocks.IRON_ORE, FlowerOre);
		flowerRegistry.registerAcceptableFlower(OreDicPreferences.getBlock("oreCopper"), FlowerOre);
		flowerRegistry.registerAcceptableFlower(OreDicPreferences.getBlock("oreTin"), FlowerOre);
		flowerRegistry.registerAcceptableFlower(Blocks.DIAMOND_ORE, FlowerDiamond);
		flowerRegistry.registerAcceptableFlower(Blocks.EMERALD_ORE, FlowerEmerald);
		flowerRegistry.registerAcceptableFlower(Blocks.REDSTONE_ORE, FlowerRedstone);
		flowerRegistry.registerAcceptableFlower(Blocks.WATERLILY, FlowerWater);
		flowerRegistry.registerAcceptableFlower(Blocks.TNT, FlowerTNT);
		flowerRegistry.registerAcceptableFlower(Blocks.SLIME_BLOCK, FlowerSlime);
		if(LoadMods.enableTinkers)
		{
			List<ItemStack> list = OreDictionary.getOres("blockSlime");
			for(ItemStack block : list)
			{
				flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(block.getItem()), FlowerSlime);
			}
		}
		if(LoadMods.enableUranium)
		{
			List<ItemStack> list = OreDictionary.getOres("oreUranium");
			for(ItemStack block : list)
			{
				flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(block.getItem()),FlowerUranium);
			}
		}
		flowerRegistry.registerAcceptableFlower(Blocks.CHORUS_FLOWER, FlowerManager.FlowerTypeEnd);
	}

	public static void RegisterGenes()
	{
		FlowerTypeOre = AlleleManager.alleleFactory.createFlowers(MOD_ID, FlowerType, FlowerOre, Flowers.ORE.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		FlowerTypeDiamond = AlleleManager.alleleFactory.createFlowers(MOD_ID, FlowerType, FlowerDiamond, Flowers.DIAMOND.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		FlowerTypeEmerald = AlleleManager.alleleFactory.createFlowers(MOD_ID, FlowerType, FlowerEmerald, Flowers.EMERALD.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		FlowerTypeRedstone = AlleleManager.alleleFactory.createFlowers(MOD_ID, FlowerType, FlowerRedstone, Flowers.REDSTONE.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		FlowerTypeWater = AlleleManager.alleleFactory.createFlowers(MOD_ID, FlowerType, FlowerWater, Flowers.WATER.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		FlowerTypeTNT = AlleleManager.alleleFactory.createFlowers(MOD_ID, FlowerType, FlowerTNT, Flowers.TNT.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		FlowerTypeUranium = AlleleManager.alleleFactory.createFlowers(MOD_ID, FlowerType, FlowerUranium, Flowers.URANIUM.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		FlowerTypeSlime = AlleleManager.alleleFactory.createFlowers(MOD_ID, FlowerType, FlowerSlime, Flowers.SLIME.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		effectWither = new AlleleEffectPotion("wither", true, MobEffects.WITHER, 400);
		AlleleManager.alleleRegistry.registerAllele(effectWither, EnumBeeChromosome.EFFECT );
		effectRadiation = new AlleleEffectPotion("Radiation", true, MobEffects.HUNGER, 400);
		AlleleManager.alleleRegistry.registerAllele(effectRadiation,  EnumBeeChromosome.EFFECT );
		effectSlimey = new AlleleEffectPotion("Slimey", true, MobEffects.JUMP_BOOST, 400);
		AlleleManager.alleleRegistry.registerAllele(effectSlimey, EnumBeeChromosome.EFFECT );
	}

	public static void RegisterHives()
	{
		PluginApiculture.hiveRegistry.registerHive(MoreBeesHiveType.ROCK.getHiveUid(), MoreBeesHiveDescription.ROCK);
		ItemStack honeyComb = PluginApiculture.items.beeComb.get(EnumHoneyComb.HONEY, 1);
		ItemStack rockComb = new ItemStack(MoreBeesItems.CombRock);
		PluginApiculture.hiveRegistry.addDrops(MoreBeesHiveType.ROCK.getHiveUid(), new IHiveDrop[] {
				new HiveDrop(0.8, BeeSpecies.ROCK, new ItemStack[] { rockComb }).setIgnobleShare(0.7),
				new HiveDrop(0.03, BeeDefinition.VALIANT, new ItemStack[] { honeyComb }) });
	}
}