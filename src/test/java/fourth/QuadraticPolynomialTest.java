package fourth;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.Arrays;

import static org.testng.Assert.*;

public class QuadraticPolynomialTest {

    @DataProvider
    public static Object[][] dataGetSolution() {
        return new Object[][]{
                {1,4,4, new double[]{-2.0} },
                {2,8,8, new double[]{-2.0} },
                {2,10,12, new double[]{-2.0, -3.0} },
                {1,2,3, new double[0]}
        };
    }

    @Test(dataProvider = "dataGetSolution")
    public void testGetSolution(double a, double b, double c, double[] expected) {
        assertTrue(Arrays.equals(new QuadraticPolynomial(a, b, c).getSolution(), expected));
    }
}