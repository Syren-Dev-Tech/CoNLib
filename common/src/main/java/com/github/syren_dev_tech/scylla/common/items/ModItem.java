package com.github.syren_dev_tech.scylla.common.items;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item.Properties;

public class ModItem {

    private ModItem() {
    }

    public static final Supplier<Item> create(ModRegister register, String name) {
        return create(register, name, new Item.Properties());
    }

    public static final Supplier<Item> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, new Item.Properties(), creativeTab);
    }

    public static final Supplier<Item> create(ModRegister register, String name, Properties properties) {
        return register.itemRegistry.register(name, () -> new Item(properties));
    }

    public static final Supplier<Item> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.itemRegistry.register(name, () -> new Item(properties), creativeTab);
    }
}