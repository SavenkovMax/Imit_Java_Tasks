package second;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.*;

public class DateTest {

    @DataProvider
    public Object[][] dataIsLeapYear() {
        return new Object[][] {
                {2020, true},
                {2016, true},
                {1900, false},
                {2021, false}
        };
    }

    @DataProvider
    public Object[][] dataDayIsTrue() {
        return new Object[][] {
                {31, 1, 2020, true},
                {29, 2, 2020, true},
                {28, 2, 2021, true},
                {31, 12, 2021, true},
                {31, 4, 2021, false},
                {31, 11, 2021, false},
                {30, 2, 2020, false},
                {29, 2, 2019, false},
                {30, 13, 2021, false}
        };
    }

    @DataProvider
    public Object[][] dataDateStringConstructor() {
        return new Object[][] {
                {"24.03.2020", new Date(24, 3, 2020)},
                {"29.02.2020", new Date(29, 2, 2020)},
                {"01.01.2015", new Date(1, 1, 2015)},
                {"31.12.2021", new Date(31, 12, 2021)},
                {"05.09.1990", new Date(5, 9, 1990)},
                {"04.12.2021", new Date(4, 12, 2021)},
                {"01.01.1970", new Date()}
        };
    }

    @DataProvider
    public Object[][] dataDateStringConstructorExcept() {
        return new Object[][] {
                {"20.13.2020"},
                {"32.10.2020"},
                {"abc"},
                {"aa.bb.cccc"},
                {"20.09.202A"},
                {"4 1 2021"},
                {"4.1.2021"},
        };
    }

    @Test(dataProvider = "dataIsLeapYear")
    public void testIsLeapYear(int year, boolean flag) {
        assertEquals(Date.isLeapYear(year), flag);
    }

    @Test(dataProvider = "dataDayIsTrue")
    public void testDayIsTrue(int day, int month, int year, boolean flag) {
        assertEquals(Date.dayIsTrue(day, month, year), flag);
    }

    @Test(dataProvider = "dataDateStringConstructor")
    public void testDateStringConstructor(String dateStr, Date expected) {
        boolean flag = new Date(dateStr).equals(expected);
        assertTrue(flag);
    }

    @Test(dataProvider = "dataDateStringConstructorExcept", expectedExceptions = IllegalArgumentException.class)
    public void testDateStringConstructorExcept(String dateStr) {
        Date date = new Date(dateStr);
    }
}