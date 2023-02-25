package array

// 15. 3Sum
class M15 {
    private lateinit var map: MutableMap<Int, Int>
    fun threeSum(nums: IntArray): List<List<Int>> {
        map = mutableMapOf()
        nums.forEachIndexed { index, num ->
            map[num] = index
        }
        val result = mutableSetOf<List<Int>>()
        for (i in nums.indices) {
            val target = -nums[i]
            for (j in i + 1 until nums.size) {
                val num = nums[j]
                val remains = target - num
                val k = map[remains]
                k?.let {
                    if (k != i && k > j) {
                        result.add(listOf(-target, num, remains).sorted())
                    }
                }
            }
        }
        return result.toList()
    }
}