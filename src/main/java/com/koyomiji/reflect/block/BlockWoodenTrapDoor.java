package com.koyomiji.reflect.block;

import com.koyomiji.reflect.ReFlect;
import com.koyomiji.reflect.util.I18nUtil;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;

public class BlockWoodenTrapDoor extends BlockTrapDoor {
  public BlockWoodenTrapDoor(String id, String translationKey) {
    super(Material.WOOD);
    setHardness(3.0F);
    setSoundType(SoundType.WOOD);
    disableStats();

    setRegistryName(ReFlect.MODID, id);
    setTranslationKey(I18nUtil.join(ReFlect.MODID, translationKey));
  }

  public BlockWoodenTrapDoor(String id) { this(id, id); }
}
