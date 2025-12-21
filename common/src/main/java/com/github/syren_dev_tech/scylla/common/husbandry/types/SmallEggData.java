package com.github.syren_dev_tech.scylla.common.husbandry.types;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;

public class SmallEggData<T extends Animal> extends EggData<T> {

    private SoundEvent crackSound = SoundEvents.TURTLE_EGG_CRACK;

    public SoundEvent getCrackSound() {
        return crackSound;
    }

    private double minTimeOfDay = 0.65D;

    public double getMinTimeOfDay() {
        return minTimeOfDay;
    }

    private double maxTimeOfDay = 0.69D;

    public double getMaxTimeOfDay() {
        return maxTimeOfDay;
    }

    private int randHatchChance = 500;

    public int getRandHatchChance() {
        return randHatchChance;
    }

    public void setRandHatchChance(int randHatchChance) {
        this.randHatchChance = randHatchChance;
    }

    public SmallEggData(EntityType<T> entityType) {
        super(entityType);
    }
}
