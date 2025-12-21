package com.github.syren_dev_tech.scylla.common.collections;

public class Quartet<W, X, Y, Z> {
    public final W w;
    public final X x;
    public final Y y;
    public final Z z;

    public Quartet(W w, X x, Y y, Z z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}