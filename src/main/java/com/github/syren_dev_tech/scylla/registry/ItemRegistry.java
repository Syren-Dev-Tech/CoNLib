package com.github.syren_dev_tech.scylla.registry;

import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.Scylla;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    private final ModRegister registry;
    private final DeferredRegister<Item> deferredItemRegistry;

    public final Map<String, Supplier<? extends Item>> items = new HashMap<>();
    public final Map<String, Supplier<? extends Item>> tools = new HashMap<>();
    public final Map<String, Supplier<? extends Item>> weapons = new HashMap<>();
    public final Map<String, Supplier<? extends ArmorItem>> wearable = new HashMap<>();
    public final Map<String, Supplier<? extends Item>> foods = new HashMap<>();

    public final void finish(IEventBus bus) {
        deferredItemRegistry.register(bus);
    }

    public final <T extends Item> Supplier<T> register(String name, Supplier<T> item) {
        var newItem = deferredItemRegistry.register(name, item);
        this.items.put(name, newItem);

        if (Scylla.LOGGER.isInfoEnabled()) {
            Scylla.LOGGER.info(String.format("Registered new item (not in creative tab): %s", name));
        }

        return newItem;
    }

    public final <T extends Item> Supplier<T> register(String name, Supplier<T> item, ResourceKey<CreativeModeTab> creativeTab) {
        var newItem = this.deferredItemRegistry.register(name, item);
        this.items.put(name, newItem);

        this.registry.creativeTabRegistry.useCreativeTab(creativeTab, newItem);

        if (Scylla.LOGGER.isInfoEnabled()) {
            Scylla.LOGGER.info(String.format("Registered new item: %s:%s", this.registry.modId, name));
        }

        return newItem;
    }

    public ItemRegistry(ModRegister registry) {
        this.registry = registry;
        this.deferredItemRegistry = DeferredRegister.create(ForgeRegistries.ITEMS, registry.modId);
    }
}
