package second;

public class Date {
    private int day;
    private int month;
    private int year;


    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 1970;
    }

    public Date(int day, int month, int year) {
        if (!dayIsTrue(day, month, year)) {
            throw new IllegalArgumentException("The day is incorrect for the corresponding month");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(final Date date) {
        if (date == null) {
            throw new IllegalArgumentException("The date is null");
        }
        this.day = date.day;
        this.month = date.month;
        this.year = date.year;
    }

    public Date (final String date) {
        if (date == null) {
            throw new IllegalArgumentException("The date string is null");
        }
        if (date.length() != 10) {
            throw new IllegalArgumentException("The string is not a date");
        }
        int day = 0;
        int month = 0;
        int year = 0;
        int j = 0;
        StringBuilder actual = new StringBuilder("");
        for (int i = 0; i < 3; i++) {
            while (date.charAt(j) != '.') {
                if (!Character.isDigit(date.charAt(j))) {
                    throw new IllegalArgumentException("The string is not a date");
                }
                actual.append(date.charAt(j));
                j++;
                if (j == date.length()) {
                    break;
                }
            }
            if (i == 0 && actual.length() == 2) {
                day = Integer.parseInt(actual.toString());
            } else if (i == 1 && actual.length() == 2) {
                month = Integer.parseInt(actual.toString());
            } else if (i == 2 && actual.length() == 4) {
                year = Integer.parseInt(actual.toString());
            }
            actual.delete(0, actual.length());
            j++;
        }
        if (!dayIsTrue(day, month, year)) {
            throw new IllegalArgumentException("The day is incorrect for the corresponding month");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isLeapYear(int year) {
        boolean leapYear = true;
        if (year % 4 != 0) {
            leapYear = false;
        } else if (year % 100 == 0 && year % 400 != 0) {
            leapYear = false;
        }
        return leapYear;
    }

    public static boolean dayIsTrue(int day, int month, int year) {
        if (day < 1 || month < 1 || year < 1) {
            throw new IllegalArgumentException("Date parameters must be positive");
        }
        if (month > 12) {
            return false;
        }
        if (day > 31) {
            throw new IllegalArgumentException("The day must be less than or equal to 31");
        }
        boolean dayTrue = true;
        if (month == 2 && isLeapYear(year) && day > 29) {
            dayTrue = false;
        }
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (!isLeapYear(year) && day > days[month - 1]) {
            dayTrue = false;
        }
        return dayTrue;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public int hashCode() {
        return this.year * 500 + this.month * 50 + this.day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.day == ((Date) o).day && this.month == ((Date) o).month && this.year == ((Date) o).year;
    }

    @Override
    public String toString() {
        return String.format("%d.%d.%d", day, month, year);
    }

    enum Months {
        January, February, March, April, May, June, July, August, September, October, November, December
    }
}
