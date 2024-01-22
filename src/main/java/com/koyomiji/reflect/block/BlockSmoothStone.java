package com.koyomiji.reflect.block;

import com.koyomiji.reflect.ReFlect;
import com.koyomiji.reflect.ReFlectBlocks;
import com.koyomiji.reflect.type.SmoothStoneType;
import com.koyomiji.reflect.util.I18nUtil;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;

public class BlockSmoothStone extends Block {
  public static final PropertyEnum<SmoothStoneType> VARIANT =
      PropertyEnum.create("variant", SmoothStoneType.class);

  public BlockSmoothStone(String id, String translationKey) {
    super(Material.ROCK);
    setDefaultState(this.blockState.getBaseState().withProperty(
        VARIANT, SmoothStoneType.STONE));
    setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

    setHardness(2.0F);
    setResistance(10.0F);
    setSoundType(SoundType.STONE);

    setRegistryName(ReFlect.MODID, id);
    setTranslationKey(I18nUtil.join(ReFlect.MODID, translationKey));
  }

  public BlockSmoothStone(String id) { this(id, id); }

  @Override
  public MapColor getMapColor(IBlockState state, IBlockAccess worldIn,
                              BlockPos pos) {
    return (state.getValue(VARIANT)).getMapColor();
  }

  @Override
  public Item getItemDropped(IBlockState state, java.util.Random rand,
                             int fortune) {
    return Item.getItemFromBlock(ReFlectBlocks.SMOOTH_STONE);
  }

  @Override
  public int damageDropped(IBlockState state) {
    return (state.getValue(VARIANT)).getMetadata();
  }

  @Override
  public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
    for (SmoothStoneType type : SmoothStoneType.values()) {
      items.add(new ItemStack(this, 1, type.getMetadata()));
    }
  }

  @Override
  public IBlockState getStateFromMeta(int meta) {
    return this.getDefaultState().withProperty(
        VARIANT, SmoothStoneType.byMetadata(meta));
  }

  @Override
  public int getMetaFromState(IBlockState state) {
    return (state.getValue(VARIANT)).getMetadata();
  }

  @Override
  protected BlockStateContainer createBlockState() {
    return new BlockStateContainer(this, VARIANT);
  }
}
