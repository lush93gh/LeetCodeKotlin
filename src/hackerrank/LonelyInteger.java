package hackerrank;

import java.util.Collections;
import java.util.List;

public class LonelyInteger {
    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        Collections.sort(a);
        int result = a.get(0);
        boolean hasDuplicate = false;
        for (int i = 1; i < a.size(); i++) {
            int current = a.get(i);
            if(current > result && hasDuplicate) {
                result = current;
                hasDuplicate = false;
            }
            else if(current > result) break;
            else if(current == result) hasDuplicate = true;
        }
        return result;
    }
}
