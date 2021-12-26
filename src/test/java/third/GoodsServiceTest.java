package third;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GoodsServiceTest {

    @DataProvider
    public Object[][] dataCountByFilter() {
        PackageGoods package1 = new PackageGoods("b", 1);
        PackagedPieceGoods goods1 = new PackagedPieceGoods("Beginfilter", "b", 5, 3, package1);
        PackagedPieceGoods goods2 = new PackagedPieceGoods("Beginfilter abc", "b", 4, 3, package1);

        PackageGoods package2 = new PackageGoods("d", 2);
        PackagedWeightGoods goods3 = new PackagedWeightGoods("I have this word", "n", 15, package2);
        PackagedPieceGoods goods4 = new PackagedPieceGoods("I don't have that word", "g", 9, 3,  package2);

        BeginStringFilter filter1 = new BeginStringFilter("Beginfilter");
        WordFilter filter2 = new WordFilter("have");
        WordFilter filter3 = new WordFilter("this");

        BatchGoods batch1 = new BatchGoods("c", goods1, goods2);
        BatchGoods batch2 = new BatchGoods("b", goods3, goods4);
        BatchGoods batch3 = new BatchGoods("m", goods1, goods2, goods3, goods4);

        return new Object[][] {
                {batch1, filter1, 2},
                {batch2, filter2, 2},
                {batch3, filter3, 1}
        };
    }

    @DataProvider
    public Object[][] dataCheckAllWeight() {
        PackageGoods package1 = new PackageGoods("b", 1);
        PackagedPieceGoods goods1 = new PackagedPieceGoods("Beginfilter", "b", 5, 3, package1);
        PackagedWeightGoods goods2 = new PackagedWeightGoods("p", "c", 30, package1);
        PackagedWeightGoods goods3 = new PackagedWeightGoods("b", "c", 25.5, package1);
        PackagedPieceGoods goods4 = new PackagedPieceGoods("n", "first", 23.7, 5, package1);


        BatchGoods batch1 = new BatchGoods("o", goods1, goods2);
        BatchGoods batch2 = new BatchGoods("i", goods2, goods3);
        BatchGoods batch3 = new BatchGoods("k", goods3, goods4);
        BatchGoods batch4 = new BatchGoods("n", goods1, goods2, goods3, goods4);

        return new Object[][] {
                {batch1, false},
                {batch2, true},
                {batch3, false},
                {batch4, false}
        };
    }

    @Test(dataProvider = "dataCountByFilter")
    public void testCountByFilter(BatchGoods goods, IFilter filter, int expected) {
        assertEquals(GoodsService.countByFilter(goods, filter), expected);
    }

    @Test(dataProvider = "dataCheckAllWeight")
    public void testCheckAllWeight(BatchGoods goods, boolean expected) {
        assertEquals(GoodsService.checkAllWeight(goods), expected);
    }
}