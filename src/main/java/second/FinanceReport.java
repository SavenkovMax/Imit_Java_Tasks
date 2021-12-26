package second;

import java.util.Objects;

public class FinanceReport {
    private Payment[] payments;
    private Date date;
    private String fullName;
    private static int amortizeCounter = 10;

    public FinanceReport() {
        this.fullName = "Somebody";
        this.date = new Date(1, 1, 1970);
        this.payments = new Payment[0];
    }

    public FinanceReport(String fullName, Date date, Payment[] payments) {
        if (fullName == null) {
            throw new IllegalArgumentException("The full name is null");
        }
        if (date == null) {
            throw new IllegalArgumentException("The date is null");
        }
        if (payments == null) {
            throw new IllegalArgumentException("Payments array is null");
        }
        this.fullName = fullName;
        this.date = new Date(date);
        this.payments = new Payment[payments.length];
        for (int i = 0; i < payments.length; i++) {
            if (payments[i] == null) {
                throw new IllegalArgumentException("Some of payments is null");
            }
            this.payments[i] = new Payment(payments[i]);
        }
    }

    public FinanceReport(final FinanceReport report) {
        if (report == null) {
            throw new IllegalArgumentException("The report is null");
        }
        this.fullName = report.fullName;
        this.payments = new Payment[report.payments.length];
        this.date = new Date(report.getDate());
        for (int i = 0; i < report.payments.length; i++) {
            if (report.payments[i] == null) {
                throw new IllegalArgumentException("Some of payments is null");
            }
            payments[i] = new Payment(report.payments[i]);
        }
    }

    public Payment[] getPayments() {
        Payment[] payments = new Payment[this.payments.length];
        for (int i = 0; i < payments.length; i++) {
            payments[i] = new Payment(this.payments[i]);
        }
        return payments;
    }

    public int paymentCount() {
        int count = 0;
        for (Payment item : payments) {
            if (item != null) {
                count++;
            }
        }
        return count;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDay() {
        return date.getDay();
    }

    public int getMonth() {
        return date.getMonth();
    }

    public int getYear() {
        return date.getYear();
    }

    public Date getDate() {
        return new Date(this.date);
    }

    public void setDate(Date date) {
        this.date = new Date(date);
    }

    public void setDay(int day) {
        date.setDay(day);
    }

    public void setMonth(int month) {
        date.setMonth(month);
    }

    public void setYear(int year) {
        date.setYear(year);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int AccessPaymentRead(int i, String code) {
        if (i < 0 || i > payments.length - 1) {
            throw new IndexOutOfBoundsException("The index of an array must be in range [0, arrSize - 1]");
        }
        if (payments[i] == null) {
            throw new IllegalArgumentException("The payment is null");
        }
        code = code.trim();
        code = code.toLowerCase();
        int result = 0;
        switch (code) {
            case "day":
                result = payments[i].getDay();
                break;
            case "month":
                result = payments[i].getMonth();
                break;
            case "year":
                result = payments[i].getYear();
                break;
            case "amount":
                result = payments[i].getAmount();
                break;
            default:
                result = -1;
                break;
        }
        return result;
    }

    public String getPaymentFullName(int i) {
        if (i < 0 || i > payments.length - 1) {
            throw new IndexOutOfBoundsException("The index of an array must be in range [0, arrSize - 1]");
        }
        if (payments[i] == null) {
            throw new IllegalArgumentException("The payment is null");
        }
        return payments[i].getFullName();
    }

    public void AccessPaymentWrite(int i, String code, int data) {
        if (i < 0 || i > payments.length - 1) {
            throw new IndexOutOfBoundsException("The index of an array must be in range [0, arrSize - 1]");
        }
        if (payments[i] == null) {
            throw new IllegalArgumentException("The payment is null");
        }
        code = code.trim();
        code = code.toLowerCase();
        switch (code) {
            case "day":
                payments[i].setDay(data);
                break;
            case "month":
                payments[i].setMonth(data);
                break;
            case "year":
                payments[i].setYear(data);
                break;
            case "amount":
                payments[i].setAmount(data);
                break;
            default:
                break;
        }
    }

    public void setPaymentFullName(int i, String fullName) {
        if (i < 0 || i > payments.length - 1) {
            throw new IndexOutOfBoundsException("The index of an array must be in range [0, arrSize - 1]");
        }
        if (payments[i] == null) {
            throw new IllegalArgumentException("The payment is null");
        }
        payments[i].setFullName(fullName);
    }

    public void addPayment(Payment payment) {
        if (amortizeCounter == 0) {
            amortizeCounter = 10;
            Payment[] payments = new Payment[this.payments.length + amortizeCounter];
            for (int i = 0; i < this.payments.length; i++) {
                payments[i] = new Payment(this.payments[i]);
            }
            this.payments = payments;
        }
        for (int i = 0; i < payments.length; i++) {
            if (this.payments[i] == null) {
                this.payments[i] = new Payment(payment);
                break;
            }
        }
        amortizeCounter--;
    }

    @Override
    public String toString() {
        String str = String.format("Compiler: %s, date: %s",
                fullName, date.toString());
        StringBuilder text = new StringBuilder();
        text.append(str);
        text.append("\n");
        int rub, k1, k2;
        for (Payment payment : payments) {
            if (payment == null) {
                continue;
            }
            rub = payment.getAmount() / 100;
            k1 = payment.getAmount() % 10;
            k2 = (payment.getAmount() / 10) % 10;
            str = String.format("Payer: %s, date: %s, payment: %d rub, %d%d kop\n",
                    payment.getFullName(), payment.getDate().toString(),
                    rub, k2, k1);
            text.append(str);
        }
        return new String(text);
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += fullName.hashCode();
        hashCode += date.hashCode();
        for (Payment payment : payments) {
            if (payment == null) {
                continue;
            }
            hashCode += payment.getDate().hashCode();
            hashCode += payment.getFullName().hashCode();
            hashCode += payment.getAmount();
        }
        return hashCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinanceReport)) return false;
        FinanceReport that = (FinanceReport) o;
        Payment[] objectPayments = that.getPayments();
        int minLength = objectPayments.length + payments.length - Math.abs(objectPayments.length - payments.length);
        for (int i = 0; i < minLength; i++) {
            if (!objectPayments[i].equals(payments[i])) {
                return false;
            }
        }
        return
                Objects.equals(getDate(), that.getDate()) &&
                Objects.equals(getFullName(), that.getFullName());
    }
}
