package com.github.syren_dev_tech.scylla.mobs.creatures;

import java.util.List;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class CustomCreature extends PathfinderMob implements GeoEntity {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private final List<AIGoal> aiGoals = new java.util.ArrayList<>();

    public CustomCreature(EntityType<? extends PathfinderMob> type, Level worldIn) {
        super(type, worldIn);
    }

    public void addAIGoal(int priority, Goal goal) {
        this.aiGoals.add(new AIGoal(priority, goal));
    }

    @Override
    protected void registerGoals() {
        aiGoals.forEach(aiGoal -> this.goalSelector.addGoal(aiGoal.priority, aiGoal.goal));
        super.registerGoals();
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 hitPos, InteractionHand hand) {
        return super.interactAt(player, hitPos, hand);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
