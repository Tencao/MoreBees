package com.tencao.morebees.hives

import com.tencao.morebees.MBCore
import net.minecraft.util.IStringSerializable
import java.util.*

enum class HiveTypes (val hiveUid: String) : IStringSerializable {
    ROCK(MBCore.MODID + ":rock");

    val meta: Int
        get() = ordinal

    override fun getName(): String {
        return name.toLowerCase(Locale.ENGLISH)
    }

}
