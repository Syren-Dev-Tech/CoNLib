package com.github.syren_dev_tech.scylla.common.husbandry.types;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;

public class MediumEggData<T extends Animal> extends EggData<T> {
    public MediumEggData(EntityType<T> entityType) {
        super(entityType);
    }
}
