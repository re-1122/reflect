package com.koyomiji.reflect.block;

import com.koyomiji.reflect.ReFlect;
import com.koyomiji.reflect.util.I18nUtil;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockStrippedWood extends BlockOldLog {
  public BlockStrippedWood(String id, String translationKey) {
    setRegistryName(ReFlect.MODID, id);
    setTranslationKey(I18nUtil.join(ReFlect.MODID, translationKey));
  }

  public BlockStrippedWood(String id) { this(id, id); }

  @Override
  public MapColor getMapColor(IBlockState state, IBlockAccess worldIn,
                              BlockPos pos) {
    BlockPlanks.EnumType type = state.getValue(VARIANT);

    switch (type) {
    case OAK:
    default:
      return MapColor.WOOD;
    case SPRUCE:
      return MapColor.OBSIDIAN;
    case BIRCH:
      return MapColor.SAND;
    case JUNGLE:
      return MapColor.DIRT;
    }
  }
}
