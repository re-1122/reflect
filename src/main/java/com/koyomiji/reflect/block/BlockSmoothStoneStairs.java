package com.koyomiji.reflect.block;

import com.koyomiji.reflect.ReFlect;
import com.koyomiji.reflect.ReFlectBlocks;
import com.koyomiji.reflect.type.SmoothStoneType;
import com.koyomiji.reflect.util.I18nUtil;
import net.minecraft.block.BlockStairs;

public class BlockSmoothStoneStairs extends BlockStairs {
  public BlockSmoothStoneStairs(SmoothStoneType type, String id,
                                String translationKey) {
    super(ReFlectBlocks.SMOOTH_STONE.getDefaultState().withProperty(
        BlockSmoothStone.VARIANT, type));

    this.useNeighborBrightness = true;

    setRegistryName(ReFlect.MODID, id);
    setTranslationKey(I18nUtil.join(ReFlect.MODID, translationKey));
  }

  public static class Sandstone extends BlockSmoothStoneStairs {
    public Sandstone(String id, String translationKey) {
      super(SmoothStoneType.SANDSTONE, id, translationKey);
    }

    public Sandstone(String id) { this(id, id); }
  }

  public static class Quartz extends BlockSmoothStoneStairs {
    public Quartz(String id, String translationKey) {
      super(SmoothStoneType.QUARTZ, id, translationKey);
    }

    public Quartz(String id) { this(id, id); }
  }

  public static class RedSandstone extends BlockSmoothStoneStairs {
    public RedSandstone(String id, String translationKey) {
      super(SmoothStoneType.RED_SANDSTONE, id, translationKey);
    }

    public RedSandstone(String id) { this(id, id); }
  }
}
