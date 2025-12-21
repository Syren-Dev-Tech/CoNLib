package com.github.syren_dev_tech.scylla.common.husbandry.types;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;

public class WaterEggData<T extends Animal> extends EggData<T> {

    private int minSpawn = 2;

    public int getMinSpawn() {
        return minSpawn;
    }

    public void setMinSpawn(int minSpawn) {
        this.minSpawn = minSpawn;
    }

    private int maxSpawn = 6;

    public int getMaxSpawn() {
        return maxSpawn;
    }

    public void setMaxSpawn(int maxSpawn) {
        this.maxSpawn = maxSpawn;
    }

    private float hitboxWidth = 0.4F;

    public float getHitboxWidth() {
        return hitboxWidth;
    }

    public void setHitboxWidth(float hitboxWidth) {
        this.hitboxWidth = hitboxWidth;
    }

    public WaterEggData(EntityType<T> entityType) {
        super(entityType);
    }
}
