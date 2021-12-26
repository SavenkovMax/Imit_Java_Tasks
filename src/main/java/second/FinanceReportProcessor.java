package second;

import java.util.ArrayList;

public final  class FinanceReportProcessor {
    private FinanceReportProcessor() {}

    public static FinanceReport getPaymentsByLastName(FinanceReport report, char letter) {
        if (report == null) {
            throw new IllegalArgumentException("The report is undefined");
        }
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("The character is not a letter");
        }
        FinanceReport result = new FinanceReport();
        result.setFullName(report.getFullName());
        result.setDate(report.getDate());
        for (int i = 0; i < report.getPayments().length; i++) {
            if (report.getPayments()[i] == null) {
                continue;
            }
            String name = report.getPaymentFullName(i);
            name = name.trim();
            if (name.charAt(0) == letter) {
                result.addPayment(new Payment(report.getPayments()[i]));
            }
        }
        return result;
    }

    public static FinanceReport getPaymentsLessThanNumber(FinanceReport report, int number) {
        if (report == null) {
            throw new IllegalArgumentException("The report is undefined");
        }
        FinanceReport result = new FinanceReport();
        result.setFullName(report.getFullName());
        result.setDate(report.getDate());
        for (int i = 0; i < report.getPayments().length; i++) {
            if (report.getPayments()[i] == null) {
                continue;
            }
            if (report.AccessPaymentRead(i, "amount") < number) {
                result.addPayment(new Payment(report.getPayments()[i]));
            }
        }
        return result;
    }

    public static long getTotalPaymentByDate(FinanceReport report, String strDate) {
        if (report == null) {
            throw new IllegalArgumentException("The report is undefined");
        }
        long result = 0;
        Date date = new Date(strDate);
        for (int i = 0; i < report.getPayments().length; i++) {
            if (report.getPayments()[i] == null) {
                continue;
            }
            if (report.getPayments()[i].getDate().equals(date)) {
                result += report.AccessPaymentRead(i, "amount");
            }
        }
        return result;
    }

    public static ArrayList<String> getMonthsWithNoPayment(FinanceReport report) {
        if (report == null) {
            throw new IllegalArgumentException("The report is undefined");
        }
        ArrayList<String> list = new ArrayList<>();
        boolean[] months = new boolean[12];
        for (int i = 0; i < report.getPayments().length; i++) {
            if (report.getPayments()[i] == null) {
                continue;
            }
            months[report.AccessPaymentRead(i, "month") - 1] = true;
        }
        for (int i = 0; i < 12; i++) {
            if (!months[i]) {
                list.add(Date.Months.values()[i].toString());
            }
        }
        return list;
    }
}
