package com.koyomiji.reflect.block;

import com.koyomiji.reflect.ReFlect;
import com.koyomiji.reflect.util.I18nUtil;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

public class BlockCobblestoneStairs extends BlockStairs {
  public BlockCobblestoneStairs(IBlockState blockState, String id,
                                String translationKey) {
    super(blockState);

    this.useNeighborBrightness = true;

    setRegistryName(ReFlect.MODID, id);
    setTranslationKey(I18nUtil.join(ReFlect.MODID, translationKey));
  }

  public static class Mossy extends BlockCobblestoneStairs {
    public Mossy(String id, String translationKey) {
      super(Blocks.MOSSY_COBBLESTONE.getDefaultState(), id, translationKey);
    }

    public Mossy(String id) { this(id, id); }
  }
}
