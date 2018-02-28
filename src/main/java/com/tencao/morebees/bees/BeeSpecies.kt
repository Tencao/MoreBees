package com.tencao.morebees.bees

import com.google.common.base.Preconditions
import com.tencao.morebees.MBCore
import com.tencao.morebees.ModConfig
import com.tencao.morebees.ObjRegistry
import forestry.api.apiculture.*
import forestry.api.core.EnumHumidity
import forestry.api.core.EnumTemperature
import forestry.api.genetics.IAllele
import forestry.apiculture.PluginApiculture
import forestry.apiculture.genetics.Bee
import forestry.apiculture.genetics.BeeBranchDefinition
import forestry.apiculture.genetics.BeeDefinition
import forestry.apiculture.genetics.IBeeDefinition
import forestry.apiculture.genetics.alleles.AlleleEffects
import forestry.apiculture.items.EnumHoneyComb
import forestry.core.PluginCore
import forestry.core.genetics.IBranchDefinition
import forestry.core.genetics.alleles.AlleleHelper
import forestry.core.genetics.alleles.EnumAllele
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraftforge.common.BiomeDictionary
import net.minecraftforge.oredict.OreDictionary
import java.awt.Color
import java.util.*

enum class BeeSpecies constructor(private val branch: IBranchDefinition, binomial: String, dominant: Boolean, primary: Color, secondary: Color) : IBeeDefinition {

