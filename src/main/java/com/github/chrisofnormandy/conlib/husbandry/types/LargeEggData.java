package com.github.chrisofnormandy.conlib.husbandry.types;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;

public class LargeEggData<T extends Animal> extends EggData<T> {

    public LargeEggData(EntityType<T> entityType) {
        super(entityType);
    }
}
