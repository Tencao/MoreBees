package lach_01298.moreBees.item;

import lach_01298.moreBees.MoreBees;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;


public class ShinyItem extends Item implements ItemModelProvider {

	protected final String name;


	public ShinyItem(String name) {
		this.name = name;
		setUnlocalizedName(MoreBees.MOD_ID+"."+name);
		setRegistryName(name);
		
	}

	@Override
	public void registerItemModel(Item item) 
	{
		MoreBees.proxy.registerItemRenderer(this, 0, name);
	}

	
	
	
	@Override
	@Nonnull
	public ShinyItem setCreativeTab(@Nonnull CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

	 @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
   
    	 return true; 
  
    }
	
	
}