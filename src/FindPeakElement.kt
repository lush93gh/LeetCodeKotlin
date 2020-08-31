import kotlin.math.min

class FindPeakElement {
    fun findPeakElement(nums: IntArray): Int {
        if(nums.isEmpty()) return -1

        var pivot: Int
        var left = 0
        var right = nums.size
        var nextIndex: Int

        while(left < right){
            pivot = left + (right - left) /2
            nextIndex = if((pivot + 1) <= (nums.size - 1)) pivot + 1 else pivot
            when {
                nums[pivot] >= nums[nextIndex] -> return pivot
                nums[pivot] < nums[nextIndex] ->
                    right = pivot - 1
                else ->
                    left = pivot +1
            }
        }

        if(left != nums.size && nums[left] == target) return left

        return -1
    }
}