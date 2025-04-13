package com.github.chrisofnormandy.conlib.mobs.geo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import com.github.chrisofnormandy.conlib.CoNLib;
import com.github.chrisofnormandy.conlib.registry.ModRegister;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;

public class GeoReader {

    private static String getFileContents(ResourceLocation resourceLocation) {
        Minecraft mc = Minecraft.getInstance();
        ResourceManager resourceManager = mc.getResourceManager();

        try (InputStream inputStream = resourceManager.getResourceOrThrow(resourceLocation).open()) {
            return IOUtils.toString(inputStream, Charset.defaultCharset());
        } catch (Exception e) {
            throw new RuntimeException(new FileNotFoundException(resourceLocation.toString()));
        }
    }

    private static JsonObject readGeoJson(ResourceLocation resourceLocation, String entityName) throws IOException {
        CoNLib.LOGGER.info("Reading geometry JSON for entity: " + entityName + " from " + resourceLocation.toString());

        String jsonString = getFileContents(resourceLocation);

        JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
        if (jsonObject == null) {
            throw new IOException("Failed to parse JSON for entity: " + entityName);
        }

        return jsonObject;
    }

    private static JsonObject getEntityGeometry(ModRegister register, String entityName) throws IOException {
        CoNLib.LOGGER.info("Getting entity geometry for: " + entityName);

        ResourceLocation resourceLocation = new ResourceLocation(register.modId, "models/entity/" + entityName + ".geo.json");

        return readGeoJson(resourceLocation, entityName);
    }

    public static GeoEntity getGeoEntity(ModRegister register, String entityName) throws IOException {
        CoNLib.LOGGER.info("Getting GeoEntity for: " + entityName);

        JsonObject json = getEntityGeometry(register, entityName);
        if (json == null) {
            throw new IOException("Failed to get geometry for entity: " + entityName);
        }

        try {
            if (!json.has("minecraft:geometry")) {
                throw new IOException("No geometry found for entity: " + entityName);
            }

            JsonArray geometryArray = json.getAsJsonArray("minecraft:geometry");
            if (geometryArray.size() == 0) {
                throw new IOException("No geometry found for entity: " + entityName);
            }

            var geometry = geometryArray.get(0).getAsJsonObject();

            return new GeoEntity(geometry);
        } catch (Exception e) {
            throw new IOException("Failed to read geometry for entity: " + entityName, e);
        }
    }
}
