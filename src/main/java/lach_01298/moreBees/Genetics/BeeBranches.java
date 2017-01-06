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
			
			
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeOre);			
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			
			
			
		}
	},
	METAL("Metalis") 
	{
		@Override
		protected void setBranchProperties(IAllele[] alleles) 
		{
			
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeOre);			
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
		}
	},
	CRYSTAL("Crystalis") 
	{
		@Override
		protected void setBranchProperties(IAllele[] alleles) 
		{
			
			
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeOre);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONG);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
		
		}
	},
	EARTH("Terris") 
	{
		@Override
		protected void setBranchProperties(IAllele[] alleles) 
		{
			
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, EnumAllele.Flowers.VANILLA);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
		}
	},
	RADIOACTIVE("Radioactivis") 
	{
		@Override
		protected void setBranchProperties(IAllele[] alleles) 
		{
			
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeUranium);			
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.LARGE);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONG);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.EFFECT, Register.effectRadiation);
		}
	},
	APOCALYTIC("Apocalytus") 
	{
		@Override
		protected void setBranchProperties(IAllele[] alleles) 
		{
			
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeTNT);			
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.LARGER);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONG);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_4);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.EFFECT, AlleleEffect.effectCreeper);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.EFFECT, AlleleEffect.effectIgnition);
		}
	},
	AQUATIC("Aqus") 
	{
		@Override
		protected void setBranchProperties(IAllele[] alleles) 
		{
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeWater);			
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.NEVER_SLEEPS, false);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_3);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_1);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.CAVE_DWELLING, false);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.AVERAGE);
			
		}
	},
	WITHER("Witherris") 
	{
		@Override
		protected void setBranchProperties(IAllele[] alleles) 
		{
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, EnumAllele.Flowers.NETHER);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.LARGEST);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONGER);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_3);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_5);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.EFFECT, Register.effectWither);
		}
	},
	Slime("Slimeus") 
	{
		@Override
		protected void setBranchProperties(IAllele[] alleles) 
		{
			
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeSlime);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.CAVE_DWELLING, false);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.AVERAGE);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.NORMAL);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_1);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.EFFECT, Register.effectSlimey);
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

			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.SHORTER);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.NONE);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.NEVER_SLEEPS, false);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.NONE);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.TOLERATES_RAIN, false);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.CAVE_DWELLING, false);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.FLOWER_PROVIDER, EnumAllele.Flowers.VANILLA);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.SLOWEST);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.AVERAGE);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.EFFECT, AlleleEffect.effectNone);
		}
		return Arrays.copyOf(defaultTemplate, defaultTemplate.length);
	}
	
}
