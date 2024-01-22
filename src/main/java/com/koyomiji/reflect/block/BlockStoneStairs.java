package com.koyomiji.reflect.block;

import com.koyomiji.reflect.ReFlect;
import com.koyomiji.reflect.util.I18nUtil;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;

public abstract class BlockStoneStairs extends BlockStairs {
  public BlockStoneStairs(BlockStone.EnumType type, String id,
                          String translationKey) {
    super(
        Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, type));

    this.useNeighborBrightness = true;

    setRegistryName(ReFlect.MODID, id);
    setTranslationKey(I18nUtil.join(ReFlect.MODID, translationKey));
  }

  public static class Stone extends BlockStoneStairs {
    public Stone(String id, String translationKey) {
      super(BlockStone.EnumType.STONE, id, translationKey);
    }

    public Stone(String id) { this(id, id); }
  }

  public static class Granite extends BlockStoneStairs {
    public Granite(String id, String translationKey) {
      super(BlockStone.EnumType.GRANITE, id, translationKey);
    }

    public Granite(String id) { this(id, id); }
  }

  public static class SmoothGranite extends BlockStoneStairs {
    public SmoothGranite(String id, String translationKey) {
      super(BlockStone.EnumType.GRANITE_SMOOTH, id, translationKey);
    }

    public SmoothGranite(String id) { this(id, id); }
  }

  public static class Diorite extends BlockStoneStairs {
    public Diorite(String id, String translationKey) {
      super(BlockStone.EnumType.DIORITE, id, translationKey);
    }

    public Diorite(String id) { this(id, id); }
  }

  public static class SmoothDiorite extends BlockStoneStairs {
    public SmoothDiorite(String id, String translationKey) {
      super(BlockStone.EnumType.DIORITE_SMOOTH, id, translationKey);
    }

    public SmoothDiorite(String id) { this(id, id); }
  }

  public static class Andesite extends BlockStoneStairs {
    public Andesite(String id, String translationKey) {
      super(BlockStone.EnumType.ANDESITE, id, translationKey);
    }

    public Andesite(String id) { this(id, id); }
  }

  public static class SmoothAndesite extends BlockStoneStairs {
    public SmoothAndesite(String id, String translationKey) {
      super(BlockStone.EnumType.ANDESITE_SMOOTH, id, translationKey);
    }

    public SmoothAndesite(String id) { this(id, id); }
  }
}
