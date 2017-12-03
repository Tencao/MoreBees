
package lach_01298.moreBees.item;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

import lach_01298.moreBees.MoreBees;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import forestry.api.apiculture.DefaultBeeModifier;
import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.apiculture.IBeeModifier;
import forestry.api.apiculture.IHiveFrame;
import forestry.api.core.Tabs;
import forestry.core.items.ItemForestry;
import forestry.core.utils.Translator;

public class ItemFrame extends ItemForestry implements IHiveFrame, ItemModelProvider {

	private final HiveFrameBeeModifier beeModifier;

	protected final String name;
	
	public ItemFrame(int maxDamage, float geneticDecay ,float production  , float lifespan, float mutationRate, String name) {
		setMaxStackSize(1);
		setMaxDamage(maxDamage);
		setCreativeTab(Tabs.tabApiculture);
		
		this.beeModifier = new HiveFrameBeeModifier(geneticDecay, lifespan ,mutationRate, production);
		this.name = name;
		setUnlocalizedName(MoreBees.MOD_ID+"."+name);
		setRegistryName(name);
	}

	@Override
	@Nonnull
	public ItemStack frameUsed(@Nonnull IBeeHousing housing, @Nonnull ItemStack frame, @Nonnull IBee queen, int wear) {
		frame.setItemDamage(frame.getItemDamage() + wear);
		if (frame.getItemDamage() >= frame.getMaxDamage()) {
			return ItemStack.EMPTY;
		} else {
			return frame;
		}
	}

	@Override
	@Nonnull
	public IBeeModifier getBeeModifier() {
		return beeModifier;
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World world, @Nullable List<String> tooltip, ITooltipFlag advanced) {
		super.addInformation(stack, world, tooltip, advanced);
		beeModifier.addInformation(stack, world, tooltip, advanced);
		if (!stack.isItemDamaged() && tooltip != null) {
			tooltip.add(Translator.translateToLocalFormatted("item.for.durability", stack.getMaxDamage()));
		}
	}

	private static class HiveFrameBeeModifier extends DefaultBeeModifier 
	{
	
		private final float geneticDecay;
		private final float lifespan;
		private final float mutationRate;
		private final float production;

		public HiveFrameBeeModifier(float geneticDecay,float lifespan,float mutationRate, float production) {
			this.geneticDecay = geneticDecay;
			this.lifespan = lifespan;
			this.mutationRate = mutationRate;
			this.production = production;
		}

		@Override
		public float getProductionModifier(IBeeGenome genome, float currentModifier) {
			return this.production;
		}
		
		public float getMutationModifier(IBeeGenome genome, IBeeGenome mate, float currentModifier) {
			return  this.mutationRate;
		}
		
		public float getLifespanModifier(IBeeGenome genome, IBeeGenome mate, float currentModifier) {
			return  this.lifespan;
		}

		@Override
		public float getGeneticDecay(IBeeGenome genome, float currentModifier) {
			return  this.geneticDecay;
		}
		
		

		public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) {
			tooltip.add(Translator.translateToLocalFormatted("item.for.bee.modifier.production", production));
			tooltip.add(Translator.translateToLocalFormatted("item.for.bee.modifier.genetic.decay", geneticDecay));
			tooltip.add(Translator.translateToLocalFormatted("item.for.bee.modifier.mutationModifier", mutationRate));
			tooltip.add(Translator.translateToLocalFormatted("item.for.bee.modifier.lifeSpanModifier", lifespan));
			
		}
	}
	
	@Override
	public void registerItemModel(Item item) 
	{
		MoreBees.proxy.registerItemRenderer(this, 0, name);
	}
}