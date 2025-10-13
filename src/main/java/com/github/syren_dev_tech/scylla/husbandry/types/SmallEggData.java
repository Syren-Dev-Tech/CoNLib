package com.github.syren_dev_tech.scylla.husbandry.types;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;

public class SmallEggData<T extends Animal> extends EggData<T> {

    public SoundEvent crackSound = SoundEvents.TURTLE_EGG_CRACK;
    public double timeOfDayMin = 0.65D;
    public double timeOfDayMax = 0.69D;
    public int randHatchChance = 500;

    public SmallEggData(EntityType<T> entityType) {
        super(entityType);

        this.hatchSound = SoundEvents.TURTLE_EGG_HATCH;
    }
}
