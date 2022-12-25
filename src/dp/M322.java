package dp;

import java.util.HashMap;

public class M322 {
    public int coinChange1(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins.length == 0) return -1;
        return recursive(coins, amount, new HashMap<>());
    }

    public int recursive(int[] coins, int amount, HashMap<Integer, Integer> cache) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (cache.containsKey(amount)) return cache.get(amount);

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= amount) {
                int rollOut = recursive(coins, amount - coin, cache) + 1;
                if (rollOut > 0 && rollOut < min) {
                    min = rollOut;
                }
            }
        }
        int result = (min == Integer.MAX_VALUE) ? -1 : min;
        cache.put(amount, result);
        return result;
    }

    public int coinChange(int[] coins, int amount) {
        int[] table = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && table[i - coin] != -1) {
                    int roll = table[i - coin] + 1;
                    if (roll < min) {
                        min = roll;
                    }
                }
            }
            int result = (min == Integer.MAX_VALUE) ? -1 : min;
            table[i] = result;
        }

        return table[amount];
    }
}
