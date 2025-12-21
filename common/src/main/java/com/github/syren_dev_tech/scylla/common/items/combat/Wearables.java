package com.github.syren_dev_tech.scylla.common.items.combat;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ArmorItem.Type;

public class Wearables {

    private Wearables() {
    }

    public static final Supplier<ArmorItem> create(ModRegister register, String name, Type armorType) {
        return create(register, name, new Properties(), armorType, ArmorMaterials.CHAIN);
    }

    public static final Supplier<ArmorItem> create(ModRegister register, String name, Type armorType, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, new Properties(), armorType, ArmorMaterials.CHAIN, creativeTab);
    }

    public static final Supplier<ArmorItem> create(ModRegister register, String name, Type armorType, ArmorMaterial armorMaterial) {
        return create(register, name, new Properties(), armorType, armorMaterial);
    }

    public static final Supplier<ArmorItem> create(ModRegister register, String name, Type armorType, ArmorMaterial armorMaterial, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, new Properties(), armorType, armorMaterial, creativeTab);
    }

    public static final Supplier<ArmorItem> create(ModRegister register, String name, Properties properties, Type armorType) {
        return create(register, name, properties, armorType, ArmorMaterials.CHAIN);
    }

    public static final Supplier<ArmorItem> create(ModRegister register, String name, Properties properties, Type armorType, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, armorType, ArmorMaterials.CHAIN, creativeTab);
    }

    public static final Supplier<ArmorItem> create(ModRegister register, String name, Properties properties, Type armorType, ArmorMaterial armorMaterial) {
        var item = register.itemRegistry.register(name, () -> new ArmorItem(armorMaterial, armorType, properties));
        register.itemRegistry.wearable.put(name, item);

        return item;
    }

    public static final Supplier<ArmorItem> create(ModRegister register, String name, Properties properties, Type armorType, ArmorMaterial armorMaterial, ResourceKey<CreativeModeTab> creativeTab) {
        var item = register.itemRegistry.register(name, () -> new ArmorItem(armorMaterial, armorType, properties), creativeTab);
        register.itemRegistry.wearable.put(name, item);

        return item;
    }
}
