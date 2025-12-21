package com.github.syren_dev_tech.scylla.common.collections;

public class Triplet<X, Y, Z> {
    public final X x;
    public final Y y;
    public final Z z;

    public Triplet(X x, Y y, Z z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}