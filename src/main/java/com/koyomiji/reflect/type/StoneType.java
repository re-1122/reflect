package com.koyomiji.reflect.type;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

public enum StoneType implements IStringSerializable {
  STONE(0, MapColor.STONE, "stone"),
  GRANITE(1, MapColor.DIRT, "granite"),
  GRANITE_SMOOTH(2, MapColor.DIRT, "smooth_granite", "polished_granite"),
  DIORITE(3, MapColor.QUARTZ, "diorite"),
  DIORITE_SMOOTH(4, MapColor.QUARTZ, "smooth_diorite", "polished_diorite"),
  ANDESITE(5, MapColor.STONE, "andesite"),
  ANDESITE_SMOOTH(6, MapColor.STONE, "smooth_andesite", "polished_andesite");

  private static final StoneType[] META_LOOKUP = new StoneType[values().length];
  private final int meta;
  private final String name;
  private final String translationKey;
  private final MapColor mapColor;

  StoneType(int meta, MapColor mapColor, String name) {
    this(meta, mapColor, name, name);
  }

  StoneType(int meta, MapColor mapColor, String name, String translationKey) {
    this.meta = meta;
    this.name = name;
    this.translationKey = translationKey;
    this.mapColor = mapColor;
  }

  public int getMetadata() { return this.meta; }

  public MapColor getMapColor() { return this.mapColor; }

  public String toString() { return this.name; }

  public static StoneType byMetadata(int meta) {
    if (meta < 0 || meta >= META_LOOKUP.length || META_LOOKUP[meta] == null) {
      meta = 0;
    }

    return META_LOOKUP[meta];
  }

  public String getName() { return this.name; }

  public String getTranslationKey() { return this.translationKey; }

  static {
    for (StoneType type : values()) {
      META_LOOKUP[type.getMetadata()] = type;
    }
  }
}