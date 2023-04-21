package sortingAndSearching.binarysearch

class BS {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        var min = 0
        var max = 0
        nums.forEach {
            if (it < min) min = it
            if (it > max) max = it
        }
        val counts = IntArray(max - min + 1) { 0 }
        nums.forEach {
            counts[it - min]++
        }
        var remains = k
        var ans = nums[0]
        for (i in counts.size - 1 downTo 0) {
            val count = counts[i]
            if (remains - count > 0) {
                remains -= count
            } else {
                ans = i + min
                break
            }
        }
        return ans
    }
}