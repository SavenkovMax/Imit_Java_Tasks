package second;

import java.util.Arrays;
import java.util.Objects;

public class IncomeStatement {
    private final int year;
    private final String citizen;
    private final IncomeCertificate[] certificates;
    private final int[] monthlyIncome;
    private final int[] totalIncome;
    private final double[] assessedTax;

    public IncomeStatement(String citizen, int year, IncomeCertificate... certificates) {
        if (citizen == null) {
            throw new IllegalArgumentException("The string citizen is null");
        }
        this.certificates = new IncomeCertificate[certificates.length];
        for (int i = 0; i < certificates.length; i++) {
            if (certificates[i] == null) {
                throw new IllegalArgumentException("Some of certificates is null" + i);
            }
            if (certificates[i].getYear() != year) {
                throw new IllegalArgumentException("The year of income certificate must be equal to the year of income statement" + i);
            }
            this.certificates[i] = new IncomeCertificate(certificates[i]);
        }
        this.year = year;
        this.citizen = citizen;
        monthlyIncome = IncomeStatement.IncomeMonthsArray(certificates);
        totalIncome = IncomeStatement.TotalIncomeArray(certificates);
        assessedTax = IncomeStatement.totalTax(certificates);
    }

    public int getYear() {
        return year;
    }

    public String getCitizen() {
        return citizen;
    }

    private static int[] IncomeMonthsArray(IncomeCertificate[] certificates) {
        int[] result = new int[12];
        for (int i = 0; i < 12; i++) {
            for (IncomeCertificate item : certificates) {
                if (item == null) {
                    throw new IllegalArgumentException("Some of certificates is null");
                }
                result[i] += item.getAmounts()[i];
            }
        }
        return result;
    }

    private static int[] TotalIncomeArray(IncomeCertificate[] certificates) {
        int[] result = new int[12];
        int totalIncome = 0;
        for (int i = 0; i < 12; i++) {
            for (IncomeCertificate item : certificates) {
                if (item == null) {
                    throw new IllegalArgumentException("Some of certificates is null");
                }
                totalIncome += item.getAmounts()[i];
            }
            result[i] = totalIncome;
        }
        return result;
    }

    private static double[] totalTax(IncomeCertificate[] certificates) {
        int totalIncomeMonth = 0;
        int totalIncome = 0;
        int prevTotal = 0;
        double tax = 0;
        double[] result = new double[12];

        for (int i = 0; i < 12; i++) {
            for (IncomeCertificate item : certificates) {
                if (item == null) {
                    throw new IllegalArgumentException("Some of certificates is null");
                }
                totalIncomeMonth += item.getAmounts()[i];
                totalIncome += item.getAmounts()[i];
            }
            if (totalIncome > 24000 && prevTotal <= 24000) {
                tax = (totalIncome - 24000) * 0.13;
            } else if (totalIncome > 240000 && prevTotal <= 240000) {
                tax += (totalIncome - 240000) * 0.2;
                tax += (totalIncomeMonth - (totalIncome - 240000)) * 0.13;
            }
            if (totalIncome > 24000 && totalIncome <= 240000 && prevTotal >= 24000) {
                tax = totalIncomeMonth * 0.13;
            } else if (totalIncome > 240000 && prevTotal >= 240000) {
                tax = totalIncomeMonth * 0.2;
            }
            prevTotal = totalIncome;
            totalIncomeMonth = 0;
            result[i] = tax;
            tax = 0;
        }
        return result;
    }

    public int[] getMonthlyIncome() {
        return monthlyIncome;
    }

    public int[] getTotalIncome() {
        return totalIncome;
    }

    public double[] getAssessedTax () {
        return assessedTax;
    }

    public double getTotalTax() {
        double result = 0;
        for (double item : assessedTax) {
            result += item;
        }
        return result;
    }

    @Override
    public String toString() {
        String title = String.format("Декларация о доходах\nГод: %d\nГражданин: %s\n" +
                "Полученный доход и начисленный налог:\nМесяц\tДоход за месяц, руб.\t" +
                "Суммарный доход с начала года, руб.\t\t" +
                "Начисленный налог на суммарный доход, руб.\n", year, citizen);
        StringBuilder text = new StringBuilder(title);
        String month;
        for (int i = 0; i < 12; i++) {
            if ((i + 1) / 10 == 0) {
                month = String.format("0%d", i + 1);
            } else {
                month = String.format("%d", i + 1);
            }
            String taxStr = String.format("%.2f", assessedTax[i]);
            text.append(String.format("%s\t\t\t%d\t\t\t\t\t\t\t%d\t\t\t\t\t\t\t\t\t\t%s\n", month, monthlyIncome[i], totalIncome[i], taxStr));
        }
        return new String(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IncomeStatement)) return false;
        IncomeStatement that = (IncomeStatement) o;
        return getYear() == that.getYear() &&
                Objects.equals(getCitizen(), that.getCitizen())
                && Arrays.equals(certificates, that.certificates)
                && Arrays.equals(getMonthlyIncome(), that.getMonthlyIncome())
                && Arrays.equals(getTotalIncome(), that.getTotalIncome())
                && Arrays.equals(getAssessedTax(), that.getAssessedTax());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getYear(), getCitizen());
        result = 31 * result + Arrays.hashCode(certificates);
        result = 31 * result + Arrays.hashCode(getMonthlyIncome());
        result = 31 * result + Arrays.hashCode(getTotalIncome());
        result = 31 * result + Arrays.hashCode(getAssessedTax());
        return result;
    }
}
