package com.koyomiji.reflect.proxy;

import com.koyomiji.reflect.ReFlect;
import com.koyomiji.reflect.ReFlectBlocks;
import com.koyomiji.reflect.ReFlectSoundEvents;
import com.koyomiji.reflect.block.*;
import com.koyomiji.reflect.item.ItemSign;
import com.koyomiji.reflect.type.*;
import com.koyomiji.reflect.util.I18nUtil;
import com.koyomiji.refound.RecipeUnregisterer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber(modid = ReFlect.MODID)
public abstract class CommonProxy {
  public void preInit(FMLPreInitializationEvent event) {
    RecipeUnregisterer.unregisterRecipe(
        new ResourceLocation("minecraft:trapdoor"));
    RecipeUnregisterer.unregisterAdvancement(new ResourceLocation("minecraft:recipes/redstone/trapdoor"));
    RecipeUnregisterer.unregisterRecipe(
        new ResourceLocation("minecraft:wooden_pressure_plate"));
      RecipeUnregisterer.unregisterAdvancement(new ResourceLocation("minecraft:recipes/redstone/wooden_pressure_plate"));
    RecipeUnregisterer.unregisterRecipe(
        new ResourceLocation("minecraft:wooden_button"));
      RecipeUnregisterer.unregisterAdvancement(new ResourceLocation("minecraft:recipes/redstone/wooden_button"));
    RecipeUnregisterer.unregisterRecipe(new ResourceLocation("minecraft:sign"));
    RecipeUnregisterer.unregisterAdvancement(new ResourceLocation("minecraft:recipes/decorations/sign"));
    RecipeUnregisterer.unregisterRecipe(
        new ResourceLocation("minecraft:stone_slab"));
    RecipeUnregisterer.unregisterAdvancement(new ResourceLocation("minecraft:recipes/building_blocks/stone_slab"));
    RecipeUnregisterer.unregisterRecipe(
        new ResourceLocation("minecraft:sandstone_slab"));
    RecipeUnregisterer.unregisterAdvancement(new ResourceLocation("minecraft:recipes/building_blocks/sandstone_slab"));
    RecipeUnregisterer.unregisterRecipe(
        new ResourceLocation("minecraft:red_sandstone_slab"));
    RecipeUnregisterer.unregisterAdvancement(new ResourceLocation("minecraft:recipes/building_blocks/red_sandstone_slab"));
    RecipeUnregisterer.unregisterRecipe(
        new ResourceLocation("minecraft:stone_brick_slab"));
    RecipeUnregisterer.unregisterAdvancement(new ResourceLocation("minecraft:recipes/building_blocks/stone_brick_slab"));
    RecipeUnregisterer.unregisterRecipe(
        new ResourceLocation("minecraft:stone_brick_stairs"));
    RecipeUnregisterer.unregisterAdvancement(new ResourceLocation("minecraft:recipes/building_blocks/stone_brick_stairs"));
    RecipeUnregisterer.unregisterRecipe(
        new ResourceLocation("minecraft:nether_brick_fence"));
    RecipeUnregisterer.unregisterAdvancement(new ResourceLocation("minecraft:recipes/decorations/nether_brick_fence"));

    Blocks.WOODEN_BUTTON.setTranslationKey(
        I18nUtil.join(ReFlect.MODID, "oak_button"));
    Blocks.STONE_BUTTON.setTranslationKey(
        I18nUtil.join(ReFlect.MODID, "stone_button"));
  }

  public void init(FMLInitializationEvent event) {
    GameRegistry.addSmelting(new ItemStack(Blocks.STONE, 1, 0),
                             new ItemStack(ReFlectBlocks.SMOOTH_STONE, 1, 0),
                             0.1F);
    GameRegistry.addSmelting(new ItemStack(Blocks.SANDSTONE, 1, 0),
                             new ItemStack(ReFlectBlocks.SMOOTH_STONE, 1, 1),
                             0.1F);
    GameRegistry.addSmelting(new ItemStack(Blocks.QUARTZ_BLOCK, 1, 0),
                             new ItemStack(ReFlectBlocks.SMOOTH_STONE, 1, 2),
                             0.1F);
    GameRegistry.addSmelting(new ItemStack(Blocks.RED_SANDSTONE, 1, 0),
                             new ItemStack(ReFlectBlocks.SMOOTH_STONE, 1, 3),
                             0.1F);
  }

