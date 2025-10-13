package com.github.syren_dev_tech.scylla.common;

import com.github.syren_dev_tech.scylla.CoNLib;
import com.github.syren_dev_tech.scylla.collections.PrimitiveTriplet.PrimDoubleTriplet;

public class Transform3D {

    // Takes a point in 3D space (origin) and transforms it by rotating it around a
    // pivot point (radians).
    public static PrimDoubleTriplet transformCoordinate(PrimDoubleTriplet point, PrimDoubleTriplet pivot,
            PrimDoubleTriplet rotation) {
        CoNLib.LOGGER.debug(" :: Point: " + point.x + ", " + point.y + ", " + point.z);
        CoNLib.LOGGER.debug(" :: Pivot: " + pivot.x + ", " + pivot.y + ", " + pivot.z);
        CoNLib.LOGGER.debug(" :: Rotation: " + rotation.x + ", " + rotation.y + ", " + rotation.z);

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