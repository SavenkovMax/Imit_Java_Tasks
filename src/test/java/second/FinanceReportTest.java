package second;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FinanceReportTest {

    @DataProvider
    public Object[][] dataPaymentCount() {
        Payment[] p1 = new Payment[4];
        p1[0] = new Payment("abc", new Date(1, 1, 2002), 150000);
        p1[2] = new Payment("abc", new Date(3, 1, 2002), 150000);
        p1[3] = new Payment("abc", new Date(4, 1, 2002), 150000);

        Payment[] p2 = new Payment[2];
        p2[0] = new Payment("abc", new Date(3, 11, 2020), 1250000);
        p2[1] = new Payment("abc", new Date(11, 12, 2020), 150000);

        Payment[] p3 = new Payment[100];

        Payment[] p4 = new Payment[3];
        p4[0] = new Payment("abc", new Date(1, 9, 2019), 350000);
        p4[1] = new Payment("abc", new Date(3, 9, 2019), 450000);
        p4[2] = new Payment("abc", new Date(4, 9, 2019), 550000);

        return new Object[][] {
                {new FinanceReport("smth", new Date(2, 2, 2002), p1), 3},
                {new FinanceReport("smth", new Date(12, 2, 2021), p2), 2},
                {new FinanceReport("smth", new Date(13, 4, 2021), p3), 0},
                {new FinanceReport("smth", new Date(15, 10, 2019), p4), 3}
        };
    }

    @DataProvider
    public Object[][] dataAccessPaymentRead() {
        int i1 = 1;
        String code1 = "Day";
        Payment[] p1 = new Payment[2];
        p1[0] = new Payment("abc", new Date(29, 2, 2020), 135000);
        p1[1] = new Payment("abc", new Date(14, 3, 2020), 190000);

        int i2 = 0;
        String code2 = "  month ";
        Payment[] p2 = new Payment[3];
        p2[0] = new Payment("abc", new Date(29, 2, 2020), 135000);
        p2[1] = new Payment("abc", new Date(14, 3, 2020), 190000);

        int i3 = 2;
        String code3 = "year";
        Payment[] p3 = new Payment[3];
        p3[0] = new Payment("abc", new Date(29, 2, 2020), 135000);
        p3[1] = new Payment("abc", new Date(14, 3, 2020), 190000);
        p3[2] = new Payment("abc", new Date(10, 12, 2019), 43211563);

        int i4 = 4;
        String code4 = "amount";
        Payment[] p4 = new Payment[6];
        p4[0] = new Payment("abc", new Date(29, 2, 2020), 1350300);
        p4[1] = new Payment("abc", new Date(14, 3, 2020), 1900400);
        p4[2] = new Payment("abc", new Date(10, 12, 2019), 43563);
        p4[3] = new Payment("abc", new Date(30, 8, 2020), 13503400);
        p4[4] = new Payment("abc", new Date(19, 3, 2020), 1900210);
        p4[5] = new Payment("abc", new Date(20, 12, 2019), 443511563);

        return new Object[][] {
                {new FinanceReport("smth", new Date(1, 1, 2021), p1), code1, i1, 14},
                {new FinanceReport("smth", new Date(2, 5, 2021), p2), code2, i2, 2},
                {new FinanceReport("smth", new Date(6, 7, 2021), p3), code3, i3, 2019},
                {new FinanceReport("smth", new Date(9, 9, 2021), p4), code4, i4, 1900210}
        };
    }

    @DataProvider
    public Object[][] dataAccessPaymentWrite() {
        int i1 = 1;
        String code1 = "Day";
        Payment[] p1 = new Payment[2];
        p1[0] = new Payment("abc", new Date(29, 2, 2020), 135000);
        p1[1] = new Payment("abc", new Date(8, 3, 2020), 190000);

        int i2 = 0;
        String code2 = "  month ";
        Payment[] p2 = new Payment[3];
        p2[0] = new Payment("abc", new Date(29, 1, 2020), 135000);
        p2[1] = new Payment("abc", new Date(14, 3, 2020), 190000);

        int i3 = 2;
        String code3 = "year";
        Payment[] p3 = new Payment[3];
        p3[0] = new Payment("abc", new Date(29, 2, 2020), 135000);
        p3[1] = new Payment("abc", new Date(14, 3, 2020), 190000);
        p3[2] = new Payment("abc", new Date(10, 12, 2018), 43211563);

        int i4 = 1;
        String code4 = "amount";
        Payment[] p4 = new Payment[2];
        p4[0] = new Payment("abc", new Date(29, 2, 2020), 1350300);
        p4[1] = new Payment("abc", new Date(14, 3, 2020), 1900400);

        return new Object[][] {
                {new FinanceReport("smth", new Date(1, 1, 2021), p1), code1, i1, 8},
                {new FinanceReport("smth", new Date(2, 5, 2021), p2), code2, i2, 1},
                {new FinanceReport("smth", new Date(6, 7, 2021), p3), code3, i3, 2018},
                {new FinanceReport("smth", new Date(9, 9, 2021), p4), code4, i4, 1900400}
        };
    }

    @DataProvider
    public Object[][] dataGetPaymentFullName() {
        String name1 = "abc";
        int i1 = 0;
        Payment[] p1 = new Payment[2];
        p1[0] = new Payment("abc", new Date(3, 5, 2020), 120000);
        p1[1] = new Payment("abe", new Date(4, 5, 2020), 140000);

        String name2 = "default string";
        int i2 = 1;
        Payment[] p2 = new Payment[3];
        p2[0] = new Payment("abc", new Date(3, 5, 2020), 120000);
        p2[2] = new Payment("abe", new Date(4, 5, 2020), 140000);

        String name3 = "bbt";
        int i3 = 4;
        Payment[] p3 = new Payment[5];
        p3[0] = new Payment("abtc", new Date(3, 5, 2020), 120000);
        p3[1] = new Payment("abse", new Date(4, 5, 2020), 140000);
        p3[2] = new Payment("abac", new Date(3, 5, 2020), 120000);
        p3[3] = new Payment("abce", new Date(4, 5, 2020), 140000);
        p3[4] = new Payment("bbt", new Date(4, 5, 2020), 140000);

        return new Object[][] {
                {new FinanceReport("smth", new Date(5, 7, 2020), p1), i1, name1},
                {new FinanceReport("smth", new Date(6, 7, 2020), p2), i2, name2},
                {new FinanceReport("smth", new Date(7, 7, 2020), p3), i3, name3}
        };
    }

    @Test(dataProvider = "dataPaymentCount")
    public void testPaymentCount(FinanceReport report, int expected) {
        assertEquals(report.paymentCount(), expected);
    }

    @Test(dataProvider = "dataAccessPaymentRead")
    public void testAccessPaymentRead(FinanceReport report, String code, int i, int expected) {
        assertEquals(report.AccessPaymentRead(i, code), expected);
    }

    @Test(dataProvider = "dataAccessPaymentWrite")
    public void testAccessPaymentWrite(FinanceReport report, String code, int i, int expected) {
        report.AccessPaymentWrite(i, code, expected);
        assertEquals(report.AccessPaymentRead(i, code), expected);
    }

    @Test(dataProvider = "dataGetPaymentFullName")
    public void testGetPaymentFullName(FinanceReport report, int i, String expected) {
        assertEquals(report.getPaymentFullName(i), expected);
    }
}