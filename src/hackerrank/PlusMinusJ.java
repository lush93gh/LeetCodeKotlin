package hackerrank;

import java.util.List;

public class PlusMinusJ {
    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        float size = arr.size();
        int positive = 0;
        int negative = 0;
        int zero = 0;
        for (int i = 0; i < size; i++) {
            if (arr.get(i) > 0) positive++;
            else if (arr.get(i) == 0) zero++;
            else negative++;
        }
        System.out.println(positive / size);
        System.out.println(negative / size);
        System.out.println(zero / size);
    }
}
