package com.github.syren_dev_tech.scylla.mobs.creatures;

import com.github.syren_dev_tech.scylla.registry.ModRegister;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CustomCreatureRenderer<T extends CustomCreature> extends GeoEntityRenderer<T> {

    public CustomCreatureRenderer(ModRegister registry, String name, EntityRendererProvider.Context renderManager) {
        super(renderManager, new CustomCreatureModel<T>(registry, name));
        this.shadowRadius = 0.5f; // Set shadow size
    }
}