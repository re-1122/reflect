package com.koyomiji.reflect.block;

import com.koyomiji.reflect.ReFlect;
import com.koyomiji.reflect.ReFlectItems;
import com.koyomiji.reflect.util.I18nUtil;
import java.util.Random;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BlockWallSign extends net.minecraft.block.BlockWallSign {
  public BlockWallSign(String id, String translationKey) {
    super();

    setHardness(1.0F);
    setSoundType(SoundType.WOOD);
    disableStats();

    setRegistryName(ReFlect.MODID, id);
    setTranslationKey(I18nUtil.join(ReFlect.MODID, translationKey));
  }

  public static class Spruce extends BlockWallSign {
    public Spruce(String id, String translationKey) {
      super(id, translationKey);
    }

    public Spruce(String id) { this(id, id); }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
      return ReFlectItems.SPRUCE_SIGN;
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
      return new ItemStack(ReFlectItems.SPRUCE_SIGN);
    }
  }

  public static class Birch extends BlockWallSign {
    public Birch(String id, String translationKey) {
      super(id, translationKey);
    }

    public Birch(String id) { this(id, id); }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
      return ReFlectItems.BIRCH_SIGN;
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
      return new ItemStack(ReFlectItems.BIRCH_SIGN);
    }
  }

  public static class Jungle extends BlockWallSign {
    public Jungle(String id, String translationKey) {
      super(id, translationKey);
    }

    public Jungle(String id) { this(id, id); }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
      return ReFlectItems.JUNGLE_SIGN;
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
      return new ItemStack(ReFlectItems.JUNGLE_SIGN);
    }
  }

  public static class Acacia extends BlockWallSign {
    public Acacia(String id, String translationKey) {
      super(id, translationKey);
    }

    public Acacia(String id) { this(id, id); }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
      return ReFlectItems.ACACIA_SIGN;
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
      return new ItemStack(ReFlectItems.ACACIA_SIGN);
    }
  }

  public static class DarkOak extends BlockWallSign {
    public DarkOak(String id, String translationKey) {
      super(id, translationKey);
    }

    public DarkOak(String id) { this(id, id); }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
      return ReFlectItems.DARK_OAK_SIGN;
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
      return new ItemStack(ReFlectItems.DARK_OAK_SIGN);
    }
  }
}
