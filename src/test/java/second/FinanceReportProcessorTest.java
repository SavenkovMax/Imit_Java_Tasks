package second;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class FinanceReportProcessorTest {


    @DataProvider
    public Object[][] dataGetPaymentsByLastName() {
        char letter1 = 'A';
        Payment[] p1 = new Payment[3];
        p1[0] = new Payment("A.B.C", new Date(5, 3, 2020), 200000);
        p1[1] = new Payment("B.T.A", new Date(6, 3, 2020), 204000);
        p1[2] = new Payment("A.B.E", new Date(8, 3, 2020), 1200000);
        Payment[] p1Expect = new Payment[2];
        p1Expect[0] = new Payment(p1[0]);
        p1Expect[1] = new Payment(p1[2]);

        char letter2 = 'C';
        Payment[] p2 = new Payment[2];
        p2[0] = new Payment("A.B.C", new Date(7, 8, 2020), 120000);
        p2[1] = new Payment("N.S.E", new Date(9, 8, 2020), 140000);
        Payment[] p2Expect = new Payment[0];

        char letter3 = 'D';
        Payment[] p3 = new Payment[5];
        p3[0] = new Payment("D.B.C", new Date(5, 3, 2020), 2005000);
        p3[1] = new Payment("D.T.A", new Date(6, 3, 2020), 2040300);
        p3[2] = new Payment("D.B.E", new Date(8, 3, 2020), 150000);
        p3[3] = new Payment("A.B.C", new Date(7, 8, 2020), 1200100);
        p3[4] = new Payment("N.S.E", new Date(9, 8, 2020), 1405000);
        Payment[] p3Expect = new Payment[3];
        p3Expect[0] = new Payment(p3[0]);
        p3Expect[1] = new Payment(p3[1]);
        p3Expect[2] = new Payment(p3[2]);

        return new Object[][]{
                {new FinanceReport("smth", new Date(10, 3, 2020), p1), letter1,
                new FinanceReport("smth", new Date(10, 3, 2020), p1Expect)},
                {new FinanceReport("smth", new Date(5, 9, 2020), p2), letter2,
                new FinanceReport("smth", new Date(5, 9, 2020), p2Expect)},
                {new FinanceReport("smth", new Date(15, 1, 2021), p3), letter3,
                new FinanceReport("smth", new Date(15, 1, 2021), p3Expect)}
        };
    }

    @DataProvider
    public Object[][] dataGetTotalPaymentByDate() {
        String strDate1 = "01.01.2020";
        Payment[] p1 = new Payment[4];
        p1[0] = new Payment("abc", new Date(1, 1, 2020), 15000000);
        p1[1] = new Payment("abc", new Date(1, 1, 2021), 19000000);
        p1[2] = new Payment("abc", new Date(1, 1, 2020), 90000000);
        p1[3] = new Payment("abc", new Date(1, 1, 2020), 125000000);
        long totalPay1 = 230000000;

        String strDate2 = "05.09.2019";
        long totalPay2 = 0;

        String strDate3 = "12.05.2021";
        Payment[] p2 = new Payment[5];
        p2[0] = new Payment("abc", new Date(15, 5, 2021), 150000);
        p2[1] = new Payment("abc", new Date(12, 5, 2021), 2350000);
        p2[2] = new Payment("abc", new Date(5, 2, 2021), 90004216);
        p2[3] = new Payment("abc", new Date(12, 5, 2021), 125034300);
        p2[4] = new Payment("abc", new Date(12, 5, 2021), 52340000);
        long totalPay3 = 179724300;

        return new Object[][]{
                {new FinanceReport("smth", new Date(1, 10, 2021), p1), strDate1, totalPay1},
                {new FinanceReport("smth", new Date(10, 10, 2021), p1), strDate2, totalPay2},
                {new FinanceReport("smth", new Date(12, 12, 2021), p2), strDate3, totalPay3}
        };
    }

    @DataProvider
    public Object[][] dataGetMonthWithNoPayment() {
        Payment[] p1 = new Payment[8];
        p1[0] = new Payment("abc", new Date(5, 1, 2020), 15000000);
        p1[1] = new Payment("abc", new Date(3, 2, 2021), 19000000);
        p1[2] = new Payment("abc", new Date(12, 3, 2020), 90000000);
        p1[3] = new Payment("abc", new Date(24, 5, 2020), 125000000);
        p1[4] = new Payment("abc", new Date(9, 6, 2020), 15000000);
        p1[5] = new Payment("abc", new Date(30, 7, 2021), 19000000);
        p1[6] = new Payment("abc", new Date(10, 9, 2020), 90000000);
        p1[7] = new Payment("abc", new Date(31, 10, 2020), 125000000);
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("April");
        list1.add("August");
        list1.add("November");
        list1.add("December");

        Payment[] p2 = new Payment[0];
        ArrayList<String> list2 = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list2.add(Date.Months.values()[i].toString());
        }

        return new Object[][] {
                {new FinanceReport("smth", new Date(4, 10, 2021), p1), list1},
                {new FinanceReport("smth", new Date(), p2), list2}
        };
    }

    @DataProvider
    public Object[][] dataGetPaymentLessThanNumber() {
        int number1 = 530000;
        Payment[] p1 = new Payment[3];
        p1[0] = new Payment("abc", new Date(5, 6, 2021), 529999);
        p1[1] = new Payment("abc", new Date(5, 6, 2021), 521000);
        p1[2] = new Payment("abc", new Date(2, 7, 2021), 230000);

        int number2 = 500000;
        Payment[] p2 = new Payment[2];
        p2[0] = new Payment("abc", new Date(5, 6, 2021), 529999);
        p2[1] = new Payment("abc", new Date(5, 6, 2021), 521000);
        Payment[] p2Expect = new Payment[0];

        int number3 = 10000;
        Payment[] p3 = new Payment[7];
        p3[0] = new Payment("abc", new Date(5, 6, 2021), 529999);
        p3[1] = new Payment("abc", new Date(5, 6, 2021), 521000);
        p3[2] = new Payment("abc", new Date(2, 7, 2021), 230000);
        p3[3] = new Payment("abc", new Date(5, 6, 2021), 999);
        p3[4] = new Payment("abc", new Date(5, 6, 2021), 521000);
        p3[5] = new Payment("abc", new Date(2, 7, 2021), 2340);
        p3[6] = new Payment("abc", new Date(2, 7, 2021), 230000);
        Payment[] p3Expect = new Payment[2];
        p3Expect[0] = new Payment(p3[3]);
        p3Expect[1] = new Payment(p3[5]);

        return new Object[][] {
                {new FinanceReport("smth", new Date(9, 9, 2021), p1), number1,
                new FinanceReport("smth", new Date(9, 9, 2021), p1)},
                {new FinanceReport("smth", new Date(10, 10, 2021), p2), number2,
                new FinanceReport("smth", new Date(10, 10, 2021), p2Expect)},
                {new FinanceReport("smth", new Date(11, 11, 2021), p3), number3,
                new FinanceReport("smth", new Date(11, 11, 2021), p3Expect)}
        };
    }

    @Test(dataProvider = "dataGetPaymentsByLastName")
    public void testGetPaymentsByLastName(FinanceReport report, char letter, FinanceReport expected) {
        boolean flag = FinanceReportProcessor.getPaymentsByLastName(report, letter).equals(expected);
        assertTrue(flag);
    }


    @Test(dataProvider = "dataGetTotalPaymentByDate")
    public void testGetTotalPaymentByDate(FinanceReport report, String strDate, long expected) {
        long actual = FinanceReportProcessor.getTotalPaymentByDate(report, strDate);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataGetMonthWithNoPayment")
    public void testGetMonthsWithNoPayment(FinanceReport report, ArrayList<String> expected) {
        boolean flag = FinanceReportProcessor.getMonthsWithNoPayment(report).equals(expected);
        assertTrue(flag);
    }

    @Test(dataProvider = "dataGetPaymentLessThanNumber")
    public void testGetPaymentLessThanNumber(FinanceReport report, int number, FinanceReport expected) {
        assertEquals(FinanceReportProcessor.getPaymentsLessThanNumber(report, number), expected);
    }
}