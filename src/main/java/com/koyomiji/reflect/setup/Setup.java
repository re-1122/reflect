package com.koyomiji.reflect.setup;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.koyomiji.reflect.ReFlect;
import com.koyomiji.refound.asset.AssetFetcher;
import com.koyomiji.refound.asset.AssetIdentifier;
import com.koyomiji.refound.asset.FileInjector;
import com.koyomiji.refound.setup.ISetupProcess;
import com.koyomiji.refound.util.IOUtil;
import com.koyomiji.refound.util.JarFileUtil;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarFile;

import javax.swing.*;

public class Setup implements ISetupProcess {
  private static final String CREDITS_FILENAME = "credits.txt";

  private static final Map<String, String> FILES_1_13_2 = Maps.newHashMap();
  private static final Map<AssetIdentifier, String> ASSETS_1_13_2 =
      Maps.newHashMap();
  private static final Map<String, String> FILES_1_14_4 = Maps.newHashMap();
  private static final String LANG_EN_US = "assets/reflect/lang/en_us.lang";
  private static final String LANG_SOURCE_EN_US =
      "assets/reflect/lang/source/en_us.lang";
  private static final String LANG_EN_US_1_14_4 =
      "assets/minecraft/lang/en_us.json";
  private static final Multimap<String, String> LANG_KEYS_1_14_4 =
      HashMultimap.create();

