package com.dwightaspencer.minecraft.mods.enderio.dimentions;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.lang3.tuple.Triple;

import com.enderio.core.common.Lang;
import com.enderio.core.common.util.NNList;

import crazypants.enderio.api.addon.IEnderIOAddon;
import crazypants.enderio.base.config.recipes.RecipeFactory;
import crazypants.enderio.machines.config.ConfigHandler;
import crazypants.enderio.machines.machine.teleport.telepad.render.TelePadSpecialRenderer;
import crazypants.enderio.machines.network.PacketHandler;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = EnderIODimentions.MODID, name = EnderIODimentions.MOD_NAME, version = EnderIODimentions.VERSION, dependencies = EnderIODimentions.DEPENDENCIES)
@EventBusSubscriber(Side.CLIENT)
public class EnderIODimentions implements IEnderIOAddon {

  public static final @Nonnull String MODID = "enderiodimentions";
  public static final @Nonnull String DOMAIN = "enderio";
  public static final @Nonnull String MOD_NAME = "Ender IO Dimentions";
  public static final @Nonnull String VERSION = "@VERSION@";

  private static final @Nonnull String DEFAULT_DEPENDENCIES = "after:" + crazypants.enderio.base.EnderIO.MODID;
  public static final @Nonnull String DEPENDENCIES = DEFAULT_DEPENDENCIES;

  @SubscribeEvent
  @SideOnly(Side.CLIENT)
  public static void onModelRegister(ModelRegistryEvent event) {
    TelePadSpecialRenderer.INSTANCE.registerRenderers();
  }

  @EventHandler
  public static void init(FMLPreInitializationEvent event) {
    ConfigHandler.init(event);
  }

  @EventHandler
  public static void init(FMLInitializationEvent event) {
    PacketHandler.init(event);
  }

  @EventHandler
  public static void init(FMLPostInitializationEvent event) {
  }

  public static final @Nonnull Lang lang = new Lang(DOMAIN);

  @Override
  @Nullable
  public Configuration getConfiguration() {
    return ConfigHandler.config;
  }

  @Override
  @Nonnull
  public NNList<Triple<Integer, RecipeFactory, String>> getRecipeFiles() {
    return new NNList<>(Triple.of(2, null, "machines"), Triple.of(2, null, "sagmill"));
  }

  @Override
  @Nonnull
  public NNList<String> getExampleFiles() {
    return new NNList<>("machines_easy_recipes", "machines_easy_recipes", "infinity", "cheap_machines");
  }

}
