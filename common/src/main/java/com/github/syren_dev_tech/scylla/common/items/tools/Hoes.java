package com.github.syren_dev_tech.scylla.common.items.tools;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

public class Hoes {

    private Hoes() {
    }

    public static final Supplier<HoeItem> create(ModRegister register, String name) {
        return create(register, name, new Properties(), Tiers.IRON, 0, -3.0F);
    }

    public static final Supplier<HoeItem> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, new Properties(), Tiers.IRON, 0, -3.0F, creativeTab);
    }

    public static final Supplier<HoeItem> create(ModRegister register, String name, Properties properties) {
        return create(register, name, properties, Tiers.IRON, 0, -3.0F);
    }

    public static final Supplier<HoeItem> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, Tiers.IRON, 0, -3.0F, creativeTab);
    }

    public static final Supplier<HoeItem> create(ModRegister register, String name, Properties properties, Tier tier) {
        return create(register, name, properties, tier, 0, -3.0F);
    }

    public static final Supplier<HoeItem> create(ModRegister register, String name, Properties properties, Tier tier, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, tier, 0, -3.0F, creativeTab);
    }

    public static final Supplier<HoeItem> create(ModRegister register, String name, Tier tier, Integer attackDamage, Float attackSpeed) {
        return create(register, name, new Properties(), tier, attackDamage, attackSpeed);
    }

    public static final Supplier<HoeItem> create(ModRegister register, String name, Tier tier, Integer attackDamage, Float attackSpeed, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, new Properties(), tier, attackDamage, attackSpeed, creativeTab);
    }

    public static final Supplier<HoeItem> create(ModRegister register, String name, Properties properties, Tier tier, Integer attackDamage, Float attackSpeed) {
        var hoe = register.itemRegistry.register(name, () -> new HoeItem(tier, attackDamage, attackSpeed, properties));
        register.itemRegistry.tools.put(name, hoe);

        return hoe;
    }

    public static final Supplier<HoeItem> create(ModRegister register, String name, Properties properties, Tier tier, Integer attackDamage, Float attackSpeed, ResourceKey<CreativeModeTab> creativeTab) {
        var hoe = register.itemRegistry.register(name, () -> new HoeItem(tier, attackDamage, attackSpeed, properties), creativeTab);
        register.itemRegistry.tools.put(name, hoe);

        return hoe;
    }
}
