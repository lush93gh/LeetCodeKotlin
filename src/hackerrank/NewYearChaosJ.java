package hackerrank;

import java.util.Collections;
import java.util.List;

public class NewYearChaosJ {
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int sum = 0;
        for (int i = 1; i <= q.size(); i++) {
            int person = q.get(i - 1);
            if (person > i + 2) {
                System.out.println("Too chaotic");
                return;
            }
        }

        for (int i = 1; i <= q.size(); i++) {
            int index = i - 1;
            while (q.get(index) != i) {
                index++;
            }
            for (int j = index; j > i - 1; j--) {
                Collections.swap(q, j, j - 1);
                sum++;
            }
        }

        System.out.println(sum);
    }
}
