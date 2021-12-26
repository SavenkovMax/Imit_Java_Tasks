package fourth;

public class LinearFunction implements IFunctionOneVariable {
    private final double left, right;
    private final double A, B;

    public LinearFunction(double left, double right, double A, double B) {
        this.left = left;
        this.right = right;
        this.A = A;
        this.B = B;
    }

    public double getLeftBorder() {
        return left;
    }

    public double getRightBorder() {
        return right;
    }

    public double getValue(double x) {
        if (x < left || x > right) {
            throw new IllegalArgumentException("Argument of function out of domain");
        }
        return A * x + B;
    }
}
