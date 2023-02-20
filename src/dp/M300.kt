package dp

import java.lang.Integer.max

// 300. Longest Increasing Subsequence
class M300 {
    private val cache = mutableMapOf<Int, Int>()
    private fun recursive(nums: IntArray, i: Int): Int {
        if (i == 0) return 1
        else if (cache.containsKey(i)) return cache[i]!!
        else {
            val num = nums[i]
            var max = 0
            for (j in 0 until i) {
                val candidate = recursive(nums, j)
                if (nums[j] < num && candidate > max) {
                    max = candidate
                }
            }
            val candidate = 1 + max
            cache[i] = candidate
            return candidate
        }
    }

    fun lengthOfLIS1(nums: IntArray): Int {
        recursive(nums, nums.size - 1)
        var max = 1
        cache.forEach {
            if (it.value > max) {
                max = it.value
            }
        }
        return max
    }

    fun lengthOfLIS2(nums: IntArray): Int {
        val cache = IntArray(nums.size) { 1 }

        for (i in nums.indices) {
            var max = 0
            for (j in 0 until i) {
                if (nums[i] > nums[j] && cache[j] > max) {
                    max = cache[j]
                }
            }
            cache[i] = 1 + max
        }

        var max = 1
        cache.forEach {
            if (it > max) {
                max = it
            }
        }
        return max
    }

    fun lengthOfLIS(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        nums.forEach {
            set.add(it)
        }

        val numSet = set.sorted().toIntArray()
        val table = Array(nums.size + 1) { IntArray(numSet.size + 1) { 0 } }

        for (i in 1..nums.size) {
            for (j in 1..numSet.size) {
                if (nums[nums.size - i] == numSet[numSet.size - j]) {
                    table[i][j] = table[i - 1][j - 1] + 1
                } else {
                    table[i][j] = max(table[i - 1][j], table[i][j - 1])
                }
            }
        }

        return table[nums.size][numSet.size]
    }
}