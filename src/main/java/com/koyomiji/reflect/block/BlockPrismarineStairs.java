package com.koyomiji.reflect.block;

import com.koyomiji.reflect.ReFlect;
import com.koyomiji.reflect.util.I18nUtil;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.block.BlockStairs;
import net.minecraft.init.Blocks;

public abstract class BlockPrismarineStairs extends BlockStairs {
  public BlockPrismarineStairs(BlockPrismarine.EnumType type, String id,
                               String translationKey) {
    super(Blocks.PRISMARINE.getDefaultState().withProperty(
        BlockPrismarine.VARIANT, type));

    this.useNeighborBrightness = true;

    setRegistryName(ReFlect.MODID, id);
    setTranslationKey(I18nUtil.join(ReFlect.MODID, translationKey));
  }

  public static class Rough extends BlockPrismarineStairs {
    public Rough(String id, String translationKey) {
      super(BlockPrismarine.EnumType.ROUGH, id, translationKey);
    }

    public Rough(String id) { this(id, id); }
  }

  public static class Brick extends BlockPrismarineStairs {
    public Brick(String id, String translationKey) {
      super(BlockPrismarine.EnumType.BRICKS, id, translationKey);
    }

    public Brick(String id) { this(id, id); }
  }

  public static class Dark extends BlockPrismarineStairs {
    public Dark(String id, String translationKey) {
      super(BlockPrismarine.EnumType.DARK, id, translationKey);
    }

    public Dark(String id) { this(id, id); }
  }
}
