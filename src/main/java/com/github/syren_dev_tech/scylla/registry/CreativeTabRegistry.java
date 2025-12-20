package com.github.syren_dev_tech.scylla.registry;

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
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.network.chat.Component;

public class CreativeTabRegistry {
    private final ModRegister registry;
    private final DeferredRegister<CreativeModeTab> creativeModeTabs;

    public final Map<String, RegistryObject<CreativeModeTab>> groups = new HashMap<>();
    public final Map<ResourceKey<CreativeModeTab>, List<RegistryObject<? extends Item>>> creativeTabs = new HashMap<>();

    public final Supplier<CreativeModeTab> register(String name, RegistryObject<Item> icon) {
        RegistryObject<CreativeModeTab> tagRegistry = creativeModeTabs.register(name, () -> {
            ResourceKey<CreativeModeTab> tabKey = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), new ResourceLocation(registry.modId, name));
            return CreativeModeTab.builder().title(Component.translatable(tabKey.location().toString())).icon(() -> icon.get().getDefaultInstance()).displayItems((params, output) -> {
                List<RegistryObject<? extends Item>> items = creativeTabs.get(tabKey);
                if (items != null) {
                    for (RegistryObject<? extends Item> item : items) {
                        output.accept(item.get().getDefaultInstance());
                    }
                }
            }).build();
        });

        this.groups.put(name, tagRegistry);

        return tagRegistry;
    }

    public <T extends Item> Supplier<T> useCreativeTab(ResourceKey<CreativeModeTab> tab, RegistryObject<T> item) {
        List<RegistryObject<? extends Item>> items = creativeTabs.computeIfAbsent(tab, k -> new ArrayList<>());

        items.add(item);

        return item;
    }

    public final void finish(IEventBus bus) {
        this.creativeModeTabs.register(bus);
    }

    public CreativeTabRegistry(ModRegister registry) {
        this.registry = registry;
        this.creativeModeTabs = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), registry.modId);
    }
}
