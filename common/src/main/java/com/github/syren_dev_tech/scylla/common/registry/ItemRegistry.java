package com.github.syren_dev_tech.scylla.common.registry;

import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.ScyllaCommon;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;

public class ItemRegistry {

    private final ModRegister registry;
    private final IRegistrar<Item> registrar;

    public final Map<String, Supplier<? extends Item>> items = new HashMap<>();
    public final Map<String, Supplier<? extends Item>> tools = new HashMap<>();
    public final Map<String, Supplier<? extends Item>> weapons = new HashMap<>();
    public final Map<String, Supplier<? extends ArmorItem>> wearable = new HashMap<>();
    public final Map<String, Supplier<? extends Item>> foods = new HashMap<>();

    public final <T extends Item> Supplier<T> register(String name, Supplier<T> item) {
        var newItem = registrar.register(registry.modId, name, item);
        this.items.put(name, newItem);

        if (ScyllaCommon.LOGGER.isInfoEnabled()) {
            ScyllaCommon.LOGGER.info(String.format("Registered new item (not in creative tab): %s", name));
        }

        return newItem;
    }

    public final <T extends Item> Supplier<T> register(String name, Supplier<T> item, ResourceKey<CreativeModeTab> creativeTab) {
        var newItem = this.registrar.register(registry.modId, name, item);
        this.items.put(name, newItem);

        this.registry.creativeTabRegistry.useCreativeTab(creativeTab, newItem);

        if (ScyllaCommon.LOGGER.isInfoEnabled()) {
            ScyllaCommon.LOGGER.info(String.format("Registered new item: %s:%s", this.registry.modId, name));
        }

        return newItem;
    }

    public <X> void finish(X bus) {
        this.registrar.finish(bus);
    }

    public ItemRegistry(ModRegister registry, IRegistrar<Item> registrar) {
        this.registry = registry;
        this.registrar = registrar;
    }
}
