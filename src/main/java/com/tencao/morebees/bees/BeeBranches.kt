package com.tencao.morebees.bees

import com.tencao.morebees.MBBlocks
import com.tencao.morebees.MBCore
import forestry.api.apiculture.BeeManager
import forestry.api.apiculture.EnumBeeChromosome
import forestry.api.genetics.AlleleManager
import forestry.api.genetics.IAllele
import forestry.api.genetics.IClassification
import forestry.apiculture.genetics.alleles.AlleleEffects
import forestry.core.genetics.IBranchDefinition
import forestry.core.genetics.alleles.AlleleHelper
import forestry.core.genetics.alleles.EnumAllele
import java.util.*

enum class BeeBranches(scientific: String) : IBranchDefinition {
    ROCK("Petramis") {
        override fun setBranchProperties(alleles: Array<IAllele>) {
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, MBBlocks.FlowerTypeOre)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1)

        }
    },
    METAL("Metalis") {
        override fun setBranchProperties(alleles: Array<IAllele>) {

            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, MBBlocks.FlowerTypeOre)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
        }
    },
    CRYSTAL("Crystalis") {
        override fun setBranchProperties(alleles: Array<IAllele>) {


            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, MBBlocks.FlowerTypeOre)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONG)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)

        }
    },
    EARTH("Terris") {
        override fun setBranchProperties(alleles: Array<IAllele>) {

            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, EnumAllele.Flowers.VANILLA)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
        }
    },
    RADIOACTIVE("Radioactivis") {
        override fun setBranchProperties(alleles: Array<IAllele>) {

            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, MBBlocks.FlowerTypeUranium)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.LARGE)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONG)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.EFFECT, MBBlocks.effectRadiation)
        }
    },
    APOCALYTIC("Apocalytus") {
        override fun setBranchProperties(alleles: Array<IAllele>) {

            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, MBBlocks.FlowerTypeTNT)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.LARGER)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONG)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_2)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_4)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.EFFECT, AlleleEffects.effectCreeper)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.EFFECT, AlleleEffects.effectIgnition)
        }
    },
    AQUATIC("Aqus") {
        override fun setBranchProperties(alleles: Array<IAllele>) {
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, MBBlocks.FlowerTypeWater)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, false)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_3)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_1)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.CAVE_DWELLING, false)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.AVERAGE)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TOLERATES_RAIN, true)
        }
    },
    WITHER("Witherris") {
        override fun setBranchProperties(alleles: Array<IAllele>) {
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, EnumAllele.Flowers.NETHER)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.CAVE_DWELLING, true)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.LARGEST)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONGER)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_3)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_5)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.EFFECT, MBBlocks.effectWither)
        }
    },
    SLIME("Slimeus") {
        override fun setBranchProperties(alleles: Array<IAllele>) {

            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, MBBlocks.FlowerTypeSlime)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.CAVE_DWELLING, false)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.AVERAGE)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.NORMAL)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_1)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
            AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.EFFECT, MBBlocks.effectSlimy)
        }
    };

    private val branch: IClassification

    init {
        branch = getOrCreateBranch(name.toLowerCase(Locale.ENGLISH), scientific)
    }

    private fun getOrCreateBranch(uid: String, scientific: String): IClassification {
        var fetchBranch: IClassification? = AlleleManager.alleleRegistry.getClassification("genus.bees.$uid")
        if (fetchBranch == null) {
            fetchBranch = BeeManager.beeFactory!!.createBranch(uid, scientific)
            MBCore.LOGGER.info(AlleleManager.alleleRegistry.registeredClassifications.keys)
            val parent = AlleleManager.alleleRegistry.createAndRegisterClassification(IClassification.EnumClassLevel.GENUS, uid, scientific)
            parent.addMemberGroup(fetchBranch!!)
        }
        return fetchBranch
    }

    protected open fun setBranchProperties(template: Array<IAllele>) {
        // ignored
    }

    override fun getTemplate(): Array<IAllele> {
        val template: Array<IAllele> = defaultTemplate
        setBranchProperties(template)
        return template
    }

    override fun getBranch(): IClassification {
        return branch
    }

    private val defaultTemplate: Array<IAllele> = arrayOf()
        get() {
            if (field.isEmpty()) {
                val template: Array<IAllele?> = arrayOfNulls(EnumBeeChromosome.values().size)

                AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST)
                AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.SHORTER)
                AlleleHelper.getInstance().set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL)
                AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.NONE)
                AlleleHelper.getInstance().set(template, EnumBeeChromosome.NEVER_SLEEPS, false)
                AlleleHelper.getInstance().set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.NONE)
                AlleleHelper.getInstance().set(template, EnumBeeChromosome.TOLERATES_RAIN, false)
                AlleleHelper.getInstance().set(template, EnumBeeChromosome.CAVE_DWELLING, false)
                AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, EnumAllele.Flowers.VANILLA)
                AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.SLOWEST)
                AlleleHelper.getInstance().set(template, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.AVERAGE)
                AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectNone)
                return Arrays.copyOf(template, template.size)
            }
            return Arrays.copyOf(field, field.size)
        }

}