package lach_01298.moreBees.util;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public final class OreDicPreferences
{

	public static ItemStack get(String oreName, int amount)
	{
		List items = OreDictionary.getOres(oreName);
		if (items.isEmpty()) throw new NullPointerException();
		ItemStack item = (ItemStack) items.get(0);
		item.setCount(amount);
		return item;
	}

	public static Block getBlock(String oreName)
	{
		List items = OreDictionary.getOres(oreName);
		ItemBlock blockItem = (ItemBlock) ((ItemStack) items.get(0)).getItem();
		return blockItem.getBlock();
	}
}
