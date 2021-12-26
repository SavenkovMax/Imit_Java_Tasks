package fourth;

public class QuadraticPolynomial {
    private final double a;
    private final double b;
    private final double c;

    public QuadraticPolynomial(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("This isn't quadratic polynomial");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] getSolution() {
        double d = b * b - 4 * a * c;
        if (d == 0) {
            return new double[]{-b / (2 * a)};
        } else if (d > 0) {
            return new double[] {(-b + Math.sqrt(d)) / (2 * a), (-b - Math.sqrt(d)) / (2 * a)};
        } else {
            return new double[0];
        }
    }
}
