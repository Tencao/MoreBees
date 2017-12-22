package com.tencao.morebees.items

import com.tencao.morebees.MBCore
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

class BasicItem(val name: String) : Item(), ItemModelProvider {
    private var effect: Boolean = false

    init {
        unlocalizedName = MBCore.MODID + "." + name
        setRegistryName(name)
    }

    override fun registerItemModel(item: Item) {
        MBCore.proxy.registerItemRenderer(this, 0, name)
    }

    fun setEffect(hasEffect: Boolean): Item {
        this.effect = hasEffect
        return this
    }


    override fun setCreativeTab(tab: CreativeTabs): BasicItem {
        super.setCreativeTab(tab)
        return this
    }

    @SideOnly(Side.CLIENT)
    override fun hasEffect(stack: ItemStack): Boolean {
        return this.effect
    }


}