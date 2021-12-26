package first;

import java.util.Objects;

public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D() {
        x = y = z = 0;
    }

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(Point3D a, Point3D b) {
        x = b.getX() - a.getX();
        y = b.getY() - a.getY();
        z = b.getZ() - a.getZ();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public String toString() {
        return "Vector3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public boolean equal(Vector3D vector) {
        return x == vector.getX() && y == vector.getY() && z == vector.getZ();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector3D vector3D)) return false;
        return Double.compare(vector3D.getX(), getX()) == 0 &&
                Double.compare(vector3D.getY(), getY()) == 0 &&
                Double.compare(vector3D.getZ(), getZ()) == 0;
    }

}
