package arraysAndStrings.array

// 215. Kth Largest Element in an Array
class M215 {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val map = mutableMapOf<Int, Int>()
        nums.forEach {
            map.putIfAbsent(it, 0)
            map[it] = map[it]!! + 1
        }
        var count = k
        for (i in map.keys.max()!! downTo map.keys.min()!!) {
            if (map.containsKey(i)) {
                val remains = map[i]!!
                if (remains != 0 && remains >= count) {
                    return i
                } else {
                    count -= remains
                }
            }
        }
        return nums[0]
    }
}