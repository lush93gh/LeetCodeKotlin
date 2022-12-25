package hackerrank;

import java.util.Collections;
import java.util.List;

public class MiniMaxSum {
    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        long min = 0;
        long max = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (i != 0) max += arr.get(i);
            if (i != 4) min += arr.get(i);
        }
        System.out.println(min + " " + max);
    }
}
