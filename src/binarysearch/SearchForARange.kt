package binarysearch

class SearchForARange {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if(nums.isEmpty()) return intArrayOf(-1, -1)

        var pivot: Int
        var left = 0
        var right = nums.size - 1
        val result = intArrayOf(-1, -1)

        while(left < right){
            pivot = left + (right - left) /2
            when {
                nums[pivot] == target -> right = pivot
                nums[pivot] > target -> right = pivot
                else -> left = pivot +1
            }
        }

        if(nums[right] == target){
            result[0] = left
            right = nums.size

            while(left < right){
                pivot = left + (right - left) /2
                when {
                    nums[pivot] == target -> left = pivot + 1
                    nums[pivot] > target -> right = pivot
                    else -> left = pivot + 1
                }
            }
            result[1] = left - 1
        }

        return result
    }
}