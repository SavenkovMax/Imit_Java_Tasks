package fourth;

public class SumFunctional<T extends IFunctionOneVariable> implements IFunctionalOneVariable<T> {
    private final double a;
    private final double b;

    public SumFunctional(double a, double b) {
        this.a = a;
        this.b = b;
    }


    public double getValue(T function) {
        if (a < function.getLeftBorder() || b > function.getRightBorder()) {
            throw new IllegalArgumentException("The parameters out of domain");
        }
        return function.getValue(function.getLeftBorder()) +
                function.getValue(function.getRightBorder()) +
                function.getValue((function.getLeftBorder() + function.getRightBorder()) / 2);
    }
}
