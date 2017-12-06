package lach_01298.moreBees.genetics;

import java.awt.Color;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

import com.google.common.base.Preconditions;
import forestry.apiculture.ModuleApiculture;
import forestry.core.ModuleCore;
import lach_01298.moreBees.MoreBees;
import lach_01298.moreBees.Register;
import lach_01298.moreBees.item.MoreBeesItems;
import lach_01298.moreBees.util.*;

import net.minecraft.item.Item;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary;
import forestry.api.apiculture.*;
import forestry.api.core.EnumHumidity;
import forestry.api.core.EnumTemperature;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAllele;
import forestry.apiculture.genetics.*;
import forestry.apiculture.genetics.alleles.AlleleEffects;
import forestry.apiculture.items.EnumHoneyComb;
import forestry.core.genetics.IBranchDefinition;
import forestry.core.genetics.alleles.AlleleHelper;
import forestry.core.genetics.alleles.EnumAllele;

import javax.annotation.Nonnull;

public enum BeeSpecies implements IBeeDefinition
{

	// Rock Branch
	ROCK(BeeBranches.ROCK, "Rock", true, new Color(0x6d6d6d), new Color(0xffdc16))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f)
			          .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{

			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeOre);
		}

		@Override
		protected void registerMutations()
		{
			// found in hives
		}
	},
	HARDENED(BeeBranches.ROCK, "Hardened", true, new Color(0x464646), new Color(0xffdc16))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.35f)
			          .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
		}

		@Override
		protected void registerMutations()
		{
			registerMutation(RockBee, CultivatedBee, getTemplate(), MathUtil.maxInt((int)(10*Config.mutationMultipler),100));

		}
	},
	OBSIDIAN(BeeBranches.ROCK, "Obsidian", false, new Color(0x241e31), new Color(0xffdc16))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.40f)
			          .addProduct(new ItemStack(Blocks.OBSIDIAN), 0.1f)
			          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);

		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(HardenedBee, SteadfastBee, getTemplate(), MathUtil.maxInt((int)(10*Config.mutationMultipler),100));

		}

	},
	LAPIS(BeeBranches.ROCK, "Lapis", false, new Color(0x22479c), new Color(0xffdc16))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f)
			          .addProduct(new ItemStack(Items.DYE, 1, 4), 0.1f)
			          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);

		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);

		}

		@Override
		protected void registerMutations()
		{

			registerMutation(ObsidianBee, ImperialBee, getTemplate(), MathUtil.maxInt((int)(8*Config.mutationMultipler),100));

		}
	},
	// Earth Branch
	DIRT(BeeBranches.EARTH, "Dirt", true, new Color(0x79553a), new Color(0xffdc16))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombDirt), 0.40f)
			          .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.FAST);
		}

		@Override
		protected void registerMutations()
		{
			for (IAlleleBeeSpecies hiveBee : hiveBees) {
				registerMutation(RockBee, hiveBee, getTemplate(), MathUtil.maxInt((int) (15 * Config.mutationMultipler), 100));
			}

		}
	},
	CLAY(BeeBranches.EARTH, "Clay", true, new Color(0xa7abbb), new Color(0xffdc16))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{

			beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombDirt), 0.30f)
			          .addProduct(new ItemStack(Items.CLAY_BALL), 1.0f)
			          .addProduct(new ItemStack(Items.CLAY_BALL), 0.5f)
			          .addProduct(new ItemStack(Items.CLAY_BALL), 0.5f)
			          .addProduct(new ItemStack(Items.CLAY_BALL), 0.5f)
			          .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.DAMP);
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.FAST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TOLERATES_RAIN, true);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(DirtBee, hiveBees[1], getTemplate(), MathUtil.maxInt((int)(15*Config.mutationMultipler),100));

		}
	},
	REDSAND(BeeBranches.EARTH, "RedSand", false, new Color(0xa75620), new Color(0xffdc16))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombDirt), 0.30f)
			          .addProduct(new ItemStack(Blocks.SAND), 0.40f)
			          .addProduct(new ItemStack(Blocks.SAND, 1, 1), 0.70f)
			          .addProduct(new ItemStack(Blocks.SAND, 2, 1), 0.30f)
			          .addProduct(new ItemStack(Blocks.SAND, 1, 1), 0.20f)
			          .setTemperature(EnumTemperature.HOT).setHumidity(EnumHumidity.ARID);
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.FAST);

		}

		@Override
		protected void registerMutations()
		{

			registerMutation(DirtBee, hiveBees[3], getTemplate(), MathUtil.maxInt((int)(15*Config.mutationMultipler),100));

		}
	},
	// Crystal branch
	QUARTZ(BeeBranches.CRYSTAL, "Quartz", false, new Color(0xf4f6f6), new Color(0xffdc16))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombCrystal), 0.30f)
			          .addProduct(new ItemStack(Items.QUARTZ), 0.20f)
			          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);

		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeRedstone);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(LapisBee, SinisterBee, getTemplate(), MathUtil.maxInt((int)(10*Config.mutationMultipler),100));

		}
	},
	CERTUS(BeeBranches.CRYSTAL, "Certus", false, new Color(0xf6feff), new Color(0xffdc16))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if (LoadMods.enableCertusQuartz) {
				beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombCrystal), 0.30f)
						  .addProduct(OreDicPreferences.get("dustCertusQuartz", 1), 0.20f)
						  .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
		    }

		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeRedstone);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(QuartzBee, IndustriousBee, getTemplate(), MathUtil.maxInt((int)(10*Config.mutationMultipler),100));

		}
	},
	REDSTONE(BeeBranches.CRYSTAL, "Redstone", false, new Color(0xaa0404), new Color(0xffdc16))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombCrystal), 0.30f)
			          .addProduct(new ItemStack(Items.REDSTONE), 0.20f)
			          .addProduct(new ItemStack(Items.REDSTONE), 0.15f)
			          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);

		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeRedstone);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(ObsidianBee, SteadfastBee, getTemplate(), MathUtil.maxInt((int)(8*Config.mutationMultipler),100));

		}
	},
	EMERALD(BeeBranches.CRYSTAL, "Emerald", false, new Color(0x4adc73), new Color(0xffdc16))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombCrystal), 0.30f)
			          .addSpecialty(new ItemStack(MoreBeesItems.EmeraldFrag), 0.15f)
			          .setJubilanceProvider(BeeManager.jubilanceFactory.getRequiresResource(Blocks.EMERALD_BLOCK.getDefaultState(),Blocks.EMERALD_ORE.getDefaultState()))
			          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);

		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeEmerald);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(RedstoneBee, ImperialBee, getTemplate(), MathUtil.maxInt((int)(5*Config.mutationMultipler),100));

		}
	},
	DIAMOND(BeeBranches.CRYSTAL, "Diamond", false, new Color(0x5decf5), new Color(0xffdc16))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombCrystal), 0.30f)
			          .addSpecialty(new ItemStack(MoreBeesItems.DiamondFrag), 0.15f)
			          .setJubilanceProvider(BeeManager.jubilanceFactory.getRequiresResource(Blocks.DIAMOND_BLOCK.getDefaultState(),Blocks.DIAMOND_ORE.getDefaultState()))
			          .setHasEffect()
			          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);

		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeDiamond);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(EmeraldBee, QuartzBee, getTemplate(), MathUtil.maxInt((int)(2*Config.mutationMultipler),100));

		}
	},
	RUBY(BeeBranches.CRYSTAL, "Ruby", false, new Color(0xff0000), new Color(0xffdc16))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if(LoadMods.enableRuby)
			{
				beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombCrystal), 0.30f)
				          .addProduct(OreDicPreferences.get("gemRuby", 1), 0.10f)
				          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
			}
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(RedstoneBee, ImperialBee, getTemplate(), MathUtil.maxInt((int)(7*Config.mutationMultipler),100));

		}
	},
	SAPPHIRE(BeeBranches.CRYSTAL, "Sapphire", false, new Color(0x0058f8), new Color(0xffdc16))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if(LoadMods.enableSapphire)
			{
				beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombCrystal), 0.30f)
				          .addProduct(OreDicPreferences.get("gemSapphire", 1), 0.10f)
				          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
			}
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(LapisBee, ImperialBee, getTemplate(), MathUtil.maxInt((int)(7*Config.mutationMultipler),100));

		}
	},
	SULFUR(BeeBranches.CRYSTAL, "Sulfur", false, new Color(0xE9F800), new Color(0xffdc16))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if(LoadMods.enableSulfur)
			{
				 beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.SIMMERING, 1), 0.3f)
				           .addProduct(OreDicPreferences.get("dustSulfur", 1), 0.15f)
				           .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
			}
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(RedstoneBee, FiendishBee, getTemplate(), MathUtil.maxInt((int)(15*Config.mutationMultipler),100));

		}
	},
	APATITE(BeeBranches.CRYSTAL, "Apatite", false, new Color(0x4baef1), new Color(0xffdc16))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{

		        beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombCrystal),0.3f)
		                  .addProduct(new ItemStack(ModuleCore.getItems().apatite),0.1f)
		                  .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(RedstoneBee, LapisBee, getTemplate(), MathUtil.maxInt((int)(10*Config.mutationMultipler),100));

		}
	},

	// Metal Branch
	METALLIC(BeeBranches.METAL, "Metallic", true, new Color(0x999999), new Color(0x999999))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombMetallic), 0.25f)
			          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);

		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER);

		}

		@Override
		protected void registerMutations()
		{

			registerMutation(ObsidianBee, FiendishBee, getTemplate(), MathUtil.maxInt((int)(10*Config.mutationMultipler),100));

		}
	},
	IRON(BeeBranches.METAL, "Iron", false, new Color(0xd9d9d9), new Color(0x999999))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombMetallic), 0.30f)
			          .addProduct(OreDicPreferences.get("dustIron", 1), 0.15f)
			          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);

		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(MetallicBee, IndustriousBee, getTemplate(), MathUtil.maxInt((int)(10*Config.mutationMultipler),100));

		}
	},
	COPPER(BeeBranches.METAL, "Copper", false, new Color(0xa76430), new Color(0x999999))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombMetallic), 0.30f)
			          .addProduct(OreDicPreferences.get("dustCopper", 1), 0.15f)
			          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(MetallicBee, IndustriousBee, getTemplate(), MathUtil.maxInt((int)(10*Config.mutationMultipler),100));

		}
	},
	TIN(BeeBranches.METAL, "Tin", false, new Color(0xe8e8e8), new Color(0x999999))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombMetallic), 0.30f)
			          .addProduct(OreDicPreferences.get("dustTin", 1), 0.15f)
			          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(MetallicBee, IndustriousBee, getTemplate(), MathUtil.maxInt((int)(10*Config.mutationMultipler),100));

		}
	},
	ALUMINIUM(BeeBranches.METAL, "Aluminium", false, new Color(0xF6F6F6), new Color(0x999999))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if(LoadMods.enableAluminium)
			{
				beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombMetallic), 0.30f)
				          .addProduct(OreDicPreferences.get("dustAluminum", 1), 0.15f)
				          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
			}
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(MetallicBee, IndustriousBee, getTemplate(), MathUtil.maxInt((int)(10*Config.mutationMultipler),100));

		}
	},
	GOLD(BeeBranches.METAL, "Gold", false, new Color(0xeed83d), new Color(0x999999))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombMetallic), 0.30f)
			          .addProduct(OreDicPreferences.get("dustGold", 1), 0.10f)
			          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);

		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(MetallicBee, ImperialBee, getTemplate(), MathUtil.maxInt((int)(8*Config.mutationMultipler),100));

		}
	},
	SILVER(BeeBranches.METAL, "Silver", false, new Color(0xf4f6f6), new Color(0x999999))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if(LoadMods.enableSilver)
			{
				beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombMetallic), 0.30f)
				          .addProduct(OreDicPreferences.get("dustSilver", 1), 0.12f)
				          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
			}
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(GoldBee, TinBee, getTemplate(), MathUtil.maxInt((int)(8*Config.mutationMultipler),100));

		}
	},
	LEAD(BeeBranches.METAL, "Lead", false, new Color(0xd5d9b9), new Color(0x999999))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if(LoadMods.enableLead)
			{
				beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombMetallic), 0.30f)
				          .addProduct(OreDicPreferences.get("dustLead", 1), 0.15f)
				          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
			}
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(MetallicBee, ObsidianBee, getTemplate(), MathUtil.maxInt((int)(8*Config.mutationMultipler),100));

		}
	},
	COBALT(BeeBranches.METAL, "Cobalt", false, new Color(0x1d62b8), new Color(0x999999))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if(LoadMods.enableTinkers)
			{
				beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombMetallic), 0.30f)
				          .addProduct(OreDicPreferences.get("nuggetCobalt", 1), 0.15f)
				          .setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID);
			}
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(DemonicBee, TinBee, getTemplate(), MathUtil.maxInt((int)(8*Config.mutationMultipler),100));

		}
	},
	ARDITE(BeeBranches.METAL, "Ardite", false, new Color(0xa82517), new Color(0x999999))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if(LoadMods.enableTinkers)
			{
				beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombMetallic), 0.30f)
				          .addProduct(OreDicPreferences.get("nuggetArdite", 1), 0.15f)
				          .setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID);
			}
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(DemonicBee, CopperBee, getTemplate(), MathUtil.maxInt((int)(8*Config.mutationMultipler),100));

		}
	},
	OSMIUM(BeeBranches.METAL, "Osmium", false, new Color(0x95a5b4), new Color(0x999999))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if(LoadMods.enableOsmium)
			{
				beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombMetallic), 0.30f)
				          .addProduct(OreDicPreferences.get("dustOsmium", 1), 0.15f)
				          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
			}
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(CopperBee, IndustriousBee, getTemplate(), MathUtil.maxInt((int)(10*Config.mutationMultipler),100));

		}
	},
	NICKEL(BeeBranches.METAL, "Nickel", false, new Color(0xa3a998), new Color(0x999999))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if(LoadMods.enableNickel)
			{
				beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombMetallic), 0.30f)
				          .addProduct(OreDicPreferences.get("dustNickel", 1), 0.15f)
				          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
			}
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(IronBee, IndustriousBee, getTemplate(), MathUtil.maxInt((int)(8*Config.mutationMultipler),100));

		}
	},
	PLATINUM(BeeBranches.METAL, "Platinum", false, new Color(0x6fe5f3), new Color(0x999999))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if(LoadMods.enablePlatinum)
			{
				beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombMetallic), 0.30f)
				          .addProduct(OreDicPreferences.get("dustPlatinum", 1), 0.10f)
				          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
			}
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(ImperialBee, GoldBee, getTemplate(), MathUtil.maxInt((int)(5*Config.mutationMultipler),100));

		}
	},
	IRIDIUM(BeeBranches.METAL, "Iridium", false, new Color(0xe4e2eb), new Color(0x999999))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if(LoadMods.enableIridium)
			{
				beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombMetallic), 0.30f)
				          .addProduct(OreDicPreferences.get("dustIridium", 1), 0.05f)
				          .setTemperature(EnumTemperature.HOT).setHumidity(EnumHumidity.ARID);
			}
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(ApocalypticBee, GoldBee, getTemplate(), MathUtil.maxInt((int)(4*Config.mutationMultipler),100));

		}
	},
	// RadioActive branch
	RADIOACTIVE(BeeBranches.RADIOACTIVE, "Radioactive", true, new Color(0x3e720c), new Color(0x999999))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.SIMMERING, 1), 0.30f)
					  .setTemperature(EnumTemperature.HOT).setHumidity(EnumHumidity.NORMAL);
			if(LoadMods.enableUranium && !LoadMods.enableIC2Classic)
			{
			    beeSpecies.addProduct(OreDicPreferences.get("oreUranium", 1), 0.05f);
			}
			else if(LoadMods.enableIC2Classic)
			{
				beeSpecies.addProduct(OreDicPreferences.get("dropUranium", 1), 0.05f);

			}
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeUranium);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true);

		}

		@Override
		protected void registerMutations()
		{

			registerMutation(LeadBee, AustereBee, getTemplate(), MathUtil.maxInt((int)(8*Config.mutationMultipler),100));

		}
	},
	RESONATING(BeeBranches.RADIOACTIVE, "Resonating", true, new Color(0xff6565), new Color(0x999999))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if(LoadMods.enableResonating)
			{
				beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.SIMMERING, 1), 0.30f)
				          .addProduct(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("deepresonance:resonating_ore")), 1), 0.05f)
				          .setTemperature(EnumTemperature.HOT).setHumidity(EnumHumidity.NORMAL);
			}

		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeUranium);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true);

		}

		@Override
		protected void registerMutations()
		{

			registerMutation(RadioactiveBee, RedstoneBee, getTemplate(), MathUtil.maxInt((int)(8*Config.mutationMultipler),100));

		}
	},
	YELLORITE(BeeBranches.RADIOACTIVE, "Yellorite", true, new Color(0xd7ef00), new Color(0x999999))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if(LoadMods.enableYellorite)
			{
				beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.SIMMERING, 1), 0.30f)
				          .addProduct(OreDicPreferences.get("oreYellorite", 1), 0.05f)
				          .setTemperature(EnumTemperature.HOT).setHumidity(EnumHumidity.NORMAL);
			}

		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeUranium);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true);

		}

		@Override
		protected void registerMutations()
		{

			registerMutation(RadioactiveBee, RedstoneBee, getTemplate(), MathUtil.maxInt((int)(8*Config.mutationMultipler),100));

		}
	},
	URANIUM(BeeBranches.RADIOACTIVE, "Uranium", false, new Color(0x6ac013), new Color(0x999999))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if(LoadMods.enableIC2 && !LoadMods.enableIC2Classic)
			{
				beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.SIMMERING, 1), 0.30f)
				          .addProduct(OreDicPreferences.get("crushedUranium", 1), 0.15f)
				          .setHasEffect()
				          .setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID);
			}
			else if(LoadMods.enableIC2Classic)
			{
				beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f)
				          .addProduct(OreDicPreferences.get("dropUranium", 1), 0.15f)
				          .setHasEffect()
				          .setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID);

			}
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);

		}

		@Override
		protected void registerMutations()
		{

			registerMutation(RadioactiveBee, ApocalypticBee, getTemplate(), MathUtil.maxInt((int)(5*Config.mutationMultipler),100)).restrictBiomeType(BiomeDictionary.Type.NETHER);

		}
	},
	// Aquatic branch
	PRISMARINE(BeeBranches.AQUATIC, "Prismarine", true, new Color(0x63ab9d), new Color(0xffdc16))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.HONEY, 1), 0.30f)
			          .addProduct(new ItemStack(Items.PRISMARINE_CRYSTALS, 2), 0.2f)
			          .addProduct(new ItemStack(Items.PRISMARINE_SHARD, 2), 0.2f)
			          .setHasEffect()
			          .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.DAMP);

		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeWater);
		}

		@Override
		protected void registerMutations()
		{
			registerMutation(ObsidianBee, ClayBee, getTemplate(), MathUtil.maxInt((int)(15*Config.mutationMultipler),100)).restrictBiomeType(BiomeDictionary.Type.OCEAN);
		}
	},
	// Apocalyptic branch
	APOCALYPTIC(BeeBranches.APOCALYTIC, "Apocalyptic", true, new Color(0xcb7204), new Color(0x830d0d))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.SIMMERING, 1), 0.30f)
			          .addSpecialty(new ItemStack(Items.BLAZE_POWDER), 0.2f)
			          .addSpecialty(new ItemStack(Items.GUNPOWDER), 0.2f)
			          .addSpecialty(new ItemStack(Items.GHAST_TEAR), 0.05f)
			          .setJubilanceProvider(BeeManager.jubilanceFactory.getRequiresResource(Blocks.TNT.getDefaultState()))
			          .setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID);
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_3);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectIgnition);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectCreeper);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeTNT);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(AustereBee, DemonicBee, getTemplate(), MathUtil.maxInt((int)(5*Config.mutationMultipler),100)).restrictBiomeType(BiomeDictionary.Type.NETHER);

		}
	},
	// Wither Branch
	WITHER(BeeBranches.WITHER, "Withering", false, new Color(0xc1c1c1), new Color(0x3c3c3c))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombWither), 0.30f)
			          .addSpecialty(new ItemStack(Items.SKULL, 1, 1), 0.05f)
			          .setJubilanceProvider(new WitherSkullJubilance())
			          .setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID);

		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_3);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(ApocalypticBee, DemonicBee, getTemplate(), MathUtil.maxInt((int)(5*Config.mutationMultipler),100)).restrictBiomeType(BiomeDictionary.Type.NETHER);

		}
	},
	NETHERSTAR(BeeBranches.WITHER, "Wither", false, new Color(0xc1c1c1), new Color(0x3c3c3c))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombWither), 0.35f)
			          .addSpecialty(new ItemStack(MoreBeesItems.NetherFrag), 0.03f)
			          .setJubilanceProvider(new WitherSkullJubilance())
			          .setHasEffect()
			          .setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID);
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_3);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
		}

		@Override
		protected void registerMutations()
		{
			registerMutation(WitherBee, EnderBee, getTemplate(), MathUtil.maxInt((int)(2*Config.mutationMultipler),100)).restrictBiomeType(BiomeDictionary.Type.NETHER);
		}
	},
	// Slime Branch
	SLIMY(BeeBranches.Slime, "Slimy", true, new Color(0x7dc873), new Color(0x7dc873))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombSlime), 0.70f)
			          .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.DAMP);
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{

			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeSlime);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, false);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.AVERAGE);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, Register.effectSlimy);

		}

		@Override
		protected void registerMutations()
		{
			registerMutation(RockBee, BoggyBee, getTemplate(), MathUtil.maxInt((int)(30*Config.mutationMultipler),100));
		}
	},
	BLUESLIMY(BeeBranches.Slime, "BlueSlimy", true, new Color(0x7dc873), new Color(0x74c8c7))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if(LoadMods.enableTinkers)
			{
				beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombSlime), 0.55f)
				          .addProduct(OreDicPreferences.get("slimeballBlue", 1), 0.55f)
				          .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.DAMP);
			}
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{

			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
		}

		@Override
		protected void registerMutations()
		{
			registerMutation(SlimyBee, PrismarineBee, getTemplate(), MathUtil.maxInt((int)(30*Config.mutationMultipler),100));
		}
	},
	PURPLESLIMY(BeeBranches.Slime, "PurpleSlimy", false, new Color(0x7dc873), new Color(0xbb5aff))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if(LoadMods.enableTinkers)
			{
				beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombSlime), 0.55f)
				          .addProduct(OreDicPreferences.get("slimeballPurple", 1), 0.55f)
				          .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.DAMP);
			}
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{

			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
		}

		@Override
		protected void registerMutations()
		{
			System.out.println(BlueSlimyBee);
			registerMutation(BlueSlimyBee, RedstoneBee, getTemplate(), MathUtil.maxInt((int)(8*Config.mutationMultipler),100));
		}
	},
	MAGMASLIMY(BeeBranches.Slime, "MagmaSlimy", false, new Color(0x7dc873), new Color(0xffab49))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if(LoadMods.enableTinkers)
			{
				beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombSlime), 0.55f)
				          .addProduct(OreDicPreferences.get("slimeballMagma", 1), 0.55f)
				          .setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID);
			}
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{

			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
		}

		@Override
		protected void registerMutations()
		{
			registerMutation(SlimyBee, FiendishBee, getTemplate(), MathUtil.maxInt((int)(10*Config.mutationMultipler),100));
		}
	},
	//forestry branches
	STRINGY(BeeBranchDefinition.TROPICAL, "Stringy", false, new Color(0x6d6d6d), new Color(0xe5e5e5))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.SILKY,1), 0.30f)
			          .addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.STRINGY,1), 0.30f)
			          .addProduct(new ItemStack(Items.STRING,1), 0.70f)
			          .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.DAMP);
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, false);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);

		}

		@Override
		protected void registerMutations()
		{
			registerMutation(TropicalBee, DiligentBee, getTemplate(), MathUtil.maxInt((int)(10*Config.mutationMultipler),100));
		}
	},
	DRACONIC(BeeBranchDefinition.END, "Draconic", true, new Color(0x4c0e80), new Color(0x830d0d))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			if (LoadMods.enableDraconium)
			{
				beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.MYSTERIOUS, 1), 0.30f)
				          .addProduct(OreDicPreferences.get("dustDraconium", 1), 0.15f)
				          .setTemperature(EnumTemperature.COLD).setHumidity(EnumHumidity.ARID);
			}
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
		}

		@Override
		protected void registerMutations()
		{

			registerMutation(AustereBee, EnderBee, getTemplate(), MathUtil.maxInt((int)(5*Config.mutationMultipler),100)).restrictBiomeType(BiomeDictionary.Type.NETHER);

		}
	};


	// forestry bees
	private static final IAlleleBeeSpecies[] hiveBees = {
			(IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesForest"),
			(IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesMarshy"),
			(IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesMeadows"),
			(IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesModest"),
			(IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesTropical"),
			(IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesWintry") };
	private static final IAlleleBeeSpecies SteadfastBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesSteadfast");
	private static final IAlleleBeeSpecies CultivatedBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesCultivated");
	private static final IAlleleBeeSpecies SinisterBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesSinister");
	private static final IAlleleBeeSpecies FiendishBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesFiendish");
	private static final IAlleleBeeSpecies IndustriousBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesIndustrious");
	private static final IAlleleBeeSpecies ImperialBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesImperial");
	private static final IAlleleBeeSpecies AustereBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesAustere");
	private static final IAlleleBeeSpecies DemonicBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesDemonic");
	private static final IAlleleBeeSpecies EnderBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesEnded");
	private static final IAlleleBeeSpecies BoggyBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesBoggy");
	private static final IAlleleBeeSpecies DiligentBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesDiligent");
	private static final IAlleleBeeSpecies TropicalBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesTropical");

	// moreBees Bees that have daughters
	private static final IAlleleBeeSpecies RockBee = BeeSpecies.ROCK.species;
	private static final IAlleleBeeSpecies HardenedBee = BeeSpecies.HARDENED.species;
	private static final IAlleleBeeSpecies ObsidianBee = BeeSpecies.OBSIDIAN.species;
	private static final IAlleleBeeSpecies LapisBee = BeeSpecies.LAPIS.species;
	private static final IAlleleBeeSpecies QuartzBee = BeeSpecies.QUARTZ.species;
	private static final IAlleleBeeSpecies RedstoneBee = BeeSpecies.REDSTONE.species;
	private static final IAlleleBeeSpecies EmeraldBee = BeeSpecies.EMERALD.species;
	private static final IAlleleBeeSpecies DirtBee = BeeSpecies.DIRT.species;
	private static final IAlleleBeeSpecies ClayBee = BeeSpecies.CLAY.species;
	private static final IAlleleBeeSpecies MetallicBee = BeeSpecies.METALLIC.species;
	private static final IAlleleBeeSpecies LeadBee = BeeSpecies.LEAD.species;
	private static final IAlleleBeeSpecies GoldBee = BeeSpecies.GOLD.species;
	private static final IAlleleBeeSpecies TinBee = BeeSpecies.TIN.species;
	private static final IAlleleBeeSpecies RadioactiveBee = BeeSpecies.RADIOACTIVE.species;
	private static final IAlleleBeeSpecies ApocalypticBee = BeeSpecies.APOCALYPTIC.species;
	private static final IAlleleBeeSpecies WitherBee = BeeSpecies.WITHER.species;
	private static final IAlleleBeeSpecies SlimyBee = BeeSpecies.SLIMY.species;
	private static final IAlleleBeeSpecies BlueSlimyBee = BeeSpecies.BLUESLIMY.species;
	private static final IAlleleBeeSpecies PrismarineBee = BeeSpecies.PRISMARINE.species;
	private static final IAlleleBeeSpecies CopperBee = BeeSpecies.COPPER.species;
	private static final IAlleleBeeSpecies IronBee = BeeSpecies.IRON.species;

	private final IBranchDefinition branch;
	private final IAlleleBeeSpecies species;

	private IAllele[] template;
	private IBeeGenome genome;

	BeeSpecies(IBranchDefinition branch, String binomial, boolean dominant, Color primary, Color secondary)
	{
		String species = toString().toLowerCase(Locale.ENGLISH);
		String modId = MoreBees.MOD_ID;
		String uid = modId + ".species." + species;

		String description = modId + ".description." + species;
		String name = "for.bees.species." + species;

		this.branch = branch;
		if (branch != null){
			IAlleleBeeSpeciesBuilder speciesBuilder = BeeManager.beeFactory.createSpecies(modId, uid, dominant, "Lach_01298", name, description, branch.getBranch(), binomial, primary.getRGB(), secondary.getRGB());
			if(isSecret())
			{
				speciesBuilder.setIsSecret();
			}
			setSpeciesProperties(speciesBuilder);
			this.species = speciesBuilder.build();
		}
		else
			this.species = null;

	}

	protected abstract void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies);

	protected abstract void setAlleles(IAllele[] template);

	protected abstract void registerMutations();

	protected boolean isSecret()
	{
		return false;
	}

	protected boolean isNeedRegister() {
		return branch != null;
	}

	public static void initBees()
	{
		for (BeeSpecies bee : values())
			if (bee.isNeedRegister())
				bee.init();

		for (BeeSpecies bee : values())
			if (bee.isNeedRegister())
				bee.registerMutations();

	}

	private void init()
	{
		template = branch.getTemplate();
		AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPECIES, species);
		setAlleles(template);

		genome = BeeManager.beeRoot.templateAsGenome(template);

		BeeManager.beeRoot.registerTemplate(template);
	}

	public IBeeMutationBuilder registerMutation(IBeeDefinition allele0, IBeeDefinition allele1, int chance) {
		return registerMutation(allele0.getGenome().getPrimary(), allele1.getGenome().getPrimary(), getTemplate(), chance);
	}

	public static IBeeMutationBuilder registerMutation(IBeeDefinition allele0, IBeeDefinition allele1, IBeeDefinition mutation, int chance) {
		return registerMutation(allele0.getGenome().getPrimary(), allele1.getGenome().getPrimary(), mutation.getTemplate(), chance);
	}

	public static IBeeMutationBuilder registerMutation(IAlleleBeeSpecies allele0, IAlleleBeeSpecies allele1, IAllele[] template, int chance) {
		Preconditions.checkNotNull(allele0);
		Preconditions.checkNotNull(allele1);
		Preconditions.checkNotNull(template);
		return BeeManager.beeMutationFactory.createMutation(allele0, allele1, template, chance);
	}


	@Override
	public final IAllele[] getTemplate()
	{
        return Arrays.copyOf(template, template.length);
	}

	@Override
	@Nonnull
	public final IBeeGenome getGenome()
	{
		return genome;
	}

	@Override
	public final IBee getIndividual()
	{
		return new Bee(genome);
	}

	@Override
	public final ItemStack getMemberStack(@Nonnull EnumBeeType beeType)
	{
		IBee bee = getIndividual();
		return BeeManager.beeRoot.getMemberStack(bee, beeType);
	}

	public final IBeeDefinition getRainResist()
	{
		return new BeeVariation.RainResist(this);
	}
}
