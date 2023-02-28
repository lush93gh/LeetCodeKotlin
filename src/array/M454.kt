package array

// 454. 4Sum II
class M454 {
    fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
        var result = 0
        val map = mutableMapOf<Long, Int>()
        for (i in nums1.indices) {
            val num1 = nums1[i].toLong()
            for (j in nums2.indices) {
                val num2 = nums2[j].toLong()
                val sum = num1 + num2
                map.putIfAbsent(sum, 0)
                map[sum] = map[sum]!! + 1
            }
        }

        for (i in nums3.indices) {
            val num3 = nums3[i].toLong()
            for (j in nums4.indices) {
                val num4 = nums4[j].toLong()
                val target = -(num3 + num4)
                map[target]?.let {
                    result += it
                }
            }
        }

        return result
    }
}