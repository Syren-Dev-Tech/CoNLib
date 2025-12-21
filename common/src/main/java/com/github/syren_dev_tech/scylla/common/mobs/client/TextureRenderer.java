package com.github.syren_dev_tech.scylla.common.mobs.client;

import java.util.function.Function;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class TextureRenderer<T extends LivingEntity & GeoAnimatable> extends GeoRenderLayer<T> {

    private Function<T, ResourceLocation> textureSupplier;

    public TextureRenderer(CustomGeoRenderer<T> geoRenderer) {
        super(geoRenderer);

        this.textureSupplier = super::getTextureResource;
    }

    public void setTextureSupplier(Function<T, ResourceLocation> textureSupplier) {
        this.textureSupplier = textureSupplier;
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        return this.textureSupplier.apply(animatable);
    }
}