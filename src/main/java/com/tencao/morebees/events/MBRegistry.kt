package com.tencao.morebees.events

import com.tencao.morebees.MBCore
import com.tencao.morebees.ObjRegistry
import com.tencao.morebees.items.ItemModelProvider
import com.tencao.morebees.recipes.RecipesCarpenter
import com.tencao.morebees.recipes.RecipesCentrifuge
import com.tencao.morebees.recipes.RecipesCrafting
import com.tencao.morebees.recipes.RecipesSmelting
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraft.item.crafting.IRecipe
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.EventPriority
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.oredict.OreDictionary
import net.minecraftforge.oredict.ShapelessOreRecipe
import java.util.*
import kotlin.collections.HashMap

@Mod.EventBusSubscriber(modid = MBCore.MODID)
object MBRegistry {
    private val blocks: LinkedList<Block> = LinkedList()
    private val items: LinkedList<Item>  = LinkedList()
    private val models: HashMap<ItemModelProvider, Item>  = HashMap()
    private val recipes: LinkedList<IRecipe>  = LinkedList()
    private val ores: HashMap<Item, String>  = HashMap()

    @JvmStatic
    @Mod.InstanceFactory
    fun shenanigan() = this

    private fun <T : Block> registerBlock(block: T, itemBlock: ItemBlock): T {
        blocks.add(block)
        items.add(itemBlock)
        if (block is ItemModelProvider) {
            models[block] = itemBlock
        }

        return block
    }

    fun <T : Block> registerBlock(block: T): T {
        val itemBlock = ItemBlock(block)
        itemBlock.registryName = Objects.requireNonNull(block.registryName)
        return registerBlock(block, itemBlock)
    }

    fun <T : Item> register(item: T): T {
        items.add(item)

        if (item is ItemModelProvider) {
            models[item] = item
        }

        return item
    }

    fun <T : Item> registerOreItem(item: T, oreDicName: String): T {
        items.add(item)
        ores[item] = oreDicName

        if (item is ItemModelProvider) {
            models[item] = item
        }

        return item
    }

    fun addShapelessOreRecipe(result: Item, vararg recipe: Any) {
        recipes.add(ShapelessOreRecipe(result, *recipe))
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun registerBlocks(event: RegistryEvent.Register<Block>) {
        ObjRegistry.registerBlocks()
        blocks.forEach{ event.registry.register(it) }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun registerItems(event: RegistryEvent.Register<Item>) {
        ObjRegistry.registerAll()
        items.forEach { event.registry.register(it) }
        ores.forEach({ item, ore -> OreDictionary.registerOre(ore, item) })
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun registerModels(event: ModelRegistryEvent) {
        models.forEach(ItemModelProvider::registerItemModel)
    }

    fun registerRecipes() {
        RecipesCarpenter.registerRecipes()
        RecipesCentrifuge.registerRecipes()
        RecipesCrafting.registerRecipes()
        RecipesSmelting.registerRecipes()
        recipes.forEach{ GameRegistry.addRecipe(it) }
    }
}