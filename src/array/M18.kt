package array

// 18. 4Sum
class M18 {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val results = mutableSetOf<List<Int>>()
        for (a in nums.indices) {
            val numA = nums[a]
            val threeSumTarget: Long = target.toLong() - numA
            for (b in a + 1 until nums.size) {
                val numB = nums[b]
                val twoSumTarget: Long = threeSumTarget - numB
                var c = b + 1
                var d = nums.size - 1
                while (c < d) {
                    val sum: Long = nums[c].toLong() + nums[d]
                    if (sum == twoSumTarget) {
                        results.add(listOf(numA, numB, nums[c], nums[d]))
                        c++
                    } else if (sum > twoSumTarget) {
                        d--
                    } else {
                        c++
                    }
                }
            }
        }
        return results.toList()
    }
}