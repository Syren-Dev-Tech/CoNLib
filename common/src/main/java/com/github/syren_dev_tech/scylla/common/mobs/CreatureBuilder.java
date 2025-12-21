package com.github.syren_dev_tech.scylla.common.mobs;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.mobs.client.TextureRenderer;
import com.github.syren_dev_tech.scylla.common.mobs.creatures.CustomCreature;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType.EntityFactory;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraftforge.registries.RegistryObject;

public class CreatureBuilder<T extends CustomCreature> {

    public final ModRegister register;
    public final String name;
    public final EntityFactory<T> factory;

    public List<Goal> goals;
    public String[] animations;
    public String[] textures;
    public TextureRenderer<T> textureRenderer;
    public float shadowSize = 0.5f;

    public CreatureBuilder(String name, ModRegister register, EntityFactory<T> factory) {
        this.name = name;
        this.register = register;
        this.factory = factory;

        this.textures = new String[] {};
        this.animations = new String[] {};
        this.goals = new ArrayList<>();
    }

    public CreatureBuilder<T> withAnimations(String... animations) {
        this.animations = animations;
        return this;
    }

    public CreatureBuilder<T> withTextures(String... textures) {
        this.textures = textures;
        return this;
    }

    public CreatureBuilder<T> withAiGoal(Goal goal) {
        this.goals.add(goal);
        return this;
    }

    public CreatureBuilder<T> withAiGoals(List<Goal> goals) {
        this.goals.addAll(goals);
        return this;
    }

    public CreatureBuilder<T> withShadowSize(float shadowSize) {
        this.shadowSize = shadowSize;
        return this;
    }

    public CreatureBuilder<T> withTextureRenderer(TextureRenderer<T> textureRenderer) {
        this.textureRenderer = textureRenderer;
        return this;
    }

    public AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0).add(Attributes.MOVEMENT_SPEED, 0.25);
    }

    public Supplier<EntityType<T>> register() {
        var registry = this.register.mobRegistry.register(this);

        var registrar = new CreatureRegistrar<T>(this, registry, this::createAttributes);
        this.register.mobRegistry.entities.put(this.name, registrar);

        return registry;
    }
}
