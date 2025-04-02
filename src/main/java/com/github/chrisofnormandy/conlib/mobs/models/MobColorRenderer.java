package com.github.chrisofnormandy.conlib.mobs.models;

import com.github.chrisofnormandy.conlib.mobs.types.CustomAnimal;
import com.github.chrisofnormandy.conlib.mobs.types.CustomAnimalModel;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MobColorRenderer<T extends CustomAnimal> extends MobRenderer<T, CustomAnimalModel<T>> {
    private static final ResourceLocation GREYSCALE_TEXTURE = new ResourceLocation("modid", "textures/entity/mob_greyscale.png");

    public MobColorRenderer(EntityRendererProvider.Context context, ModelLayerLocation modelLayerLocation) {
        super(context, new CustomAnimalModel<>(context.bakeLayer(modelLayerLocation)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return GREYSCALE_TEXTURE;
    }

    @Override
    public void render(T entity, float limbSwing, float limbSwingAmount, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        // Determine the color based on mob properties
        int color = getColorFromMob(entity);

        // Apply the color overlay
        float red = (color >> 16 & 255) / 255.0F;
        float green = (color >> 8 & 255) / 255.0F;
        float blue = (color & 255) / 255.0F;

        // Render the greyscale texture with the color overlay
        RenderParams<T> params = new RenderParams<>(this.model, this.getTextureLocation(entity), poseStack, bufferSource, packedLight, entity);
        params.useColoring(red, green, blue);

        renderColoredCutoutModel(params);
    }

    private void renderColoredCutoutModel(RenderParams<T> params) {
        PoseStack poseStack = params.poseStack;
        MultiBufferSource bufferSource = params.bufferSource;
        int packedLight = params.packedLight;

        // Render the model with the specified color
        this.model.renderToBuffer(poseStack, bufferSource.getBuffer(this.model.renderType(params.textureLocation)), packedLight, 0, params.red, params.green, params.blue, 1.0F);
    }

    private int getColorFromMob(T entity) {
        // Example: Use mob health to determine color (red for low health, green for
        // high health)
        float healthPercentage = entity.getHealth() / entity.getMaxHealth();
        return (int) (255 * (1 - healthPercentage)) << 16 | (int) (255 * healthPercentage) << 8;
    }
}
