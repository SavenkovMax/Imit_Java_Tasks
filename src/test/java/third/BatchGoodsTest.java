package third;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BatchGoodsTest {

    @DataProvider
    public Object[][] dataBatchMass() {
        PackageGoods package1 = new PackageGoods("b", 1);
        PackagedPieceGoods goods1 = new PackagedPieceGoods("a", "b", 5, 3, package1);
        PackagedPieceGoods goods2 = new PackagedPieceGoods("a", "b", 2, 3, package1);
        PackagedPieceGoods goods3 = new PackagedPieceGoods("a", "b", 4, 3, package1);

        PackageGoods package2 = new PackageGoods("d", 2);
        PackagedWeightGoods goods4 = new PackagedWeightGoods("c", "n", 15, package2);
        PackagedPieceGoods goods5 = new PackagedPieceGoods("h", "g", 9, 3,  package2);

        BatchGoods batch1 = new BatchGoods("c", goods1, goods2, goods3);
        BatchGoods batch2 = new BatchGoods("b", goods4, goods5);
        BatchGoods batch3 = new BatchGoods("m", goods1, goods2, goods3, goods4, goods5);
        return new Object[][] {
                {batch1, 36.0},
                {batch2, 46.0},
                {batch3, 82.0}
        };
    }

    @Test(dataProvider = "dataBatchMass")
    public void testGetBatchMass(BatchGoods goods, double expected) {
        assertEquals(goods.getBatchMass(), expected);
    }
}