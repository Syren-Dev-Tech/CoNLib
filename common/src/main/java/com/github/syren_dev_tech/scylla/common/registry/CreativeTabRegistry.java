package com.github.syren_dev_tech.scylla.common.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

public class CreativeTabRegistry {

    private final ModRegister registry;
    private final IRegistrar<CreativeModeTab> registrar;

    public final Map<String, Supplier<CreativeModeTab>> groups = new HashMap<>();
    public final Map<ResourceKey<CreativeModeTab>, List<Supplier<? extends Item>>> creativeTabs = new HashMap<>();

    public final Supplier<CreativeModeTab> register(String name, Supplier<Item> icon) {
        Supplier<CreativeModeTab> tagRegistry = registrar.register(registry.modId, name, () -> {
            ResourceKey<CreativeModeTab> tabKey = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), ResourceLocation.fromNamespaceAndPath(registry.modId, name));
            return CreativeModeTab.builder().title(Component.translatable(tabKey.location().toString())).icon(() -> icon.get().getDefaultInstance()).displayItems((params, output) -> {
                List<Supplier<? extends Item>> items = creativeTabs.get(tabKey);
                if (items != null) {
                    for (Supplier<? extends Item> item : items) {
                        output.accept(item.get().getDefaultInstance());
                    }
                }
            }).build();
        });

        this.groups.put(name, tagRegistry);

        return tagRegistry;
    }

    public <T extends Item> Supplier<T> useCreativeTab(ResourceKey<CreativeModeTab> tab, Supplier<T> item) {
        List<Supplier<? extends Item>> items = creativeTabs.computeIfAbsent(tab, k -> new ArrayList<>());

        items.add(item);

        return item;
    }

    public <X> void finish(X bus) {
        this.registrar.finish(bus);
    }

    public CreativeTabRegistry(ModRegister registry, IRegistrar<CreativeModeTab> registrar) {
        this.registry = registry;
        this.registrar = registrar;
    }
}
