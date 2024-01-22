package com.koyomiji.reflect.block;

import com.koyomiji.reflect.ReFlect;
import com.koyomiji.reflect.ReFlectItems;
import com.koyomiji.reflect.util.I18nUtil;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BlockStandingSign
    extends net.minecraft.block.BlockStandingSign {
  public BlockStandingSign(String id, String translationKey) {
    super();

    setHardness(1.0F);
    setSoundType(net.minecraft.block.SoundType.WOOD);
    disableStats();

    setRegistryName(ReFlect.MODID, id);
    setTranslationKey(I18nUtil.join(ReFlect.MODID, translationKey));
  }

  public static class Spruce extends BlockStandingSign {
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

  public static class Birch extends BlockStandingSign {
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

  public static class Jungle extends BlockStandingSign {
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

  public static class Acacia extends BlockStandingSign {
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

  public static class DarkOak extends BlockStandingSign {
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
