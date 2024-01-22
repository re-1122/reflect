package com.koyomiji.reflect.type;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

public enum SandstoneType implements IStringSerializable {
  DEFAULT(0, MapColor.SAND, "sandstone", "default"),
  CHISELED(1, MapColor.SAND, "chiseled_sandstone", "chiseled"),
  SMOOTH(2, MapColor.SAND, "smooth_sandstone", "smooth");

  private static final SandstoneType[] META_LOOKUP =
      new SandstoneType[values().length];
  private final int meta;
  private final String name;
  private final String translationKey;
  private final MapColor mapColor;

  SandstoneType(int meta, MapColor mapColor, String name) {
    this(meta, mapColor, name, name);
  }

  SandstoneType(int meta, MapColor mapColor, String name,
                String translationKey) {
    this.meta = meta;
    this.name = name;
    this.translationKey = translationKey;
    this.mapColor = mapColor;
  }

  public int getMetadata() { return this.meta; }

  public MapColor getMapColor() { return this.mapColor; }

  public String toString() { return this.name; }

  public static SandstoneType byMetadata(int meta) {
    if (meta < 0 || meta >= META_LOOKUP.length || META_LOOKUP[meta] == null) {
      meta = 0;
    }

    return META_LOOKUP[meta];
  }

  public String getName() { return this.name; }

  public String getTranslationKey() { return this.translationKey; }

  static {
    for (SandstoneType type : values()) {
      META_LOOKUP[type.getMetadata()] = type;
    }
  }
}