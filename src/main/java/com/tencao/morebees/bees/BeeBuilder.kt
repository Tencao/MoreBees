package com.tencao.morebees.bees

import forestry.api.apiculture.IAlleleBeeSpecies
import forestry.api.apiculture.IAlleleBeeSpeciesBuilder
import forestry.api.genetics.AlleleManager
import forestry.api.genetics.IClassification
import forestry.apiculture.genetics.alleles.AlleleBeeSpecies
import net.minecraft.item.ItemStack

class BeeBuilder(modId: String, uid: String, unlocalizedName: String, authority: String, unlocalizedDescription: String, dominant: Boolean, branch: IClassification, binomial: String, primaryColor: Int, secondaryColor: Int)
    : AlleleBeeSpecies(modId, uid, unlocalizedName, authority, unlocalizedDescription, dominant, branch, binomial, primaryColor, secondaryColor) {

    private var valid = true

    override fun addProduct(product: ItemStack, chance: Float): IAlleleBeeSpeciesBuilder {
        if (product.isEmpty) {
            this.valid = false
            return this
        }
        return super.addProduct(product, chance)
    }

    override fun addSpecialty(specialty: ItemStack, chance: Float): IAlleleBeeSpeciesBuilder {
        if (specialty.isEmpty) {
            this.valid = false
            return this
        }
        return super.addSpecialty(specialty, chance)
    }

    override fun build(): IAlleleBeeSpecies {
        if (!this.valid) {
            AlleleManager.alleleRegistry.blacklistAllele(this.uid)
        }
        return super.build()
    }

}