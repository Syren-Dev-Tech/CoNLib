package com.github.chrisofnormandy.conlib.mobs.creatures;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CustomCreatureRenderer<T extends CustomCreature> extends MobRenderer<T, CustomCreatureModel<T>> {

    private final ModRegister register;
    private final String name;

    public CustomCreatureRenderer(ModRegister register, String name, Context context, ModelLayerLocation layer, float shadowRadius) {
        super(context, new CustomCreatureModel<T>(register, name, context.bakeLayer(layer)), shadowRadius);
        this.name = name;
        this.register = register;
    }

    @Override
    public ResourceLocation getTextureLocation(CustomCreature creature) {
        return new ResourceLocation(this.register.modId, "textures/entity/" + this.name + "/" + this.name + ".png");
    }
}
