package com.github.syren_dev_tech.scylla.common.util;

import net.minecraft.resources.ResourceLocation;

public class Resources {

    private Resources() {
    }

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
        return ResourceLocation.fromNamespaceAndPath(modId, path);
    }

    public static ResourceLocation getResourceLocation(String modId, String path, String fileName) {
        return ResourceLocation.fromNamespaceAndPath(modId, path + "/" + fileName);
    }

    public static ResourceLocation getResourceLocation(String modId, String path, String fileName, String extension) {
        return ResourceLocation.fromNamespaceAndPath(modId, path + "/" + fileName + "." + extension);
    }
}
