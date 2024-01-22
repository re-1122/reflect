package com.koyomiji.reflect;

import com.koyomiji.reflect.proxy.CommonProxy;
import com.koyomiji.reflect.setup.Assets;
import com.koyomiji.reflect.setup.Setup;
import com.koyomiji.refound.RecipeUnregisterer;
import com.koyomiji.refound.asset.AssetFetcher;
import com.koyomiji.refound.asset.FileInjector;
import com.koyomiji.refound.util.JarFileUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.jar.JarFile;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ReFlect.MODID, dependencies = "required-after:refound")
public class ReFlect {
  public static final String MODID = "reflect";
  @Mod.Instance public static ReFlect instance;
  @SidedProxy(clientSide = "com.koyomiji.reflect.proxy.ClientProxy",
              serverSide = "com.koyomiji.reflect.proxy.ServerProxy")
  public static CommonProxy proxy;
  public static Logger logger;
  public static File modFile;
  public static boolean isDeobfuscatedEnvironment;

  @Mod.EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    logger = event.getModLog();
    modFile = event.getSourceFile();
    isDeobfuscatedEnvironment =
        (boolean)Launch.blackboard.get("fml.deobfuscatedEnvironment");

    Setup.setup();
    proxy.preInit(event);
  }

  @Mod.EventHandler
  public void init(FMLInitializationEvent event) {
    proxy.init(event);
  }

  @Mod.EventHandler
  public void postInit(FMLPostInitializationEvent event) {
    proxy.postInit(event);
  }

  public static InputStream getInputStream(String pathStr) {
    if (isDeobfuscatedEnvironment) {
      Path path = modFile.toPath().resolve(pathStr);
      try {
        return Files.newInputStream(path);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    } else {
      try {
        JarFile modFileJar = new JarFile(modFile);
        return modFileJar.getInputStream(modFileJar.getJarEntry(pathStr));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
