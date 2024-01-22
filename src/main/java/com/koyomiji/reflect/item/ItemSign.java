package com.koyomiji.reflect.item;

import com.koyomiji.reflect.ReFlect;
import com.koyomiji.reflect.ReFlectBlocks;
import com.koyomiji.reflect.util.I18nUtil;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockStandingSign;
import net.minecraft.block.BlockWallSign;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemSign extends net.minecraft.item.ItemSign {
  private BlockStandingSign standingSign;
  private BlockWallSign wallSign;

  public ItemSign(BlockStandingSign standingSign, BlockWallSign wallSign,
                  String id, String translationKey) {
    this.standingSign = standingSign;
    this.wallSign = wallSign;

    setRegistryName(ReFlect.MODID, id);
    setTranslationKey(I18nUtil.join(ReFlect.MODID, translationKey));
  }

  public EnumActionResult onItemUse(EntityPlayer player, World worldIn,
                                    BlockPos pos, EnumHand hand,
                                    EnumFacing facing, float hitX, float hitY,
                                    float hitZ) {
    IBlockState blockstate = worldIn.getBlockState(pos);
    boolean replaceable = blockstate.getBlock().isReplaceable(worldIn, pos);

    if (facing != EnumFacing.DOWN &&
        (blockstate.getMaterial().isSolid() || replaceable) &&
        (!replaceable || facing == EnumFacing.UP)) {
      pos = pos.offset(facing);
      ItemStack heldStack = player.getHeldItem(hand);

      if (player.canPlayerEdit(pos, facing, heldStack) &&
          standingSign.canPlaceBlockAt(worldIn, pos)) {
        if (worldIn.isRemote) {
          return EnumActionResult.SUCCESS;
        } else {
          pos = replaceable ? pos.down() : pos;

          if (facing == EnumFacing.UP) {
            int angle =
                MathHelper.floor(
                    (double)((player.rotationYaw + 180.0F) * 16.0F / 360.0F) +
                    0.5D) &
                15;
            worldIn.setBlockState(
                pos,
                standingSign.getDefaultState().withProperty(
                    BlockStandingSign.ROTATION, Integer.valueOf(angle)),
                11);
          } else {
            worldIn.setBlockState(pos,
                                  wallSign.getDefaultState().withProperty(
                                      BlockWallSign.FACING, facing),
                                  11);
          }

          TileEntity tileEntity = worldIn.getTileEntity(pos);

          if (tileEntity instanceof TileEntitySign &&
              !ItemBlock.setTileEntityNBT(worldIn, player, pos, heldStack)) {
            player.openEditSign((TileEntitySign)tileEntity);
          }

          if (player instanceof EntityPlayerMP) {
            CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos,
                                                  heldStack);
          }

          heldStack.shrink(1);
          return EnumActionResult.SUCCESS;
        }
      } else {
        return EnumActionResult.FAIL;
      }
    } else {
      return EnumActionResult.FAIL;
    }
  }

  public static class Spruce extends ItemSign {
    public Spruce(String id, String translationKey) {
      super(ReFlectBlocks.SPRUCE_STANDING_SIGN, ReFlectBlocks.SPRUCE_WALL_SIGN,
            id, translationKey);
    }

    public Spruce(String id) { this(id, id); }
  }

  public static class Birch extends ItemSign {
    public Birch(String id, String translationKey) {
      super(ReFlectBlocks.BIRCH_STANDING_SIGN, ReFlectBlocks.BIRCH_WALL_SIGN,
            id, translationKey);
    }

    public Birch(String id) { this(id, id); }
  }

  public static class Jungle extends ItemSign {
    public Jungle(String id, String translationKey) {
      super(ReFlectBlocks.JUNGLE_STANDING_SIGN, ReFlectBlocks.JUNGLE_WALL_SIGN,
            id, translationKey);
    }

    public Jungle(String id) { this(id, id); }
  }

  public static class Acacia extends ItemSign {
    public Acacia(String id, String translationKey) {
      super(ReFlectBlocks.ACACIA_STANDING_SIGN, ReFlectBlocks.ACACIA_WALL_SIGN,
            id, translationKey);
    }

    public Acacia(String id) { this(id, id); }
  }

  public static class DarkOak extends ItemSign {
    public DarkOak(String id, String translationKey) {
      super(ReFlectBlocks.DARK_OAK_STANDING_SIGN,
            ReFlectBlocks.DARK_OAK_WALL_SIGN, id, translationKey);
    }

    public DarkOak(String id) { this(id, id); }
  }
}
