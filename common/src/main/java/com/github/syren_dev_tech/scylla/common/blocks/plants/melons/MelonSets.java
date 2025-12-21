package com.github.syren_dev_tech.scylla.common.blocks.plants.melons;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.crops.Stems;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.world.item.Item;

public class MelonSets {

    public static final Supplier<?>[] create(ModRegister register, String name, Item seeds) {
        var melon = Melons.create(register, name);

        var stems = Stems.create(register, name, melon.get(), seeds);
        melon.get().setStem(stems.x.get()).setAttachedStem(stems.y.get());

        return new Supplier<?>[] { melon, stems.x, stems.y };
    }

    private MelonSets() {
        // Prevent instantiation
    }
}
