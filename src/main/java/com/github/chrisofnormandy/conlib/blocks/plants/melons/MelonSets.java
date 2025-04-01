package com.github.chrisofnormandy.conlib.blocks.plants.melons;

import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.crops.Stems;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

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
