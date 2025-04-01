package com.github.chrisofnormandy.conlib.registry;

import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.CoNLib;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    private final ModRegister registry;
    private final DeferredRegister<Item> ITEMS;

    public final HashMap<String, Supplier<? extends Item>> items = new HashMap<>();
    public final HashMap<String, Supplier<? extends Item>> tools = new HashMap<>();
    public final HashMap<String, Supplier<? extends Item>> weapons = new HashMap<>();
    public final HashMap<String, Supplier<? extends ArmorItem>> wearable = new HashMap<>();
    public final HashMap<String, Supplier<? extends Item>> foods = new HashMap<>();

    public final void finish(IEventBus bus) {
        ITEMS.register(bus);
    }

    public final <T extends Item> Supplier<T> register(String name, Supplier<T> item) {
        var registry = ITEMS.register(name, item);
        this.items.put(name, registry);

        CoNLib.LOGGER.info("Registered new item (not in creative tab): " + name);

        return registry;
    }

    public final <T extends Item> Supplier<T> register(String name, Supplier<T> item, ResourceKey<CreativeModeTab> creativeTab) {
        var itemRegistry = this.ITEMS.register(name, item);
        this.items.put(name, itemRegistry);

        this.registry.creativeTabRegistry.useCreativeTab(creativeTab, itemRegistry);

        CoNLib.LOGGER.info("Registered new item: " + this.registry.modId + ":" + name);

        return itemRegistry;
    }

    public ItemRegistry(ModRegister registry) {
        this.registry = registry;
        this.ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, registry.modId);
    }
}
