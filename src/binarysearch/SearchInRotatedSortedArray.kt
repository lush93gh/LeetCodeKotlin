package binarysearch

class SearchInRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        var pivot: Int
        var left = 0
        var right = nums.size - 1

        while(left <= right){
            pivot = left + (right - left) /2
            val numsPivot = nums[pivot]
            if(target == numsPivot)  return pivot

            if(numsPivot >= nums[0]){
                when {
                    (target < numsPivot && target >= nums[0]) ->
                        right = pivot - 1
                    (target > numsPivot || ( numsPivot > target && nums[0] > target)) ->
                        left = pivot +1
                }
            }
            else if(numsPivot <= nums[nums.size-1]){
                when {
                    (target < numsPivot || (target > numsPivot && target > nums[nums.size-1])) ->
                        right = pivot - 1
                    (target > numsPivot && target <= nums[nums.size-1]) ->
                        left = pivot +1
                }
            }
        }

        return -1
    }
}