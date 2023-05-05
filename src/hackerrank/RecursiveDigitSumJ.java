package hackerrank;

public class RecursiveDigitSumJ {
    public static int superDigit(String n, int k) {
        // Write your code here
        char[] charArray = n.toCharArray();
        Long number = sum(charArray) * k;
        while (number / 10 > 0) {
            number = sum(number.toString().toCharArray());
        }
        return number.intValue();
    }

    private static Long sum(char[] charArray) {
        Long num = 0L;
        for (char c : charArray) {
            num += Integer.parseInt(String.valueOf(c));
        }
        return num;
    }
}
