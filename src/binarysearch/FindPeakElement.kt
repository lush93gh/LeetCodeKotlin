package binarysearch

class FindPeakElement {
    fun findPeakElement(nums: IntArray): Int {
        if(nums.isEmpty()) return -1

        var pivot: Int
        var left = 0
        var right = nums.size
        var nextIndex = 0
        var prevIndex = 0

        while(left < right){
            pivot = left + (right - left) /2
            prevIndex = if((pivot - 1) >= 0) pivot - 1 else pivot
            nextIndex = if((pivot + 1) <= (nums.size - 1)) pivot + 1 else pivot
            val numsPivot = nums[pivot]

            if(numsPivot > nums[prevIndex]){
                when {
                    numsPivot >= nums[nextIndex] -> return pivot
                    else ->
                        left = pivot +1
                }
            }
            else right = pivot
        }

        return if(left != nums.size && nums[left] >= nums[prevIndex] && nums[left] >= nums[nextIndex]) left
                else -1
    }
}