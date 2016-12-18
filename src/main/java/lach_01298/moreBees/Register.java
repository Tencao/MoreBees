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

	public static void RegisterFlowers()
	{

		FlowerRegistry flowerRegistry = (FlowerRegistry) FlowerManager.flowerRegistry;
		flowerRegistry.registerAcceptableFlower(Blocks.COAL_ORE, new String[] { "Ore" });
		flowerRegistry.registerAcceptableFlower(Blocks.IRON_ORE, new String[] { "Ore" });
		flowerRegistry.registerAcceptableFlower(OreDicPreferences.getBlock((String) "oreCopper"), new String[] { "Ore" });
		flowerRegistry.registerAcceptableFlower(OreDicPreferences.getBlock((String) "oreTin"), new String[] { "Ore" });
		flowerRegistry.registerAcceptableFlower(Blocks.DIAMOND_ORE, new String[] { "Diamond" });
		flowerRegistry.registerAcceptableFlower(Blocks.EMERALD_ORE, new String[] { "Emerald" });
		flowerRegistry.registerAcceptableFlower(Blocks.REDSTONE_ORE, new String[] { "Redstone" });
		flowerRegistry.registerAcceptableFlower(Blocks.WATERLILY, new String[] { "Water" });
		flowerRegistry.registerAcceptableFlower(Blocks.TNT, new String[] { "TNT" });
		flowerRegistry.registerAcceptableFlower(Blocks.SLIME_BLOCK, new String[] { "Slime" });
		if(LoadMods.enableTinkers)
		{
			List<ItemStack> list = OreDictionary.getOres((String) "blockSlime");
			for(ItemStack block : list)
			{
				flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem((Item) block.getItem()), new String[] { "Slime" });
			}
		}
		if(LoadMods.enableUranium)
		{
			List<ItemStack> list = OreDictionary.getOres((String) "oreUranium");
			for(ItemStack block : list)
			{
				flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem((Item) block.getItem()), new String[] { "Uranium" });
			}
		}
		flowerRegistry.registerAcceptableFlower(Blocks.CHORUS_FLOWER, new String[] { "flowersEnd" });
	}

	public static void RegisterGenes()
	{
		FlowerTypeOre = AlleleManager.alleleFactory.createFlowers("morebees", "flowers", "Ore", (IFlowerProvider) Flowers.ORE.getValue(), true, new IChromosomeType[] { EnumBeeChromosome.FLOWER_PROVIDER });
		FlowerTypeDiamond = AlleleManager.alleleFactory.createFlowers("morebees", "flowers", "Diamond", (IFlowerProvider) Flowers.DIAMOND.getValue(), true, new IChromosomeType[] { EnumBeeChromosome.FLOWER_PROVIDER });
		FlowerTypeEmerald = AlleleManager.alleleFactory.createFlowers("morebees", "flowers", "Emerald", (IFlowerProvider) Flowers.EMERALD.getValue(), true, new IChromosomeType[] { EnumBeeChromosome.FLOWER_PROVIDER });
		FlowerTypeRedstone = AlleleManager.alleleFactory.createFlowers("morebees", "flowers", "Redstone", (IFlowerProvider) Flowers.REDSTONE.getValue(), true, new IChromosomeType[] { EnumBeeChromosome.FLOWER_PROVIDER });
		FlowerTypeWater = AlleleManager.alleleFactory.createFlowers("morebees", "flowers", "Water", (IFlowerProvider) Flowers.WATER.getValue(), true, new IChromosomeType[] { EnumBeeChromosome.FLOWER_PROVIDER });
		FlowerTypeTNT = AlleleManager.alleleFactory.createFlowers("morebees", "flowers", "TNT", (IFlowerProvider) Flowers.TNT.getValue(), true, new IChromosomeType[] { EnumBeeChromosome.FLOWER_PROVIDER });
		FlowerTypeUranium = AlleleManager.alleleFactory.createFlowers("morebees", "flowers", "Uranium", (IFlowerProvider) Flowers.URANIUM.getValue(), true, new IChromosomeType[] { EnumBeeChromosome.FLOWER_PROVIDER });
		FlowerTypeSlime = AlleleManager.alleleFactory.createFlowers("morebees", "flowers", "Slime", (IFlowerProvider) Flowers.SLIME.getValue(), true, new IChromosomeType[] { EnumBeeChromosome.FLOWER_PROVIDER });
		effectWither = new AlleleEffectPotion("wither", true, MobEffects.WITHER, 400);
		AlleleManager.alleleRegistry.registerAllele((IAllele) effectWither, new IChromosomeType[] { EnumBeeChromosome.EFFECT });
		effectRadiation = new AlleleEffectPotion("Radiation", true, MobEffects.HUNGER, 400);
		AlleleManager.alleleRegistry.registerAllele((IAllele) effectRadiation, new IChromosomeType[] { EnumBeeChromosome.EFFECT });
		effectSlimey = new AlleleEffectPotion("Slimey", true, MobEffects.JUMP_BOOST, 400);
		AlleleManager.alleleRegistry.registerAllele((IAllele) effectSlimey, new IChromosomeType[] { EnumBeeChromosome.EFFECT });
	}

	public static void RegisterHives()
	{
		PluginApiculture.hiveRegistry.registerHive(MoreBeesHiveType.ROCK.getHiveUid(), (IHiveDescription) MoreBeesHiveDescription.ROCK);
		ItemStack honeyComb = PluginApiculture.items.beeComb.get(EnumHoneyComb.HONEY, 1);
		ItemStack rockComb = new ItemStack((Item) MoreBeesItems.CombRock);
		PluginApiculture.hiveRegistry.addDrops(MoreBeesHiveType.ROCK.getHiveUid(), new IHiveDrop[] {
				new HiveDrop(0.8, (IBeeDefinition) BeeSpecies.ROCK, new ItemStack[] { rockComb }).setIgnobleShare(0.7),
				new HiveDrop(0.03, (IBeeDefinition) BeeDefinition.VALIANT, new ItemStack[] { honeyComb }) });
	}
}