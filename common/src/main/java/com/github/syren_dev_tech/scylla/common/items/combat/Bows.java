package com.github.syren_dev_tech.scylla.common.items.combat;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;

public class Bows {

    private Bows() {
    }

    public static final Supplier<BowItem> create(ModRegister register, String name) {
        return create(register, name, new Item.Properties());
    }

    public static final Supplier<BowItem> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, new Item.Properties(), creativeTab);
    }

    public static final Supplier<BowItem> create(ModRegister register, String name, Properties properties) {
        var bow = register.itemRegistry.register(name, () -> new BowItem(properties));
        register.itemRegistry.weapons.put(name, bow);

        return bow;
    }

    public static final Supplier<BowItem> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        var bow = register.itemRegistry.register(name, () -> new BowItem(properties), creativeTab);
        register.itemRegistry.weapons.put(name, bow);

        return bow;
    }
}
