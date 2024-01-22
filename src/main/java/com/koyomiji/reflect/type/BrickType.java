package com.koyomiji.reflect.type;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

public enum BrickType implements IStringSerializable {
  DEFAULT(0, MapColor.RED, "brick", "default");

  private static final BrickType[] META_LOOKUP = new BrickType[values().length];
  private final int meta;
  private final String name;
  private final String translationKey;
  private final MapColor mapColor;

  BrickType(int meta, MapColor mapColor, String name) {
    this(meta, mapColor, name, name);
  }

  BrickType(int meta, MapColor mapColor, String name, String translationKey) {
    this.meta = meta;
    this.name = name;
    this.translationKey = translationKey;
    this.mapColor = mapColor;
  }

  public int getMetadata() { return this.meta; }

  public MapColor getMapColor() { return this.mapColor; }

  public String toString() { return this.name; }

  public static BrickType byMetadata(int meta) {
    if (meta < 0 || meta >= META_LOOKUP.length || META_LOOKUP[meta] == null) {
      meta = 0;
    }

    return META_LOOKUP[meta];
  }

  public String getName() { return this.name; }

  public String getTranslationKey() { return this.translationKey; }

  static {
    for (BrickType type : values()) {
      META_LOOKUP[type.getMetadata()] = type;
    }
  }
}
