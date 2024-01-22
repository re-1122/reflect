package com.koyomiji.reflect.type;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

public enum NetherBrickType implements IStringSerializable {
  DEFAULT(0, MapColor.NETHERRACK, "nether_brick", "default");

  private static final NetherBrickType[] META_LOOKUP =
      new NetherBrickType[values().length];
  private final int meta;
  private final String name;
  private final String translationKey;
  private final MapColor mapColor;

  NetherBrickType(int meta, MapColor mapColor, String name) {
    this(meta, mapColor, name, name);
  }

  NetherBrickType(int meta, MapColor mapColor, String name,
                  String translationKey) {
    this.meta = meta;
    this.name = name;
    this.translationKey = translationKey;
    this.mapColor = mapColor;
  }

  public int getMetadata() { return this.meta; }

  public MapColor getMapColor() { return this.mapColor; }

  public String toString() { return this.name; }

  public static NetherBrickType byMetadata(int meta) {
    if (meta < 0 || meta >= META_LOOKUP.length || META_LOOKUP[meta] == null) {
      meta = 0;
    }

    return META_LOOKUP[meta];
  }

  public String getName() { return this.name; }

  public String getTranslationKey() { return this.translationKey; }

  static {
    for (NetherBrickType type : values()) {
      META_LOOKUP[type.getMetadata()] = type;
    }
  }
}