package com.koyomiji.reflect.block;

import com.koyomiji.reflect.ReFlect;
import com.koyomiji.reflect.util.I18nUtil;
import net.minecraft.block.BlockButtonWood;
import net.minecraft.block.SoundType;

public class BlockWoodenButton extends BlockButtonWood {
  public BlockWoodenButton(String id, String translationKey) {
    super();
    setHardness(0.5F);
    setSoundType(SoundType.WOOD);

    setRegistryName(ReFlect.MODID, id);
    setTranslationKey(I18nUtil.join(ReFlect.MODID, translationKey));
  }

  public BlockWoodenButton(String id) { this(id, id); }
}
