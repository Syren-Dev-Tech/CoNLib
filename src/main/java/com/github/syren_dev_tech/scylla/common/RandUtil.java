package com.github.syren_dev_tech.scylla.common;

public class RandUtil {
    public static int randInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
