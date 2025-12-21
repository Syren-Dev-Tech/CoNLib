package com.github.syren_dev_tech.scylla.common.items.tools;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

public class Axes {

    private Axes() {
    }

    public static final Supplier<AxeItem> create(ModRegister register, String name) {
        return create(register, name, new Properties(), Tiers.IRON, 6, -3.1F);
    }

    public static final Supplier<AxeItem> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, new Properties(), Tiers.IRON, 6, -3.1F, creativeTab);
    }

    public static final Supplier<AxeItem> create(ModRegister register, String name, Properties properties) {
        return create(register, name, properties, Tiers.IRON, 6, -3.1F);
    }

    public static final Supplier<AxeItem> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, Tiers.IRON, 6, -3.1F, creativeTab);
    }

    public static final Supplier<AxeItem> create(ModRegister register, String name, Properties properties, Tier tier) {
        return create(register, name, properties, tier, 6, -3.1F);
    }

    public static final Supplier<AxeItem> create(ModRegister register, String name, Properties properties, Tier tier, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, tier, 6, -3.1F, creativeTab);
    }

    public static final Supplier<AxeItem> create(ModRegister register, String name, Tier tier, Integer attackDamage, Float attackSpeed) {
        return create(register, name, new Properties(), tier, attackDamage, attackSpeed);
    }

    public static final Supplier<AxeItem> create(ModRegister register, String name, Tier tier, Integer attackDamage, Float attackSpeed, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, new Properties(), tier, attackDamage, attackSpeed, creativeTab);
    }

    public static final Supplier<AxeItem> create(ModRegister register, String name, Properties properties, Tier tier, Integer attackDamage, Float attackSpeed) {
        var axe = register.itemRegistry.register(name, () -> new AxeItem(tier, attackDamage, attackSpeed, properties));
        register.itemRegistry.tools.put(name, axe);

        return axe;
    }

    public static final Supplier<AxeItem> create(ModRegister register, String name, Properties properties, Tier tier, Integer attackDamage, Float attackSpeed, ResourceKey<CreativeModeTab> creativeTab) {
        var axe = register.itemRegistry.register(name, () -> new AxeItem(tier, attackDamage, attackSpeed, properties), creativeTab);
        register.itemRegistry.tools.put(name, axe);

        return axe;
    }
}
