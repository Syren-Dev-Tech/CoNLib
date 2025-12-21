package com.github.syren_dev_tech.scylla.common.items.tools;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

public class Pickaxes {

    private Pickaxes() {
    }

    public static final Supplier<PickaxeItem> create(ModRegister register, String name) {
        return create(register, name, new Item.Properties(), Tiers.IRON, 2, -2.8F);
    }

    public static final Supplier<PickaxeItem> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, new Item.Properties(), Tiers.IRON, 2, -2.8F, creativeTab);
    }

    public static final Supplier<PickaxeItem> create(ModRegister register, String name, Properties properties) {
        return create(register, name, properties, Tiers.IRON, 2, -2.8F);
    }

    public static final Supplier<PickaxeItem> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, Tiers.IRON, 2, -2.8F, creativeTab);
    }

    public static final Supplier<PickaxeItem> create(ModRegister register, String name, Properties properties, Tier tier) {
        return create(register, name, properties, tier, 2, -2.8F);
    }

    public static final Supplier<PickaxeItem> create(ModRegister register, String name, Properties properties, Tier tier, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, tier, 2, -2.8F, creativeTab);
    }

    public static final Supplier<PickaxeItem> create(ModRegister register, String name, Tier tier, Integer attackDamage, Float attackSpeed) {
        return create(register, name, new Item.Properties(), tier, attackDamage, attackSpeed);
    }

    public static final Supplier<PickaxeItem> create(ModRegister register, String name, Tier tier, Integer attackDamage, Float attackSpeed, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, new Item.Properties(), tier, attackDamage, attackSpeed, creativeTab);
    }

    public static final Supplier<PickaxeItem> create(ModRegister register, String name, Properties properties, Tier tier, Integer attackDamage, Float attackSpeed) {
        var pickaxe = register.itemRegistry.register(name, () -> new PickaxeItem(tier, attackDamage, attackSpeed, properties));
        register.itemRegistry.tools.put(name, pickaxe);

        return pickaxe;
    }

    public static final Supplier<PickaxeItem> create(ModRegister register, String name, Properties properties, Tier tier, Integer attackDamage, Float attackSpeed, ResourceKey<CreativeModeTab> creativeTab) {
        var pickaxe = register.itemRegistry.register(name, () -> new PickaxeItem(tier, attackDamage, attackSpeed, properties), creativeTab);
        register.itemRegistry.tools.put(name, pickaxe);

        return pickaxe;
    }
}
