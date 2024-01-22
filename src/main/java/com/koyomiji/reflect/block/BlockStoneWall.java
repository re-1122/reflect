package com.koyomiji.reflect.block;

import com.koyomiji.reflect.ReFlect;
import com.koyomiji.reflect.type.StoneType;
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

public class BlockStoneWall extends BlockWall {
  public static final PropertyEnum<StoneType> VARIANT = PropertyEnum.create(
      "variant", StoneType.class,
      (type)
          -> type == StoneType.GRANITE || type == StoneType.DIORITE ||
                 type == StoneType.ANDESITE);

  public BlockStoneWall(String id, String translationKey) {
    super(Blocks.STONE);

    this.setDefaultState(this.blockState.getBaseState()
                             .withProperty(UP, Boolean.valueOf(false))
                             .withProperty(NORTH, Boolean.valueOf(false))
                             .withProperty(EAST, Boolean.valueOf(false))
                             .withProperty(SOUTH, Boolean.valueOf(false))
                             .withProperty(WEST, Boolean.valueOf(false))
                             .withProperty(VARIANT, StoneType.GRANITE));

    setRegistryName(ReFlect.MODID, id);
    setTranslationKey(I18nUtil.join(ReFlect.MODID, translationKey));
  }

  public BlockStoneWall(String id) { this(id, id); }

  public String getLocalizedName() {
    return I18n.translateToLocal(this.getTranslationKey() + ".name");
  }

  public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
    items.add(new ItemStack(this, 1, StoneType.GRANITE.getMetadata()));
    items.add(new ItemStack(this, 1, StoneType.DIORITE.getMetadata()));
    items.add(new ItemStack(this, 1, StoneType.ANDESITE.getMetadata()));
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
                                               StoneType.byMetadata(meta));
  }

  public int getMetaFromState(IBlockState state) {
    return (state.getValue(VARIANT)).getMetadata();
  }

  protected BlockStateContainer createBlockState() {
    return new BlockStateContainer(this, UP, NORTH, EAST, WEST, SOUTH, VARIANT);
  }
}
