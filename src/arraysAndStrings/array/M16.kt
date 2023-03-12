package arraysAndStrings.array

import kotlin.math.abs

// 16. 3Sum Closest
class M16 {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var minDiff = Int.MAX_VALUE
        var closest = Int.MAX_VALUE
        for (i in nums.indices) {
            val twoSumTarget = target - nums[i]
            var j = i + 1
            var k = nums.size - 1
            while (j < k) {
                val sum = nums[j] + nums[k]
                if (abs(sum - twoSumTarget) < minDiff) {
                    minDiff = abs(sum - twoSumTarget)
                    closest = sum + nums[i]
                }
                if (sum == twoSumTarget) {
                    return sum + +nums[i]
                } else if (sum > twoSumTarget) {
                    k--
                } else {
                    j++
                }
            }
        }
        return closest
    }
}