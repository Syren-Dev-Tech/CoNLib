package com.github.syren_dev_tech.scylla.common.blocks.plants.flowers.types;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CustomFlower extends FlowerBlock {

    private ParticleOptions particle;
    private Block[] canBePlacedOn = new Block[] {};
    private MobEffect effect; // Effect when physically touched.
    private boolean disabledInPeaceful = false;

    public CustomFlower(Supplier<MobEffect> mobEffect, Properties properties) {
        super(mobEffect, 8, properties);
    }

    public CustomFlower(Supplier<MobEffect> mobEffect, int duration, Properties properties) {
        super(mobEffect, duration, properties);
    }

    public CustomFlower setPlaceable(Block[] blocks) {
        this.canBePlacedOn = blocks;
        return this;
    }

    public CustomFlower setParticle(ParticleOptions particle) {
        this.particle = particle;
        return this;
    }

    public CustomFlower setPhysicalEffect(MobEffect effect) {
        this.effect = effect;
        return this;
    }

    public CustomFlower notPeaceful() {
        this.disabledInPeaceful = true;
        return this;
    }

    @Override
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        if (super.mayPlaceOn(blockState, blockGetter, blockPos))
            return true;

        for (Block block : this.canBePlacedOn) {
            if (blockState.is(block)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (this.particle == null) {
            return;
        }

        VoxelShape voxelshape = this.getShape(blockState, level, blockPos, CollisionContext.empty());
        var vec3 = voxelshape.bounds().getCenter();

        double d0 = blockPos.getX() + vec3.x;
        double d1 = blockPos.getZ() + vec3.z;

        for (int i = 0; i < 3; ++i) {
            if (randomSource.nextBoolean()) {
                level.addParticle(ParticleTypes.SMOKE, d0 + randomSource.nextDouble() / 5.0D, blockPos.getY() + (0.5D - randomSource.nextDouble()), d1 + randomSource.nextDouble() / 5.0D, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) { // NOSONAR - Ignore deprecation warning
        boolean notPeaceful = !level.isClientSide && level.getDifficulty() != Difficulty.PEACEFUL;

        if ((notPeaceful || !this.disabledInPeaceful) && entity instanceof LivingEntity livingentity) {

            boolean applyEffect = this.effect != MobEffects.WITHER || !livingentity.isInvulnerableTo(level.damageSources().wither());

            if (applyEffect)
                livingentity.addEffect(new MobEffectInstance(effect, 40));
        }
    }
}
