package com.github.syren_dev_tech.scylla.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabRegistry {
    // private final ModRegister registry;
    private final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS;

    public final HashMap<String, RegistryObject<CreativeModeTab>> groups = new HashMap<>();
    public final HashMap<ResourceKey<CreativeModeTab>, List<RegistryObject<? extends Item>>> creativeTabs = new HashMap<>();

    public final Supplier<CreativeModeTab> register(String name, RegistryObject<Item> icon) {
        var tagRegistry = this.CREATIVE_MODE_TABS.register(name, () -> CreativeModeTab.builder()
                .withTabsBefore(CreativeModeTabs.COMBAT)
                .icon(() -> icon.get().getDefaultInstance())
                .displayItems((parameters, output) -> output.accept(icon.get())).build());

        this.groups.put(name, tagRegistry);

        return tagRegistry;
    }

    public <T extends Item> Supplier<T> useCreativeTab(ResourceKey<CreativeModeTab> tab,
            RegistryObject<T> item) {
        var items = creativeTabs.get(tab);
        if (items == null) {
            items = new ArrayList<>();
            creativeTabs.put(tab, items);
        }

        items.add(item);

        return item;
    }

    public final void finish(IEventBus bus) {
        this.CREATIVE_MODE_TABS.register(bus);
    }

    public CreativeTabRegistry(ModRegister registry) {
        // this.registry = registry;
        this.CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, registry.modId);
    }
}
