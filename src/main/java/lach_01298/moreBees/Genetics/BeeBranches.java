package lach_01298.moreBees.Genetics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import lach_01298.moreBees.Flowers;
import lach_01298.moreBees.MoreBees;
import lach_01298.moreBees.Register;
import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAllele;
import forestry.api.genetics.IClassification;
import forestry.apiculture.genetics.alleles.AlleleEffect;
import forestry.apiculture.genetics.alleles.AlleleEffects;
import forestry.core.genetics.IBranchDefinition;
import forestry.core.genetics.alleles.AlleleHelper;
import forestry.core.genetics.alleles.EnumAllele;

public enum BeeBranches implements IBranchDefinition 
{
	ROCK("Petramis") 
	{
		@Override
		protected void setBranchProperties(IAllele[] alleles) 
		{
			
			
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeOre);			
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			
			
			
		}
	},
	METAL("Metalis") 
	{
		@Override
		protected void setBranchProperties(IAllele[] alleles) 
		{
			
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeOre);			
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
		}
	},
	CRYSTAL("Crystalis") 
	{
		@Override
		protected void setBranchProperties(IAllele[] alleles) 
		{
			
			
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeOre);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONG);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
		
		}
	},
	EARTH("Terris") 
	{
		@Override
		protected void setBranchProperties(IAllele[] alleles) 
		{
			
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, EnumAllele.Flowers.VANILLA);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
		}
	},
	RADIOACTIVE("Radioactivis") 
	{
		@Override
		protected void setBranchProperties(IAllele[] alleles) 
		{
			
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeUranium);			
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.LARGE);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONG);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.EFFECT, Register.effectRadiation);
		}
	},
	APOCALYTIC("Apocalytus") 
	{
		@Override
		protected void setBranchProperties(IAllele[] alleles) 
		{
			
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeTNT);			
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.LARGER);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONG);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_4);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.EFFECT, AlleleEffects.effectCreeper);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.EFFECT, AlleleEffects.effectIgnition);
		}
	},
	AQUATIC("Aqus") 
	{
		@Override
		protected void setBranchProperties(IAllele[] alleles) 
		{
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeWater);			
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, false);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_3);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.CAVE_DWELLING, false);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.AVERAGE);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TOLERATES_RAIN, true);
		}
	},
	WITHER("Witherris") 
	{
		@Override
		protected void setBranchProperties(IAllele[] alleles) 
		{
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, EnumAllele.Flowers.NETHER);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.LARGEST);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONGER);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_3);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_5);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.EFFECT, Register.effectWither);
		}
	},
	Slime("Slimeus") 
	{
		@Override
		protected void setBranchProperties(IAllele[] alleles) 
		{
			
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeSlime);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.CAVE_DWELLING, false);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.AVERAGE);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.NORMAL);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.EFFECT, Register.effectSlimey);
		}
	};
	
	 


	private final IClassification branch;

	BeeBranches(String scientific) {
		branch = BeeManager.beeFactory.createBranch(this.name().toLowerCase(Locale.ENGLISH), scientific);
	}

	protected void setBranchProperties(IAllele[] template) {

	}

	@Override
	public final IAllele[] getTemplate() {
		IAllele[] template = getDefaultTemplate();
		setBranchProperties(template);
		return template;
	}

	@Override
	public final IClassification getBranch() {
		return branch;
	}

	private static IAllele[] defaultTemplate;

	private static IAllele[] getDefaultTemplate() {
		if (defaultTemplate == null) {
			defaultTemplate = new IAllele[EnumBeeChromosome.values().length];

			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.SHORTER);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.NONE);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.NEVER_SLEEPS, false);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.NONE);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.TOLERATES_RAIN, false);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.CAVE_DWELLING, false);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.FLOWER_PROVIDER, EnumAllele.Flowers.VANILLA);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.SLOWEST);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.AVERAGE);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.EFFECT, AlleleEffects.effectNone);
		}
		return Arrays.copyOf(defaultTemplate, defaultTemplate.length);
	}
	
}