  static {
    FILES_1_13_2.put("assets/minecraft/textures/block/acacia_trapdoor.png",
                     "assets/reflect/textures/blocks/acacia_trapdoor.png");
    FILES_1_13_2.put("assets/minecraft/textures/block/birch_trapdoor.png",
                     "assets/reflect/textures/blocks/birch_trapdoor.png");
    FILES_1_13_2.put("assets/minecraft/textures/block/dark_oak_trapdoor.png",
                     "assets/reflect/textures/blocks/dark_oak_trapdoor.png");
    FILES_1_13_2.put("assets/minecraft/textures/block/jungle_trapdoor.png",
                     "assets/reflect/textures/blocks/jungle_trapdoor.png");
    FILES_1_13_2.put("assets/minecraft/textures/block/spruce_trapdoor.png",
                     "assets/reflect/textures/blocks/spruce_trapdoor.png");

    FILES_1_13_2.put("assets/minecraft/textures/block/stripped_oak_log_top.png",
                     "assets/reflect/textures/blocks/stripped_oak_log_top.png");
    FILES_1_13_2.put("assets/minecraft/textures/block/stripped_oak_log.png",
                     "assets/reflect/textures/blocks/stripped_oak_log.png");
    FILES_1_13_2.put(
        "assets/minecraft/textures/block/stripped_spruce_log_top.png",
        "assets/reflect/textures/blocks/stripped_spruce_log_top.png");
    FILES_1_13_2.put("assets/minecraft/textures/block/stripped_spruce_log.png",
                     "assets/reflect/textures/blocks/stripped_spruce_log.png");
    FILES_1_13_2.put(
        "assets/minecraft/textures/block/stripped_birch_log_top.png",
        "assets/reflect/textures/blocks/stripped_birch_log_top.png");
    FILES_1_13_2.put("assets/minecraft/textures/block/stripped_birch_log.png",
                     "assets/reflect/textures/blocks/stripped_birch_log.png");
    FILES_1_13_2.put(
        "assets/minecraft/textures/block/stripped_jungle_log_top.png",
        "assets/reflect/textures/blocks/stripped_jungle_log_top.png");
    FILES_1_13_2.put("assets/minecraft/textures/block/stripped_jungle_log.png",
                     "assets/reflect/textures/blocks/stripped_jungle_log.png");
    FILES_1_13_2.put(
        "assets/minecraft/textures/block/stripped_acacia_log_top.png",
        "assets/reflect/textures/blocks/stripped_acacia_log_top.png");
    FILES_1_13_2.put("assets/minecraft/textures/block/stripped_acacia_log.png",
                     "assets/reflect/textures/blocks/stripped_acacia_log.png");
    FILES_1_13_2.put(
        "assets/minecraft/textures/block/stripped_dark_oak_log_top.png",
        "assets/reflect/textures/blocks/stripped_dark_oak_log_top.png");
    FILES_1_13_2.put(
        "assets/minecraft/textures/block/stripped_dark_oak_log.png",
        "assets/reflect/textures/blocks/stripped_dark_oak_log.png");

    ASSETS_1_13_2.put(Assets.axeStrip1,
                      "assets/reflect/sounds/item/axe/strip1.ogg");
    ASSETS_1_13_2.put(Assets.axeStrip2,
                      "assets/reflect/sounds/item/axe/strip2.ogg");
    ASSETS_1_13_2.put(Assets.axeStrip3,
                      "assets/reflect/sounds/item/axe/strip3.ogg");
    ASSETS_1_13_2.put(Assets.axeStrip4,
                      "assets/reflect/sounds/item/axe/strip4.ogg");

    FILES_1_14_4.put("assets/minecraft/textures/entity/signs/spruce.png",
                     "assets/reflect/textures/entity/signs/spruce.png");
    FILES_1_14_4.put("assets/minecraft/textures/entity/signs/birch.png",
                     "assets/reflect/textures/entity/signs/birch.png");
    FILES_1_14_4.put("assets/minecraft/textures/entity/signs/jungle.png",
                     "assets/reflect/textures/entity/signs/jungle.png");
    FILES_1_14_4.put("assets/minecraft/textures/entity/signs/acacia.png",
                     "assets/reflect/textures/entity/signs/acacia.png");
    FILES_1_14_4.put("assets/minecraft/textures/entity/signs/dark_oak.png",
                     "assets/reflect/textures/entity/signs/dark_oak.png");

    FILES_1_14_4.put("assets/minecraft/textures/item/spruce_sign.png",
                     "assets/reflect/textures/items/spruce_sign.png");
    FILES_1_14_4.put("assets/minecraft/textures/item/birch_sign.png",
                     "assets/reflect/textures/items/birch_sign.png");
    FILES_1_14_4.put("assets/minecraft/textures/item/jungle_sign.png",
                     "assets/reflect/textures/items/jungle_sign.png");
    FILES_1_14_4.put("assets/minecraft/textures/item/acacia_sign.png",
                     "assets/reflect/textures/items/acacia_sign.png");
    FILES_1_14_4.put("assets/minecraft/textures/item/dark_oak_sign.png",
                     "assets/reflect/textures/items/dark_oak_sign.png");

    LANG_KEYS_1_14_4.put("block.minecraft.oak_trapdoor", "tile.trapdoor.name");
    LANG_KEYS_1_14_4.put("block.minecraft.spruce_trapdoor",
                         "tile.reflect.spruce_trapdoor.name");
    LANG_KEYS_1_14_4.put("block.minecraft.birch_trapdoor",
                         "tile.reflect.birch_trapdoor.name");
    LANG_KEYS_1_14_4.put("block.minecraft.jungle_trapdoor",
                         "tile.reflect.jungle_trapdoor.name");
    LANG_KEYS_1_14_4.put("block.minecraft.acacia_trapdoor",
                         "tile.reflect.acacia_trapdoor.name");
    LANG_KEYS_1_14_4.put("block.minecraft.dark_oak_trapdoor",
                         "tile.reflect.dark_oak_trapdoor.name");

    LANG_KEYS_1_14_4.put("block.minecraft.oak_button",
                         "tile.reflect.oak_button.name");
    LANG_KEYS_1_14_4.put("block.minecraft.spruce_button",
                         "tile.reflect.spruce_button.name");
    LANG_KEYS_1_14_4.put("block.minecraft.birch_button",
                         "tile.reflect.birch_button.name");
    LANG_KEYS_1_14_4.put("block.minecraft.jungle_button",
                         "tile.reflect.jungle_button.name");
    LANG_KEYS_1_14_4.put("block.minecraft.acacia_button",
                         "tile.reflect.acacia_button.name");
    LANG_KEYS_1_14_4.put("block.minecraft.dark_oak_button",
                         "tile.reflect.dark_oak_button.name");
    LANG_KEYS_1_14_4.put("block.minecraft.stone_button",
                         "tile.reflect.stone_button.name");

    LANG_KEYS_1_14_4.put("block.minecraft.oak_pressure_plate",
                         "tile.pressurePlateWood.name");
    LANG_KEYS_1_14_4.put("block.minecraft.spruce_pressure_plate",
                         "tile.reflect.spruce_pressure_plate.name");
    LANG_KEYS_1_14_4.put("block.minecraft.birch_pressure_plate",
                         "tile.reflect.birch_pressure_plate.name");
    LANG_KEYS_1_14_4.put("block.minecraft.jungle_pressure_plate",
                         "tile.reflect.jungle_pressure_plate.name");
    LANG_KEYS_1_14_4.put("block.minecraft.acacia_pressure_plate",
                         "tile.reflect.acacia_pressure_plate.name");
    LANG_KEYS_1_14_4.put("block.minecraft.dark_oak_pressure_plate",
                         "tile.reflect.dark_oak_pressure_plate.name");

    LANG_KEYS_1_14_4.put("block.minecraft.oak_wood",
                         "tile.reflect.wood.oak.name");
    LANG_KEYS_1_14_4.put("block.minecraft.spruce_wood",
                         "tile.reflect.wood.spruce.name");
    LANG_KEYS_1_14_4.put("block.minecraft.birch_wood",
                         "tile.reflect.wood.birch.name");
    LANG_KEYS_1_14_4.put("block.minecraft.jungle_wood",
                         "tile.reflect.wood.jungle.name");
    LANG_KEYS_1_14_4.put("block.minecraft.acacia_wood",
                         "tile.reflect.wood.acacia.name");
    LANG_KEYS_1_14_4.put("block.minecraft.dark_oak_wood",
                         "tile.reflect.wood.dark_oak.name");

    LANG_KEYS_1_14_4.put("block.minecraft.stripped_oak_wood",
                         "tile.reflect.stripped_wood.oak.name");
    LANG_KEYS_1_14_4.put("block.minecraft.stripped_spruce_wood",
                         "tile.reflect.stripped_wood.spruce.name");
    LANG_KEYS_1_14_4.put("block.minecraft.stripped_birch_wood",
                         "tile.reflect.stripped_wood.birch.name");
    LANG_KEYS_1_14_4.put("block.minecraft.stripped_jungle_wood",
                         "tile.reflect.stripped_wood.jungle.name");
    LANG_KEYS_1_14_4.put("block.minecraft.stripped_acacia_wood",
                         "tile.reflect.stripped_wood.acacia.name");
    LANG_KEYS_1_14_4.put("block.minecraft.stripped_dark_oak_wood",
                         "tile.reflect.stripped_wood.dark_oak.name");

    LANG_KEYS_1_14_4.put("block.minecraft.oak_log", "tile.log.oak.name");
    LANG_KEYS_1_14_4.put("block.minecraft.spruce_log", "tile.log.spruce.name");
    LANG_KEYS_1_14_4.put("block.minecraft.birch_log", "tile.log.birch.name");
    LANG_KEYS_1_14_4.put("block.minecraft.jungle_log", "tile.log.jungle.name");
    LANG_KEYS_1_14_4.put("block.minecraft.acacia_log", "tile.log.acacia.name");
    LANG_KEYS_1_14_4.put("block.minecraft.dark_oak_log",
                         "tile.log.big_oak.name");

    LANG_KEYS_1_14_4.put("block.minecraft.stripped_oak_log",
                         "tile.reflect.stripped_log.oak.name");
    LANG_KEYS_1_14_4.put("block.minecraft.stripped_spruce_log",
                         "tile.reflect.stripped_log.spruce.name");
    LANG_KEYS_1_14_4.put("block.minecraft.stripped_birch_log",
                         "tile.reflect.stripped_log.birch.name");
    LANG_KEYS_1_14_4.put("block.minecraft.stripped_jungle_log",
                         "tile.reflect.stripped_log.jungle.name");
    LANG_KEYS_1_14_4.put("block.minecraft.stripped_acacia_log",
                         "tile.reflect.stripped_log.acacia.name");
    LANG_KEYS_1_14_4.put("block.minecraft.stripped_dark_oak_log",
                         "tile.reflect.stripped_log.dark_oak.name");

    LANG_KEYS_1_14_4.put("block.minecraft.prismarine_slab",
                         "tile.reflect.prismarine_slab.name");
    LANG_KEYS_1_14_4.put("block.minecraft.prismarine_slab",
                         "tile.reflect.prismarine_slab.rough.name");
    LANG_KEYS_1_14_4.put("block.minecraft.prismarine_brick_slab",
                         "tile.reflect.prismarine_slab.brick.name");
    LANG_KEYS_1_14_4.put("block.minecraft.dark_prismarine_slab",
                         "tile.reflect.prismarine_slab.dark.name");
    LANG_KEYS_1_14_4.put("block.minecraft.prismarine_stairs",
                         "tile.reflect.prismarine_stairs.name");
    LANG_KEYS_1_14_4.put("block.minecraft.prismarine_brick_stairs",
                         "tile.reflect.prismarine_brick_stairs.name");
    LANG_KEYS_1_14_4.put("block.minecraft.dark_prismarine_stairs",
                         "tile.reflect.dark_prismarine_stairs.name");

    LANG_KEYS_1_14_4.put("block.minecraft.stone_slab",
                         "tile.reflect.stone_slab3.name");
    LANG_KEYS_1_14_4.put("block.minecraft.stone_slab",
                         "tile.reflect.stone_slab3.stone.name");
    LANG_KEYS_1_14_4.put("block.minecraft.granite_slab",
                         "tile.reflect.stone_slab3.granite.name");
    LANG_KEYS_1_14_4.put("block.minecraft.polished_granite_slab",
                         "tile.reflect.stone_slab3.polished_granite.name");
    LANG_KEYS_1_14_4.put("block.minecraft.diorite_slab",
                         "tile.reflect.stone_slab3.diorite.name");
    LANG_KEYS_1_14_4.put("block.minecraft.polished_diorite_slab",
                         "tile.reflect.stone_slab3.polished_diorite.name");
    LANG_KEYS_1_14_4.put("block.minecraft.andesite_slab",
                         "tile.reflect.stone_slab3.andesite.name");
    LANG_KEYS_1_14_4.put("block.minecraft.polished_andesite_slab",
                         "tile.reflect.stone_slab3.polished_andesite.name");

    LANG_KEYS_1_14_4.put("block.minecraft.stone_stairs",
                         "tile.reflect.stone_stairs.name");
    LANG_KEYS_1_14_4.put("block.minecraft.granite_stairs",
                         "tile.reflect.granite_stairs.name");
    LANG_KEYS_1_14_4.put("block.minecraft.polished_granite_stairs",
                         "tile.reflect.polished_granite_stairs.name");
    LANG_KEYS_1_14_4.put("block.minecraft.diorite_stairs",
                         "tile.reflect.diorite_stairs.name");
    LANG_KEYS_1_14_4.put("block.minecraft.polished_diorite_stairs",
                         "tile.reflect.polished_diorite_stairs.name");
    LANG_KEYS_1_14_4.put("block.minecraft.andesite_stairs",
                         "tile.reflect.andesite_stairs.name");
    LANG_KEYS_1_14_4.put("block.minecraft.polished_andesite_stairs",
                         "tile.reflect.polished_andesite_stairs.name");

    LANG_KEYS_1_14_4.put("block.minecraft.smooth_stone",
                         "tile.reflect.smooth_stone.name");
    LANG_KEYS_1_14_4.put("block.minecraft.smooth_stone",
                         "tile.reflect.smooth_stone.stone.name");
    LANG_KEYS_1_14_4.put("block.minecraft.smooth_sandstone",
                         "tile.reflect.smooth_stone.sandstone.name");
    LANG_KEYS_1_14_4.put("block.minecraft.smooth_red_sandstone",
                         "tile.reflect.smooth_stone.red_sandstone.name");
    LANG_KEYS_1_14_4.put("block.minecraft.smooth_quartz",
                         "tile.reflect.smooth_stone.quartz.name");

    LANG_KEYS_1_14_4.put("block.minecraft.smooth_sandstone_stairs",
                         "tile.reflect.smooth_sandstone_stairs.name");
    LANG_KEYS_1_14_4.put("block.minecraft.smooth_red_sandstone_stairs",
                         "tile.reflect.smooth_red_sandstone_stairs.name");
    LANG_KEYS_1_14_4.put("block.minecraft.smooth_quartz_stairs",
                         "tile.reflect.smooth_quartz_stairs.name");

    LANG_KEYS_1_14_4.put("block.minecraft.smooth_stone_slab",
                         "tile.reflect.smooth_stone_slab.name");
    LANG_KEYS_1_14_4.put("block.minecraft.smooth_sandstone_slab",
                         "tile.reflect.smooth_stone_slab.sandstone.name");
    LANG_KEYS_1_14_4.put("block.minecraft.smooth_red_sandstone_slab",
                         "tile.reflect.smooth_stone_slab.red_sandstone.name");
    LANG_KEYS_1_14_4.put("block.minecraft.smooth_quartz_slab",
                         "tile.reflect.smooth_stone_slab.quartz.name");

    LANG_KEYS_1_14_4.put("block.minecraft.sandstone_slab",
                         "tile.reflect.sandstone_slab.name");
    LANG_KEYS_1_14_4.put("block.minecraft.cut_sandstone_slab",
                         "tile.reflect.sandstone_slab.smooth.name");
    LANG_KEYS_1_14_4.put("block.minecraft.cut_red_sandstone_slab",
                         "tile.reflect.red_sandstone_slab.smooth.name");

    LANG_KEYS_1_14_4.put("block.minecraft.cobblestone_slab",
                         "tile.reflect.cobblestone_slab.name");
    LANG_KEYS_1_14_4.put("block.minecraft.mossy_cobblestone_slab",
                         "tile.reflect.cobblestone_slab.mossy.name");
    LANG_KEYS_1_14_4.put("block.minecraft.mossy_cobblestone_stairs",
                         "tile.reflect.mossy_cobblestone_stairs.name");

    LANG_KEYS_1_14_4.put("block.minecraft.stone_brick_slab",
                         "tile.reflect.stone_brick_slab.name");
    LANG_KEYS_1_14_4.put("block.minecraft.mossy_stone_brick_slab",
                         "tile.reflect.stone_brick_slab.mossy.name");

    LANG_KEYS_1_14_4.put("block.minecraft.mossy_stone_brick_stairs",
                         "tile.reflect.mossy_stone_brick_stairs.name");

    LANG_KEYS_1_14_4.put("block.minecraft.end_stone_brick_slab",
                         "tile.reflect.end_brick_slab.name");
    LANG_KEYS_1_14_4.put("block.minecraft.end_stone_brick_slab",
                         "tile.reflect.end_brick_slab.default.name");

    LANG_KEYS_1_14_4.put("block.minecraft.end_stone_brick_stairs",
                         "tile.reflect.end_brick_stairs.name");

    LANG_KEYS_1_14_4.put("block.minecraft.red_nether_brick_slab",
                         "tile.reflect.red_nether_brick_slab.name");
    LANG_KEYS_1_14_4.put("block.minecraft.red_nether_brick_slab",
                         "tile.reflect.red_nether_brick_slab.default.name");

    LANG_KEYS_1_14_4.put("block.minecraft.red_nether_brick_stairs",
                         "tile.reflect.red_nether_brick_stairs.name");

    LANG_KEYS_1_14_4.put("block.minecraft.brick_wall",
                         "tile.reflect.brick_wall.name");
    LANG_KEYS_1_14_4.put("block.minecraft.brick_wall",
                         "tile.reflect.brick_wall.default.name");
    LANG_KEYS_1_14_4.put("block.minecraft.prismarine_wall",
                         "tile.reflect.prismarine_wall.name");
    LANG_KEYS_1_14_4.put("block.minecraft.prismarine_wall",
                         "tile.reflect.prismarine_wall.rough.name");
    LANG_KEYS_1_14_4.put("block.minecraft.red_sandstone_wall",
                         "tile.reflect.red_sandstone_wall.name");
    LANG_KEYS_1_14_4.put("block.minecraft.red_sandstone_wall",
                         "tile.reflect.red_sandstone_wall.default.name");
    LANG_KEYS_1_14_4.put("block.minecraft.sandstone_wall",
                         "tile.reflect.sandstone_wall.name");
    LANG_KEYS_1_14_4.put("block.minecraft.sandstone_wall",
                         "tile.reflect.sandstone_wall.default.name");
    LANG_KEYS_1_14_4.put("block.minecraft.stone_brick_wall",
                         "tile.reflect.stone_brick_wall.name");
    LANG_KEYS_1_14_4.put("block.minecraft.stone_brick_wall",
                         "tile.reflect.stone_brick_wall.default.name");
    LANG_KEYS_1_14_4.put("block.minecraft.mossy_stone_brick_wall",
                         "tile.reflect.stone_brick_wall.mossy.name");
    LANG_KEYS_1_14_4.put("block.minecraft.granite_wall",
                         "tile.reflect.stone_wall.granite.name");
    LANG_KEYS_1_14_4.put("block.minecraft.diorite_wall",
                         "tile.reflect.stone_wall.diorite.name");
    LANG_KEYS_1_14_4.put("block.minecraft.andesite_wall",
                         "tile.reflect.stone_wall.andesite.name");
    LANG_KEYS_1_14_4.put("block.minecraft.nether_brick_wall",
                         "tile.reflect.nether_brick_wall.name");
    LANG_KEYS_1_14_4.put("block.minecraft.nether_brick_wall",
                         "tile.reflect.nether_brick_wall.default.name");
    LANG_KEYS_1_14_4.put("block.minecraft.red_nether_brick_wall",
                         "tile.reflect.red_nether_brick_wall.name");
    LANG_KEYS_1_14_4.put("block.minecraft.red_nether_brick_wall",
                         "tile.reflect.red_nether_brick_wall.default.name");
    LANG_KEYS_1_14_4.put("block.minecraft.end_stone_brick_wall",
                         "tile.reflect.end_brick_wall.name");
    LANG_KEYS_1_14_4.put("block.minecraft.end_stone_brick_wall",
                         "tile.reflect.end_brick_wall.default.name");

    LANG_KEYS_1_14_4.put("block.minecraft.oak_sign", "tile.sign.name");
    LANG_KEYS_1_14_4.put("block.minecraft.oak_sign", "item.sign.name");
    LANG_KEYS_1_14_4.put("block.minecraft.spruce_sign",
                         "tile.reflect.spruce_sign.name");
    LANG_KEYS_1_14_4.put("block.minecraft.spruce_sign",
                         "item.reflect.spruce_sign.name");
    LANG_KEYS_1_14_4.put("block.minecraft.birch_sign",
                         "tile.reflect.birch_sign.name");
    LANG_KEYS_1_14_4.put("block.minecraft.birch_sign",
                         "item.reflect.birch_sign.name");
    LANG_KEYS_1_14_4.put("block.minecraft.jungle_sign",
                         "tile.reflect.jungle_sign.name");
    LANG_KEYS_1_14_4.put("block.minecraft.jungle_sign",
                         "item.reflect.jungle_sign.name");
    LANG_KEYS_1_14_4.put("block.minecraft.acacia_sign",
                         "tile.reflect.acacia_sign.name");
    LANG_KEYS_1_14_4.put("block.minecraft.acacia_sign",
                         "item.reflect.acacia_sign.name");
    LANG_KEYS_1_14_4.put("block.minecraft.dark_oak_sign",
                         "tile.reflect.dark_oak_sign.name");
    LANG_KEYS_1_14_4.put("block.minecraft.dark_oak_sign",
                         "item.reflect.dark_oak_sign.name");

    LANG_KEYS_1_14_4.put("block.minecraft.oak_planks", "tile.wood.oak.name");
    LANG_KEYS_1_14_4.put("block.minecraft.spruce_planks",
                         "tile.wood.spruce.name");
    LANG_KEYS_1_14_4.put("block.minecraft.birch_planks",
                         "tile.wood.birch.name");
    LANG_KEYS_1_14_4.put("block.minecraft.jungle_planks",
                         "tile.wood.jungle.name");
    LANG_KEYS_1_14_4.put("block.minecraft.acacia_planks",
                         "tile.wood.acacia.name");
    LANG_KEYS_1_14_4.put("block.minecraft.dark_oak_planks",
                         "tile.wood.big_oak.name");

    LANG_KEYS_1_14_4.put("block.minecraft.oak_slab", "tile.woodSlab.oak.name");
    LANG_KEYS_1_14_4.put("block.minecraft.spruce_slab",
                         "tile.woodSlab.spruce.name");
    LANG_KEYS_1_14_4.put("block.minecraft.birch_slab",
                         "tile.woodSlab.birch.name");
    LANG_KEYS_1_14_4.put("block.minecraft.jungle_slab",
                         "tile.woodSlab.jungle.name");
    LANG_KEYS_1_14_4.put("block.minecraft.acacia_slab",
                         "tile.woodSlab.acacia.name");
    LANG_KEYS_1_14_4.put("block.minecraft.dark_oak_slab",
                         "tile.woodSlab.big_oak.name");

    LANG_KEYS_1_14_4.put("block.minecraft.oak_stairs", "tile.stairsWood.name");
    LANG_KEYS_1_14_4.put("block.minecraft.spruce_stairs",
                         "tile.stairsWoodSpruce.name");
    LANG_KEYS_1_14_4.put("block.minecraft.birch_stairs",
                         "tile.stairsWoodBirch.name");
    LANG_KEYS_1_14_4.put("block.minecraft.jungle_stairs",
                         "tile.stairsWoodJungle.name");
    LANG_KEYS_1_14_4.put("block.minecraft.acacia_stairs",
                         "tile.stairsWoodAcacia.name");
    LANG_KEYS_1_14_4.put("block.minecraft.dark_oak_stairs",
                         "tile.stairsWoodDarkOak.name");

    LANG_KEYS_1_14_4.put("block.minecraft.cut_sandstone",
                         "tile.sandStone.smooth.name");
    LANG_KEYS_1_14_4.put("block.minecraft.cut_red_sandstone",
                         "tile.redSandStone.smooth.name");

    LANG_KEYS_1_14_4.put("block.minecraft.mossy_cobblestone",
                         "tile.stoneMoss.name");

    LANG_KEYS_1_14_4.put("block.minecraft.brick_slab",
                         "tile.stoneSlab.brick.name");

    LANG_KEYS_1_14_4.put("block.minecraft.stone_brick_slab",
                         "tile.stoneSlab.smoothStoneBrick.name");

    LANG_KEYS_1_14_4.put("block.minecraft.nether_bricks",
                         "tile.netherBrick.name");

    LANG_KEYS_1_14_4.put("block.minecraft.red_nether_bricks",
                         "tile.redNetherBrick.name");

    LANG_KEYS_1_14_4.put("subtitles.item.axe.strip",
                         "subtitles.item.axe.strip");

    LANG_KEYS_1_14_4.put("block.minecraft.smooth_stone_slab",
                         "tile.stoneSlab.stone.name");
  }

