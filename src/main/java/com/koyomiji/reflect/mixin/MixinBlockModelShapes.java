package com.koyomiji.reflect.mixin;

import com.koyomiji.reflect.ReFlect;
import com.koyomiji.reflect.ReFlectBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockModelShapes.class)
public abstract class MixinBlockModelShapes {
  @Shadow public abstract IBakedModel getModelForState(IBlockState state);

  @Shadow @Final private ModelManager modelManager;

  // For destroy particles
  @Inject(method = "getTexture", at = @At("HEAD"), cancellable = true)
  private void getTexture(IBlockState state,
                          CallbackInfoReturnable<TextureAtlasSprite> cir) {
    Block block = state.getBlock();

    if (block == ReFlectBlocks.SPRUCE_WALL_SIGN ||
        block == ReFlectBlocks.SPRUCE_STANDING_SIGN) {
      cir.setReturnValue(this.modelManager.getTextureMap().getAtlasSprite(
          "minecraft:blocks/planks_spruce"));
    } else if (block == ReFlectBlocks.BIRCH_WALL_SIGN ||
               block == ReFlectBlocks.BIRCH_STANDING_SIGN) {
      cir.setReturnValue(this.modelManager.getTextureMap().getAtlasSprite(
          "minecraft:blocks/planks_birch"));
    } else if (block == ReFlectBlocks.JUNGLE_WALL_SIGN ||
               block == ReFlectBlocks.JUNGLE_STANDING_SIGN) {
      cir.setReturnValue(this.modelManager.getTextureMap().getAtlasSprite(
          "minecraft:blocks/planks_jungle"));
    } else if (block == ReFlectBlocks.ACACIA_WALL_SIGN ||
               block == ReFlectBlocks.ACACIA_STANDING_SIGN) {
      cir.setReturnValue(this.modelManager.getTextureMap().getAtlasSprite(
          "minecraft:blocks/planks_acacia"));
    } else if (block == ReFlectBlocks.DARK_OAK_WALL_SIGN ||
               block == ReFlectBlocks.DARK_OAK_STANDING_SIGN) {
      cir.setReturnValue(this.modelManager.getTextureMap().getAtlasSprite(
          "minecraft:blocks/planks_big_oak"));
    }
  }
}
