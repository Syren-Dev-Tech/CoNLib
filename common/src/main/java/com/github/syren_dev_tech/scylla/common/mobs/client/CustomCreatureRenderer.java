package com.github.syren_dev_tech.scylla.common.mobs.client;

import com.github.syren_dev_tech.scylla.common.mobs.CreatureBuilder;
import com.github.syren_dev_tech.scylla.common.mobs.creatures.CustomCreature;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CustomCreatureRenderer<T extends CustomCreature> extends GeoEntityRenderer<T> {

    public CustomCreatureRenderer(CreatureBuilder<T> builder, EntityRendererProvider.Context context) {
        super(context, new CustomCreatureModel<>(builder));
        this.shadowRadius = builder.shadowSize; // Set shadow size

        if (builder.textureRenderer != null) {
            this.addRenderLayer(builder.textureRenderer);
        }
    }
}