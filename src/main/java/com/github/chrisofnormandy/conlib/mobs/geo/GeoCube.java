package com.github.chrisofnormandy.conlib.mobs.geo;

import com.github.chrisofnormandy.conlib.CoNLib;
import com.github.chrisofnormandy.conlib.collections.PrimitiveTriplet;
import com.github.chrisofnormandy.conlib.collections.PrimitiveTuple;
import com.github.chrisofnormandy.conlib.collections.PrimitiveTuple.PrimIntTuple;
import com.github.chrisofnormandy.conlib.collections.PrimitiveTriplet.PrimFloatTriplet;
import com.google.gson.JsonObject;

import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;

public class GeoCube {
    public final PrimFloatTriplet origin;
    public final PrimFloatTriplet size;
    public final PrimIntTuple uv;
    public final boolean mirror;

    public CubeListBuilder getCubeListBuilder(CubeListBuilder builder, CubeDeformation deformation) {
        // Adjust origin relative to pivot
        float adjustedOriginX = this.origin.x;
        float adjustedOriginY = -this.origin.y;
        float adjustedOriginZ = this.origin.z;

        builder.texOffs(this.uv.x, this.uv.y).addBox(adjustedOriginX, adjustedOriginY, adjustedOriginZ, this.size.x, this.size.y, this.size.z, deformation);
        if (this.mirror) {
            builder.mirror();
        }
        return builder;
    }

    public GeoCube(JsonObject json) {
        if (!json.has("origin")) {
            throw new IllegalArgumentException("GeoCube JSON must contain an 'origin' array.");
        }

        if (!json.has("size")) {
            throw new IllegalArgumentException("GeoCube JSON must contain a 'size' array.");
        }

        if (!json.has("uv")) {
            throw new IllegalArgumentException("GeoCube JSON must contain a 'uv' array.");
        }

        var origin = json.get("origin").getAsJsonArray();
        var size = json.get("size").getAsJsonArray();
        var uv = json.get("uv").getAsJsonArray();

        this.origin = PrimitiveTriplet.of(origin.get(0).getAsFloat(), origin.get(1).getAsFloat(), origin.get(2).getAsFloat());
        this.size = PrimitiveTriplet.of(size.get(0).getAsFloat(), size.get(1).getAsFloat(), size.get(2).getAsFloat());
        this.uv = PrimitiveTuple.of(uv.get(0).getAsInt(), uv.get(1).getAsInt());

        this.mirror = json.has("mirror") && json.get("mirror").getAsBoolean();
    }
}
