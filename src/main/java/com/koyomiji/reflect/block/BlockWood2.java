package com.koyomiji.reflect.block;

import com.google.common.base.Predicate;
import com.koyomiji.reflect.ReFlect;
import javax.annotation.Nullable;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.MapColor;
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

public class BlockWood2 extends BlockNewLog {
  public BlockWood2(String id, String translationKey) {
    setDefaultState(this.blockState.getBaseState()
                        .withProperty(VARIANT, BlockPlanks.EnumType.ACACIA)
                        .withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));

    setRegistryName(ReFlect.MODID, id);
    setTranslationKey(ReFlect.MODID + "." + translationKey);
  }

  public BlockWood2(String id) { this(id, id); }

  @Override
  public MapColor getMapColor(IBlockState state, IBlockAccess worldIn,
                              BlockPos pos) {
    return state.getValue(VARIANT).getMapColor();
  }
}
