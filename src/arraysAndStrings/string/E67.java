package arraysAndStrings.string;

import java.math.BigInteger;

// 67. Add Binary
public class E67 {
    public String addBinary1(String a, String b) {
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();

        char[] reverseA = new char[aCharArray.length];
        char[] reverseB = new char[bCharArray.length];

        for (int i = 0; i < aCharArray.length; i++) {
            reverseA[i] = aCharArray[aCharArray.length - 1 - i];
        }

        for (int i = 0; i < bCharArray.length; i++) {
            reverseB[i] = bCharArray[bCharArray.length - 1 - i];
        }

        int digit = Math.max(aCharArray.length, bCharArray.length);

        char[] result = new char[digit + 1];
        char[] longerArray = aCharArray.length > bCharArray.length ? reverseA : reverseB;
        boolean carry = false;
        int i = 0;
        for (i = 0; i < digit; i++) {
            if (i < aCharArray.length && i < bCharArray.length) {
                char num1 = reverseA[i];
                char num2 = reverseB[i];

                if (num1 != num2) {
                    if (carry) {
                        result[i] = '0';
                    } else {
                        result[i] = '1';
                    }
                } else {
                    if (num1 == '0') {
                        if (carry) {
                            result[i] = '1';
                            carry = false;
                        } else {
                            result[i] = '0';
                        }
                    } else {
                        if (carry) {
                            result[i] = '1';
                        } else {
                            result[i] = '0';
                            carry = true;
                        }
                    }
                }
            } else {
                char num = longerArray[i];
                if (num == '0') {
                    if (carry) {
                        result[i] = '1';
                        carry = false;
                    } else {
                        result[i] = '0';
                    }
                } else {
                    if (carry) {
                        result[i] = '0';
                    } else {
                        result[i] = '1';
                    }
                }
            }
        }

        if (carry) result[i] = '1';

        int newDigit = carry ? digit + 1 : digit;
        char[] resultReverse = carry ? new char[digit + 1] : new char[digit];
        for (i = 0; i < newDigit; i++) {
            resultReverse[i] = result[newDigit - 1 - i];
        }

        return String.valueOf(resultReverse);
    }

    public String addBinary2(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int num1 = i < 0 ? 0 : a.charAt(i--) - '0';
            int num2 = j < 0 ? 0 : b.charAt(j--) - '0';
            int sum = (num1 + num2 + carry) % 2;
            carry = (num1 + num2 + carry) / 2;
            result.insert(0, sum);
        }
        return result.toString();
    }

    public String addBinary(String a, String b) {
        return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
    }
}
