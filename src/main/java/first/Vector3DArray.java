package first;

import java.util.Arrays;

public class Vector3DArray {
    private Vector3D[] vectors;

    public Vector3DArray(int n) {
        vectors = new Vector3D[n];
        for (int i = 0; i < n; i++) {
            vectors[i] = new Vector3D();
        }
    }

    public int length() {
        return vectors.length;
    }

    public void replace(Vector3D vect, int i) {
        vectors[i] = vect;
    }

    public Vector3D[] getArr() {
        return vectors;
    }

    public double maxLength() {
        double max = 0;
        double length;
        for (Vector3D item : vectors) {
            length = item.length();
            if (length > max) {
                max = length;
            }
        }
        return max;
    }

    public int findVector(Vector3D vect) {
        int index = -1;
        int j = 0;
        for (Vector3D item : vectors) {
            if (item.equal(vect)) {
                index = j;
                break;
            }
            j++;
        }
        return index;
    }

    public Vector3D add() {
        double x = 0;
        double y = 0;
        double z = 0;
        for (Vector3D item : vectors) {
            x += item.getX();
            y += item.getY();
            z += item.getZ();
        }
        return new Vector3D(x, y, z);
    }

    public Vector3D linearComb(double[] data) {
        if (data.length != vectors.length) {
            throw new IllegalArgumentException("Array of coefficient must have the same length with vectors array");
        }
        double x = 0;
        double y = 0;
        double z = 0;
        for (int i = 0; i < data.length; i++) {
            x += data[i] * vectors[i].getX();
            y += data[i] * vectors[i].getY();
            z += data[i] * vectors[i].getZ();
        }
        return new Vector3D(x, y, z);
    }

    public Point3D[] shift(Point3D P) {
        Point3D[] data = new Point3D[vectors.length];
        for (int i = 0; i < vectors.length; i++) {
            data[i] = new Point3D();
            data[i].setX(vectors[i].getX() + P.getX());
            data[i].setY(vectors[i].getY() + P.getY());
            data[i].setZ(vectors[i].getZ() + P.getZ());
        }
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector3DArray)) return false;
        Vector3DArray that = (Vector3DArray) o;
        return Arrays.equals(vectors, that.vectors);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vectors);
    }
}
