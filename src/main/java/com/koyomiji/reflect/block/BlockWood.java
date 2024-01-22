package com.koyomiji.reflect.block;

import com.koyomiji.reflect.ReFlect;
import com.koyomiji.reflect.util.I18nUtil;
import javax.annotation.Nullable;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockWood extends BlockOldLog {
  public BlockWood(String id, String translationKey) {
    setDefaultState(this.blockState.getBaseState()
                        .withProperty(VARIANT, BlockPlanks.EnumType.OAK)
                        .withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));

    setRegistryName(ReFlect.MODID, id);
    setTranslationKey(I18nUtil.join(ReFlect.MODID, translationKey));
  }

  public BlockWood(String id) { this(id, id); }

  @Override
  public MapColor getMapColor(IBlockState state, IBlockAccess worldIn,
                              BlockPos pos) {
    return state.getValue(VARIANT).getMapColor();
  }
}
