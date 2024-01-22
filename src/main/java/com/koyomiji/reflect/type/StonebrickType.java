package com.koyomiji.reflect.type;

import com.koyomiji.reflect.block.BlockStonebrickSlab;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

public enum StonebrickType implements IStringSerializable {
  DEFAULT(0, MapColor.STONE, "stone_brick", "default"),
  MOSSY(1, MapColor.STONE, "mossy_stone_brick", "mossy"),
  CRACKED(2, MapColor.STONE, "cracked_stone_brick", "cracked"),
  CHISELED(3, MapColor.STONE, "chiseled_stone_brick", "chiseled");

  private static final StonebrickType[] META_LOOKUP =
      new StonebrickType[values().length];
  private final int meta;
  private final String name;
  private final String translationKey;
  private final MapColor mapColor;

  StonebrickType(int meta, MapColor mapColor, String name) {
    this(meta, mapColor, name, name);
  }

  StonebrickType(int meta, MapColor mapColor, String name,
                 String translationKey) {
    this.meta = meta;
    this.name = name;
    this.translationKey = translationKey;
    this.mapColor = mapColor;
  }

  public int getMetadata() { return this.meta; }

  public MapColor getMapColor() { return this.mapColor; }

  public String toString() { return this.name; }

  public static StonebrickType byMetadata(int meta) {
    if (meta < 0 || meta >= META_LOOKUP.length || META_LOOKUP[meta] == null) {
      meta = 0;
    }

    return META_LOOKUP[meta];
  }

  public String getName() { return this.name; }

  public String getTranslationKey() { return this.translationKey; }

  static {
    for (StonebrickType type : values()) {
      META_LOOKUP[type.getMetadata()] = type;
    }
  }
}