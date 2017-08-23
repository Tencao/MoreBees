package lach_01298.moreBees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import lach_01298.moreBees.item.ItemModelProvider;

public class Registry {
	private static List<Block> blocks = new LinkedList<>();
	private static List<Item> items = new LinkedList<>();
	private static HashMap<ItemModelProvider, Item> models = new HashMap<>();
	private static List<IRecipe> recipes = new LinkedList<>();
	private static HashMap<Item, String> ores = new HashMap<>();
	
	public static <T extends Block> T registerBlock(T block, ItemBlock itemBlock) {
		blocks.add(block);
		items.add(itemBlock);
		if (block instanceof ItemModelProvider) {
			models.put((ItemModelProvider) block, itemBlock);
		}
		
		return block;
	}
	
	public static <T extends Block> T registerBlock(T block) {
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(block.getRegistryName());
		return registerBlock(block, itemBlock);
	}
	
	public static <T extends Item> T register(T item) {
		items.add(item);
		
		if (item instanceof ItemModelProvider) {
			models.put((ItemModelProvider) item, item);
		}
		
		return item;
	}
	
	public static <T extends Item> T registerOreItem(T item, String oreDicName) {
		items.add(item);
		ores.put(item, oreDicName);
		
		if (item instanceof ItemModelProvider) {
			models.put((ItemModelProvider) item, item);
		}
		
		return item;
	}
	
	public static void addShapelessOreRecipe(String name, Item result, Object... recipe) {
		recipes.add(new ShapelessOreRecipe(new ResourceLocation(MoreBees.MOD_ID, name), result, recipe).setRegistryName(MoreBees.MOD_ID, name));
	}
	
	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		blocks.forEach(event.getRegistry()::register);
	}
	
	@SubscribeEvent
	public void registerModels(ModelRegistryEvent event) {
		models.forEach((model, item) -> model.registerItemModel(item));
	}
	
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		items.forEach(event.getRegistry()::register);
		ores.forEach((item, ore)-> OreDictionary.registerOre(ore, item));
	}
	
	@SubscribeEvent
	public void registerRecipes(RegistryEvent.Register<IRecipe> event) {
		recipes.forEach(event.getRegistry()::register);
	}
}
