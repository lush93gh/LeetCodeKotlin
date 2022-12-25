package array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class E1 {
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int remains = target - nums[i];
            result[0] = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == remains) {
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                map.get(num).add(i);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int remains = target - nums[i];
            if (map.containsKey(remains)) {
                result[0] = i;
                List<Integer> list = map.get(remains);
                for (Integer num : list) {
                    if (num != i) {
                        result[1] = num;
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int remains = target - num;
            if (map.containsKey(remains)) {
                return new int[] { map.get(remains), i };
            }
            map.put(num, i);
        }

        return null;
    }
}
