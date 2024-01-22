package com.koyomiji.reflect.type;

import com.koyomiji.reflect.block.BlockSmoothStone;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

public enum SmoothStoneType implements IStringSerializable {
  STONE(0, MapColor.STONE, "smooth_stone", "stone"),
  SANDSTONE(1, MapColor.SAND, "smooth_sandstone", "sandstone"),
  QUARTZ(2, MapColor.QUARTZ, "smooth_quartz", "quartz"),
  RED_SANDSTONE(3, MapColor.ADOBE, "smooth_red_sandstone", "red_sandstone");

  private static final SmoothStoneType[] META_LOOKUP =
      new SmoothStoneType[values().length];
  private final int meta;
  private final String name;
  private final String translationKey;
  private final MapColor mapColor;

  SmoothStoneType(int meta, MapColor mapColor, String name) {
    this(meta, mapColor, name, name);
  }

  SmoothStoneType(int meta, MapColor mapColor, String name,
                  String translationKey) {
    this.meta = meta;
    this.name = name;
    this.translationKey = translationKey;
    this.mapColor = mapColor;
  }

  public int getMetadata() { return this.meta; }

  public MapColor getMapColor() { return this.mapColor; }

  public String toString() { return this.name; }

  public static SmoothStoneType byMetadata(int meta) {
    if (meta < 0 || meta >= META_LOOKUP.length || META_LOOKUP[meta] == null) {
      meta = 0;
    }

    return META_LOOKUP[meta];
  }

  public String getName() { return this.name; }

  public String getTranslationKey() { return this.translationKey; }

  static {
    for (SmoothStoneType type : values()) {
      META_LOOKUP[type.getMetadata()] = type;
    }
  }
}