package com.github.chrisofnormandy.conlib.common;

import net.minecraft.resources.ResourceLocation;

public class Resources {
    public static String getResourcePath(String modId, String path) {
        return "assets/" + modId + "/" + path;
    }

    public static String getResourcePath(String modId, String path, String fileName) {
        return getResourcePath(modId, path) + "/" + fileName;
    }

    public static String getResourcePath(String modId, String path, String fileName, String extension) {
        return getResourcePath(modId, path, fileName) + "." + extension;
    }

    public static ResourceLocation getResourceLocation(String modId, String path) {
        return new ResourceLocation(modId, path);
    }

    public static ResourceLocation getResourceLocation(String modId, String path, String fileName) {
        return new ResourceLocation(modId, path + "/" + fileName);
    }

    public static ResourceLocation getResourceLocation(String modId, String path, String fileName, String extension) {
        return new ResourceLocation(modId, path + "/" + fileName + "." + extension);
    }
}
