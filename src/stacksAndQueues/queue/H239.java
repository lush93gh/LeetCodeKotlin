package stacksAndQueues.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

// 239. Sliding Window Maximum
public class H239 {
    class Pair<T1, T2> {
        T1 first;
        T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int j = 0;
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }

        result[j++] = nums[deque.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);

            result[j++] = nums[deque.peekFirst()];
        }

        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int j = 0;
        Deque<Pair<Integer, Integer>> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast().second) {
                deque.pollLast();
            }
            deque.addLast(new Pair<>(i, nums[i]));
        }

        result[j++] = deque.peekFirst().second;

        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst().first <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[i] > deque.peekLast().second) {
                deque.pollLast();
            }
            deque.addLast(new Pair<>(i, nums[i]));

            result[j++] = deque.peekFirst().second;
        }

        return result;
    }

    Stack<Pair<Integer, Integer>> s1 = new Stack<>();
    Stack<Pair<Integer, Integer>> s2 = new Stack<>();

    private void push(Stack<Pair<Integer, Integer>> stack, int value) {
        int max = stack.isEmpty() ? value : Math.max(stack.peek().second, value);
        stack.push(new Pair<>(value, max));
    }

    private Pair<Integer, Integer> pop() {
        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                Pair<Integer, Integer> node = s2.peek();
                push(s1, node.first);
                s2.pop();
            }
        }
        return s1.pop();
    }

    private int getMax() {
        int max = Integer.MIN_VALUE;
        if (!s1.isEmpty()) max = Math.max(max, s1.peek().second);
        if (!s2.isEmpty()) max = Math.max(max, s2.peek().second);
        return max;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int j = 0;

        for (int i = 0; i < k; i++) {
            push(s2, nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            result[j++] = getMax();
            pop();
            push(s2, nums[i]);
        }

        result[j] = getMax();

        return result;
    }
}
