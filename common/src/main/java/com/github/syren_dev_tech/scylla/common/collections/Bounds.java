package com.github.syren_dev_tech.scylla.common.collections;

public class Bounds {
    private double x1;

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    private double y1;

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    private double z1;

    public double getZ1() {
        return z1;
    }

    public void setZ1(double z1) {
        this.z1 = z1;
    }

    private double x2;

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    private double y2;

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    private double z2;

    public double getZ2() {
        return z2;
    }

    public void setZ2(double z2) {
        this.z2 = z2;
    }

    public void add(double x, double y, double z, double width, double height, double depth) {
        this.x1 = Math.min(this.x1, x);
        this.y1 = Math.min(this.y1, y);
        this.z1 = Math.min(this.z1, z);

        this.x2 = Math.max(this.x2, x + width);
        this.y2 = Math.max(this.y2, y + height);
        this.z2 = Math.max(this.z2, z + depth);
    }

    public double width() {
        return Math.abs(this.x2 - this.x1);
    }

    public float widthF() {
        return (float) Math.abs(this.x2 - this.x1);
    }

    public double height() {
        return Math.abs(this.y2 - this.y1);
    }

    public float heightF() {
        return (float) Math.abs(this.y2 - this.y1);
    }

    public double depth() {
        return Math.abs(this.z2 - this.z1);
    }

    public float depthF() {
        return (float) Math.abs(this.z2 - this.z1);
    }

    public Bounds() {
        this.x1 = 0;
        this.y1 = 0;
        this.z1 = 0;

        this.x2 = 0;
        this.y2 = 0;
        this.z2 = 0;
    }

    public Bounds(double x1, double y1, double z1, double x2, double y2, double z2) {
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;

        this.x2 = x2;
        this.y2 = y2;
        this.z2 = z2;
    }
}