  public void postInit(FMLPostInitializationEvent event) {}

  @SubscribeEvent
  public static void registerBlocks(RegistryEvent.Register<Block> event) {
    event.getRegistry().registerAll(
        new BlockStrippedLog("stripped_log", "stripped_log"),
        new BlockStrippedLog2("stripped_log2", "stripped_log"),

        new BlockWood("wood", "wood"), new BlockWood2("wood2", "wood"),

        new BlockStrippedWood("stripped_wood", "stripped_wood"),
        new BlockStrippedWood2("stripped_wood2", "stripped_wood"),

        new BlockPrismarineStairs.Rough("prismarine_stairs"),
        new BlockPrismarineStairs.Brick("prismarine_brick_stairs"),
        new BlockPrismarineStairs.Dark("dark_prismarine_stairs"),
        new BlockPrismarineSlab.Double("prismarine_double_slab",
                                       "prismarine_slab"),
        new BlockPrismarineSlab.Half("prismarine_slab", "prismarine_slab"),

        new BlockWoodenPressurePlate("spruce_pressure_plate"),
        new BlockWoodenPressurePlate("birch_pressure_plate"),
        new BlockWoodenPressurePlate("jungle_pressure_plate"),
        new BlockWoodenPressurePlate("acacia_pressure_plate"),
        new BlockWoodenPressurePlate("dark_oak_pressure_plate"),

        new BlockWoodenTrapDoor("spruce_trapdoor"),
        new BlockWoodenTrapDoor("birch_trapdoor"),
        new BlockWoodenTrapDoor("jungle_trapdoor"),
        new BlockWoodenTrapDoor("acacia_trapdoor"),
        new BlockWoodenTrapDoor("dark_oak_trapdoor"),

        new BlockWoodenButton("spruce_button"),
        new BlockWoodenButton("birch_button"),
        new BlockWoodenButton("jungle_button"),
        new BlockWoodenButton("acacia_button"),
        new BlockWoodenButton("dark_oak_button"),

        new BlockStoneStairs.Stone("stone_stairs"),
        new BlockStoneStairs.Granite("granite_stairs"),
        new BlockStoneStairs.SmoothGranite("smooth_granite_stairs",
                                           "polished_granite_stairs"),
        new BlockStoneStairs.Diorite("diorite_stairs"),
        new BlockStoneStairs.SmoothDiorite("smooth_diorite_stairs",
                                           "polished_diorite_stairs"),
        new BlockStoneStairs.Andesite("andesite_stairs"),
        new BlockStoneStairs.SmoothAndesite("smooth_andesite_stairs",
                                            "polished_andesite_stairs"),
        new BlockStoneSlab.Double("stone_double_slab3", "stone_slab3"),
        new BlockStoneSlab.Half("stone_slab3", "stone_slab3"),

        new BlockCobblestoneStairs.Mossy("mossy_cobblestone_stairs"),
        new BlockCobblestoneSlab.Double("cobblestone_double_slab",
                                        "cobblestone_slab"),
        new BlockCobblestoneSlab.Half("cobblestone_slab", "cobblestone_slab"),

        new BlockSandstoneSlab.Double("sandstone_double_slab",
                                      "sandstone_slab"),
        new BlockSandstoneSlab.Half("sandstone_slab", "sandstone_slab"),

        ReFlectBlocks.SMOOTH_STONE = new BlockSmoothStone("smooth_stone"),
        new BlockSmoothStoneStairs.Sandstone("smooth_sandstone_stairs"),
        new BlockSmoothStoneStairs.Quartz("smooth_quartz_stairs"),
        new BlockSmoothStoneStairs.RedSandstone("smooth_red_sandstone_stairs"),
        new BlockSmoothStoneSlab.Double("smooth_stone_double_slab",
                                        "smooth_stone_slab"),
        new BlockSmoothStoneSlab.Half("smooth_stone_slab", "smooth_stone_slab"),

        new BlockStonebrickStairs.Mossy("mossy_stone_brick_stairs"),
        new BlockStonebrickSlab.Double("stone_brick_double_slab",
                                       "stone_brick_slab"),
        new BlockStonebrickSlab.Half("stone_brick_slab", "stone_brick_slab"),

        new BlockRedSandstoneSlab.Double("red_sandstone_double_slab",
                                         "red_sandstone_slab"),
        new BlockRedSandstoneSlab.Half("red_sandstone_slab",
                                       "red_sandstone_slab"),

        new BlockEndStoneBrickStairs.Default("end_brick_stairs"),
        new BlockEndStoneBrickSlab.Double("end_brick_double_slab",
                                          "end_brick_slab"),
        new BlockEndStoneBrickSlab.Half("end_brick_slab", "end_brick_slab"),

        new BlockRedNetherBrickStairs.Default("red_nether_brick_stairs"),
        new BlockRedNetherBrickSlab.Double("red_nether_brick_double_slab",
                                           "red_nether_brick_slab"),
        new BlockRedNetherBrickSlab.Half("red_nether_brick_slab",
                                         "red_nether_brick_slab"),

        new BlockStoneWall("stone_wall"),
        new BlockSandstoneWall("sandstone_wall"),
        new BlockBrickWall("brick_wall"),
        new BlockStonebrickWall("stone_brick_wall"),
        new BlockNetherBrickWall("nether_brick_wall"),
        new BlockPrismarineWall("prismarine_wall"),
        new BlockRedSandstoneWall("red_sandstone_wall"),
        new BlockEndStoneBrickWall("end_brick_wall"),
        new BlockRedNetherBrickWall("red_nether_brick_wall"),

        new BlockStandingSign.Spruce("spruce_standing_sign", "spruce_sign"),
        new BlockStandingSign.Birch("birch_standing_sign", "birch_sign"),
        new BlockStandingSign.Jungle("jungle_standing_sign", "jungle_sign"),
        new BlockStandingSign.Acacia("acacia_standing_sign", "acacia_sign"),
        new BlockStandingSign.DarkOak("dark_oak_standing_sign",
                                      "dark_oak_sign"),
        new BlockWallSign.Spruce("spruce_wall_sign", "spruce_sign"),
        new BlockWallSign.Birch("birch_wall_sign", "birch_sign"),
        new BlockWallSign.Jungle("jungle_wall_sign", "jungle_sign"),
        new BlockWallSign.Acacia("acacia_wall_sign", "acacia_sign"),
        new BlockWallSign.DarkOak("dark_oak_wall_sign", "dark_oak_sign"));
  }

