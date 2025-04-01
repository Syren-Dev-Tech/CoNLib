package com.github.chrisofnormandy.conlib.mobs;

import com.github.chrisofnormandy.conlib.mobs.types.CustomAnimal;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

public class Animals {
    public static final void create(ModRegister register, String name) {
        register.mobRegistry.register(name, CustomAnimal::new);
    }
}
