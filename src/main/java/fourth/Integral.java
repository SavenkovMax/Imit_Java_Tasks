package fourth;

public class Integral<T extends IFunctionOneVariable> implements IFunctionalOneVariable<T> {
    private final double a;
    private final double b;

    public Integral(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getValue(T function) {
        if (function == null) {
            throw new IllegalArgumentException("The function is null");
        }
        if (a < function.getLeftBorder() || b > function.getRightBorder()) {
            throw new IllegalArgumentException("The parameters out of domain");
        }

        int n = 1000;
        double result = 0.0;

        double d = Math.abs(b - a) / n;
        for (int i = 0; i < n; i++) {
            result += function.getValue(a + i * d) * d;
        }
        return result;
    }

}
