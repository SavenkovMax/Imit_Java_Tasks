package second;

import java.util.Stack;

public final class StringProcessor {
    private StringProcessor() {}

    public static String copyString(int N, String s) {
        if (N < 0) {
            throw new IllegalArgumentException("The number of copies must be non-negative");
        }
        if (s == null) {
            throw new NullPointerException("The string is null");
        }
        StringBuilder st = new StringBuilder("");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < s.length(); j++) {
                st.append(s.charAt(j));
            }
        }
        return new String(st);
    }

    public static boolean palindrome(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("String is empty");
        }
        boolean flag = true;
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                flag = false;
                break;
            }
            i++;
            j--;
        }
        return flag;
    }

    public static int reiterations(String str1, String str2) {
        if (str2 == null) {
            throw new NullPointerException("String number 2 is null");
        }
        if (str2.length() == 0) {
            throw new IllegalArgumentException("String number 2 is empty");
        }
        int amountOfSubs = 0;
        int index = 0;
        int length = 1;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(index) && length != str2.length()) {
                index++;
                length++;
            } else if (str1.charAt(i) == str2.charAt(index) && length == str2.length()) {
                length = 1;
                index = 0;
                amountOfSubs++;
            }
        }
        return amountOfSubs;
    }

    public static String replaceNumbers(String str) {
        if (str == null) {
            throw new NullPointerException("The string is null");
        }
        StringBuilder st = new StringBuilder(str);
        for (int i = 0; i < st.length(); i++) {
            switch (st.charAt(i)) {
                case '1':
                    st.setCharAt(i, 'о');
                    st.insert(i + 1, "дин");
                    break;
                case '2':
                    st.setCharAt(i, 'д');
                    st.insert(i + 1, "ва");
                    break;
                case '3':
                    st.setCharAt(i, 'т');
                    st.insert(i + 1, "ри");
                    break;
                default:
                    break;
            }
        }
        return new String(st);
    }

    public static StringBuilder deleteEvenChar(StringBuilder str) {
        if (str == null) {
            throw new NullPointerException("The string is null");
        }
        int length = str.length() / 2;
        for (int i = 0; i < length; i++) {
            str.deleteCharAt(i + 1);
        }
        return str;
    }

    public static String reverseWords(String str) {
        if (str == null) {
            throw new NullPointerException("The string is null");
        }
        StringBuilder words = new StringBuilder(str);
        StringBuilder subWordLeft = new StringBuilder("");
        StringBuilder subWordRight = new StringBuilder("");
        int i = 0;
        int j = words.length() - 1;
        int left1 = 0;
        int right1 = 0;
        int left2 = 0;
        int right2 = 0;
        boolean word1 = false;
        boolean word2 = false;
        while (i < j) {
            if (words.charAt(i) >= 33 && words.charAt(i) <= 126) {
                left1 = right1 = i;
                left2 = right2 = j;
                word1 = true;
                while (words.charAt(right1) >= 33 && words.charAt(i) <= 126) {
                    subWordLeft.append(words.charAt(right1));
                    right1++;
                }
                while (words.charAt(left2) < 33 || words.charAt(left2) > 126) {
                    left2--;
                    right2--;
                    j--;
                }
                while (words.charAt(left2) >= 33 && words.charAt(left2) <= 126) {
                    word2 = true;
                    subWordRight.append(words.charAt(left2));
                    left2--;
                }
                subWordRight.reverse();
                j = left2;
            }
            if (word1 && word2) {
                words.delete(left1, right1);
                words.insert(left1, subWordRight);
                left2 += subWordRight.length() - subWordLeft.length() + 1;
                right2 += subWordRight.length() - subWordLeft.length();
                words.delete(left2, right2 + 1);
                words.insert(left2, subWordLeft);
                subWordLeft.delete(0, subWordLeft.length());
                subWordRight.delete(0, subWordRight.length());
                j = left2;
                i = right1;
                j--;
            }
            word1 = false;
            word2 = false;
            i++;
        }
        return new String(words);
    }

    public static long hexadecimalNumber(Stack<Character> number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }
        long result = 0;
        int rank = 0;
        char symbol = 0;
        while (!(number.isEmpty())) {
            symbol = number.pop();
            if (symbol >= 48 && symbol <= 57) {
                result += (symbol - 48) * Math.pow(16, rank);
            } else if (symbol >= 65 && symbol <= 70) {
                result += (symbol - 55) * Math.pow(16, rank);
            } else {
                throw new IllegalArgumentException("This stack hasn't a hexadecimal number");
            }
            rank++;
        }
        return result;
    }

    public static String replaceHexadecimalNumbers(String str) {
        if (str == null) {
            throw new NullPointerException("The string is null");
        }
        Stack<Character> number = new Stack<>();
        int i = 0;
        int left = 0;
        int right = 0;
        long result = 0;
        StringBuilder replacer = new StringBuilder(str);
        while (i < replacer.length()) {
            left = replacer.indexOf("0x");
            if (left == -1) {
                break;
            } else {
                left += 2;
                right = left;
                while (right != left + 8 && right != replacer.length()) {
                    number.push(replacer.charAt(right));
                    right++;
                }
                result = hexadecimalNumber(number);
                left -= 2;
                replacer.delete(left, right);
                replacer.insert(left, result);
                String letter = Long.toString(result);
                i = left + letter.length() - 1;
            }
            i++;
        }
        return new String(replacer);
    }
}
