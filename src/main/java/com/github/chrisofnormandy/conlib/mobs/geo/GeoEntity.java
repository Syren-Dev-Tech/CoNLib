package com.github.chrisofnormandy.conlib.mobs.geo;

import java.util.HashMap;
import java.util.Map;

import com.github.chrisofnormandy.conlib.CoNLib;
import com.github.chrisofnormandy.conlib.collections.PrimitiveTriplet;
import com.github.chrisofnormandy.conlib.collections.PrimitiveTriplet.PrimFloatTriplet;
import com.google.gson.JsonObject;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class GeoEntity {

    private final Map<String, GeoEntityBone> bones = new HashMap<>();
    private final Map<String, PartDefinition> partDefinitions = new HashMap<>();

    private int textureWidth;
    private int textureHeight;

    private PrimFloatTriplet visibleBoundsOffset;

    private MeshDefinition createBodyMesh(CubeDeformation deformation) {
        var meshDefinition = new MeshDefinition();
        PartDefinition partdefinition = meshDefinition.getRoot();

        this.bones.forEach((name, bone) -> {
            var cubeList = bone.getCubeListBuilder(deformation);
            var partPose = bone.getPart(this.bones.get(bone.parent));

            partDefinitions.put(name, partdefinition.addOrReplaceChild(name, cubeList, partPose));
        });

        return meshDefinition;
    }

    public LayerDefinition getLayerDefinition() {
        return LayerDefinition.create(this.createBodyMesh(CubeDeformation.NONE), this.textureWidth, this.textureHeight);
    }

    public Map<String, ModelPart> getModelParts(ModelPart root) {
        Map<String, ModelPart> modelParts = new HashMap<>();

        this.bones.forEach((name, bone) -> {
            modelParts.put(name, bone.getModelPart(root));
        });

        return modelParts;
    }

    public GeoEntity(JsonObject json) {
        CoNLib.LOGGER.info("Creating GeoEntity");

        if (!json.has("description")) {
            throw new IllegalArgumentException("GeoEntity JSON must contain a 'description' definition.");
        }

        if (!json.has("bones")) {
            throw new IllegalArgumentException("GeoEntity JSON must contain a 'bones' array.");
        }

        if (!json.get("bones").isJsonArray()) {
            throw new IllegalArgumentException("GeoEntity JSON 'bones' must be an array.");
        }

        var bones = json.get("bones").getAsJsonArray();
        var boneCount = bones.size();

        if (boneCount == 0) {
            throw new IllegalArgumentException("GeoEntity JSON 'bones' array must not be empty.");
        }

        CoNLib.LOGGER.info("GeoEntity bone count: " + boneCount);

        for (int i = 0; i < boneCount; i++) {
            var bone = new GeoEntityBone(bones.get(i).getAsJsonObject());

            this.bones.put(bone.name, bone);

            CoNLib.LOGGER.info("Added bone: " + bone.name);
        }

        var description = json.get("description").getAsJsonObject();

        if (description.has("texture_width")) {
            this.textureWidth = description.get("texture_width").getAsInt();
        } else {
            throw new IllegalArgumentException("GeoEntity JSON 'description' must contain a 'texture_width' integer.");
        }

        if (description.has("texture_height")) {
            this.textureHeight = description.get("texture_height").getAsInt();
        } else {
            throw new IllegalArgumentException("GeoEntity JSON 'description' must contain a 'texture_height' integer.");
        }

        if (description.has("visible_bounds_offset")) {
            var offset = description.get("visible_bounds_offset").getAsJsonArray();
            this.visibleBoundsOffset = PrimitiveTriplet.of(offset.get(0).getAsFloat(), offset.get(1).getAsFloat(), offset.get(2).getAsFloat());
        } else {
            throw new IllegalArgumentException("GeoEntity JSON 'description' must contain a 'visible_bounds_offset' array.");
        }
    }
}
