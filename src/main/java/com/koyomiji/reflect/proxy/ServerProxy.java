package com.koyomiji.reflect.proxy;

import com.koyomiji.reflect.ReFlect;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = ReFlect.MODID, value = Side.SERVER)
public class ServerProxy extends CommonProxy {}
