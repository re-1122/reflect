package com.koyomiji.reflect.block;

import com.koyomiji.reflect.ReFlect;
import com.koyomiji.reflect.util.I18nUtil;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockWoodenPressurePlate extends BlockPressurePlate {
  public BlockWoodenPressurePlate(String id, String translationKey) {
    super(Material.WOOD, BlockPressurePlate.Sensitivity.EVERYTHING);
    setHardness(0.5F);
    setSoundType(SoundType.WOOD);

    setRegistryName(ReFlect.MODID, id);
    setTranslationKey(I18nUtil.join(ReFlect.MODID, translationKey));
  }

  public BlockWoodenPressurePlate(String id) { this(id, id); }
}
