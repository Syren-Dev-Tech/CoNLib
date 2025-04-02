package com.github.chrisofnormandy.conlib.husbandry.types;

import java.util.function.Consumer;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;

public class EggData<T extends Animal> {
    public EntityType<T> entityType;
    public SoundEvent hatchSound;
    public int ageOnHatch = -24000;

    public EggData(EntityType<T> entityType) {
        this.entityType = entityType;
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
