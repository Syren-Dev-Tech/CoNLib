package com.github.chrisofnormandy.conlib.mobs.models;

import com.github.chrisofnormandy.conlib.mobs.types.CustomAnimal;
import com.github.chrisofnormandy.conlib.mobs.types.CustomAnimalModel;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;

public class RenderParams<T extends CustomAnimal> {
    public CustomAnimalModel<T> model;
    public ResourceLocation textureLocation;
    public PoseStack poseStack;
    public MultiBufferSource bufferSource;
    public int packedLight;
    public T entity;

    public float red;
    public float green;
    public float blue;

    public void useColoring(float red, float green, float blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public RenderParams(CustomAnimalModel<T> model, ResourceLocation textureLocation, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, T entity) {
        this.model = model;
        this.textureLocation = textureLocation;
        this.poseStack = poseStack;
        this.bufferSource = bufferSource;
        this.packedLight = packedLight;
        this.entity = entity;
    }
}
