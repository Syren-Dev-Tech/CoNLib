package com.github.syren_dev_tech.scylla.mobs.creatures;

import com.github.syren_dev_tech.scylla.registry.ModRegister;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CustomCreatureModel<T extends CustomCreature> extends GeoModel<T> {

    private final ModRegister registry;
    private final String name;

    private ResourceLocation model;
    private ResourceLocation texture;
    private ResourceLocation animations;

    public CustomCreatureModel(ModRegister registry, String name) {
        super();
        this.registry = registry;
        this.name = name;

        defineResourceLocations();
    }

    protected void defineResourceLocations() {
        this.model = new ResourceLocation(registry.modId, "geo/" + name + ".geo.json");
        this.texture = new ResourceLocation(registry.modId, "textures/entity/" + name + ".png");
        this.animations = new ResourceLocation(registry.modId, "animations/" + name + ".animation.json");
    }

    @Override
    public ResourceLocation getModelResource(T animatable) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return this.animations;
    }
}
