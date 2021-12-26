package first;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;


public class Vector3DArrayTest {

    private Vector3DArray varray;

    @BeforeMethod
    public void setUp() {
        varray = new Vector3DArray(5);
        varray.replace(new Vector3D(2,1,0), 0);     //1
        varray.replace(new Vector3D(0,1,5), 1);   //2
        varray.replace(new Vector3D(1,1,2), 2);
        varray.replace(new Vector3D(0.5, 6,0), 4);   //1
    }

    @Test
    public void testLength() {
        assertEquals(varray.length(), 5);
    }

   @Test
    public void testGetElement() {
        assertEquals(varray.getArr()[0], new Vector3D(2,1,0));
    }

    @Test
    public void testFindIndexZ() {
        Vector3D v = new Vector3D(2,3,100);
        assertEquals(varray.findVector(v), -1);
    }

    @Test
    public void testGetSumOfVectors() throws IllegalArgumentException {
        Vector3D sum = new Vector3D(3.5,9,7);
        assertEquals(varray.add(), sum);
    }

    @Test(expectedExceptions = {Exception.class})
    public void testGetLinearCombination() throws Exception {
        double[] coef = {1,2,0,1};
        varray.linearComb(coef);
//        fail();
    }
    @Test
    public void testGetLinearCombinationWell() throws Exception {
        double[] coef = {1,2,0,0,1};
        Vector3D v = new Vector3D(2.5,9.0,10);
        assertEquals(varray.linearComb(coef), v);
    }

    @Test
    public void testGetPointShiftArray() {
        Point3D point = new Point3D(1,1,1);
        Point3D[] expected = new Point3D[5];
        expected[0] = new Point3D(3, 2, 1);
        expected[1] = new Point3D(1, 2, 6);
        expected[2] = new Point3D(2, 2, 3);
        expected[3] = new Point3D(1,1,1);
        expected[4] = new Point3D(1.5, 7, 1);
        assertEquals(varray.shift(point), expected);
    }
}