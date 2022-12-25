package weivretni.yapenil;

import java.util.*;

public class Window {

    public void windowMax(List<Long> nums, long capacity) {
        int n = nums.size();
        if (n == 0) return;

        long[] result = new long[(int)(n - capacity + 1)];
        Deque<Integer> window = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (window.size() > 0
                    && window.peekFirst() <= i - capacity) {
                window.pollFirst();
            }

            while (window.size() > 0 &&
                    nums.get(window.peekLast()) < nums.get(i)
            ) {
                window.pollLast();
            }

            window.offerLast(i);

            if (i >= capacity - 1) {
                result[(int)(i - capacity + 1)] = nums.get(window.peekFirst());
            }
        }
        for(int i = 0;i< result.length;i++){
            System.out.println(result[i]);
        }
    }
}
