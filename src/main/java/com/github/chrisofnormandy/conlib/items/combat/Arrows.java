package com.github.chrisofnormandy.conlib.items.combat;

import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;

public class Arrows {

    public static final Supplier<ArrowItem> create(ModRegister register, String name) {
        return create(register, name, new Item.Properties());
    }

    public static final Supplier<ArrowItem> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, new Item.Properties(), creativeTab);
    }

    public static final Supplier<ArrowItem> create(ModRegister register, String name, Properties properties) {
        var arrow = register.itemRegistry.register(name, () -> new ArrowItem(properties));
        register.itemRegistry.weapons.put(name, arrow);

        return arrow;
    }

    public static final Supplier<ArrowItem> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        var arrow = register.itemRegistry.register(name, () -> new ArrowItem(properties), creativeTab);
        register.itemRegistry.weapons.put(name, arrow);

        return arrow;
    }
}
