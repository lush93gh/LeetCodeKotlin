package weivretni.yapyap;

import java.util.*;

public class MostOccurDigits {
    public int[] calculate(int[] a) {
        int[] counts = new int[10];
        for (Integer num : a) {
            char[] array = num.toString().toCharArray();
            for (char c : array) {
                counts[c - '0']++;
            }
        }
        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (Integer num : counts) {
            if (num > max) {
                max = num;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (counts[i] == max) {
                result.add(i);
            }
        }

        result.sort(Integer::compareTo);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
