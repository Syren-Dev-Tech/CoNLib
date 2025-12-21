package com.github.syren_dev_tech.scylla.common.mobs.creatures;

import com.github.syren_dev_tech.scylla.common.ScyllaCommon;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class CustomCreature extends PathfinderMob implements GeoEntity { // NOSONAR - Ignore parent class limit

    private final AnimatableInstanceCache cache;
    public static final String DEFAULT_ANIMATION = "fly";

    public CustomCreature(EntityType<? extends PathfinderMob> type, Level worldIn) {
        super(type, worldIn);

        this.cache = GeckoLibUtil.createInstanceCache(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CustomCreature that = (CustomCreature) obj;
        return this.getUUID().equals(that.getUUID());
    }

    @Override
    public int hashCode() {
        return this.getUUID().hashCode();
    }

    private <E extends GeoEntity> PlayState animationPredicate(AnimationState<E> event) {
        var controller = event.getController();
        var currentAnimation = controller.getCurrentAnimation();

        if (currentAnimation != null) {
            ScyllaCommon.LOGGER.info("Current animation: {}", currentAnimation.animation().name());
        } else {
            ScyllaCommon.LOGGER.info("No current animation.");
        }

        if (currentAnimation != null && currentAnimation.animation().name().equals(DEFAULT_ANIMATION)) {
            return PlayState.CONTINUE;
        }

        ScyllaCommon.LOGGER.info("Setting animation to default animation: {}", DEFAULT_ANIMATION);

        controller.setAnimationSpeed(0.5);
        controller.setAnimation(RawAnimation.begin().thenLoop(DEFAULT_ANIMATION));

        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, this::animationPredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
