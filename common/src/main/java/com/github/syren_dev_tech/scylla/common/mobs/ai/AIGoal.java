package com.github.syren_dev_tech.scylla.common.mobs.ai;

import net.minecraft.world.entity.ai.goal.Goal;

public class AIGoal extends Goal {

    public boolean enabled = true;

    public AIGoal() {
        super();
    }

    @Override
    public boolean canUse() {
        return this.enabled;
    }
}
