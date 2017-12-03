package lach_01298.moreBees.item;

import lach_01298.moreBees.MoreBees;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;


public class BasicItem extends Item implements ItemModelProvider {

	protected final String name;
	protected boolean effect;

	public BasicItem(String name) {
		this.name = name;
		setUnlocalizedName(MoreBees.MOD_ID+"."+name);
		setRegistryName(name);
		
	}

	@Override
	public void registerItemModel(Item item) 
	{
		MoreBees.proxy.registerItemRenderer(this, 0, name);
	}

	public Item setEffect(boolean hasEffect)
	{
		this.effect = hasEffect;
		return this;
	}
	
	
	@Override
	@Nonnull
	public BasicItem setCreativeTab(@Nonnull CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

	 @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
		return this.effect;
	}
	
	
}