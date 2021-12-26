package fourth;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FunctionsTest {

    @Test
    public void testLinearFunction() {
        LinearFunction linearFunction = new LinearFunction(-100, 100, 1, 5);
        assertEquals(linearFunction.getValue(50), 55);
    }

    @Test
    public void testSinusFunction() {
        SinusFunction sinusFunction = new SinusFunction(0, 100, 1, 1);
        assertTrue(sinusFunction.getValue(2) - 0.90929 < 1e-5);
    }

    @Test
    public void testRationalFunction() {
        RationalFunction rationalFunction = new RationalFunction(0, 100, 3, -5, 2, 4);
        assertTrue(rationalFunction.getValue(10) - 1.041 < 1e-3);
    }

    @Test
    public void testExponentialFunction() {
        ExponentialFunction exponentialFunction = new ExponentialFunction(0, 100, 1, 0);
        assertTrue(exponentialFunction.getValue(3) - 20.0855 < 1e-4);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testException() {
        SinusFunction sin = new SinusFunction(0, 1, 1, 1);
        assertEquals(sin.getValue(Math.PI / 2), 1);
    }
}