  private static byte[] fetch(AssetFetcher af, AssetIdentifier asset) {
    ReFlect.logger.info("Fetching " + asset.url + "...");

    boolean didFetch = true;

    if (af.queryCache(asset) != null) {
      didFetch = false;
      ReFlect.logger.info("Found " + asset.url + " in cache.");
    }

    Stopwatch sw = new Stopwatch();
    sw.start();
    byte[] result = af.fetch(asset);
    sw.stop();

    if (didFetch) {
      ReFlect.logger.info("Fetched " + asset.url + " in " +
                          sw.getElapsedInSeconds() + "s.");
    }

    return result;
  }

  private static Path fetchAndGetPath(AssetFetcher af, AssetIdentifier asset) {
    ReFlect.logger.info("Fetching " + asset.url + "...");

    boolean didFetch = true;

    if (af.queryCache(asset) != null) {
      didFetch = false;
      ReFlect.logger.info("Found " + asset.url + " in cache.");
    }

    Stopwatch sw = new Stopwatch();
    sw.start();
    Path result = af.fetchAndGetPath(asset);
    sw.stop();

    if (didFetch) {
      ReFlect.logger.info("Fetched " + asset.url + " in " +
                          sw.getElapsedInSeconds() + "s.");
    }

    return result;
  }

