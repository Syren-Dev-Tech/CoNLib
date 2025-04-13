package com.github.chrisofnormandy.conlib.mobs.creatures;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class CustomCreature extends PathfinderMob {

    private EntityType<CustomCreature> child;

    public CustomCreature(EntityType<? extends CustomCreature> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.COW_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.COW_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.COW_DEATH;
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    protected void playStepSound(BlockPos blockPos, BlockState blockState) {
        this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        CustomCreature that = (CustomCreature) obj;

        return this.getUUID().equals(that.getUUID());
    }

    @Override
    public int hashCode() {
        return this.getUUID().hashCode();
    }

    @Nullable
    public CustomCreature getBreedOffspring(ServerLevel serverLevel, AgeableMob mob) {
        return child.create(serverLevel);
    }
}
