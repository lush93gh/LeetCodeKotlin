package weivretni.yapyap;

import java.util.ArrayList;
import java.util.List;

public class BiggestTwoDigits {
    public int solution(String S) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < S.length() - 1; i++) {
            String num = S.substring(i, i + 2);
            numbers.add(Integer.parseInt(num));
        }

        int max = Integer.MIN_VALUE;
        for (Integer num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
