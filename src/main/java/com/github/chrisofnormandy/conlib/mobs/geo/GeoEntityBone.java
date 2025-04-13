package com.github.chrisofnormandy.conlib.mobs.geo;

import com.github.chrisofnormandy.conlib.CoNLib;
import com.github.chrisofnormandy.conlib.collections.PrimitiveTriplet;
import com.github.chrisofnormandy.conlib.collections.PrimitiveTriplet.PrimDoubleTriplet;
import com.github.chrisofnormandy.conlib.collections.PrimitiveTriplet.PrimFloatTriplet;
import com.github.chrisofnormandy.conlib.collections.PrimitiveTriplet.PrimIntTriplet;
import com.github.chrisofnormandy.conlib.common.Transform3D;
import com.google.gson.JsonObject;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;

public class GeoEntityBone {
    public String name;
    public String parent;

    public GeoCube[] cubes;

    public PrimFloatTriplet pivot;
    public PrimFloatTriplet rotation;

    public CubeListBuilder getCubeListBuilder(CubeDeformation deformation) {
        var builder = CubeListBuilder.create();

        for (var cube : this.cubes) {
            cube.getCubeListBuilder(builder, deformation);
        }

        return builder;
    }

    public PrimFloatTriplet getPosition() {
        var cube = this.cubes[0];
        return PrimitiveTriplet.of(cube.origin.x, cube.origin.y, cube.origin.z);
    }

    public PrimFloatTriplet getRotation() {
        if (this.rotation != null)
            return PrimitiveTriplet.of(this.rotation.x, this.rotation.y, this.rotation.z);

        return PrimitiveTriplet.of(0F, 0F, 0F);
    }

    public ModelPart getModelPart(ModelPart root) {
        return root.getChild(this.name);
    }

    public PartPose getPart(GeoEntityBone parentBone) {
        float adjustedPivotX = this.pivot.x;
        float adjustedPivotY = this.pivot.y;
        float adjustedPivotZ = this.pivot.z;

        if (parentBone != null && parentBone.pivot != null) {
            adjustedPivotX -= parentBone.pivot.x;
            adjustedPivotY -= parentBone.pivot.y;
            adjustedPivotZ -= parentBone.pivot.z;
        }

        var rotation = this.getRotation();
        var parentRotation = parentBone != null ? parentBone.getRotation() : PrimitiveTriplet.of(0F, 0F, 0F);

        var rotationX = (float) Math.toRadians((rotation.x + parentRotation.x) % 360);
        var rotationY = (float) Math.toRadians((rotation.y + parentRotation.y) % 360);
        var rotationZ = (float) Math.toRadians((rotation.z + parentRotation.z) % 360);

        return PartPose.offsetAndRotation(adjustedPivotX, adjustedPivotY, adjustedPivotZ, rotationX, rotationY, rotationZ);
    }

    public GeoEntityBone(JsonObject json) {
        if (!json.has("name")) {
            throw new IllegalArgumentException("GeoEntityBone JSON must contain a 'name' string.");
        }

        if (!json.has("cubes")) {
            throw new IllegalArgumentException("GeoEntityBone JSON must contain a 'cubes' array.");
        }

        this.name = json.get("name").getAsString();

        CoNLib.LOGGER.info("Creating GeoEntityBone: " + this.name);

        var cubes = json.get("cubes").getAsJsonArray();
        var cubeCount = cubes.size();

        this.cubes = new GeoCube[cubeCount];

        for (int i = 0; i < cubeCount; i++) {
            this.cubes[i] = new GeoCube(cubes.get(i).getAsJsonObject());
        }

        if (json.has("parent")) {
            this.parent = json.get("parent").getAsString();
        }

        if (json.has("pivot")) {
            var pivot = json.get("pivot").getAsJsonArray();
            this.pivot = PrimitiveTriplet.of(pivot.get(0).getAsFloat() / 16, pivot.get(1).getAsFloat() / 16, pivot.get(2).getAsFloat() / 16);
        }

        if (json.has("rotation")) {
            var rotation = json.get("rotation").getAsJsonArray();
            this.rotation = PrimitiveTriplet.of(rotation.get(0).getAsFloat(), rotation.get(1).getAsFloat(), rotation.get(2).getAsFloat());
        }
    }
}
