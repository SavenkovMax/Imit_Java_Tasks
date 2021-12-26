package third;

public class PrimeNumbersFilter implements IFilter {
    private final int left;
    private final int right;

    PrimeNumbersFilter(int left, int right) {
        this.left = left;
        this.right = right;
    }

    private boolean isPrimeNumber(long number) {
        for (long i = 2; i < (long) Math.sqrt(number) + 1; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public boolean apply(String str) {
        String[] numbers = str.split(" ");
        for (String number : numbers) {
            long temp = Long.parseLong(number);
            if (!(temp >= left && temp <= right) || !isPrimeNumber(temp)) return false;
        }
        return true;
    }
}
