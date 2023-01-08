package weivretni.ta


class TwoSumLessThanK {

    // time complexity : (nlogn) for sorting the array
    // Space complexity: O(1)
    fun twoSumLessThanK(nums: IntArray, k: Int): Array<IntArray> {

        val result = mutableListOf<IntArray>()

        var i = 0
        var j = nums.size - 1
        var max = Int.MIN_VALUE

        nums.sort()

        while (i < j) {
            val sum = nums[i] + nums[j]
            if (sum >= k) {
                j--
            } else {
                if (sum > max) {
                    max = sum
                    result.clear()
                    result.add(intArrayOf(nums[i], nums[j]))
                } else if (sum == max) {
                    result.add(intArrayOf(nums[i], nums[j]))
                }
                i++
            }
        }
        return result.toTypedArray()
    }
}