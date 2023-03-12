package sortingAndSearching.binarysearch

class FindMinimumInRotatedSortedArray {
    fun findMin(nums: IntArray): Int {
        if(nums[0] < nums[nums.size - 1]) return nums[0]

        var pivot: Int
        var nextIndex = 0
        var prevIndex = 0
        var left = 0
        var right = nums.size - 1

        while(left <= right){
            pivot = left + (right - left) /2
            prevIndex = if((pivot - 1) >= 0) pivot - 1 else pivot
            nextIndex = if((pivot + 1) <= (nums.size - 1)) pivot + 1 else pivot

            val numsPivot = nums[pivot]
            if(numsPivot<= nums[nextIndex] && numsPivot<=nums[prevIndex])  return nums[pivot]

            if(numsPivot >= nums[0]) left = pivot +1
            else if(numsPivot <= nums[nums.size-1]) right = pivot - 1
        }

        return -1
    }
}