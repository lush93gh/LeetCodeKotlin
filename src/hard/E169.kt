package hard

class E169 {
    fun majorityElement(nums: IntArray): Int {
        var result = nums[0]
        var max = -Int.MAX_VALUE
        nums.groupBy { it }.forEach { (t, u) ->
            if (u.size > max) {
                max = u.size
                result = t
            }
        }
        return result
    }
}