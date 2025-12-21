package com.github.syren_dev_tech.scylla.common.items.combat;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ShieldItem;

public class Shields {

    private Shields() {
    }

    public static final Supplier<ShieldItem> create(ModRegister register, String name) {
        return create(register, name, new Item.Properties());
    }

    public static final Supplier<ShieldItem> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, new Item.Properties(), creativeTab);
    }

    public static final Supplier<ShieldItem> create(ModRegister register, String name, Properties properties) {
        var shield = register.itemRegistry.register(name, () -> new ShieldItem(properties));
        register.itemRegistry.weapons.put(name, shield);

        return shield;
    }

    public static final Supplier<ShieldItem> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        var shield = register.itemRegistry.register(name, () -> new ShieldItem(properties), creativeTab);
        register.itemRegistry.weapons.put(name, shield);

        return shield;
    }
}
