package com.github.syren_dev_tech.scylla.common.items.combat;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;

public class Crossbows {

    private Crossbows() {
    }

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
