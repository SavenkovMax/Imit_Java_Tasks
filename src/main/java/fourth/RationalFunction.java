package fourth;

public class RationalFunction implements IFunctionOneVariable{
    private final double left, right;
    private final double A, B, C, D;

    public RationalFunction(double left, double right, double A, double B, double C, double D) {
        this.left = left;
        this.right = right;
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        if (C == 0 && D == 0) {
            throw new IllegalArgumentException("The parameters C and D out of domain, division by zero");
        }
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

//    add throw new....

        return (A * x + B) / (C * x + D) ;
    }
}
