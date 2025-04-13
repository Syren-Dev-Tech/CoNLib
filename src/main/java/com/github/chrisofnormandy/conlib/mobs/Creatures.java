package com.github.chrisofnormandy.conlib.mobs;

import com.github.chrisofnormandy.conlib.mobs.creatures.CustomCreature;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

public class Creatures {
    public static final void create(ModRegister register, String name) {
        register.mobRegistry.register(name, CustomCreature::new);
    }
}
