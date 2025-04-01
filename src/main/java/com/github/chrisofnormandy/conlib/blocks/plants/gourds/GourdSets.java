package com.github.chrisofnormandy.conlib.blocks.plants.gourds;

import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.crops.Stems;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.world.item.Item;

public class GourdSets {

    public static final Supplier<?>[] create(ModRegister register, String name, Item seeds) {
        // CarvedGourd carved = CarvedGourds.create(name);
        var weableCarved = EquipableGourds.create(register, name);
        var lantern = CarvedGourdLanterns.create(register, name);

        var gourdRegistry = Gourds.create(register, name);
        var gourd = gourdRegistry.get();
        gourd.setCarvedBlock(weableCarved.get()).setSeeds(seeds);

        var stems = Stems.create(register, name, gourd, seeds);

        gourd.setStemBlock(stems.x.get()).setAttachedStemBlock(stems.y.get());

        return new Supplier<?>[] { gourdRegistry, weableCarved, lantern, stems.x, stems.y };
    }

    private GourdSets() {
        // Prevent instantiation
    }
}
