package com.github.syren_dev_tech.scylla.common.util;

public class RandUtil {
    private static final java.util.Random RANDOM = new java.util.Random();

    private RandUtil() {
    }

    public static int randInt(int min, int max) {
        return RANDOM.nextInt((max - min) + 1) + min;
    }
}
