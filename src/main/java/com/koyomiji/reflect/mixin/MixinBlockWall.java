package com.koyomiji.reflect.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockWall.class)
public class MixinBlockWall extends Block {
  @Shadow @Final public static PropertyEnum<BlockWall.EnumType> VARIANT;

  public MixinBlockWall(Material blockMaterialIn, MapColor blockMapColorIn) {
    super(blockMaterialIn, blockMapColorIn);
  }

  @Redirect(
      method = "<init>",
      at = @At(
          value = "INVOKE",
          target =
              "Lnet/minecraft/block/state/IBlockState;withProperty(Lnet/minecraft/block/properties/IProperty;Ljava/lang/Comparable;)Lnet/minecraft/block/state/IBlockState;",
          ordinal = 5))
  private IBlockState
  withProperty(IBlockState instance, IProperty property, Comparable value) {
    if (this.blockState.getProperty("variant") != VARIANT) {
      return instance;
    }

    return instance.withProperty(property, value);
  }
}
