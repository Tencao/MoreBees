package com.tencao.morebees.items

import com.tencao.morebees.MBCore
import forestry.api.apiculture.*
import forestry.api.core.Tabs
import forestry.core.items.ItemForestry
import forestry.core.utils.Translator
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraft.item.ItemStack

class ItemFrame(maxDamage: Int, geneticDecay: Float, production: Float, lifespan: Float, mutationRate: Float, private val name: String) : ItemForestry(), IHiveFrame, ItemModelProvider {

    private val beeModifier: HiveFrameBeeModifier

    init {
        setMaxStackSize(1)
        setMaxDamage(maxDamage)
        creativeTab = Tabs.tabApiculture

        this.beeModifier = HiveFrameBeeModifier(geneticDecay, lifespan, mutationRate, production)
        unlocalizedName = MBCore.MODID + "." + name
        setRegistryName(name)
    }

    override fun frameUsed(housing: IBeeHousing, frame: ItemStack, queen: IBee, wear: Int): ItemStack {
        frame.itemDamage = frame.itemDamage + wear
        return if (frame.itemDamage >= frame.maxDamage) {
            ItemStack.EMPTY
        } else {
            frame
        }
    }

    override fun getBeeModifier(): IBeeModifier {
        return beeModifier
    }

    override fun addInformation(stack: ItemStack, playerIn: EntityPlayer, tooltip: MutableList<String>, advanced: Boolean) {
        super.addInformation(stack, playerIn, tooltip, advanced)
        beeModifier.addInformation(tooltip)
        if (!stack.isItemDamaged) {
            tooltip.add(Translator.translateToLocalFormatted("item.for.durability", stack.maxDamage))
        }
    }

    private class HiveFrameBeeModifier(private val geneticDecay: Float, private val lifespan: Float, private val mutationRate: Float, private val production: Float) : DefaultBeeModifier() {

        override fun getProductionModifier(genome: IBeeGenome?, currentModifier: Float): Float {
            return this.production
        }

        override fun getMutationModifier(genome: IBeeGenome?, mate: IBeeGenome?, currentModifier: Float): Float {
            return this.mutationRate
        }

        override fun getLifespanModifier(genome: IBeeGenome?, mate: IBeeGenome?, currentModifier: Float): Float {
            return this.lifespan
        }

        override fun getGeneticDecay(genome: IBeeGenome?, currentModifier: Float): Float {
            return this.geneticDecay
        }


        fun addInformation(tooltip: MutableList<String>?) {
            tooltip!!.add(Translator.translateToLocalFormatted("item.for.bee.modifier.production", production))
            tooltip.add(Translator.translateToLocalFormatted("item.for.bee.modifier.genetic.decay", geneticDecay))
            tooltip.add(Translator.translateToLocalFormatted("item.for.bee.modifier.mutationModifier", mutationRate))
            tooltip.add(Translator.translateToLocalFormatted("item.for.bee.modifier.lifeSpanModifier", lifespan))

        }
    }

    override fun registerItemModel(item: Item) {
        MBCore.proxy.registerItemRenderer(this, 0, name)
    }
}