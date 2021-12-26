package first;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SimpleTest {


    @DataProvider
    public static Object[][] fourth() {
        return new Object[][]{
                {1,4,4, new double[]{-2.0} },
                {2,8,8, new double[]{-2.0} },
                {2,10,12, new double[]{-2.0, -3.0} },
                {1,2,3, new double[0]}
        };
    }

    @DataProvider
    public static Object[][] fourthEx() {
        return new Object[][]{
                {0, 0, 0},
                {0, 0, 1},
                {0, 1, 2}
        };
    }

    @DataProvider
    public static Object[][] seven() {
        return new Object[][]{
                {0.0, 10, Math.exp(0.0)},
                {2.0, 10, Math.exp(2.0)},
                {-2.0, 10, Math.exp(-2.0)}
        };
    }

    @DataProvider
    public static Object[][] fifth() {
        return new Object[][]{
                { 0, 0, 0 },
                { 0, 0, -0.1 },
                { 0, 0, 0.1 },
//
                { 1, 0, 0 },
                { 1, 0, -0.1 },
                { 1, 0, 0.1 },
                 { 0, 1, 0.1 }
        };
    }

    @Test(dataProvider = "fourth")
    public void testFourthTask(double a, double b, double c, double[] expected) {
        double[] actual = SimpleTasks.roots(a, b, c);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "fourthEx", expectedExceptions = {IllegalArgumentException.class})
    public void testFourthTask(double a, double b, double c) {
        SimpleTasks.roots(a, b, c);
    }

    @Test(dataProvider = "seven")
    public void testSeven(double x, int eps, double expected) {
        double actual = SimpleTasks.expF(x, eps);
        Assert.assertEquals(actual, expected, 1e-10);
    }

    @Test
    public void testSixth() {
        double[] expected = new double[]{-1.0, 2.0};
        SimpleTasks.system(0, 0, 0, 0, 0, 0);  //R^2
        System.out.println();

        System.out.print("1 ");
        SimpleTasks.system(0, 0, 1, 0, 0, 0);  // empty set
        System.out.print("2 ");
        SimpleTasks.system(0, 0, 0, 0, 0, 1);
        System.out.print("3 ");
        SimpleTasks.system(1, 2, 3, 0, 0, 1);
        System.out.print("4 ");
        SimpleTasks.system(1, 0, 3, 2, 0, 7);
        System.out.print("5 ");
        SimpleTasks.system(0, 2, 3, 0, 5, 7);
        System.out.print("6 ");
        SimpleTasks.system(1, 2, 3, 2, 4, 7);
        System.out.println();

        SimpleTasks.system(1, 2, 3, 0, 0, 0);
        SimpleTasks.system(1, 2, 3, 2, 4, 6);  // (x, y(x))
        SimpleTasks.system(0, 2, 3, 0, 4, 6);
        SimpleTasks.system(1, 0, 3, 2, 0, 6);
        System.out.println();

        System.out.println(Arrays.toString(SimpleTasks.system(1, 2, 3, 4, 5, 6)));
        Assert.assertEquals(SimpleTasks.system(1, 2, 3, 4, 5, 6), expected); // -1, 2

    }

    @Test(dataProvider = "fifth")
    public void testFifth(double inf, double sup, double step) {
        SimpleTasks.tabulation(inf, sup, step);
    }

}