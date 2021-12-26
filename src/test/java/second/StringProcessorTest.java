package second;

import static second.StringProcessor.*;
import static org.testng.Assert.*;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class StringProcessorTest {

    @DataProvider
    public static Object[][] dataFirst() {
        return new Object[][]{
                {3, "Hello!", new String("Hello!Hello!Hello!")},
                {1, "Java", "Java"},
                {2, "ABC", "ABCABC"},
                {0, "abc", ""},
                {10, "a", "aaaaaaaaaa"},
        };
    }

    @DataProvider
    public static Object[][] dataSecond() {
        return new Object[][]{
                {"Hello! Hello!", "Hello!", 2},
                {"Hello!", "Hello!", 1},
                {"aa bb cc dd", "aa bb cc", 1},
                {"abcabcabcabc", "abc", 4},
                {"   ", " ", 3}
        };
    }

    @DataProvider
    public static Object[][] dataThird() {
        return new Object[][]{
                {"1 плюс 2 равно 3", "один плюс два равно три"},
                {"just another string", "just another string"},
                {"1 1 1 1 1", "один один один один один"},
                {"123321", "одиндватритридваодин"}
        };
    }

    @DataProvider
    public static Object[][] dataFourth() {
        return new Object[][]{
                {new StringBuilder("java"), new StringBuilder("jv")},
                {new StringBuilder("H"), new StringBuilder("H")},
                {new StringBuilder(""), new StringBuilder("")},
                {new StringBuilder("ABC"), new StringBuilder("AC")},
                {new StringBuilder("EverySecondCharWillBeDeleted"), new StringBuilder("Eeyeodhrileeee")}
        };
    }

    @DataProvider
    public static Object[][] dataFifth() {
        return new Object[][]{
                {"Hello, world, Java!", "Java! world, Hello,"},
                {"a b c d e f g", "g f e d c b a"},
                {"abc bcd", "bcd abc"},
                {"abc bcd cdf tre", "tre cdf bcd abc"},
                {" htrdrfs areabeabe raenaentrsd", " raenaentareabeabe rsd htrdrfs"}
        };
    }

    @DataProvider
    public static Object[][] dataSixth() {
        return new Object[][]{
                {"Васе 0x00000010 лет", "Васе 16 лет"},
                {"На часах 0x00000010:0x000000000x00000005", "На часах 16:05"},
                {"0x000000E6 + 0x0000000A = 0x000000F0", "230 + 10 = 240"},
                {"0x00000010 * 0x00000010 = 0x00000100", "16 * 16 = 256"},
                {"0x0E05A623", "235251235"},
                {"0xE0000000 = 0xE0000000", "3758096384 = 3758096384"}
        };
    }

    @Test(dataProvider = "dataFirst")
    public void testCopyString(int N, String str, String expected) {
        assertEquals(copyString(N, str), expected);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testCopyStringExIllegal() {
        copyString(-1, "something");
    }

    @Test(expectedExceptions = {NullPointerException.class})
    public void testCopyStringExNull() {
        copyString(2, null);
    }


    @Test(dataProvider = "dataSecond")
    public void testReiterations(String first, String second, int expected) {
        assertEquals(reiterations(first, second), expected);
    }

    @Test(expectedExceptions = {NullPointerException.class})
    public void testReiterationsExNull() {
        reiterations("something", null);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testReiterationsEmpty() {
        reiterations("something", "");
    }


    @Test(dataProvider = "dataThird")
    public void testReplaceNumbers(String str, String expected) {
        assertEquals(replaceNumbers(str), expected);
    }

    @Test(expectedExceptions = {NullPointerException.class})
    public void testReplaceNumbersNull() {
        replaceNumbers(null);
    }

    @Test(dataProvider = "dataFourth")
    public void testDeleteEvenChar(StringBuilder str, StringBuilder expected) {
        assertEquals(deleteEvenChar(str).toString(), expected.toString());
    }

    @Test(dataProvider = "dataFifth")
    public void testReverseWords(String str, String expected) {
        assertEquals(reverseWords(str), expected);
    }

    @Test(dataProvider = "dataSixth")
    public void testReplaceHexadecimalNumbers(String str, String expected) {
        assertEquals(replaceHexadecimalNumbers(str), expected);
    }
}