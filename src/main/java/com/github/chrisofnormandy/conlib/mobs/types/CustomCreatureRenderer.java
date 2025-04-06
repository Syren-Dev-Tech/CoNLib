package com.github.chrisofnormandy.conlib.mobs.types;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CustomCreatureRenderer extends MobRenderer<CustomCreature, CustomCreatureModel<CustomCreature>> {

    public CustomCreatureRenderer(Context context) {
        super(context, new CustomCreatureModel<>(context.bakeLayer(ModelLayers.PIG)), 0.5F);
        // Add layers like saddles and harnesses here
        // this.addLayer(new SaddleLayer<>(this, new
        // PigModel<>(p_174340_.bakeLayer(ModelLayers.PIG_SADDLE)), new
        // ResourceLocation("textures/entity/pig/pig_saddle.png")));
    }

    @Override
    public ResourceLocation getTextureLocation(CustomCreature creature) {
        return new ResourceLocation("textures/entity/" + "creature_name" + "/" + "creature_name" + ".png");
    }
}
