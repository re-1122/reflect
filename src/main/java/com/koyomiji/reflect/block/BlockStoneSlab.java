package com.koyomiji.reflect.block;

import com.koyomiji.reflect.ReFlect;
import com.koyomiji.reflect.ReFlectBlocks;
import com.koyomiji.reflect.type.StoneType;
import com.koyomiji.reflect.util.I18nUtil;
import java.util.Random;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStone;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockStoneSlab extends BlockSlab {
  public static final PropertyEnum<StoneType> VARIANT =
      PropertyEnum.create("variant", StoneType.class);

  public BlockStoneSlab(String id, String translationKey) {
    super(Material.ROCK);
    IBlockState state = this.blockState.getBaseState();

    if (!this.isDouble()) {
      state = state.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
    }

    this.setDefaultState(state.withProperty(VARIANT, StoneType.STONE));
    this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

    this.useNeighborBrightness = true;

    this.setHardness(2.0F);
    this.setResistance(10.0F);
    this.setSoundType(SoundType.STONE);

    setRegistryName(ReFlect.MODID, id);
    setTranslationKey(I18nUtil.join(ReFlect.MODID, translationKey));
  }

  public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    return Item.getItemFromBlock(ReFlectBlocks.STONE_SLAB3);
  }

  public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
    return new ItemStack(ReFlectBlocks.STONE_SLAB3, 1,
                         (state.getValue(VARIANT)).getMetadata());
  }

  public String getTranslationKey(int meta) {
    return super.getTranslationKey() + "." +
        StoneType.byMetadata(meta).getTranslationKey();
  }

  public IProperty<?> getVariantProperty() { return VARIANT; }

  public Comparable<?> getTypeForItem(ItemStack stack) {
    return StoneType.byMetadata(stack.getMetadata() & 7);
  }

  public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
    for (StoneType type : StoneType.values()) {
      items.add(new ItemStack(this, 1, type.getMetadata()));
    }
  }

  public IBlockState getStateFromMeta(int meta) {
    IBlockState state = this.getDefaultState().withProperty(
        VARIANT, StoneType.byMetadata(meta & 7));

    if (!this.isDouble()) {
      state = state.withProperty(HALF, (meta & 8) == 0
                                           ? BlockSlab.EnumBlockHalf.BOTTOM
                                           : BlockSlab.EnumBlockHalf.TOP);
    }

    return state;
  }

  public int getMetaFromState(IBlockState state) {
    int meta = 0;
    meta = meta | (state.getValue(VARIANT)).getMetadata();

    if (!this.isDouble() &&
        state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP) {
      meta |= 8;
    }

    return meta;
  }

  protected BlockStateContainer createBlockState() {
    return this.isDouble() ? new BlockStateContainer(this, VARIANT)
                           : new BlockStateContainer(this, HALF, VARIANT);
  }

  public int damageDropped(IBlockState state) {
    return (state.getValue(VARIANT)).getMetadata();
  }

  public MapColor getMapColor(IBlockState state, IBlockAccess worldIn,
                              BlockPos pos) {
    return (state.getValue(VARIANT)).getMapColor();
  }

  public static class Double extends BlockStoneSlab {
    public Double(String id, String translationKey) {
      super(id, translationKey);
    }

    public Double(String id) { this(id, id); }

    @Override
    public boolean isDouble() {
      return true;
    }
  }

  public static class Half extends BlockStoneSlab {
    public Half(String id, String translationKey) { super(id, translationKey); }

    public Half(String id) { this(id, id); }

    @Override
    public boolean isDouble() {
      return false;
    }
  }
}
