package first;

public final class SimpleTasks {
    private SimpleTasks() {}

    public static double[] roots(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("It's not a quadratic equation");
        }
        double d = b * b - 4 * a * c;
        if (d == 0) {
            return new double[]{-b / (2 * a)};
        } else if (d > 0) {
            return new double[] {(-b + Math.sqrt(d)) / (2 * a), (-b - Math.sqrt(d)) / (2 * a)};
        } else {
            return new double[0];
        }
    }

    public static void tabulation(double a, double b, double h) {
        if (h <= 0) {
            throw new IllegalArgumentException("Step of tabulation isn't positive");
        }
        double curValue;
        System.out.println("Value of an argument" + "\t" + "Value of the function");
        while (a < b) {
            curValue = Math.sin(a);
            System.out.print("\t");
            System.out.printf("%5f", a);
            System.out.print("\t\t\t\t");
            System.out.printf("%5f", curValue);
            System.out.println();
            a += h;
        }
    }

    public static double[] system(double a1, double b1, double c1,
                                  double a2, double b2, double c2
    ) {
        double delta = a1 * b2 - a2 * b1;
        double deltaB1 = c1 * b2 - c2 * b1;
        double deltaB2 = a1 * c2 - a2 * c1;
        if (a1 == 0 && b1 == 0 && c1 == 0 && a2 == 0 && b2 == 0 && c2 == 0) {
            System.out.println("There are infinity many roots: R^2");
            return new double[0];
        }
        if (a1 == 0 && a2 == 0 && b1 != 0 && b2 != 0 && c1 != 0 && c2 != 0) {
            if (deltaB1 == 0) {
                System.out.println("There are infinity many roots: R");
            }
            else {
                System.out.println("There's empty set of solution");
            }
            return new double[0];
        }
        if (b1 == 0 && b2 == 0 && a1 != 0 && a2 != 0 && c1 != 0 && c2 != 0) {
            if (deltaB2 == 0) {
                System.out.println("There are infinity many roots: R");
            }
            else {
                System.out.println("There's empty set of solution");
            }
            return new double[0];
        }
        if ((a1 == 0 && b1 == 0 && c1 == 0 && a2 != 0 && b2 != 0 && c2 != 0) ||
                (a1 != 0 && b1 != 0 && c1 != 0 && a2 == 0 && b2 == 0 && c2 == 0)) {
            System.out.println("There are infinity many roots: R");
            return new double[0];
        }
        if (deltaB1 == 0 && deltaB2 == 0 && a1 != 0 && a2 != 0 && b1 != 0 && b2 != 0 && c1 != 0 && c2 != 0) {
            System.out.println("There's infinity many roots: R");
            return new double[0];
        }
        if (delta == 0) {
            System.out.println("There's empty set of solution");
            return new double[0];
        }
        double x = deltaB1 / delta;
        double y = deltaB2 / delta;
        return new double[]{x, y};

    }

    public static double expF(double x, int n) {
        double eps = Math.pow(10, -n);
        double expf = 1;
        double k = 1;
        double term = 1;
        if (eps < 1) {
            while (Math.abs(term) > eps) {
                term *= x / k;
                expf += term;
                k++;
            }
        }
        return expf;
    }
}
