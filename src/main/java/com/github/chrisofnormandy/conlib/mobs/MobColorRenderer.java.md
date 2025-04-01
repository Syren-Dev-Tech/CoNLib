package com.github.chrisofnormandy.conlib.mobs;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

public class MobColorRenderer<T extends Mob> extends MobRenderer<T, MobModel<T>> {
    private static final ResourceLocation GREYSCALE_TEXTURE = new ResourceLocation("modid", "textures/entity/mob_greyscale.png");

    public MobColorRenderer(EntityRendererProvider.Context context) {
        super(context, new MobModel<>(context.bakeLayer(MobModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return GREYSCALE_TEXTURE;
    }

    @Override
    protected void renderModel(T entity, float limbSwing, float limbSwingAmount, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        // Determine the color based on mob properties
        int color = getColorFromMob(entity);

        // Apply the color overlay
        float red = (color >> 16 & 255) / 255.0F;
        float green = (color >> 8 & 255) / 255.0F;
        float blue = (color & 255) / 255.0F;

        // Render the greyscale texture with the color overlay
        renderColoredCutoutModel(this.model, this.getTextureLocation(entity), poseStack, bufferSource, packedLight, entity, red, green, blue);
    }

    private int getColorFromMob(T entity) {
        // Example: Use mob health to determine color (red for low health, green for
        // high health)
        float healthPercentage = entity.getHealth() / entity.getMaxHealth();
        return (int) (255 * (1 - healthPercentage)) << 16 | (int) (255 * healthPercentage) << 8;
    }
}
