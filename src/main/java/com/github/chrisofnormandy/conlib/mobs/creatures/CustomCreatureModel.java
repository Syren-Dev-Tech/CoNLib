package com.github.chrisofnormandy.conlib.mobs.creatures;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.github.chrisofnormandy.conlib.CoNLib;
import com.github.chrisofnormandy.conlib.mobs.geo.GeoEntity;
import com.github.chrisofnormandy.conlib.mobs.geo.GeoReader;
import com.github.chrisofnormandy.conlib.registry.ModRegister;
import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;

public class CustomCreatureModel<T extends CustomCreature> extends AgeableListModel<T> {

    private final Map<String, ModelPart> parts;
    private final GeoEntity geoEntity;

    public CustomCreatureModel(ModRegister register, String name, ModelPart root) {
        super(false, 4F, 4F, 2F, 2F, 24);
        try {
            this.geoEntity = GeoReader.getGeoEntity(register, name);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load model: " + name, e);
        }

        this.parts = this.geoEntity.getModelParts(root);
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(this.parts.get("head"));
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        Map<String, ModelPart> allButHead = new HashMap<>();
        for (Map.Entry<String, ModelPart> entry : this.parts.entrySet()) {
            if (!entry.getKey().equals("head")) {
                allButHead.put(entry.getKey(), entry.getValue());
            }
        }

        return allButHead.values();
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    public static LayerDefinition createBodyLayer(ModRegister register, String name) {
        try {
            GeoEntity json = GeoReader.getGeoEntity(register, name);

            return json.getLayerDefinition();
        } catch (Exception e) {
            CoNLib.LOGGER.error("Failed to load model: " + name, e);
        }

        return null;
    }
}