    // Rock Branch
    ROCK(BeeBranches.ROCK, "Rock", true, Color(0x6d6d6d), Color(0xffdc16)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombRock), 0.30f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {

            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true)
            AlleleHelper.getInstance().set<EnumBeeChromosome>(template, EnumBeeChromosome.FLOWER_PROVIDER, ObjRegistry.FlowerTypeOre)
        }

        override fun registerMutations() {
            // found in hives
        }
    },
    HARDENED(BeeBranches.ROCK, "Hardened", true, Color(0x464646), Color(0xffdc16)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombRock), 0.35f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.ROCK, BeeDefinition.CULTIVATED, template, Math.min((10 * ModConfig.bees.mutationMultipler).toInt(), 100))

        }
    },
    OBSIDIAN(BeeBranches.ROCK, "Obsidian", false, Color(0x241e31), Color(0xffdc16)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombRock), 0.40f)
                    .addProduct(ItemStack(Blocks.OBSIDIAN), 0.1f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.HARDENED, BeeDefinition.STEADFAST, template, Math.min((10 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }

    },
    LAPIS(BeeBranches.ROCK, "Lapis", false, Color(0x22479c), Color(0xffdc16)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombRock), 0.30f)
                    .addProduct(ItemStack(Items.DYE, 1, 4), 0.1f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.OBSIDIAN, BeeDefinition.IMPERIAL, template, Math.min((8 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    // Earth Branch
    DIRT(BeeBranches.EARTH, "Dirt", true, Color(0x79553a), Color(0xffdc16)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombDirt), 0.40f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.FAST)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.ROCK, BeeDefinition.FOREST, template, Math.min((15 * ModConfig.bees.mutationMultipler).toInt(), 100))
            registerMutation(BeeSpecies.ROCK, BeeDefinition.MARSHY, template, Math.min((15 * ModConfig.bees.mutationMultipler).toInt(), 100))
            registerMutation(BeeSpecies.ROCK, BeeDefinition.MEADOWS, template, Math.min((15 * ModConfig.bees.mutationMultipler).toInt(), 100))
            registerMutation(BeeSpecies.ROCK, BeeDefinition.MODEST, template, Math.min((15 * ModConfig.bees.mutationMultipler).toInt(), 100))
            registerMutation(BeeSpecies.ROCK, BeeDefinition.TROPICAL, template, Math.min((15 * ModConfig.bees.mutationMultipler).toInt(), 100))
            registerMutation(BeeSpecies.ROCK, BeeDefinition.WINTRY, template, Math.min((15 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    CLAY(BeeBranches.EARTH, "Clay", true, Color(0xa7abbb), Color(0xffdc16)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombDirt), 0.30f)
                    .addProduct(ItemStack(Items.CLAY_BALL), 1.0f)
                    .addProduct(ItemStack(Items.CLAY_BALL), 0.5f)
                    .addProduct(ItemStack(Items.CLAY_BALL), 0.5f)
                    .addProduct(ItemStack(Items.CLAY_BALL), 0.5f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.DAMP)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.FAST)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TOLERATES_RAIN, true)
        }

        override fun registerMutations() {

            registerMutation(BeeSpecies.DIRT, BeeDefinition.MARSHY, template, Math.min((15 * ModConfig.bees.mutationMultipler).toInt(), 100))

        }
    },
    REDSAND(BeeBranches.EARTH, "RedSand", false, Color(0xa75620), Color(0xffdc16)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombDirt), 0.30f)
                    .addProduct(ItemStack(Blocks.SAND), 0.40f)
                    .addProduct(ItemStack(Blocks.SAND, 1, 1), 0.70f)
                    .addProduct(ItemStack(Blocks.SAND, 2, 1), 0.30f)
                    .addProduct(ItemStack(Blocks.SAND, 1, 1), 0.20f)
                    .setTemperature(EnumTemperature.HOT).setHumidity(EnumHumidity.ARID)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.FAST)

        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.DIRT, BeeDefinition.MODEST, template, Math.min((15 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    // Crystal branch
    QUARTZ(BeeBranches.CRYSTAL, "Quartz", false, Color(0xf4f6f6), Color(0xffdc16)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombCrystal), 0.30f)
                    .addProduct(ItemStack(Items.QUARTZ), 0.20f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)

        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set<EnumBeeChromosome>(template, EnumBeeChromosome.FLOWER_PROVIDER, ObjRegistry.FlowerTypeRedstone)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.LAPIS, BeeDefinition.SINISTER, template, Math.min((10 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    CERTUS(BeeBranches.CRYSTAL, "Certus", false, Color(0xf6feff), Color(0xffdc16)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("dustCertusQuartz").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombCrystal), 0.30f)
                    .addProduct(stack, 0.20f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set<EnumBeeChromosome>(template, EnumBeeChromosome.FLOWER_PROVIDER, ObjRegistry.FlowerTypeRedstone)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.QUARTZ, BeeDefinition.INDUSTRIOUS, template, Math.min((10 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    REDSTONE(BeeBranches.CRYSTAL, "Redstone", false, Color(0xaa0404), Color(0xffdc16)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombCrystal), 0.30f)
                    .addProduct(ItemStack(Items.REDSTONE), 0.20f)
                    .addProduct(ItemStack(Items.REDSTONE), 0.15f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)

        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set<EnumBeeChromosome>(template, EnumBeeChromosome.FLOWER_PROVIDER, ObjRegistry.FlowerTypeRedstone)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.OBSIDIAN, BeeDefinition.STEADFAST, template, Math.min((8 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    EMERALD(BeeBranches.CRYSTAL, "Emerald", false, Color(0x4adc73), Color(0xffdc16)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombCrystal), 0.30f)
                    .addSpecialty(ItemStack(ObjRegistry.EmeraldFrag), 0.15f)
                    .setJubilanceProvider(BeeManager.jubilanceFactory.getRequiresResource(Blocks.EMERALD_BLOCK.defaultState, Blocks.EMERALD_ORE.defaultState))
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)

        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER)
            AlleleHelper.getInstance().set<EnumBeeChromosome>(template, EnumBeeChromosome.FLOWER_PROVIDER, ObjRegistry.FlowerTypeEmerald)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.REDSTONE, BeeDefinition.IMPERIAL, template, Math.min((5 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    DIAMOND(BeeBranches.CRYSTAL, "Diamond", false, Color(0x5decf5), Color(0xffdc16)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombCrystal), 0.30f)
                    .addSpecialty(ItemStack(ObjRegistry.DiamondFrag), 0.15f)
                    .setJubilanceProvider(BeeManager.jubilanceFactory.getRequiresResource(Blocks.DIAMOND_BLOCK.defaultState, Blocks.DIAMOND_ORE.defaultState))
                    .setHasEffect()
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)

        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST)
            AlleleHelper.getInstance().set<EnumBeeChromosome>(template, EnumBeeChromosome.FLOWER_PROVIDER, ObjRegistry.FlowerTypeDiamond)
        }

        override fun registerMutations() {

            registerMutation(BeeSpecies.EMERALD, BeeSpecies.QUARTZ, template, Math.min((2 * ModConfig.bees.mutationMultipler).toInt(), 100))

        }
    },
    RUBY(BeeBranches.CRYSTAL, "Ruby", false, Color(0xff0000), Color(0xffdc16)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("gemRuby").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombCrystal), 0.30f)
                    .addProduct(stack, 0.10f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.REDSTONE, BeeDefinition.IMPERIAL, template, Math.min((7 * ModConfig.bees.mutationMultipler).toInt(), 100))

        }
    },
    SAPPHIRE(BeeBranches.CRYSTAL, "Sapphire", false, Color(0x0058f8), Color(0xffdc16)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("gemSapphire").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombCrystal), 0.30f)
                    .addProduct(stack, 0.10f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.LAPIS, BeeDefinition.IMPERIAL, template, Math.min((7 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    SULFUR(BeeBranches.CRYSTAL, "Sulfur", false, Color(0xE9F800), Color(0xffdc16)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("dustSulfur").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(PluginApiculture.getItems().beeComb.get(EnumHoneyComb.SIMMERING, 1), 0.3f)
                    .addProduct(stack, 0.15f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.REDSTONE, BeeDefinition.FIENDISH, template, Math.min((15 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    APATITE(BeeBranches.CRYSTAL, "Apatite", false, Color(0x4baef1), Color(0xffdc16)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombCrystal), 0.3f)
                    .addProduct(ItemStack(PluginCore.getItems().apatite), 0.1f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.REDSTONE, BeeSpecies.LAPIS, template, Math.min((10 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },

    // Metal Branch
    METALLIC(BeeBranches.METAL, "Metallic", true, Color(0x999999), Color(0x999999)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombMetallic), 0.25f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER)

        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.OBSIDIAN, BeeDefinition.FIENDISH, template, Math.min((10 * ModConfig.bees.mutationMultipler).toInt(), 100))

        }
    },
    IRON(BeeBranches.METAL, "Iron", false, Color(0xd9d9d9), Color(0x999999)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("dustIron").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombMetallic), 0.30f)
                    .addProduct(stack, 0.15f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)

        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.METALLIC, BeeDefinition.INDUSTRIOUS, template, Math.min((10 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    COPPER(BeeBranches.METAL, "Copper", false, Color(0xa76430), Color(0x999999)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("dustCopper").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombMetallic), 0.30f)
                    .addProduct(stack, 0.15f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.METALLIC, BeeDefinition.INDUSTRIOUS, template, Math.min((10 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    TIN(BeeBranches.METAL, "Tin", false, Color(0xe8e8e8), Color(0x999999)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("dustTin").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombMetallic), 0.30f)
                    .addProduct(stack, 0.15f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.METALLIC, BeeDefinition.INDUSTRIOUS, template, Math.min((10 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    ALUMINIUM(BeeBranches.METAL, "Aluminium", false, Color(0xF6F6F6), Color(0x999999)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("dustAluminum").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombMetallic), 0.30f)
                    .addProduct(stack, 0.15f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.METALLIC, BeeDefinition.INDUSTRIOUS, template, Math.min((10 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    GOLD(BeeBranches.METAL, "Gold", false, Color(0xeed83d), Color(0x999999)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("dustGold").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombMetallic), 0.30f)
                    .addProduct(stack, 0.10f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.METALLIC, BeeDefinition.IMPERIAL, template, Math.min((8 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    SILVER(BeeBranches.METAL, "Silver", false, Color(0xf4f6f6), Color(0x999999)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("dustSilver").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombMetallic), 0.30f)
                    .addProduct(stack, 0.12f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.GOLD, BeeSpecies.TIN, template, Math.min((8 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    LEAD(BeeBranches.METAL, "Lead", false, Color(0xd5d9b9), Color(0x999999)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("dustLead").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombMetallic), 0.30f)
                    .addProduct(stack, 0.15f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.METALLIC, BeeSpecies.OBSIDIAN, template, Math.min((8 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    COBALT(BeeBranches.METAL, "Cobalt", false, Color(0x1d62b8), Color(0x999999)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("nuggetCobalt").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombMetallic), 0.30f)
                    .addProduct(stack, 0.15f)
                    .setTemperature(EnumTemperature.HELLISH)
                    .setHumidity(EnumHumidity.ARID)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW)
        }

        override fun registerMutations() {
            registerMutation(BeeDefinition.DEMONIC, BeeSpecies.TIN, template, Math.min((8 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    ARDITE(BeeBranches.METAL, "Ardite", false, Color(0xa82517), Color(0x999999)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("nuggetArdite").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombMetallic), 0.30f)
                    .addProduct(stack, 0.15f)
                    .setTemperature(EnumTemperature.HELLISH)
                    .setHumidity(EnumHumidity.ARID)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW)
        }

        override fun registerMutations() {
            registerMutation(BeeDefinition.DEMONIC, BeeSpecies.COPPER, template, Math.min((8 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    OSMIUM(BeeBranches.METAL, "Osmium", false, Color(0x95a5b4), Color(0x999999)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("dustOsmium").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombMetallic), 0.30f)
                    .addProduct(stack, 0.15f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.COPPER, BeeDefinition.INDUSTRIOUS, template, Math.min((10 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    NICKEL(BeeBranches.METAL, "Nickel", false, Color(0xa3a998), Color(0x999999)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("dustNickel").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombMetallic), 0.30f)
                    .addProduct(stack, 0.15f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.IRON, BeeDefinition.INDUSTRIOUS, template, Math.min((8 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    PLATINUM(BeeBranches.METAL, "Platinum", false, Color(0x6fe5f3), Color(0x999999)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("dustPlatinum").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombMetallic), 0.30f)
                    .addProduct(stack, 0.10f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW)
        }

        override fun registerMutations() {
            registerMutation(BeeDefinition.IMPERIAL, BeeSpecies.GOLD, template, Math.min((5 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    IRIDIUM(BeeBranches.METAL, "Iridium", false, Color(0xe4e2eb), Color(0x999999)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("dustIridium").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombMetallic), 0.30f)
                    .addProduct(stack, 0.05f)
                    .setTemperature(EnumTemperature.HOT).setHumidity(EnumHumidity.ARID)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.APOCALYPTIC, BeeSpecies.GOLD, template, Math.min((4 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    // RadioActive branch
    RADIOACTIVE(BeeBranches.RADIOACTIVE, "Radioactive", true, Color(0x3e720c), Color(0x999999)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            var stack = OreDictionary.getOres("oreUranium").stream().findFirst().orElse(ItemStack.EMPTY)
            if (stack.isEmpty)
                stack = OreDictionary.getOres("dropUranium").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(PluginApiculture.getItems().beeComb.get(EnumHoneyComb.SIMMERING, 1), 0.30f)
                    .addProduct(stack, 0.05f)
                    .setTemperature(EnumTemperature.HOT).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER)
            AlleleHelper.getInstance().set<EnumBeeChromosome>(template, EnumBeeChromosome.FLOWER_PROVIDER, ObjRegistry.FlowerTypeUranium)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true)

        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.LEAD, BeeDefinition.AUSTERE, template, Math.min((8 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    RESONATING(BeeBranches.RADIOACTIVE, "Resonating", true, Color(0xff6565), Color(0x999999)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val item = Item.getByNameOrId("deepresonance:resonating_ore")
            val stack = if (item != null) ItemStack(item, 1) else ItemStack.EMPTY
            beeSpecies.addProduct(PluginApiculture.getItems().beeComb.get(EnumHoneyComb.SIMMERING, 1), 0.30f)
                    .addProduct(stack, 0.05f)
                    .setTemperature(EnumTemperature.HOT).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER)
            AlleleHelper.getInstance().set<EnumBeeChromosome>(template, EnumBeeChromosome.FLOWER_PROVIDER, ObjRegistry.FlowerTypeUranium)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true)

        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.RADIOACTIVE, BeeSpecies.REDSTONE, template, Math.min((8 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    YELLORITE(BeeBranches.RADIOACTIVE, "Yellorite", true, Color(0xd7ef00), Color(0x999999)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("oreYellorite").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(PluginApiculture.getItems().beeComb.get(EnumHoneyComb.SIMMERING, 1), 0.30f)
                    .addProduct(stack, 0.05f)
                    .setTemperature(EnumTemperature.HOT).setHumidity(EnumHumidity.NORMAL)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER)
            AlleleHelper.getInstance().set<EnumBeeChromosome>(template, EnumBeeChromosome.FLOWER_PROVIDER, ObjRegistry.FlowerTypeUranium)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true)

        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.RADIOACTIVE, BeeSpecies.REDSTONE, template, Math.min((8 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    URANIUM(BeeBranches.RADIOACTIVE, "Uranium", false, Color(0x6ac013), Color(0x999999)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            var stack = OreDictionary.getOres("crushedUranium").stream().findFirst().orElse(ItemStack.EMPTY)
            if (!stack.isEmpty) {
                beeSpecies.addProduct(PluginApiculture.getItems().beeComb.get(EnumHoneyComb.SIMMERING, 1), 0.30f)
                        .addProduct(stack, 0.15f)
            } else {
                stack = OreDictionary.getOres("dropUranium").stream().findFirst().orElse(ItemStack.EMPTY)
                beeSpecies.addProduct(ItemStack(ObjRegistry.CombRock), 0.30f)
                        .addProduct(stack, 0.15f)
            }
            beeSpecies.setHasEffect()
                    .setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL)

        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.RADIOACTIVE, BeeSpecies.APOCALYPTIC, template, Math.min((5 * ModConfig.bees.mutationMultipler).toInt(), 100)).restrictBiomeType(BiomeDictionary.Type.NETHER)
        }
    },
    // Aquatic branch
    PRISMARINE(BeeBranches.AQUATIC, "Prismarine", true, Color(0x63ab9d), Color(0xffdc16)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            beeSpecies.addProduct(PluginApiculture.getItems().beeComb.get(EnumHoneyComb.HONEY, 1), 0.30f)
                    .addProduct(ItemStack(Items.PRISMARINE_CRYSTALS, 2), 0.2f)
                    .addProduct(ItemStack(Items.PRISMARINE_SHARD, 2), 0.2f)
                    .setHasEffect()
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.DAMP)

        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL)
            AlleleHelper.getInstance().set<EnumBeeChromosome>(template, EnumBeeChromosome.FLOWER_PROVIDER, ObjRegistry.FlowerTypeWater)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.OBSIDIAN, BeeSpecies.CLAY, template, Math.min((15 * ModConfig.bees.mutationMultipler).toInt(), 100)).restrictBiomeType(BiomeDictionary.Type.OCEAN)
        }
    },
    // Apocalyptic branch
    APOCALYPTIC(BeeBranches.APOCALYTIC, "Apocalyptic", true, Color(0xcb7204), Color(0x830d0d)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            beeSpecies.addProduct(PluginApiculture.getItems().beeComb.get(EnumHoneyComb.SIMMERING, 1), 0.30f)
                    .addSpecialty(ItemStack(Items.BLAZE_POWDER), 0.2f)
                    .addSpecialty(ItemStack(Items.GUNPOWDER), 0.2f)
                    .addSpecialty(ItemStack(Items.GHAST_TEAR), 0.05f)
                    .setJubilanceProvider(BeeManager.jubilanceFactory.getRequiresResource(Blocks.TNT.defaultState))
                    .setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_3)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectIgnition)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectCreeper)
            AlleleHelper.getInstance().set<EnumBeeChromosome>(template, EnumBeeChromosome.FLOWER_PROVIDER, ObjRegistry.FlowerTypeTNT)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW)
        }

        override fun registerMutations() {
            registerMutation(BeeDefinition.AUSTERE, BeeDefinition.DEMONIC, template, Math.min((5 * ModConfig.bees.mutationMultipler).toInt(), 100)).restrictBiomeType(BiomeDictionary.Type.NETHER)
        }
    },
    // Wither Branch
    WITHER(BeeBranches.WITHER, "Withering", false, Color(0xc1c1c1), Color(0x3c3c3c)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombWither), 0.30f)
                    .addSpecialty(ItemStack(Items.SKULL, 1, 1), 0.05f)
                    .setJubilanceProvider(WitherSkullJubilance())
                    .setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID)

        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_3)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.APOCALYPTIC, BeeDefinition.DEMONIC, template, Math.min((5 * ModConfig.bees.mutationMultipler).toInt(), 100)).restrictBiomeType(BiomeDictionary.Type.NETHER)

        }
    },
    NETHERSTAR(BeeBranches.WITHER, "Wither", false, Color(0xc1c1c1), Color(0x3c3c3c)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombWither), 0.35f)
                    .addSpecialty(ItemStack(ObjRegistry.NetherFrag), 0.03f)
                    .setJubilanceProvider(WitherSkullJubilance())
                    .setHasEffect()
                    .setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_3)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.WITHER, BeeDefinition.ENDED, template, Math.min((2 * ModConfig.bees.mutationMultipler).toInt(), 100)).restrictBiomeType(BiomeDictionary.Type.NETHER)
        }
    },
    // SLIME Branch
    SLIMY(BeeBranches.SLIME, "Slimy", true, Color(0x7dc873), Color(0x7dc873)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombSlime), 0.70f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.DAMP)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set<EnumBeeChromosome>(template, EnumBeeChromosome.FLOWER_PROVIDER, ObjRegistry.FlowerTypeSlime)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, false)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.AVERAGE)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set<EnumBeeChromosome>(template, EnumBeeChromosome.EFFECT, ObjRegistry.effectSlimy)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.ROCK, BeeDefinition.BOGGY, template, Math.min((30 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    BLUESLIMY(BeeBranches.SLIME, "BlueSlimy", true, Color(0x7dc873), Color(0x74c8c7)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("slimeballBlue").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombSlime), 0.55f)
                    .addProduct(stack, 0.55f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.DAMP)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.SLIMY, BeeSpecies.PRISMARINE, template, Math.min((30 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    PURPLESLIMY(BeeBranches.SLIME, "PurpleSlimy", false, Color(0x7dc873), Color(0xbb5aff)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("slimeballPurple").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombSlime), 0.55f)
                    .addProduct(stack, 0.55f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.DAMP)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.BLUESLIMY, BeeSpecies.REDSTONE, template, Math.min((8 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    MAGMASLIMY(BeeBranches.SLIME, "MagmaSlimy", false, Color(0x7dc873), Color(0xffab49)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("slimeballMagma").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(ItemStack(ObjRegistry.CombSlime), 0.55f)
                    .addProduct(stack, 0.55f)
                    .setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL)
        }

        override fun registerMutations() {
            registerMutation(BeeSpecies.SLIMY, BeeDefinition.FIENDISH, template, Math.min((10 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    //forestry branches
    STRINGY(BeeBranchDefinition.TROPICAL, "Stringy", false, Color(0x6d6d6d), Color(0xe5e5e5)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            beeSpecies.addProduct(PluginApiculture.getItems().beeComb.get(EnumHoneyComb.SILKY, 1), 0.30f)
                    .addProduct(PluginApiculture.getItems().beeComb.get(EnumHoneyComb.STRINGY, 1), 0.30f)
                    .addProduct(ItemStack(Items.STRING, 1), 0.70f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.DAMP)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, false)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL)

        }

        override fun registerMutations() {
            registerMutation(BeeDefinition.TROPICAL, BeeDefinition.DILIGENT, template, Math.min((10 * ModConfig.bees.mutationMultipler).toInt(), 100))
        }
    },
    DRACONIC(BeeBranchDefinition.END, "Draconic", true, Color(0x4c0e80), Color(0x830d0d)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("dustDraconium").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addProduct(PluginApiculture.getItems().beeComb.get(EnumHoneyComb.MYSTERIOUS, 1), 0.30f)
                    .addProduct(stack, 0.15f)
                    .setTemperature(EnumTemperature.COLD).setHumidity(EnumHumidity.ARID)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW)
        }

        override fun registerMutations() {
            registerMutation(BeeDefinition.AUSTERE, BeeDefinition.ENDED, template, Math.min((5 * ModConfig.bees.mutationMultipler).toInt(), 100)).restrictBiomeType(BiomeDictionary.Type.NETHER)
        }
    },
    SPECTRITE(BeeBranchDefinition.INDUSTRIOUS, "Spectrite", true, Color(0x6fe5f3), Color(0x999999)) {
        override fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder) {
            val stack = OreDictionary.getOres("gemSpectrite").stream().findFirst().orElse(ItemStack.EMPTY)
            beeSpecies.addSpecialty(ItemStack(ObjRegistry.CombSpectrite), 0.1f)
                    .addSpecialty(stack, 0.001f)
                    .addProduct(ItemStack(ObjRegistry.CombWither), 0.35f)
                    .setJubilanceProvider(SpectriteJubilance())
                    .setHasEffect()
                    .setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID)
        }

        override fun setAlleles(template: Array<IAllele>) {
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST)
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.NORMAL)
        }

        override fun registerMutations() {
            if (!OreDictionary.getOres("dustIridium").isEmpty())
                registerMutation(BeeSpecies.NETHERSTAR, BeeSpecies.IRIDIUM, template, Math.min((1 * ModConfig.bees.mutationMultipler).toInt(), 100)).requireNight().setIsSecret()
            else
                registerMutation(BeeSpecies.NETHERSTAR, BeeSpecies.METALLIC, template, Math.min((1 * ModConfig.bees.mutationMultipler).toInt(), 100)).requireNight().setIsSecret()
        }
    };

    private lateinit var species: IAlleleBeeSpecies

    private lateinit var template: Array<IAllele>
    private lateinit var genome: IBeeGenome

    private lateinit var speciesBuilder: BeeBuilder

    protected val isSecret: Boolean
        get() = false

    init {
        val species = name.toLowerCase(Locale.ENGLISH)
        val modId = MBCore.MODID
        val uid = modId + ".species." + species

        val description = modId + ".description." + species
        val name = "for.bees.species." + species
        speciesBuilder = BeeBuilder(uid, name, "Tencao", description, dominant, branch.branch, binomial, primary.rgb, secondary.rgb)
    }

    protected abstract fun setSpeciesProperties(beeSpecies: IAlleleBeeSpeciesBuilder)

    protected abstract fun setAlleles(template: Array<IAllele>)

    protected abstract fun registerMutations()

    private fun init() {
            if (isSecret) {
                speciesBuilder.setIsSecret()
            }
            setSpeciesProperties(speciesBuilder)
            this.species = speciesBuilder.build()
            template = branch.template
            AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPECIES, species)
            setAlleles(template)

            genome = BeeManager.beeRoot.templateAsGenome(template)

            BeeManager.beeRoot.registerTemplate(template)
    }

    override fun getTemplate(): Array<IAllele> {
        return Arrays.copyOf(template, template.size)
    }

    override fun getGenome(): IBeeGenome {
        return genome
    }

    override fun getIndividual(): IBee {
        return Bee(genome)
    }

    override fun getMemberStack(beeType: EnumBeeType): ItemStack {
        val bee = individual
        return BeeManager.beeRoot.getMemberStack(bee, beeType)
    }

    companion object {

        fun initBees() {
            for (bee in values())
                bee.init()

            for (bee in values())
                bee.registerMutations()

        }

        fun registerMutation(allele0: IBeeDefinition, allele1: IBeeDefinition, template: Array<IAllele>, chance: Int): IBeeMutationBuilder {
            return registerMutation(allele0.genome.primary, allele1.genome.primary, template, chance)
        }

        private fun registerMutation(allele0: IAlleleBeeSpecies, allele1: IAlleleBeeSpecies, template: Array<IAllele>, chance: Int): IBeeMutationBuilder {
            Preconditions.checkNotNull(allele0)
            Preconditions.checkNotNull(allele1)
            Preconditions.checkNotNull(template)
            return BeeManager.beeMutationFactory.createMutation(allele0, allele1, template, chance)
        }
    }
}
