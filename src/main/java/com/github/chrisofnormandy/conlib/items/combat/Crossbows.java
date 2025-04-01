package com.github.chrisofnormandy.conlib.items.combat;

import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;

public class Crossbows {

    public static final Supplier<CrossbowItem> create(ModRegister register, String name) {
        return create(register, name, new Item.Properties());
    }

    public static final Supplier<CrossbowItem> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, new Item.Properties(), creativeTab);
    }

    public static final Supplier<CrossbowItem> create(ModRegister register, String name, Properties properties) {
        var crossbow = register.itemRegistry.register(name, () -> new CrossbowItem(properties));
        register.itemRegistry.weapons.put(name, crossbow);

        return crossbow;
    }

    public static final Supplier<CrossbowItem> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        var crossbow = register.itemRegistry.register(name, () -> new CrossbowItem(properties), creativeTab);
        register.itemRegistry.weapons.put(name, crossbow);

        return crossbow;
    }
}
