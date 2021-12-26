package second;

import static second.Date.dayIsTrue;

public class Payment {
    private String fullName;
    private final Date date;
    private int amount;

    public Payment() {
        this.fullName = "Somebody";
        date = new Date(1, 1, 1970);
        this.amount = 1;
    }

    public Payment(String fullName, Date date, int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException("Payment amount can't be zero");
        }
        if (fullName == null) {
            throw new IllegalArgumentException("The string full name is empty");
        }
        this.fullName = fullName;
        this.amount = amount;
        this.date = new Date(date);
    }

    public Payment(final Payment payment) {
        if (payment == null) {
            throw new IllegalArgumentException("The payment is null");
        }
        this.fullName = payment.fullName;
        this.date = new Date(payment.date);
        this.amount = payment.amount;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDay(int day) {
        if (dayIsTrue(day, getMonth(), getYear())) {
            this.date.setDay(day);
        }
    }

    public void setMonth(int month) {
        if (dayIsTrue(getDay(), month, getYear())) {
            this.date.setMonth(month);
        }
    }

    public void setYear(int year) {
        if (dayIsTrue(getDay(), getMonth(), year)) {
            this.date.setYear(year);
        }
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDay() {
        return this.date.getDay();
    }

    public int getMonth() {
        return this.date.getMonth();
    }

    public int getYear() {
        return this.date.getYear();
    }

    public int getAmount() {
        return amount;
    }

    public Date getDate() {
        return new Date(this.date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment pay = (Payment) o;
        return amount == pay.getAmount() && fullName.equals(pay.getFullName()) && date.equals(((Payment) o).date);
    }

    @Override
    public int hashCode() {
        int result = amount;
        for (char data : fullName.toCharArray()) {
            result += data;
        }
        result += date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Payer full name: %s date: %s amount: %d",
                fullName, date.toString(), amount);
    }
}
