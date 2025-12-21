package com.github.syren_dev_tech.scylla.common.collections;

/**
 * A utility class for creating specialized triplets that directly store
 * primitive values without the overhead of boxing/unboxing.
 */
public final class PrimitiveTriplet {

    private PrimitiveTriplet() {
        // Utility class, prevent instantiation
    }

    /**
     * A triplet that stores three int values.
     */
    public static final class PrimIntTriplet {
        public final int x;
        public final int y;
        public final int z;

        public PrimIntTriplet(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    /**
     * A triplet that stores three float values.
     */
    public static final class PrimFloatTriplet {
        public final float x;
        public final float y;
        public final float z;

        public PrimFloatTriplet(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    /**
     * A triplet that stores three double values.
     */
    public static final class PrimDoubleTriplet {
        public final double x;
        public final double y;
        public final double z;

        public PrimDoubleTriplet(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    /**
     * A triplet that stores three long values.
     */
    public static final class PrimLongTriplet {
        public final long x;
        public final long y;
        public final long z;

        public PrimLongTriplet(long x, long y, long z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    /**
     * A triplet that stores three boolean values.
     */
    public static final class PrimBooleanTriplet {
        public final boolean x;
        public final boolean y;
        public final boolean z;

        public PrimBooleanTriplet(boolean x, boolean y, boolean z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    /**
     * Creates a new int triplet.
     */
    public static PrimIntTriplet of(int x, int y, int z) {
        return new PrimIntTriplet(x, y, z);
    }

    /**
     * Creates a new float triplet.
     */
    public static PrimFloatTriplet of(float x, float y, float z) {
        return new PrimFloatTriplet(x, y, z);
    }

    /**
     * Creates a new double triplet.
     */
    public static PrimDoubleTriplet of(double x, double y, double z) {
        return new PrimDoubleTriplet(x, y, z);
    }

    /**
     * Creates a new long triplet.
     */
    public static PrimLongTriplet of(long x, long y, long z) {
        return new PrimLongTriplet(x, y, z);
    }

    /**
     * Creates a new boolean triplet.
     */
    public static PrimBooleanTriplet of(boolean x, boolean y, boolean z) {
        return new PrimBooleanTriplet(x, y, z);
    }
}