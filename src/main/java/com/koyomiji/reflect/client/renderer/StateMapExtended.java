package com.koyomiji.reflect.client.renderer;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.util.ResourceLocation;

public class StateMapExtended extends StateMapperBase {
  private final IProperty<?> name;
  private final String prefix;
  private final String suffix;
  private final Map<String, String> renameMap;
  private final List<IProperty<?>> ignored;

  private StateMapExtended(@Nullable IProperty<?> name, @Nullable String prefix,
                           @Nullable String suffix,
                           Map<String, String> renameMap,
                           List<IProperty<?>> ignored) {
    this.name = name;
    this.prefix = prefix;
    this.suffix = suffix;
    this.renameMap = renameMap;
    this.ignored = ignored;
  }

  protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
    Map<IProperty<?>, Comparable<?>> properties =
        Maps.newLinkedHashMap(state.getProperties());
    String name;
    String location;
    ResourceLocation rl = Block.REGISTRY.getNameForObject(state.getBlock());

    if (this.name == null) {
      name = rl.getPath();
    } else {
      name = this.removeName(this.name, properties);
    }

    name = this.renameMap.getOrDefault(name, name);
    name = this.emptyIfNull(this.prefix) + name + this.emptyIfNull(this.suffix);
    location = String.format("%s:%s", rl.getNamespace(), name);

    for (IProperty<?> i : this.ignored) {
      properties.remove(i);
    }

    return new ModelResourceLocation(location,
                                     this.getPropertyString(properties));
  }

  private String emptyIfNull(String s) { return s == null ? "" : s; }

  private <T extends Comparable<T>> String
  removeName(IProperty<T> property, Map<IProperty<?>, Comparable<?>> values) {
    return property.getName((T)values.remove(this.name));
  }

  public static class Builder {
    private IProperty<?> name;
    private String prefix;
    private String suffix;
    private final Map<String, String> renameMap = Maps.newHashMap();
    private final List<IProperty<?>> ignored =
        Lists.<IProperty<?>>newArrayList();

    public StateMapExtended.Builder withName(IProperty<?> builderPropertyIn) {
      this.name = builderPropertyIn;
      return this;
    }

    public StateMapExtended.Builder withPrefix(String builderPrefixIn) {
      this.prefix = builderPrefixIn;
      return this;
    }

    public StateMapExtended.Builder withSuffix(String builderSuffixIn) {
      this.suffix = builderSuffixIn;
      return this;
    }

    public StateMapExtended.Builder remapName(String from, String to) {
      this.renameMap.put(from, to);
      return this;
    }

    public StateMapExtended.Builder ignore(IProperty<?>... ignores) {
      Collections.addAll(this.ignored, ignores);
      return this;
    }

    public StateMapExtended build() {
      return new StateMapExtended(this.name, this.prefix, this.suffix,
                                  this.renameMap, this.ignored);
    }
  }
}
