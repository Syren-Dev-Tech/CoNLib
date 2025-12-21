package com.github.syren_dev_tech.scylla.common.mobs.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class CustomGeoRenderer<T extends LivingEntity & GeoAnimatable> implements GeoRenderer<T> {

    @Override
    public GeoModel<T> getGeoModel() {
        // Return a valid GeoModel<T> instance (replace with actual implementation)
        return new GeoModel<T>() {
            @Override
            public ResourceLocation getModelResource(T animatable) {
                // Provide a valid ResourceLocation for the model
                return ResourceLocation.fromNamespaceAndPath("mod_id", "models/entity/model.json");
            }

            @Override
            public ResourceLocation getTextureResource(T animatable) {
                throw new UnsupportedOperationException("Unimplemented method 'getTextureResource'");
            }

            @Override
            public ResourceLocation getAnimationResource(T animatable) {
                throw new UnsupportedOperationException("Unimplemented method 'getAnimationResource'");
            }
        };
    }

    @Override
    public T getAnimatable() {
        throw new UnsupportedOperationException("Unimplemented method 'getAnimatable'");
    }

    @Override
    public void fireCompileRenderLayersEvent() {
        throw new UnsupportedOperationException("Unimplemented method 'fireCompileRenderLayersEvent'");
    }

    @Override
    public boolean firePreRenderEvent(PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        throw new UnsupportedOperationException("Unimplemented method 'firePreRenderEvent'");
    }

    @Override
    public void firePostRenderEvent(PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        throw new UnsupportedOperationException("Unimplemented method 'firePostRenderEvent'");
    }

    @Override
    public void updateAnimatedTextureFrame(T animatable) {
        throw new UnsupportedOperationException("Unimplemented method 'updateAnimatedTextureFrame'");
    }

}