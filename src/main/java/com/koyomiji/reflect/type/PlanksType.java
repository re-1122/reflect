package com.koyomiji.reflect.type;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

public enum PlanksType implements IStringSerializable {
  OAK(0, MapColor.WOOD, "oak"),
  SPRUCE(1, MapColor.OBSIDIAN, "spruce"),
  BIRCH(2, MapColor.SAND, "birch"),
  JUNGLE(3, MapColor.DIRT, "jungle"),
  ACACIA(4, MapColor.ADOBE, "acacia"),
  DARK_OAK(5, MapColor.BROWN, "dark_oak");

  private static final PlanksType[] META_LOOKUP =
      new PlanksType[values().length];
  private final int meta;
  private final String name;
  private final String translationKey;
  private final MapColor mapColor;

  PlanksType(int meta, MapColor mapColor, String name) {
    this(meta, mapColor, name, name);
  }

  PlanksType(int meta, MapColor mapColor, String name, String translationKey) {
    this.meta = meta;
    this.name = name;
    this.translationKey = translationKey;
    this.mapColor = mapColor;
  }

  public int getMetadata() { return this.meta; }

  public MapColor getMapColor() { return this.mapColor; }

  public String toString() { return this.name; }

  public static PlanksType byMetadata(int meta) {
    if (meta < 0 || meta >= META_LOOKUP.length || META_LOOKUP[meta] == null) {
      meta = 0;
    }

    return META_LOOKUP[meta];
  }

  public String getName() { return this.name; }

  public String getTranslationKey() { return this.translationKey; }

  static {
    for (PlanksType type : values()) {
      META_LOOKUP[type.getMetadata()] = type;
    }
  }
}