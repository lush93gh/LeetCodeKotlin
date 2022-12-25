package hackerrank;

import java.util.Collections;
import java.util.List;

public class FindTheMedian {
    public static int findMedian(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int index = arr.size() / 2;
        return arr.get(index);
    }
}
