package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class CountingSort1J {
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            result.add(0);
        }
        for (Integer i : arr) {
            result.set(i, result.get(i) + 1);
        }
        return result;
    }
}
