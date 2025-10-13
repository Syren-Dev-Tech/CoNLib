package com.github.syren_dev_tech.scylla.husbandry.types;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;

public class WaterEggData<T extends Animal> extends EggData<T> {

    public int minSpawn = 2;
    public int maxSpawn = 6;
    public float hitboxWidth = 0.4F;

    public WaterEggData(EntityType<T> entityType) {
        super(entityType);
        this.hatchSound = SoundEvents.FROGSPAWN_HATCH;
    }
}
