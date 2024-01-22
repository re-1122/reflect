package com.koyomiji.reflect.type;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

public enum PrismarineType implements IStringSerializable {
  ROUGH(0, MapColor.CYAN, "prismarine", "rough"),
  BRICK(1, MapColor.DIAMOND, "prismarine_brick", "brick"),
  DARK(2, MapColor.DIAMOND, "dark_prismarine", "dark");

  private static final PrismarineType[] META_LOOKUP =
      new PrismarineType[values().length];
  private final int meta;
  private final String name;
  private final String translationKey;
  private final MapColor mapColor;

  PrismarineType(int meta, MapColor mapColor, String name) {
    this(meta, mapColor, name, name);
  }

  PrismarineType(int meta, MapColor mapColor, String name,
                 String translationKey) {
    this.meta = meta;
    this.name = name;
    this.translationKey = translationKey;
    this.mapColor = mapColor;
  }

  public int getMetadata() { return this.meta; }

  public MapColor getMapColor() { return this.mapColor; }

  public String toString() { return this.name; }

  public static PrismarineType byMetadata(int meta) {
    if (meta < 0 || meta >= META_LOOKUP.length || META_LOOKUP[meta] == null) {
      meta = 0;
    }

    return META_LOOKUP[meta];
  }

  public String getName() { return this.name; }

  public String getTranslationKey() { return this.translationKey; }

  static {
    for (PrismarineType type : values()) {
      META_LOOKUP[type.getMetadata()] = type;
    }
  }
}