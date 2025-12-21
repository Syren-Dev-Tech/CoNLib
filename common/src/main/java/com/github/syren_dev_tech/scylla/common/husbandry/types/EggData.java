package com.github.syren_dev_tech.scylla.common.husbandry.types;

import java.util.function.Consumer;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;

public class EggData<T extends Animal> {

    private final EntityType<T> entityType;
    private SoundEvent hatchSound;

    public SoundEvent getHatchSound() {
        return hatchSound;
    }

    public void setHatchSound(SoundEvent hatchSound) {
        this.hatchSound = hatchSound;
    }

    private int ageOnHatch = -24000;

    public int getAgeOnHatch() {
        return ageOnHatch;
    }

    public void setAgeOnHatch(int ageOnHatch) {
        this.ageOnHatch = ageOnHatch;
    }

    public EggData(EntityType<T> entityType) {
        this.entityType = entityType;
    }

    public EntityType<T> getEntityType() {
        return entityType;
    }

    public T spawn(ServerLevel serverLevel) {
        return this.spawn(serverLevel, creature -> {
            // No-op
        });
    }

    public T spawn(ServerLevel serverLevel, Consumer<T> beforeSummon) {
        T creature = this.entityType.create(serverLevel);

        if (creature != null) {
            creature.setAge(this.ageOnHatch);
            beforeSummon.accept(creature);
            serverLevel.addFreshEntity(creature);
        }

        return creature;
    }
}