  @SubscribeEvent
  public static void registerItems(RegistryEvent.Register<Item> event) {
    event.getRegistry().registerAll(
        new ItemMultiTexture(ReFlectBlocks.STRIPPED_LOG, null,
                             new ItemMultiTexture.Mapper() {
                               public String apply(ItemStack is) {
                                 return PlanksType.byMetadata(is.getMetadata())
                                     .getTranslationKey();
                               }
                             })
            .setRegistryName(ReFlectBlocks.STRIPPED_LOG.getRegistryName()),
        new ItemMultiTexture(ReFlectBlocks.STRIPPED_LOG2, null,
                             new ItemMultiTexture.Mapper() {
                               public String apply(ItemStack is) {
                                 return PlanksType
                                     .byMetadata(is.getMetadata() + 4)
                                     .getTranslationKey();
                               }
                             })
            .setRegistryName(ReFlectBlocks.STRIPPED_LOG2.getRegistryName()),

        new ItemMultiTexture(ReFlectBlocks.WOOD, null,
                             new ItemMultiTexture.Mapper() {
                               public String apply(ItemStack is) {
                                 return PlanksType.byMetadata(is.getMetadata())
                                     .getTranslationKey();
                               }
                             })
            .setRegistryName(ReFlectBlocks.WOOD.getRegistryName()),
        new ItemMultiTexture(ReFlectBlocks.WOOD2, null,
                             new ItemMultiTexture.Mapper() {
                               public String apply(ItemStack is) {
                                 return PlanksType
                                     .byMetadata(is.getMetadata() + 4)
                                     .getTranslationKey();
                               }
                             })
            .setRegistryName(ReFlectBlocks.WOOD2.getRegistryName()),

        new ItemMultiTexture(ReFlectBlocks.STRIPPED_WOOD, null,
                             new ItemMultiTexture.Mapper() {
                               public String apply(ItemStack is) {
                                 return PlanksType.byMetadata(is.getMetadata())
                                     .getTranslationKey();
                               }
                             })
            .setRegistryName(ReFlectBlocks.STRIPPED_WOOD.getRegistryName()),
        new ItemMultiTexture(ReFlectBlocks.STRIPPED_WOOD2, null,
                             new ItemMultiTexture.Mapper() {
                               public String apply(ItemStack is) {
                                 return PlanksType
                                     .byMetadata(is.getMetadata() + 4)
                                     .getTranslationKey();
                               }
                             })
            .setRegistryName(ReFlectBlocks.STRIPPED_WOOD2.getRegistryName()),

        new ItemBlock(ReFlectBlocks.PRISMARINE_STAIRS)
            .setRegistryName(ReFlectBlocks.PRISMARINE_STAIRS.getRegistryName()),
        new ItemBlock(ReFlectBlocks.PRISMARINE_BRICK_STAIRS)
            .setRegistryName(
                ReFlectBlocks.PRISMARINE_BRICK_STAIRS.getRegistryName()),
        new ItemBlock(ReFlectBlocks.DARK_PRISMARINE_STAIRS)
            .setRegistryName(
                ReFlectBlocks.DARK_PRISMARINE_STAIRS.getRegistryName()),
        new ItemSlab(ReFlectBlocks.PRISMARINE_SLAB,
                     ReFlectBlocks.PRISMARINE_SLAB,
                     ReFlectBlocks.PRISMARINE_DOUBLE_SLAB)
            .setRegistryName(ReFlectBlocks.PRISMARINE_SLAB.getRegistryName()),

        new ItemBlock(ReFlectBlocks.SPRUCE_PRESSURE_PLATE)
            .setRegistryName(
                ReFlectBlocks.SPRUCE_PRESSURE_PLATE.getRegistryName()),
        new ItemBlock(ReFlectBlocks.BIRCH_PRESSURE_PLATE)
            .setRegistryName(
                ReFlectBlocks.BIRCH_PRESSURE_PLATE.getRegistryName()),
        new ItemBlock(ReFlectBlocks.JUNGLE_PRESSURE_PLATE)
            .setRegistryName(
                ReFlectBlocks.JUNGLE_PRESSURE_PLATE.getRegistryName()),
        new ItemBlock(ReFlectBlocks.ACACIA_PRESSURE_PLATE)
            .setRegistryName(
                ReFlectBlocks.ACACIA_PRESSURE_PLATE.getRegistryName()),
        new ItemBlock(ReFlectBlocks.DARK_OAK_PRESSURE_PLATE)
            .setRegistryName(
                ReFlectBlocks.DARK_OAK_PRESSURE_PLATE.getRegistryName()),

        new ItemBlock(ReFlectBlocks.SPRUCE_TRAPDOOR)
            .setRegistryName(ReFlectBlocks.SPRUCE_TRAPDOOR.getRegistryName()),
        new ItemBlock(ReFlectBlocks.BIRCH_TRAPDOOR)
            .setRegistryName(ReFlectBlocks.BIRCH_TRAPDOOR.getRegistryName()),
        new ItemBlock(ReFlectBlocks.JUNGLE_TRAPDOOR)
            .setRegistryName(ReFlectBlocks.JUNGLE_TRAPDOOR.getRegistryName()),
        new ItemBlock(ReFlectBlocks.ACACIA_TRAPDOOR)
            .setRegistryName(ReFlectBlocks.ACACIA_TRAPDOOR.getRegistryName()),
        new ItemBlock(ReFlectBlocks.DARK_OAK_TRAPDOOR)
            .setRegistryName(ReFlectBlocks.DARK_OAK_TRAPDOOR.getRegistryName()),

        new ItemBlock(ReFlectBlocks.SPRUCE_BUTTON)
            .setRegistryName(ReFlectBlocks.SPRUCE_BUTTON.getRegistryName()),
        new ItemBlock(ReFlectBlocks.BIRCH_BUTTON)
            .setRegistryName(ReFlectBlocks.BIRCH_BUTTON.getRegistryName()),
        new ItemBlock(ReFlectBlocks.JUNGLE_BUTTON)
            .setRegistryName(ReFlectBlocks.JUNGLE_BUTTON.getRegistryName()),
        new ItemBlock(ReFlectBlocks.ACACIA_BUTTON)
            .setRegistryName(ReFlectBlocks.ACACIA_BUTTON.getRegistryName()),
        new ItemBlock(ReFlectBlocks.DARK_OAK_BUTTON)
            .setRegistryName(ReFlectBlocks.DARK_OAK_BUTTON.getRegistryName()),

        new ItemBlock(ReFlectBlocks.STONE_STAIRS)
            .setRegistryName(ReFlectBlocks.STONE_STAIRS.getRegistryName()),
        new ItemBlock(ReFlectBlocks.GRANITE_STAIRS)
            .setRegistryName(ReFlectBlocks.GRANITE_STAIRS.getRegistryName()),
        new ItemBlock(ReFlectBlocks.SMOOTH_GRANITE_STAIRS)
            .setRegistryName(
                ReFlectBlocks.SMOOTH_GRANITE_STAIRS.getRegistryName()),
        new ItemBlock(ReFlectBlocks.DIORITE_STAIRS)
            .setRegistryName(ReFlectBlocks.DIORITE_STAIRS.getRegistryName()),
        new ItemBlock(ReFlectBlocks.SMOOTH_DIORITE_STAIRS)
            .setRegistryName(
                ReFlectBlocks.SMOOTH_DIORITE_STAIRS.getRegistryName()),
        new ItemBlock(ReFlectBlocks.ANDESITE_STAIRS)
            .setRegistryName(ReFlectBlocks.ANDESITE_STAIRS.getRegistryName()),
        new ItemBlock(ReFlectBlocks.SMOOTH_ANDESITE_STAIRS)
            .setRegistryName(
                ReFlectBlocks.SMOOTH_ANDESITE_STAIRS.getRegistryName()),

        new ItemSlab(ReFlectBlocks.STONE_SLAB3, ReFlectBlocks.STONE_SLAB3,
                     ReFlectBlocks.STONE_DOUBLE_SLAB3)
            .setRegistryName(ReFlectBlocks.STONE_SLAB3.getRegistryName()),

        new ItemBlock(ReFlectBlocks.MOSSY_COBBLESTONE_STAIRS)
            .setRegistryName(
                ReFlectBlocks.MOSSY_COBBLESTONE_STAIRS.getRegistryName()),
        new ItemSlab(ReFlectBlocks.COBBLESTONE_SLAB,
                     ReFlectBlocks.COBBLESTONE_SLAB,
                     ReFlectBlocks.COBBLESTONE_DOUBLE_SLAB)
            .setRegistryName(ReFlectBlocks.COBBLESTONE_SLAB.getRegistryName()),

        new ItemSlab(ReFlectBlocks.SANDSTONE_SLAB, ReFlectBlocks.SANDSTONE_SLAB,
                     ReFlectBlocks.SANDSTONE_DOUBLE_SLAB)
            .setRegistryName(ReFlectBlocks.SANDSTONE_SLAB.getRegistryName()),

        new ItemMultiTexture(ReFlectBlocks.SMOOTH_STONE, null,
                             new ItemMultiTexture.Mapper() {
                               public String apply(ItemStack is) {
                                 return SmoothStoneType
                                     .byMetadata(is.getMetadata())
                                     .getTranslationKey();
                               }
                             })
            .setRegistryName(ReFlectBlocks.SMOOTH_STONE.getRegistryName()),
        new ItemBlock(ReFlectBlocks.SMOOTH_SANDSTONE_STAIRS)
            .setRegistryName(
                ReFlectBlocks.SMOOTH_SANDSTONE_STAIRS.getRegistryName()),
        new ItemBlock(ReFlectBlocks.SMOOTH_QUARTZ_STAIRS)
            .setRegistryName(
                ReFlectBlocks.SMOOTH_QUARTZ_STAIRS.getRegistryName()),
        new ItemBlock(ReFlectBlocks.SMOOTH_RED_SANDSTONE_STAIRS)
            .setRegistryName(
                ReFlectBlocks.SMOOTH_RED_SANDSTONE_STAIRS.getRegistryName()),
        new ItemSlab(ReFlectBlocks.SMOOTH_STONE_SLAB,
                     ReFlectBlocks.SMOOTH_STONE_SLAB,
                     ReFlectBlocks.SMOOTH_STONE_DOUBLE_SLAB)
            .setRegistryName(ReFlectBlocks.SMOOTH_STONE_SLAB.getRegistryName()),

        new ItemBlock(ReFlectBlocks.MOSSY_STONE_BRICK_STAIRS)
            .setRegistryName(
                ReFlectBlocks.MOSSY_STONE_BRICK_STAIRS.getRegistryName()),
        new ItemSlab(ReFlectBlocks.STONE_BRICK_SLAB,
                     ReFlectBlocks.STONE_BRICK_SLAB,
                     ReFlectBlocks.STONE_BRICK_DOUBLE_SLAB)
            .setRegistryName(ReFlectBlocks.STONE_BRICK_SLAB.getRegistryName()),

        new ItemSlab(ReFlectBlocks.RED_SANDSTONE_SLAB,
                     ReFlectBlocks.RED_SANDSTONE_SLAB,
                     ReFlectBlocks.RED_SANDSTONE_DOUBLE_SLAB)
            .setRegistryName(
                ReFlectBlocks.RED_SANDSTONE_SLAB.getRegistryName()),

        new ItemBlock(ReFlectBlocks.END_BRICK_STAIRS)
            .setRegistryName(ReFlectBlocks.END_BRICK_STAIRS.getRegistryName()),
        new ItemSlab(ReFlectBlocks.END_BRICK_SLAB, ReFlectBlocks.END_BRICK_SLAB,
                     ReFlectBlocks.END_BRICK_DOUBLE_SLAB)
            .setRegistryName(ReFlectBlocks.END_BRICK_SLAB.getRegistryName()),

        new ItemBlock(ReFlectBlocks.RED_NETHER_BRICK_STAIRS)
            .setRegistryName(
                ReFlectBlocks.RED_NETHER_BRICK_STAIRS.getRegistryName()),
        new ItemSlab(ReFlectBlocks.RED_NETHER_BRICK_SLAB,
                     ReFlectBlocks.RED_NETHER_BRICK_SLAB,
                     ReFlectBlocks.RED_NETHER_BRICK_DOUBLE_SLAB)
            .setRegistryName(
                ReFlectBlocks.RED_NETHER_BRICK_SLAB.getRegistryName()),

        new ItemMultiTexture(ReFlectBlocks.STONE_WALL, null,
                             new ItemMultiTexture.Mapper() {
                               public String apply(ItemStack is) {
                                 return BlockStone.EnumType
                                     .byMetadata(is.getMetadata())
                                     .getTranslationKey();
                               }
                             })
            .setRegistryName(ReFlectBlocks.STONE_WALL.getRegistryName()),
        new ItemMultiTexture(ReFlectBlocks.SANDSTONE_WALL, null,
                             new ItemMultiTexture.Mapper() {
                               public String apply(ItemStack is) {
                                 return SandstoneType
                                     .byMetadata(is.getMetadata())
                                     .getTranslationKey();
                               }
                             })
            .setRegistryName(ReFlectBlocks.SANDSTONE_WALL.getRegistryName()),
        new ItemMultiTexture(ReFlectBlocks.BRICK_WALL, null,
                             new ItemMultiTexture.Mapper() {
                               public String apply(ItemStack is) {
                                 return BrickType.byMetadata(is.getMetadata())
                                     .getTranslationKey();
                               }
                             })
            .setRegistryName(ReFlectBlocks.BRICK_WALL.getRegistryName()),
        new ItemMultiTexture(ReFlectBlocks.STONE_BRICK_WALL, null,
                             new ItemMultiTexture.Mapper() {
                               public String apply(ItemStack is) {
                                 return StonebrickType
                                     .byMetadata(is.getMetadata())
                                     .getTranslationKey();
                               }
                             })
            .setRegistryName(ReFlectBlocks.STONE_BRICK_WALL.getRegistryName()),
        new ItemMultiTexture(ReFlectBlocks.NETHER_BRICK_WALL, null,
                             new ItemMultiTexture.Mapper() {
                               public String apply(ItemStack is) {
                                 return NetherBrickType
                                     .byMetadata(is.getMetadata())
                                     .getTranslationKey();
                               }
                             })
            .setRegistryName(ReFlectBlocks.NETHER_BRICK_WALL.getRegistryName()),
        new ItemMultiTexture(ReFlectBlocks.PRISMARINE_WALL, null,
                             new ItemMultiTexture.Mapper() {
                               public String apply(ItemStack is) {
                                 return PrismarineType
                                     .byMetadata(is.getMetadata())
                                     .getTranslationKey();
                               }
                             })
            .setRegistryName(ReFlectBlocks.PRISMARINE_WALL.getRegistryName()),
        new ItemMultiTexture(ReFlectBlocks.RED_SANDSTONE_WALL, null,
                             new ItemMultiTexture.Mapper() {
                               public String apply(ItemStack is) {
                                 return RedSandstoneType
                                     .byMetadata(is.getMetadata())
                                     .getTranslationKey();
                               }
                             })
            .setRegistryName(
                ReFlectBlocks.RED_SANDSTONE_WALL.getRegistryName()),
        new ItemMultiTexture(ReFlectBlocks.END_BRICK_WALL, null,
                             new ItemMultiTexture.Mapper() {
                               public String apply(ItemStack is) {
                                 return EndStoneBrickType
                                     .byMetadata(is.getMetadata())
                                     .getTranslationKey();
                               }
                             })
            .setRegistryName(ReFlectBlocks.END_BRICK_WALL.getRegistryName()),
        new ItemMultiTexture(ReFlectBlocks.RED_NETHER_BRICK_WALL, null,
                             new ItemMultiTexture.Mapper() {
                               public String apply(ItemStack is) {
                                 return RedNetherBrickType
                                     .byMetadata(is.getMetadata())
                                     .getTranslationKey();
                               }
                             })
            .setRegistryName(
                ReFlectBlocks.RED_NETHER_BRICK_WALL.getRegistryName()),

        new ItemSign.Spruce("spruce_sign"), new ItemSign.Birch("birch_sign"),
        new ItemSign.Jungle("jungle_sign"), new ItemSign.Acacia("acacia_sign"),
        new ItemSign.DarkOak("dark_oak_sign"));
  }

  private static SoundEvent createSoundEvent(String path) {
    ResourceLocation location = new ResourceLocation(ReFlect.MODID, path);
    return new SoundEvent(location).setRegistryName(location);
  }

  @SubscribeEvent
  public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
    event.getRegistry().registerAll(ReFlectSoundEvents.ITEM_AXE_STRIP =
                                        createSoundEvent("item.axe.strip"));
  }
}
