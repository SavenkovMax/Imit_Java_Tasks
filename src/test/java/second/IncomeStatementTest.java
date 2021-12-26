package second;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IncomeStatementTest {

    @DataProvider
    public Object[][] dataMonthlyIncome() {
        int[] amount = {3000, 5000, 8000, 5000, 9900, 2400, 12300, 4000, 0, 12000, 3000, 5000};
        IncomeCertificate first = new IncomeCertificate("smb", "smth", 2020, amount);
        int[] amountSecond = {9000, 1800, 4000, 2000, 5000, 10000, 500, 0, 0, 0, 16000, 17000};
        IncomeCertificate second = new IncomeCertificate("smb", "another organization", 2020, amountSecond);
        int[] expected = {12000, 6800, 12000, 7000, 14900, 12400, 12800, 4000, 0, 12000, 19000, 22000};
        int[] amountThird = {23000, 4000, 15600, 5000, 24200, 9000, 6000, 7000, 1000, 0, 0, 0};
        int[] amountFourth = {5000, 1200, 430, 600, 9000, 12000, 5000, 6000, 5000, 0, 0, 0};
        IncomeCertificate third = new IncomeCertificate("smb", "organization", 2020, amountThird);
        IncomeCertificate fourth = new IncomeCertificate("smb", "organization", 2020, amountFourth);
        int[] expectedSecond = {28000, 5200, 16030, 5600, 33200, 21000, 11000, 13000, 6000, 0, 0, 0};
        return new Object[][] {
                {new IncomeStatement("smb", 2020, first, second), expected},
                {new IncomeStatement("smb", 2020, third, fourth), expectedSecond}
        };
    }

    @DataProvider
    public Object[][] dataTotalIncome() {
        int[] amount = {500, 1230, 600, 3000, 1200, 6000, 7000, 0, 0, 5000, 20000, 3500};
        IncomeCertificate first = new IncomeCertificate("smb", "org", 2020, amount);
        int[] amountSecond = {1000, 1000, 1000, 3000, 2000, 4000, 5000, 3000, 6000, 10000, 10000, 20000};
        IncomeCertificate second = new IncomeCertificate("smb", "org", 2020, amountSecond);
        int[] expected = {1500, 3730, 5330, 11330, 14530, 24530, 36530, 39530, 45530, 60530, 90530, 114030};
        int[] amountThird = {9000, 2300, 50000, 12300, 6000, 6000, 7000, 14000, 9000, 14000, 5000, 9000};
        IncomeCertificate third = new IncomeCertificate("smb", "org", 2020, amountThird);
        int[] amountFourth = {95000, 50000, 60000, 50000, 30000, 35000, 60000, 28000, 29900, 40000, 11000, 12000};
        IncomeCertificate fourth = new IncomeCertificate("smb", "org", 2020, amountFourth);
        int[] expectedSecond = {105500, 160030, 271630, 339930, 379130, 430130, 509130, 554130, 599030, 668030, 714030, 758530};
        return new Object[][] {
                {new IncomeStatement("smb", 2020, first, second), expected},
                {new IncomeStatement("smb", 2020, first, second, third, fourth), expectedSecond}
        };
    }

    @DataProvider
    public Object[][] dataAssessedTax() {
        int[] amount = {6000, 6000, 6000, 8000, 60000, 60000, 60000, 60000, 100000, 100000, 100000, 100000};
        IncomeCertificate first = new IncomeCertificate("smb", "org", 2020, amount);
        double[] expected = {0.0, 0.0, 0.0, 260.0, 7800.0, 7800.0, 7800.0, 9620.0, 20000.0, 20000.0, 20000.0, 20000.0};
        int[] amountSecond = {1200, 2300, 24000, 25000, 20000, 50000, 20000, 12000, 30000, 50000, 20000, 24000};
        IncomeCertificate second = new IncomeCertificate("smb", "org", 2020, amountSecond);
        double[] expectedSecond = {0.0, 0.0, 455.0, 3250.0, 2600.0, 6500.0, 2600.0, 6500.0, 2600.0, 1560.0, 3900.0, 6500.0, 3615.0, 4800.0};
        return new Object[][] {
                {new IncomeStatement("smb", 2020, first), expected}
        };
    }

    @Test(dataProvider = "dataMonthlyIncome")
    public void testGetMonthlyIncome(IncomeStatement incomeStatement, int[] expected) {
        assertEquals(incomeStatement.getMonthlyIncome(), expected);
    }

    @Test(dataProvider = "dataTotalIncome")
    public void testGetTotalIncome(IncomeStatement incomeStatement, int[] expected) {
        assertEquals(incomeStatement.getTotalIncome(), expected);
    }

    @Test(dataProvider = "dataAssessedTax")
    public void testGetAssessedTax(IncomeStatement incomeStatement, double[] expected) {
        assertEquals(incomeStatement.getAssessedTax(), expected);
    }

    @Test(dataProvider = "dataAssessedTax")
    public void testGetTotalTax(IncomeStatement incomeStatement, double[] expected) {
        double expectedSum = 0;
        for (double data: expected) {
            expectedSum += data;
        }
        assertEquals(incomeStatement.getTotalTax(), expectedSum);
    }
}