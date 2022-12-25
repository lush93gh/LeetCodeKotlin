package hackerrank;

public class PalindromeIndex {
    static int attempts = 0;
    static int result = -1;

    public static int palindromeIndex(String s) {
        attempts = 0;
        result = -1;
        // Write your code here
        char[] charArray = s.toCharArray();
        palindrome(charArray, 0, charArray.length - 1);

        return result;
    }

    public static boolean palindrome(char[] charArray, int i, int j) {
        if (i > j) return true;
        if (charArray[i] != charArray[j]) {
            if (attempts > 0) return false;
            else {
                attempts++;
                boolean left = palindrome(charArray, i + 1, j);
                boolean right = palindrome(charArray, i, j - 1);
                if (attempts > 0 && left) result = i;
                else if (attempts > 0 && right) result = j;
                return left || right;
            }
        } else return palindrome(charArray, i + 1, j - 1);

    }

}
