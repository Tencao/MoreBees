package com.tencao.morebees.events;

import com.google.common.collect.Lists;
import com.tencao.morebees.MBBlocks;
import com.tencao.morebees.MBCore;
import com.tencao.morebees.MBItems;
import com.tencao.morebees.items.ItemModelProvider;
import com.tencao.morebees.recipes.RecipesCarpenter;
import com.tencao.morebees.recipes.RecipesCentrifuge;
import com.tencao.morebees.recipes.RecipesSmelting;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Objects;

@Mod.EventBusSubscriber(modid = MBCore.MODID)
public final class MBRegistry {

    private static final LinkedList<Block> blocks = Lists.newLinkedList();
    private static final LinkedList<Item> items = Lists.newLinkedList();
    private static final LinkedHashMap<Item, String> ores = new LinkedHashMap<>();
    private static final LinkedHashMap<ItemModelProvider, Item> models = new LinkedHashMap<>();

    private static void registerBlock(Block block, ItemBlock itemBlock){
        blocks.add(block);
        items.add(itemBlock);
        if (block instanceof ItemModelProvider) {
            models.put((ItemModelProvider)block, itemBlock);
        }
    }

    public static void registerBlock(Block block){
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
        registerBlock(block, itemBlock);
    }

    public static void register(Item item){
        items.add(item);
        if (item instanceof ItemModelProvider) {
            models.put((ItemModelProvider)item, item);
        }
    }

    public static void registerOreItem(Item item, String oreDicName){
        items.add(item);
        ores.put(item, oreDicName);
        if (item instanceof ItemModelProvider) {
            models.put((ItemModelProvider)item, item);
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerBlocks(RegistryEvent.Register<Block> event){
        MBBlocks.INSTANCE.init();
        blocks.forEach(it -> event.getRegistry().register(it));
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerItems(RegistryEvent.Register<Item> event){
        MBItems.INSTANCE.init();
        items.forEach(it -> event.getRegistry().register(it));
        ores.forEach((item, ore) -> OreDictionary.registerOre(ore, item));
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event){
        RecipesCarpenter.INSTANCE.registerRecipes();
        RecipesCentrifuge.INSTANCE.registerRecipes();
        RecipesSmelting.INSTANCE.registerRecipes();
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerModels(ModelRegistryEvent event){
        models.forEach(ItemModelProvider::registerItemModel);
    }

}
