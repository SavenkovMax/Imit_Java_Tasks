package first;

import java.util.Scanner;

public final class Array {

    private Array() {}

    public static void print(int[] data) {
        for (int item : data) {
            System.out.print(item + " ");
        }
    }

    public static void fill(int[] data) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < data.length; i++) {
            data[i] = in.nextInt();
        }
    }

    public static int sum(int[] data) {
        int summa = 0;
        for (int item : data) {
            summa += item;
        }
        return summa;
    }

    public static int evenNumber(int[] data) {
        int count = 0;
        for (int item : data) {
            if (item % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int section(int[] data, double a, double b) {
        int count = 0;
        for (int item : data) {
            if (item >= a && item <= b) {
                count++;
            }
        }
        return count;
    }

    public static boolean positive(int[] data) {
        boolean pos = true;
        for (int item : data) {
            if (item <= 0) {
                pos = false;
                break;
            }
        }
        return pos;
    }

    public static void reverse(int[] data) {
        int i = 0;
        int j = data.length - 1;
        int tmp;
        while (i < j) {
            tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
            i++;
            j--;
        }
    }
}
