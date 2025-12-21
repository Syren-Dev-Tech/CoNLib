package com.github.syren_dev_tech.scylla.common.mobs.ai;

import net.minecraft.world.entity.Mob;

public class SitIdleGoal extends AIGoal {

    private final Mob self;
    private boolean bored = false;
    private int boredomTicksMod = 100; // 20 * 5 seconds
    private float chanceToGetBored = 0.1F;

    public SitIdleGoal(Mob self) {
        super();
        this.self = self;
    }

    @Override
    public boolean canUse() {
        if (this.self.isSwimming()) {
            return false;
        }

        return true;
    }

    @Override
    public boolean canContinueToUse() {
        if (this.bored) {
            return false;
        }

        if (this.self.isSwimming()) {
            return false;
        }

        return true;
    }

    @Override
    public void start() {
        this.self.getNavigation().stop();
        this.bored = false;
    }

    @Override
    public void stop() {

    }

    @Override
    public void tick() {
        // Check on 0th tick if the mob's been idle long enough
        if (this.self.tickCount % this.boredomTicksMod == 0) {
            this.bored = this.self.getRandom().nextFloat() < this.chanceToGetBored;
        }
    }
}
