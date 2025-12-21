package com.github.syren_dev_tech.scylla.common.collections;

/**
 * A utility class for creating specialized tuples that directly store primitive
 * values without the overhead of boxing/unboxing.
 */
public final class PrimitiveTuple {

    private PrimitiveTuple() {
        // Utility class, prevent instantiation
    }

    /**
     * A tuple that stores three int values.
     */
    public static final class PrimIntTuple {
        public final int x;
        public final int y;

        public PrimIntTuple(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * A tuple that stores three float values.
     */
    public static final class PrimFloatTuple {
        public final float x;
        public final float y;

        public PrimFloatTuple(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * A tuple that stores three double values.
     */
    public static final class PrimDoubleTuple {
        public final double x;
        public final double y;

        public PrimDoubleTuple(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * A tuple that stores three long values.
     */
    public static final class PrimLongTuple {
        public final long x;
        public final long y;

        public PrimLongTuple(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * A tuple that stores three boolean values.
     */
    public static final class PrimBooleanTuple {
        public final boolean x;
        public final boolean y;

        public PrimBooleanTuple(boolean x, boolean y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Creates a new int tuple.
     */
    public static PrimIntTuple of(int x, int y) {
        return new PrimIntTuple(x, y);
    }

    /**
     * Creates a new float tuple.
     */
    public static PrimFloatTuple of(float x, float y) {
        return new PrimFloatTuple(x, y);
    }

    /**
     * Creates a new double tuple.
     */
    public static PrimDoubleTuple of(double x, double y) {
        return new PrimDoubleTuple(x, y);
    }

    /**
     * Creates a new long tuple.
     */
    public static PrimLongTuple of(long x, long y) {
        return new PrimLongTuple(x, y);
    }

    /**
     * Creates a new boolean tuple.
     */
    public static PrimBooleanTuple of(boolean x, boolean y) {
        return new PrimBooleanTuple(x, y);
    }
}