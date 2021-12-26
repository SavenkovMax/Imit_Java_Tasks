package fourth;

import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FunctionalTest {

    @Test
    public void testSinIntegral() {
        SinusFunction sin = new SinusFunction(0, 100, 1, 1);
        Integral<SinusFunction> integral = new Integral<>(0, Math.PI / 4);
        assertTrue(integral.getValue(sin) - 0.292 < 1e-3);
    }

    @Test
    public void testExponentialIntegral() {
        ExponentialFunction exp  = new ExponentialFunction(0, 100, 1, 0);
        Integral<ExponentialFunction> integral = new Integral<>(0, 1);
        assertTrue(integral.getValue(exp) - 1.717 < 1e-3);
    }

    @Test
    public void testSumFunctional() {
        LinearFunction linear = new LinearFunction(0, 100, 1, 1);
        SumFunctional<LinearFunction> sumFunctional = new SumFunctional<>(10, 50);
        assertEquals(sumFunctional.getValue(linear), 153.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testExceptionIntegral() {
        LinearFunction linear = new LinearFunction(-10, 10, 1, 0);
        Integral<LinearFunction> integral = new Integral<>(-10, 12);
        integral.getValue(linear);
    }
}