  @Override
  public String getModID() {
    return ReFlect.MODID;
  }

  @Override
  public boolean needsSetup() {
    FileInjector assetInjector = new FileInjector(ReFlect.modFile);
    return !assetInjector.exists(CREDITS_FILENAME);
  }

  @Override
  public boolean needsRestart() {
    return true;
  }

  @Override
  public void setup() {
    FileInjector assetInjector = new FileInjector(ReFlect.modFile);

    ReFlect.logger.info("Beginning setup...");
    Stopwatch swTotal = new Stopwatch();
    swTotal.start();
    Stopwatch sw = new Stopwatch();

    CreditsGenerator cg = new CreditsGenerator();

    AssetFetcher assetFetcher = new AssetFetcher();
    Path client1_13_2Path = fetchAndGetPath(assetFetcher, Assets.client1_13_2);

    try (JarFile client1_13_2 = new JarFile(client1_13_2Path.toFile())) {
      for (Map.Entry<String, String> e : FILES_1_13_2.entrySet()) {
        sw.start();

        assetInjector.add(e.getValue(),
                          JarFileUtil.readFile(client1_13_2, e.getKey()));
        cg.add(Assets.client1_13_2, e.getValue());

        sw.stop();
        ReFlect.logger.info("Extracted " + e.getValue() + " in " +
                            sw.getElapsedInSeconds() + "s.");
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    Path client1_14_4Path = fetchAndGetPath(assetFetcher, Assets.client1_14_4);

    try (JarFile client1_14_4 = new JarFile(client1_14_4Path.toFile())) {
      for (Map.Entry<String, String> e : FILES_1_14_4.entrySet()) {
        sw.start();

        assetInjector.add(e.getValue(),
                          JarFileUtil.readFile(client1_14_4, e.getKey()));
        cg.add(Assets.client1_14_4, e.getValue());

        sw.stop();
        ReFlect.logger.info("Extracted " + e.getValue() + " in " +
                            sw.getElapsedInSeconds() + "s.");
      }

      sw.start();

      String langEnUs1_14_4 =
          new String(JarFileUtil.readFile(client1_14_4, LANG_EN_US_1_14_4),
                     StandardCharsets.UTF_8);
      Map<String, String> langMapEnUs1_14_4 =
          JsonLanguageMap.parse(langEnUs1_14_4);

      String langEnUs = new String(
          IOUtil.readAllBytes(ReFlect.getInputStream(LANG_SOURCE_EN_US)),
          StandardCharsets.UTF_8);
      Map<String, String> langMap =
          new HashMap<>(RawLanguageMap.parse(langEnUs));

      for (Map.Entry<String, String> e : LANG_KEYS_1_14_4.entries()) {
        String key = e.getKey();
        String value = e.getValue();

        langMap.put(value, langMapEnUs1_14_4.get(key));
      }

      langEnUs = RawLanguageMap.stringify(langMap);

      sw.stop();
      ReFlect.logger.info("Generated " + LANG_EN_US + " in " + sw.getElapsedInSeconds() + "s.");

      assetInjector.add(LANG_EN_US, langEnUs.getBytes(StandardCharsets.UTF_8));
      cg.add(Assets.client1_14_4, LANG_EN_US);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    for (Map.Entry<AssetIdentifier, String> e : ASSETS_1_13_2.entrySet()) {
      byte[] data = fetch(assetFetcher, e.getKey());

      sw.start();
      assetInjector.add(e.getValue(), data);
      cg.add(e.getKey(), e.getValue());
      sw.stop();

      ReFlect.logger.info("Extracted " + e.getValue() + " in " +
                          sw.getElapsedInSeconds() + "s.");
    }

    assetInjector.add(CREDITS_FILENAME,
                      cg.generate().getBytes(StandardCharsets.UTF_8));

    ReFlect.logger.info("Injecting files...");
    sw.start();
    assetInjector.commit();
    sw.stop();
    ReFlect.logger.info("Injected files in " + sw.getElapsedInSeconds() + "s.");

    swTotal.stop();
    ReFlect.logger.info("Setup completed in " + swTotal.getElapsedInSeconds() +
                        "s.");

    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException |
             IllegalAccessException | UnsupportedLookAndFeelException e) {
      throw new RuntimeException(e);
    }

    JOptionPane.showMessageDialog(
            null, "ReFlect has been set up successfully. Please restart the game.",
            "ReFlect", JOptionPane.INFORMATION_MESSAGE);
  }
}
