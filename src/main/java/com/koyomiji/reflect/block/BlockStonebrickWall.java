package com.koyomiji.reflect.block;

import com.koyomiji.reflect.ReFlect;
import com.koyomiji.reflect.type.StonebrickType;
import com.koyomiji.reflect.util.I18nUtil;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;

public class BlockStonebrickWall extends BlockWall {
  public static final PropertyEnum<StonebrickType> VARIANT =
      PropertyEnum.create("variant", StonebrickType.class,
                          (type)
                              -> type == StonebrickType.DEFAULT ||
                                     type == StonebrickType.MOSSY);

  public BlockStonebrickWall(String id, String translationKey) {
    super(Blocks.STONEBRICK);

    this.setDefaultState(this.blockState.getBaseState()
                             .withProperty(UP, Boolean.valueOf(false))
                             .withProperty(NORTH, Boolean.valueOf(false))
                             .withProperty(EAST, Boolean.valueOf(false))
                             .withProperty(SOUTH, Boolean.valueOf(false))
                             .withProperty(WEST, Boolean.valueOf(false))
                             .withProperty(VARIANT, StonebrickType.DEFAULT));

    setRegistryName(ReFlect.MODID, id);
    setTranslationKey(I18nUtil.join(ReFlect.MODID, translationKey));
  }

  public BlockStonebrickWall(String id) { this(id, id); }

  public String getLocalizedName() {
    return I18n.translateToLocal(this.getTranslationKey() + ".name");
  }

  public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
    items.add(new ItemStack(this, 1, StonebrickType.DEFAULT.getMetadata()));
    items.add(new ItemStack(this, 1, StonebrickType.MOSSY.getMetadata()));
  }

  public int damageDropped(IBlockState state) {
    return (state.getValue(VARIANT)).getMetadata();
  }

  public MapColor getMapColor(IBlockState state, IBlockAccess worldIn,
                              BlockPos pos) {
    return (state.getValue(VARIANT)).getMapColor();
  }

  public IBlockState getStateFromMeta(int meta) {
    return this.getDefaultState().withProperty(VARIANT,
                                               StonebrickType.byMetadata(meta));
  }

  public int getMetaFromState(IBlockState state) {
    return (state.getValue(VARIANT)).getMetadata();
  }

  protected BlockStateContainer createBlockState() {
    return new BlockStateContainer(this, UP, NORTH, EAST, WEST, SOUTH, VARIANT);
  }
}
