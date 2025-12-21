package com.github.syren_dev_tech.scylla.common.util;

import com.github.syren_dev_tech.scylla.common.collections.PrimitiveTriplet.PrimDoubleTriplet;
import com.github.syren_dev_tech.scylla.common.ScyllaCommon;

public class Transform3D {

    private Transform3D() {
    }

    // Takes a point in 3D space (origin) and transforms it by rotating it around a
    // pivot point (radians).
    public static PrimDoubleTriplet transformCoordinate(PrimDoubleTriplet point, PrimDoubleTriplet pivot, PrimDoubleTriplet rotation) {
        if (ScyllaCommon.LOGGER.isDebugEnabled()) {
            ScyllaCommon.LOGGER.debug(String.format(" :: Point: %f, %f, %f", point.x, point.y, point.z));
            ScyllaCommon.LOGGER.debug(String.format(" :: Pivot: %f, %f, %f", pivot.x, pivot.y, pivot.z));
            ScyllaCommon.LOGGER.debug(String.format(" :: Rotation: %f, %f, %f", rotation.x, rotation.y, rotation.z));
        }

        double translatedX = point.x - pivot.x;
        double translatedY = point.y - pivot.y;
        double translatedZ = point.z - pivot.z;

        // Rotate around X axis
        double rotatedY = translatedY * Math.cos(rotation.x) - translatedZ * Math.sin(rotation.x);
        double rotatedZ = translatedY * Math.sin(rotation.x) + translatedZ * Math.cos(rotation.x);

        // Rotate around Y axis
        double rotatedX = translatedX * Math.cos(rotation.y) + rotatedZ * Math.sin(rotation.y);
        double rotatedZ2 = -translatedX * Math.sin(rotation.y) + rotatedZ * Math.cos(rotation.y);

        // Rotate around Z axis
        double rotatedX2 = rotatedX * Math.cos(rotation.z) - rotatedY * Math.sin(rotation.z);
        double rotatedY2 = rotatedX * Math.sin(rotation.z) + rotatedY * Math.cos(rotation.z);

        // Translate point back
        double finalX = rotatedX2 + pivot.x;
        double finalY = rotatedY2 + pivot.y;
        double finalZ = rotatedZ2 + pivot.z;

        return new PrimDoubleTriplet(finalX, finalY, finalZ);
    }
}