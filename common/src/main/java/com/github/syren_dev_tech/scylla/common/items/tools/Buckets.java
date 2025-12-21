package com.github.syren_dev_tech.scylla.common.items.tools;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public class Buckets {

    private Buckets() {
    }

    public static final Supplier<BucketItem> create(ModRegister register, String name) {
        return create(register, name, new Properties());
    }

    public static final Supplier<BucketItem> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, new Properties(), creativeTab);
    }

    public static final Supplier<BucketItem> create(ModRegister register, String name, Properties properties) {
        return create(register, name, properties, Fluids.EMPTY);
    }

    public static final Supplier<BucketItem> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, Fluids.EMPTY, creativeTab);
    }

    public static final Supplier<BucketItem> create(ModRegister register, String name, Properties properties, Fluid fluid) {
        var bucket = register.itemRegistry.register(name, () -> new BucketItem(() -> fluid, properties));
        register.itemRegistry.tools.put(name, bucket);

        return bucket;
    }

    public static final Supplier<BucketItem> create(ModRegister register, String name, Properties properties, Fluid fluid, ResourceKey<CreativeModeTab> creativeTab) {
        var bucket = register.itemRegistry.register(name, () -> new BucketItem(() -> fluid, properties), creativeTab);
        register.itemRegistry.tools.put(name, bucket);

        return bucket;
    }
}
