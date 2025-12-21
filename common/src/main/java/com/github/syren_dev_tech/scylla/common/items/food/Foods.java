package com.github.syren_dev_tech.scylla.common.items.food;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.items.ModItem;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;

public class Foods {

    private Foods() {
    }

    public static final FoodProperties properties(Integer hunger, Float saturation) {
        return new FoodProperties.Builder().saturationMod(saturation).nutrition(hunger).build();
    }

    public static final Supplier<Item> create(ModRegister register, String name) {
        return create(register, name, properties(1, 0.6f));
    }

    public static final Supplier<Item> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties(1, 0.6f), creativeTab);
    }

    public static final Supplier<Item> create(ModRegister register, String name, FoodProperties food) {
        return create(register, name, new Properties(), food);
    }

    public static final Supplier<Item> create(ModRegister register, String name, FoodProperties food, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, new Properties(), food, creativeTab);
    }

    public static final Supplier<Item> create(ModRegister register, String name, Properties properties) {
        return create(register, name, properties, properties(1, 0.6f));
    }

    public static final Supplier<Item> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, properties(1, 0.6f), creativeTab);
    }

    public static final Supplier<Item> create(ModRegister register, String name, Properties properties, FoodProperties food) {
        var item = ModItem.create(register, name, properties.food(food));
        register.itemRegistry.foods.put(name, item);

        return item;
    }

    public static final Supplier<Item> create(ModRegister register, String name, Properties properties, FoodProperties food, ResourceKey<CreativeModeTab> creativeTab) {
        var item = ModItem.create(register, name, properties.food(food), creativeTab);
        register.itemRegistry.foods.put(name, item);

        return item;
    }
}
