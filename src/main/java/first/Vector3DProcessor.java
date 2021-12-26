package first;

public final class Vector3DProcessor {
    private Vector3DProcessor() {}

    public static Vector3D add(Vector3D vect1, Vector3D vect2) {
        double x = vect1.getX() + vect2.getX();
        double y = vect1.getY() + vect2.getY();
        double z = vect1.getZ() + vect2.getZ();
        return new Vector3D(x, y, z);
    }

    public static Vector3D subtract(Vector3D vect1, Vector3D vect2) {
        double x = vect1.getX() - vect2.getX();
        double y = vect1.getY() - vect2.getY();
        double z = vect1.getZ() - vect2.getZ();
        return new Vector3D(x, y, z);
    }

    public static Vector3D crossProduct(Vector3D vect1, Vector3D vect2) {
        double x = vect1.getY() * vect2.getZ() - vect1.getZ() * vect2.getY();
        double y = vect1.getZ() * vect2.getX() - vect1.getX() * vect2.getZ();
        double z = vect1.getX() * vect2.getY() - vect1.getY() * vect2.getX();
        return new Vector3D(x, y, z);
    }

    public static double scalarProduct(Vector3D vect1, Vector3D vect2) {
        return vect1.getX() * vect2.getX() + vect1.getY() * vect2.getY() + vect1.getZ() * vect2.getZ();
    }

    public static boolean collinear(Vector3D vect1, Vector3D vect2) {
        return scalarProduct(vect1, vect2) == 1 || scalarProduct(vect1, vect2) == -1;
    }

}
