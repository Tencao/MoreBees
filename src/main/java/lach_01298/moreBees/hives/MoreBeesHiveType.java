package lach_01298.moreBees.hives;

import java.util.Locale;


import lach_01298.moreBees.MoreBees;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;


public enum MoreBeesHiveType implements IStringSerializable {
	ROCK(MoreBees.MOD_ID + ":rock", MoreBees.MOD_ID + ".speciesRock");


	public static final MoreBeesHiveType[] VALUES = values();

	@Nonnull
	private final String hiveUid;
	@Nonnull
	private final String speciesUid;

	MoreBeesHiveType(@Nonnull String hiveUid, @Nonnull String speciesUid) {
		this.hiveUid = hiveUid;
		this.speciesUid = speciesUid;
	}

	@Nonnull
	public String getHiveUid() {
		return hiveUid;
	}

	@Nonnull
	public String getSpeciesUid() {
		return speciesUid;
	}

	@Override
	public String getName() {
		return name().toLowerCase(Locale.ENGLISH);
	}

	public int getMeta() {
		return ordinal();
	}

}
