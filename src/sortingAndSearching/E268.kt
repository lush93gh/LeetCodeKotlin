package sortingAndSearching

class E268 {
    fun missingNumber(nums: IntArray): Int {
        val sum = (nums.size + 1) * nums.size / 2
        return sum - nums.sum()
    }
}