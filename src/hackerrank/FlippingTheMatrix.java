package hackerrank;

import java.util.List;

public class FlippingTheMatrix {
    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        int sum = 0;
        int lastIndex = matrix.size() - 1;
        for (int i = 0; i < matrix.size() / 2; i++) {
            for (int j = 0; j < matrix.size() / 2; j++) {
                int upper = Math.max(matrix.get(i).get(j), matrix.get(i).get(lastIndex - j));
                int lower = Math.max(matrix.get(lastIndex - i).get(j), matrix.get(lastIndex - i).get(lastIndex - j));
                sum += Math.max(upper, lower);
            }
        }
        return sum;
    }
}
