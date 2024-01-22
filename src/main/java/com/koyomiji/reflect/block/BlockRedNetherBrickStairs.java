package com.koyomiji.reflect.block;

import com.koyomiji.reflect.ReFlect;
import com.koyomiji.reflect.util.I18nUtil;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

public class BlockRedNetherBrickStairs extends BlockStairs {
  public BlockRedNetherBrickStairs(IBlockState blockState, String id,
                                   String translationKey) {
    super(blockState);

    this.useNeighborBrightness = true;

    setRegistryName(ReFlect.MODID, id);
    setTranslationKey(I18nUtil.join(ReFlect.MODID, translationKey));
  }

  public static class Default extends BlockRedNetherBrickStairs {
    public Default(String id, String translationKey) {
      super(Blocks.RED_NETHER_BRICK.getDefaultState(), id, translationKey);
    }

    public Default(String id) { this(id, id); }
  }
}
