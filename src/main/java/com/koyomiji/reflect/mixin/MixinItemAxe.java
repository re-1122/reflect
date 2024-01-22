package com.koyomiji.reflect.mixin;

import com.koyomiji.reflect.ReFlectBlocks;
import com.koyomiji.reflect.ReFlectSoundEvents;
import com.koyomiji.reflect.block.BlockStrippedWood;
import com.koyomiji.reflect.block.BlockStrippedWood2;
import java.util.Set;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemAxe.class)
public class MixinItemAxe extends ItemTool {
  protected MixinItemAxe(float attackDamageIn, float attackSpeedIn,
                         ToolMaterial materialIn,
                         Set<Block> effectiveBlocksIn) {
    super(attackDamageIn, attackSpeedIn, materialIn, effectiveBlocksIn);
  }

  public EnumActionResult onItemUse(EntityPlayer player, World worldIn,
                                    BlockPos pos, EnumHand hand,
                                    EnumFacing facing, float hitX, float hitY,
                                    float hitZ) {
    ItemStack stack = player.getHeldItem(hand);

    if (!player.canPlayerEdit(pos.offset(facing), facing, stack)) {
      return EnumActionResult.FAIL;
    }

    IBlockState state = worldIn.getBlockState(pos);
    Block block = state.getBlock();

    if (block == Blocks.LOG || block == Blocks.LOG2 ||
        block == ReFlectBlocks.WOOD || block == ReFlectBlocks.WOOD2) {
      IBlockState newState = null;

      if (block == Blocks.LOG) {
        newState = ReFlectBlocks.STRIPPED_LOG.getDefaultState();
        newState = newState
                       .withProperty(BlockOldLog.VARIANT,
                                     state.getValue(BlockOldLog.VARIANT))
                       .withProperty(BlockOldLog.LOG_AXIS,
                                     state.getValue(BlockOldLog.LOG_AXIS));
      } else if (block == Blocks.LOG2) {
        newState = ReFlectBlocks.STRIPPED_LOG2.getDefaultState();
        newState = newState
                       .withProperty(BlockNewLog.VARIANT,
                                     state.getValue(BlockNewLog.VARIANT))
                       .withProperty(BlockNewLog.LOG_AXIS,
                                     state.getValue(BlockNewLog.LOG_AXIS));
      } else if (block == ReFlectBlocks.WOOD) {
        newState = ReFlectBlocks.STRIPPED_WOOD.getDefaultState();
        newState =
            newState.withProperty(BlockStrippedWood.VARIANT,
                                  state.getValue(BlockStrippedWood.VARIANT));
      } else if (block == ReFlectBlocks.WOOD2) {
        newState = ReFlectBlocks.STRIPPED_WOOD2.getDefaultState();
        newState =
            newState.withProperty(BlockStrippedWood2.VARIANT,
                                  state.getValue(BlockStrippedWood2.VARIANT));
      }

      worldIn.playSound(player, pos, ReFlectSoundEvents.ITEM_AXE_STRIP,
                        SoundCategory.BLOCKS, 1.0F, 1.0F);

      if (!worldIn.isRemote) {
        worldIn.setBlockState(pos, newState, 11);
        stack.damageItem(1, player);
      }

      return EnumActionResult.SUCCESS;
    } else {
      return EnumActionResult.PASS;
    }
  }
}
