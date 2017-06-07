package lach_01298.moreBees.util;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public final class OreDicPreferences
{

	public static ItemStack get(String oreName, int amount)
	{
		List items = OreDictionary.getOres((String) oreName);
		ItemStack item = (ItemStack) items.get(0);
		item.setCount(amount);
		return item;
	}

	public static Block getBlock(String oreName)
	{
		List items = OreDictionary.getOres((String) oreName);
		ItemBlock blockItem = (ItemBlock) ((ItemStack) items.get(0)).getItem();
		Block block = blockItem.getBlock();
		return block;
	}
}
