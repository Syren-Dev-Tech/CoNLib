package com.github.chrisofnormandy.conlib.common;

import java.util.Arrays;

import com.github.chrisofnormandy.conlib.collections.PrimitiveTriplet;
import com.github.chrisofnormandy.conlib.collections.PrimitiveTriplet.PrimFloatTriplet;

public class Transform3D {

    public static PrimFloatTriplet transformCoordinate(PrimFloatTriplet origin, PrimFloatTriplet pivot, PrimFloatTriplet rotation) {
        // Convert rotation angles from degrees to radians
        double rx = Math.toRadians(rotation.x % 360);
        double ry = Math.toRadians(rotation.y % 360);
        double rz = Math.toRadians(rotation.z % 360);

        // Create rotation matrices for each axis
        double[][] rotX = { { 1, 0, 0 }, { 0, Math.cos(rx), -Math.sin(rx) }, { 0, Math.sin(rx), Math.cos(rx) } };

        double[][] rotY = { { Math.cos(ry), 0, Math.sin(ry) }, { 0, 1, 0 }, { -Math.sin(ry), 0, Math.cos(ry) } };

        double[][] rotZ = { { Math.cos(rz), -Math.sin(rz), 0 }, { Math.sin(rz), Math.cos(rz), 0 }, { 0, 0, 1 } };

        // Combine the rotation matrices: rotationMatrix = rotZ * rotY * rotX
        double[][] rotationMatrix = matrixMultiply(matrixMultiply(rotZ, rotY), rotX);

        // Translate origin to pivot point
        double[] translatedOrigin = { origin.x + pivot.x, origin.y + pivot.y, origin.z + pivot.z };

        // Apply rotation
        double[] rotatedPoint = matrixVectorMultiply(rotationMatrix, translatedOrigin);

        // Translate back to the original position
        float[] transformedPoint = { (float) (rotatedPoint[0] + pivot.x), (float) (rotatedPoint[1] + pivot.y), (float) (rotatedPoint[2] + pivot.z) };

        return PrimitiveTriplet.of(transformedPoint[0], transformedPoint[1], transformedPoint[2]);
    }

    // Helper method to multiply two matrices
    private static double[][] matrixMultiply(double[][] a, double[][] b) {
        int rows = a.length;
        int cols = b[0].length;
        int common = b.length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < common; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    // Helper method to multiply a matrix by a vector
    private static double[] matrixVectorMultiply(double[][] matrix, double[] vector) {
        int rows = matrix.length;
        double[] result = new double[rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }

        return result;
    }
}