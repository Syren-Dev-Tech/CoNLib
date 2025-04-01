package com.github.chrisofnormandy.conlib.items.tools;

import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.Item.Properties;

public class FishingRods {

    public static final Supplier<FishingRodItem> create(ModRegister register, String name) {
        return create(register, name, new Properties());
    }

    public static final Supplier<FishingRodItem> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, new Properties(), creativeTab);
    }

    public static final Supplier<FishingRodItem> create(ModRegister register, String name, Properties properties) {
        var fas = register.itemRegistry.register(name, () -> new FishingRodItem(properties));
        register.itemRegistry.tools.put(name, fas);

        return fas;
    }

    public static final Supplier<FishingRodItem> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        var fas = register.itemRegistry.register(name, () -> new FishingRodItem(properties), creativeTab);
        register.itemRegistry.tools.put(name, fas);

        return fas;
    }
}
