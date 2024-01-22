package com.koyomiji.reflect.mixin;

import com.koyomiji.reflect.ReFlect;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStandingSign;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntitySign;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiEditSign.class)
public class MixinGuiEditSign {
  @Shadow @Final private TileEntitySign tileSign;

  @ModifyVariable(method = "drawScreen", at = @At(value = "LOAD", ordinal = 0),
                  name = "block")
  private Block
  mixin(Block block) {
    if (block instanceof BlockStandingSign) {
      return Blocks.STANDING_SIGN;
    }

    return null;
  }
}
