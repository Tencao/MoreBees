package lach_01298.moreBees.block;

import lach_01298.moreBees.MoreBees;
import lach_01298.moreBees.item.ItemModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import javax.annotation.Nonnull;


public class BasicBlock extends Block implements ItemModelProvider{

	protected final String name;

	public BasicBlock(Material material, String name) {
		super(material);

		this.name = name;

		setUnlocalizedName(name);
		setRegistryName(name);
	}

	public void registerItemModel(Item itemBlock) {
		MoreBees.proxy.registerItemRenderer(itemBlock, 0, name);
	}

	@Override
	@Nonnull
	public BasicBlock setCreativeTab(@Nonnull CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

}