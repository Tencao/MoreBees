package lach_01298.moreBees.block;

import lach_01298.moreBees.MoreBees;
import lach_01298.moreBees.item.ItemModelProvider;
import forestry.apiculture.blocks.BlockBeeHives;
import forestry.core.proxy.Proxies;
import forestry.plugins.PluginManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MoreBeesBlocks 
{

	public static BlockHive hive;
	

	public static void init() 
	{
		hive = registerBlock(new BlockHive("hive"));
		
	
	}

	

	private static <T extends Block> T registerBlock(T block, ItemBlock itemBlock) {
		GameRegistry.register(block);
		GameRegistry.register(itemBlock);

		if (block instanceof ItemModelProvider) {
			((ItemModelProvider)block).registerItemModel(itemBlock);
		}

		return block;
	}

	private static <T extends Block> T registerBlock(T block) {
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(block.getRegistryName());
		return registerBlock(block, itemBlock);
	}

}
