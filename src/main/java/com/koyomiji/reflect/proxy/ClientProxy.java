package com.koyomiji.reflect.proxy;

import com.koyomiji.reflect.*;
import com.koyomiji.reflect.block.*;
import com.koyomiji.reflect.client.renderer.StateMapExtended;
import com.koyomiji.reflect.client.renderer.tileentity.TileEntitySignRenderer;
import com.koyomiji.reflect.type.StoneType;
import java.util.Collections;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = ReFlect.MODID, value = Side.CLIENT)
public class ClientProxy extends CommonProxy {
  public void init(FMLInitializationEvent event) {
    super.init(event);
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySign.class,
                                                 new TileEntitySignRenderer());
  }

  @SubscribeEvent
  public static void registerModels(ModelRegistryEvent event) {
    ModelLoader.setCustomStateMapper(ReFlectBlocks.STRIPPED_LOG,
                                     new StateMap.Builder()
                                         .withName(BlockStrippedLog.VARIANT)
                                         .withSuffix("_stripped_log")
                                         .build());
    setCustomModelResourceLocation(ReFlectBlocks.STRIPPED_LOG, 0,
                                   "reflect:oak_stripped_log");
    setCustomModelResourceLocation(ReFlectBlocks.STRIPPED_LOG, 1,
                                   "reflect:spruce_stripped_log");
    setCustomModelResourceLocation(ReFlectBlocks.STRIPPED_LOG, 2,
                                   "reflect:birch_stripped_log");
    setCustomModelResourceLocation(ReFlectBlocks.STRIPPED_LOG, 3,
                                   "reflect:jungle_stripped_log");

    ModelLoader.setCustomStateMapper(ReFlectBlocks.STRIPPED_LOG2,
                                     new StateMap.Builder()
                                         .withName(BlockStrippedLog2.VARIANT)
                                         .withSuffix("_stripped_log")
                                         .build());
    setCustomModelResourceLocation(ReFlectBlocks.STRIPPED_LOG2, 0,
                                   "reflect:acacia_stripped_log");
    setCustomModelResourceLocation(ReFlectBlocks.STRIPPED_LOG2, 1,
                                   "reflect:dark_oak_stripped_log");

    ModelLoader.setCustomStateMapper(ReFlectBlocks.WOOD,
                                     new StateMap.Builder()
                                         .withName(BlockWood.VARIANT)
                                         .withSuffix("_wood")
                                         .build());
    setCustomModelResourceLocation(ReFlectBlocks.WOOD, 0, "reflect:oak_wood");
    setCustomModelResourceLocation(ReFlectBlocks.WOOD, 1,
                                   "reflect:spruce_wood");
    setCustomModelResourceLocation(ReFlectBlocks.WOOD, 2, "reflect:birch_wood");
    setCustomModelResourceLocation(ReFlectBlocks.WOOD, 3,
                                   "reflect:jungle_wood");

    ModelLoader.setCustomStateMapper(ReFlectBlocks.WOOD2,
                                     new StateMap.Builder()
                                         .withName(BlockWood2.VARIANT)
                                         .withSuffix("_wood")
                                         .build());
    setCustomModelResourceLocation(ReFlectBlocks.WOOD2, 0,
                                   "reflect:acacia_wood");
    setCustomModelResourceLocation(ReFlectBlocks.WOOD2, 1,
                                   "reflect:dark_oak_wood");

    ModelLoader.setCustomStateMapper(ReFlectBlocks.STRIPPED_WOOD,
                                     new StateMap.Builder()
                                         .withName(BlockStrippedWood.VARIANT)
                                         .withSuffix("_stripped_wood")
                                         .build());
    setCustomModelResourceLocation(ReFlectBlocks.STRIPPED_WOOD, 0,
                                   "reflect:oak_stripped_wood");
    setCustomModelResourceLocation(ReFlectBlocks.STRIPPED_WOOD, 1,
                                   "reflect:spruce_stripped_wood");
    setCustomModelResourceLocation(ReFlectBlocks.STRIPPED_WOOD, 2,
                                   "reflect:birch_stripped_wood");
    setCustomModelResourceLocation(ReFlectBlocks.STRIPPED_WOOD, 3,
                                   "reflect:jungle_stripped_wood");

    ModelLoader.setCustomStateMapper(ReFlectBlocks.STRIPPED_WOOD2,
                                     new StateMap.Builder()
                                         .withName(BlockStrippedWood2.VARIANT)
                                         .withSuffix("_stripped_wood")
                                         .build());
    setCustomModelResourceLocation(ReFlectBlocks.STRIPPED_WOOD2, 0,
                                   "reflect:acacia_stripped_wood");
    setCustomModelResourceLocation(ReFlectBlocks.STRIPPED_WOOD2, 1,
                                   "reflect:dark_oak_stripped_wood");

    setCustomModelResourceLocationByRegistryName(
        ReFlectBlocks.PRISMARINE_STAIRS, 0);
    setCustomModelResourceLocationByRegistryName(
        ReFlectBlocks.PRISMARINE_BRICK_STAIRS, 0);
    setCustomModelResourceLocationByRegistryName(
        ReFlectBlocks.DARK_PRISMARINE_STAIRS, 0);

    ModelLoader.setCustomStateMapper(ReFlectBlocks.PRISMARINE_DOUBLE_SLAB,
                                     new StateMap.Builder()
                                         .withName(BlockPrismarineSlab.VARIANT)
                                         .withSuffix("_double_slab")
                                         .build());
    ModelLoader.setCustomStateMapper(ReFlectBlocks.PRISMARINE_SLAB,
                                     new StateMap.Builder()
                                         .withName(BlockPrismarineSlab.VARIANT)
                                         .withSuffix("_slab")
                                         .build());
    setCustomModelResourceLocation(ReFlectBlocks.PRISMARINE_SLAB, 0,
                                   "reflect:prismarine_slab");
    setCustomModelResourceLocation(ReFlectBlocks.PRISMARINE_SLAB, 1,
                                   "reflect:prismarine_brick_slab");
    setCustomModelResourceLocation(ReFlectBlocks.PRISMARINE_SLAB, 2,
                                   "reflect:dark_prismarine_slab");

    setCustomModelResourceLocationByRegistryName(
        ReFlectBlocks.SPRUCE_PRESSURE_PLATE, 0);
    setCustomModelResourceLocationByRegistryName(
        ReFlectBlocks.BIRCH_PRESSURE_PLATE, 0);
    setCustomModelResourceLocationByRegistryName(
        ReFlectBlocks.JUNGLE_PRESSURE_PLATE, 0);
    setCustomModelResourceLocationByRegistryName(
        ReFlectBlocks.ACACIA_PRESSURE_PLATE, 0);
    setCustomModelResourceLocationByRegistryName(
        ReFlectBlocks.DARK_OAK_PRESSURE_PLATE, 0);

    setCustomModelResourceLocationByRegistryName(ReFlectBlocks.SPRUCE_TRAPDOOR,
                                                 0);
    setCustomModelResourceLocationByRegistryName(ReFlectBlocks.BIRCH_TRAPDOOR,
                                                 0);
    setCustomModelResourceLocationByRegistryName(ReFlectBlocks.JUNGLE_TRAPDOOR,
                                                 0);
    setCustomModelResourceLocationByRegistryName(ReFlectBlocks.ACACIA_TRAPDOOR,
                                                 0);
    setCustomModelResourceLocationByRegistryName(
        ReFlectBlocks.DARK_OAK_TRAPDOOR, 0);

    setCustomModelResourceLocationByRegistryName(ReFlectBlocks.SPRUCE_BUTTON,
                                                 0);
    setCustomModelResourceLocationByRegistryName(ReFlectBlocks.BIRCH_BUTTON, 0);
    setCustomModelResourceLocationByRegistryName(ReFlectBlocks.JUNGLE_BUTTON,
                                                 0);
    setCustomModelResourceLocationByRegistryName(ReFlectBlocks.ACACIA_BUTTON,
                                                 0);
    setCustomModelResourceLocationByRegistryName(ReFlectBlocks.DARK_OAK_BUTTON,
                                                 0);

    setCustomModelResourceLocation(ReFlectBlocks.STONE_STAIRS, 0,
                                   "reflect:stone_stairs");
    setCustomModelResourceLocation(ReFlectBlocks.GRANITE_STAIRS, 0,
                                   "reflect:granite_stairs");
    ModelLoader.setCustomStateMapper(
        ReFlectBlocks.SMOOTH_GRANITE_STAIRS,
        new StateMapExtended.Builder()
            .remapName("smooth_granite_stairs", "polished_granite_stairs")
            .build());
    setCustomModelResourceLocation(ReFlectBlocks.SMOOTH_GRANITE_STAIRS, 0,
                                   "reflect:polished_granite_stairs");
    setCustomModelResourceLocation(ReFlectBlocks.DIORITE_STAIRS, 0,
                                   "reflect:diorite_stairs");
    ModelLoader.setCustomStateMapper(
        ReFlectBlocks.SMOOTH_DIORITE_STAIRS,
        new StateMapExtended.Builder()
            .remapName("smooth_diorite_stairs", "polished_diorite_stairs")
            .build());
    setCustomModelResourceLocation(ReFlectBlocks.SMOOTH_DIORITE_STAIRS, 0,
                                   "reflect:polished_diorite_stairs");
    setCustomModelResourceLocation(ReFlectBlocks.ANDESITE_STAIRS, 0,
                                   "reflect:andesite_stairs");
    ModelLoader.setCustomStateMapper(
        ReFlectBlocks.SMOOTH_ANDESITE_STAIRS,
        new StateMapExtended.Builder()
            .remapName("smooth_andesite_stairs", "polished_andesite_stairs")
            .build());
    setCustomModelResourceLocation(ReFlectBlocks.SMOOTH_ANDESITE_STAIRS, 0,
                                   "reflect:polished_andesite_stairs");
    ModelLoader.setCustomStateMapper(
        ReFlectBlocks.STONE_DOUBLE_SLAB3,
        new StateMapExtended.Builder()
            .withName(BlockStoneSlab.VARIANT)
            .remapName("smooth_granite", "polished_granite")
            .remapName("smooth_diorite", "polished_diorite")
            .remapName("smooth_andesite", "polished_andesite")
            .withSuffix("_double_slab")
            .build());
    ModelLoader.setCustomStateMapper(
        ReFlectBlocks.STONE_SLAB3,
        new StateMapExtended.Builder()
            .withName(BlockStoneSlab.VARIANT)
            .remapName("smooth_granite", "polished_granite")
            .remapName("smooth_diorite", "polished_diorite")
            .remapName("smooth_andesite", "polished_andesite")
            .withSuffix("_slab")
            .build());
    setCustomModelResourceLocation(ReFlectBlocks.STONE_SLAB3, 0,
                                   "reflect:stone_slab");
    setCustomModelResourceLocation(ReFlectBlocks.STONE_SLAB3, 1,
                                   "reflect:granite_slab");
    setCustomModelResourceLocation(ReFlectBlocks.STONE_SLAB3, 2,
                                   "reflect:polished_granite_slab");
    setCustomModelResourceLocation(ReFlectBlocks.STONE_SLAB3, 3,
                                   "reflect:diorite_slab");
    setCustomModelResourceLocation(ReFlectBlocks.STONE_SLAB3, 4,
                                   "reflect:polished_diorite_slab");
    setCustomModelResourceLocation(ReFlectBlocks.STONE_SLAB3, 5,
                                   "reflect:andesite_slab");
    setCustomModelResourceLocation(ReFlectBlocks.STONE_SLAB3, 6,
                                   "reflect:polished_andesite_slab");

    ModelLoader.setCustomStateMapper(ReFlectBlocks.COBBLESTONE_DOUBLE_SLAB,
                                     new StateMap.Builder()
                                         .withName(BlockCobblestoneSlab.VARIANT)
                                         .withSuffix("_double_slab")
                                         .build());
    ModelLoader.setCustomStateMapper(ReFlectBlocks.COBBLESTONE_SLAB,
                                     new StateMap.Builder()
                                         .withName(BlockCobblestoneSlab.VARIANT)
                                         .withSuffix("_slab")
                                         .build());
    setCustomModelResourceLocation(ReFlectBlocks.COBBLESTONE_SLAB, 1,
                                   "reflect:mossy_cobblestone_slab");
    setCustomModelResourceLocationByRegistryName(
        ReFlectBlocks.MOSSY_COBBLESTONE_STAIRS, 0);

    ModelLoader.setCustomStateMapper(
        ReFlectBlocks.SANDSTONE_DOUBLE_SLAB,
        new StateMapExtended.Builder()
            .withName(BlockSandstoneSlab.VARIANT)
            .remapName("smooth_sandstone", "cut_sandstone")
            .withSuffix("_double_slab")
            .build());
    ModelLoader.setCustomStateMapper(
        ReFlectBlocks.SANDSTONE_SLAB,
        new StateMapExtended.Builder()
            .withName(BlockSandstoneSlab.VARIANT)
            .remapName("smooth_sandstone", "cut_sandstone")
            .withSuffix("_slab")
            .build());
    setCustomModelResourceLocation(ReFlectBlocks.SANDSTONE_SLAB, 2,
                                   "reflect:cut_sandstone_slab");

    ModelLoader.setCustomStateMapper(ReFlectBlocks.SMOOTH_STONE,
                                     new StateMapExtended.Builder()
                                         .withName(BlockSmoothStone.VARIANT)
                                         .build());
    setCustomModelResourceLocation(ReFlectBlocks.SMOOTH_STONE, 0,
                                   "reflect:smooth_stone");
    setCustomModelResourceLocation(ReFlectBlocks.SMOOTH_STONE, 1,
                                   "reflect:smooth_sandstone");
    setCustomModelResourceLocation(ReFlectBlocks.SMOOTH_STONE, 2,
                                   "reflect:smooth_quartz");
    setCustomModelResourceLocation(ReFlectBlocks.SMOOTH_STONE, 3,
                                   "reflect:smooth_red_sandstone");
    setCustomModelResourceLocationByRegistryName(
        ReFlectBlocks.SMOOTH_SANDSTONE_STAIRS, 0);
    setCustomModelResourceLocationByRegistryName(
        ReFlectBlocks.SMOOTH_QUARTZ_STAIRS, 0);
    setCustomModelResourceLocationByRegistryName(
        ReFlectBlocks.SMOOTH_RED_SANDSTONE_STAIRS, 0);
    ModelLoader.setCustomStateMapper(ReFlectBlocks.SMOOTH_STONE_DOUBLE_SLAB,
                                     new StateMapExtended.Builder()
                                         .withName(BlockSmoothStoneSlab.VARIANT)
                                         .withSuffix("_double_slab")
                                         .build());
    ModelLoader.setCustomStateMapper(ReFlectBlocks.SMOOTH_STONE_SLAB,
                                     new StateMapExtended.Builder()
                                         .withName(BlockSmoothStoneSlab.VARIANT)
                                         .withSuffix("_slab")
                                         .build());
    setCustomModelResourceLocation(ReFlectBlocks.SMOOTH_STONE_SLAB, 1,
                                   "reflect:smooth_sandstone_slab");
    setCustomModelResourceLocation(ReFlectBlocks.SMOOTH_STONE_SLAB, 2,
                                   "reflect:smooth_quartz_slab");
    setCustomModelResourceLocation(ReFlectBlocks.SMOOTH_STONE_SLAB, 3,
                                   "reflect:smooth_red_sandstone_slab");

    setCustomModelResourceLocationByRegistryName(
        ReFlectBlocks.MOSSY_STONE_BRICK_STAIRS, 0);
    ModelLoader.setCustomStateMapper(ReFlectBlocks.STONE_BRICK_DOUBLE_SLAB,
                                     new StateMap.Builder()
                                         .withName(BlockStonebrickSlab.VARIANT)
                                         .withSuffix("_double_slab")
                                         .build());
    ModelLoader.setCustomStateMapper(ReFlectBlocks.STONE_BRICK_SLAB,
                                     new StateMap.Builder()
                                         .withName(BlockStonebrickSlab.VARIANT)
                                         .withSuffix("_slab")
                                         .build());
    setCustomModelResourceLocation(ReFlectBlocks.STONE_BRICK_SLAB, 1,
                                   "reflect:mossy_stone_brick_slab");

    ModelLoader.setCustomStateMapper(
        ReFlectBlocks.RED_SANDSTONE_DOUBLE_SLAB,
        new StateMapExtended.Builder()
            .withName(BlockRedSandstoneSlab.VARIANT)
            .remapName("smooth_red_sandstone", "cut_red_sandstone")
            .withSuffix("_double_slab")
            .build());
    ModelLoader.setCustomStateMapper(
        ReFlectBlocks.RED_SANDSTONE_SLAB,
        new StateMapExtended.Builder()
            .withName(BlockRedSandstoneSlab.VARIANT)
            .remapName("smooth_red_sandstone", "cut_red_sandstone")
            .withSuffix("_slab")
            .build());
    setCustomModelResourceLocation(ReFlectBlocks.RED_SANDSTONE_SLAB, 2,
                                   "reflect:cut_red_sandstone_slab");

    setCustomModelResourceLocationByRegistryName(ReFlectBlocks.END_BRICK_STAIRS,
                                                 0);
    ModelLoader.setCustomStateMapper(
        ReFlectBlocks.END_BRICK_DOUBLE_SLAB,
        new StateMap.Builder()
            .withName(BlockEndStoneBrickSlab.VARIANT)
            .withSuffix("_double_slab")
            .build());
    ModelLoader.setCustomStateMapper(
        ReFlectBlocks.END_BRICK_SLAB,
        new StateMap.Builder()
            .withName(BlockEndStoneBrickSlab.VARIANT)
            .withSuffix("_slab")
            .build());
    setCustomModelResourceLocation(ReFlectBlocks.END_BRICK_SLAB, 0,
                                   "reflect:end_brick_slab");

    setCustomModelResourceLocationByRegistryName(
        ReFlectBlocks.RED_NETHER_BRICK_STAIRS, 0);
    ModelLoader.setCustomStateMapper(
        ReFlectBlocks.RED_NETHER_BRICK_DOUBLE_SLAB,
        new StateMap.Builder()
            .withName(BlockRedNetherBrickSlab.VARIANT)
            .withSuffix("_double_slab")
            .build());
    ModelLoader.setCustomStateMapper(
        ReFlectBlocks.RED_NETHER_BRICK_SLAB,
        new StateMap.Builder()
            .withName(BlockRedNetherBrickSlab.VARIANT)
            .withSuffix("_slab")
            .build());
    setCustomModelResourceLocation(ReFlectBlocks.RED_NETHER_BRICK_SLAB, 0,
                                   "reflect:red_nether_brick_slab");

    ModelLoader.setCustomStateMapper(ReFlectBlocks.STONE_WALL,
                                     new StateMap.Builder()
                                         .withName(BlockStoneWall.VARIANT)
                                         .withSuffix("_wall")
                                         .build());
    setCustomModelResourceLocation(ReFlectBlocks.STONE_WALL,
                                   StoneType.GRANITE.getMetadata(),
                                   "reflect:granite_wall");
    setCustomModelResourceLocation(ReFlectBlocks.STONE_WALL,
                                   StoneType.DIORITE.getMetadata(),
                                   "reflect:diorite_wall");
    setCustomModelResourceLocation(ReFlectBlocks.STONE_WALL,
                                   StoneType.ANDESITE.getMetadata(),
                                   "reflect:andesite_wall");
    setCustomModelResourceLocationByRegistryName(ReFlectBlocks.SANDSTONE_WALL,
                                                 0);
    ModelLoader.setCustomStateMapper(ReFlectBlocks.BRICK_WALL,
                                     new StateMap.Builder()
                                         .withName(BlockBrickWall.VARIANT)
                                         .withSuffix("_wall")
                                         .build());
    setCustomModelResourceLocationByRegistryName(ReFlectBlocks.BRICK_WALL, 0);
    ModelLoader.setCustomStateMapper(ReFlectBlocks.STONE_BRICK_WALL,
                                     new StateMap.Builder()
                                         .withName(BlockStonebrickWall.VARIANT)
                                         .withSuffix("_wall")
                                         .build());
    setCustomModelResourceLocation(ReFlectBlocks.STONE_BRICK_WALL, 0,
                                   "reflect:stone_brick_wall");
    setCustomModelResourceLocation(ReFlectBlocks.STONE_BRICK_WALL, 1,
                                   "reflect:mossy_stone_brick_wall");
    ModelLoader.setCustomStateMapper(ReFlectBlocks.NETHER_BRICK_WALL,
                                     new StateMap.Builder()
                                         .withName(BlockNetherBrickWall.VARIANT)
                                         .withSuffix("_wall")
                                         .build());
    setCustomModelResourceLocationByRegistryName(
        ReFlectBlocks.NETHER_BRICK_WALL, 0);
    setCustomModelResourceLocationByRegistryName(ReFlectBlocks.PRISMARINE_WALL,
                                                 0);
    setCustomModelResourceLocationByRegistryName(
        ReFlectBlocks.RED_SANDSTONE_WALL, 0);
    ModelLoader.setCustomStateMapper(
        ReFlectBlocks.END_BRICK_WALL,
        new StateMap.Builder()
            .withName(BlockEndStoneBrickWall.VARIANT)
            .withSuffix("_wall")
            .build());
    setCustomModelResourceLocationByRegistryName(ReFlectBlocks.END_BRICK_WALL,
                                                 0);
    ModelLoader.setCustomStateMapper(
        ReFlectBlocks.RED_NETHER_BRICK_WALL,
        new StateMap.Builder()
            .withName(BlockRedNetherBrickWall.VARIANT)
            .withSuffix("_wall")
            .build());
    setCustomModelResourceLocationByRegistryName(
        ReFlectBlocks.RED_NETHER_BRICK_WALL, 0);

    setCustomModelResourceLocationByRegistryName(ReFlectItems.SPRUCE_SIGN, 0);
    setCustomModelResourceLocationByRegistryName(ReFlectItems.BIRCH_SIGN, 0);
    setCustomModelResourceLocationByRegistryName(ReFlectItems.JUNGLE_SIGN, 0);
    setCustomModelResourceLocationByRegistryName(ReFlectItems.ACACIA_SIGN, 0);
    setCustomModelResourceLocationByRegistryName(ReFlectItems.DARK_OAK_SIGN, 0);

    ModelLoader.setCustomStateMapper(ReFlectBlocks.SPRUCE_STANDING_SIGN,
                                     blockIn -> Collections.emptyMap());
    ModelLoader.setCustomStateMapper(ReFlectBlocks.SPRUCE_WALL_SIGN,
                                     blockIn -> Collections.emptyMap());
    ModelLoader.setCustomStateMapper(ReFlectBlocks.BIRCH_STANDING_SIGN,
                                     blockIn -> Collections.emptyMap());
    ModelLoader.setCustomStateMapper(ReFlectBlocks.BIRCH_WALL_SIGN,
                                     blockIn -> Collections.emptyMap());
    ModelLoader.setCustomStateMapper(ReFlectBlocks.JUNGLE_STANDING_SIGN,
                                     blockIn -> Collections.emptyMap());
    ModelLoader.setCustomStateMapper(ReFlectBlocks.JUNGLE_WALL_SIGN,
                                     blockIn -> Collections.emptyMap());
    ModelLoader.setCustomStateMapper(ReFlectBlocks.ACACIA_STANDING_SIGN,
                                     blockIn -> Collections.emptyMap());
    ModelLoader.setCustomStateMapper(ReFlectBlocks.ACACIA_WALL_SIGN,
                                     blockIn -> Collections.emptyMap());
    ModelLoader.setCustomStateMapper(ReFlectBlocks.DARK_OAK_STANDING_SIGN,
                                     blockIn -> Collections.emptyMap());
    ModelLoader.setCustomStateMapper(ReFlectBlocks.DARK_OAK_WALL_SIGN,
                                     blockIn -> Collections.emptyMap());
  }

  private static void setCustomModelResourceLocation(Item item, int meta,
                                                     String location) {
    ModelLoader.setCustomModelResourceLocation(
        item, meta, new ModelResourceLocation(location, "inventory"));
  }

  private static void setCustomModelResourceLocation(Block block, int meta,
                                                     String location) {
    setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
                                   location);
  }

  private static void setCustomModelResourceLocationByRegistryName(Item item,
                                                                   int meta) {
    setCustomModelResourceLocation(item, meta,
                                   item.getRegistryName().toString());
  }

  private static void setCustomModelResourceLocationByRegistryName(Block block,
                                                                   int meta) {
    setCustomModelResourceLocationByRegistryName(Item.getItemFromBlock(block),
                                                 meta);
  }
}
