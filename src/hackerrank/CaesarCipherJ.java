package hackerrank;

public class CaesarCipherJ {
    public static String caesarCipher(String s, int k) {
        // Write your code here
        StringBuilder result = new StringBuilder();
        char[] string = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (string[i] >= 65 && string[i] <= 90) {
                int c = (string[i] - 65 + k) % 26 + 65;
                result.append((char)c);
            }
            else if (string[i] >= 97 && string[i] <= 122) {
                int c = (string[i] - 97 + k) % 26 + 97;
                result.append((char)c);
            } else result.append(string[i]);
        }
        return result.toString();
    }
}
