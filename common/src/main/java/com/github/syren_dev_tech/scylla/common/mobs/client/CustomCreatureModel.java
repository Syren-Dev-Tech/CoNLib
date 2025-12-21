package com.github.syren_dev_tech.scylla.common.mobs.client;

import java.util.HashMap;
import java.util.Map;

import com.github.syren_dev_tech.scylla.common.ScyllaCommon;
import com.github.syren_dev_tech.scylla.common.mobs.CreatureBuilder;
import com.github.syren_dev_tech.scylla.common.mobs.creatures.CustomCreature;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CustomCreatureModel<T extends CustomCreature> extends GeoModel<T> {

    private final CreatureBuilder<T> builder;

    private ResourceLocation model;
    private final Map<String, ResourceLocation> textures = new HashMap<>();
    private final Map<String, ResourceLocation> animations = new HashMap<>();

    public CustomCreatureModel(CreatureBuilder<T> builder) {
        super();
        this.builder = builder;

        defineResources();
    }

    private void defineResources() {
        var registry = this.builder.register;

        this.model = ResourceLocation.fromNamespaceAndPath(registry.modId, "geo/" + this.builder.name + ".geo.json");

        for (String tex : this.builder.textures)
            this.textures.put(tex, ResourceLocation.fromNamespaceAndPath(registry.modId, "textures/entity/" + this.builder.name + "." + tex + ".png"));

        for (String anim : this.builder.animations)
            this.animations.put(anim, ResourceLocation.fromNamespaceAndPath(registry.modId, "animations/" + this.builder.name + "." + anim + ".json"));
    }

    @Override
    public ResourceLocation getModelResource(T animatable) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        ScyllaCommon.LOGGER.debug("Getting texture resource for {}", this.builder.name);

        return this.textures.get("air");
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        ScyllaCommon.LOGGER.debug("Getting animation resource for {}", this.builder.name);

        return this.animations.get(CustomCreature.DEFAULT_ANIMATION);
    }
}
