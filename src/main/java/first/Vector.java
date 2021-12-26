package first;

public class Vector {
    private double[] values;

    public Vector(double[] values) {
        this.values = values;
    }

    public double length() {
        double res = 0;
        for (double data : values) {
            res += data * data;
        }
        return Math.sqrt(res);
    }

    public boolean compare(Vector vector) {
        if (values.length != vector.values.length) {
            throw new IllegalArgumentException("Vectors must be of the same dimension");
        }
        boolean equal = true;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != vector.values[i]) {
                equal = false;
                break;
            }
        }
        return equal;
    }

    public double scalarProduct(Vector vector) {
        if (values.length != vector.values.length) {
            throw new IllegalArgumentException("Vectors must be of the same dimension");
        }
        double res = 0;
        for (int i = 0; i < values.length; i++) {
            res += values[i] * vector.values[i];
        }
        return res;
    }

    public double cos(Vector vector) {
        return scalarProduct(vector) / (length() * vector.length());
    }

    public Vector add(Vector vector) {
        if (values.length != vector.values.length) {
            throw new IllegalArgumentException("Vectors must be of the same dimension");
        }
        double[] another = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            another[i] = values[i] + vector.values[i];
        }
        return new Vector(another);
    }

    public Vector subtract(Vector vector) {
        if (values.length != vector.values.length) {
            throw new IllegalArgumentException("Vectors must be of the same dimension");
        }
        double[] another = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            another[i] = values[i] - vector.values[i];
        }
        return new Vector(another);
    }

    public static Vector[] generate(int n) {
        Vector[] array = new Vector[n];
        for (int i = 0; i < n; i++) {
            double[] vector = new double[(int) Math.random() * 5];
            for (int k = 0; k < vector.length; k++) {
                vector[k] = (int) Math.random() * 4;
            }
            array[i] = new Vector(vector);
        }
        return array;
    }

}