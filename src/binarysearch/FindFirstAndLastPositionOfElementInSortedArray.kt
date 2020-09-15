package binarysearch

class FindFirstAndLastPositionOfElementInSortedArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if(nums.isEmpty()) return intArrayOf(-1, -1)

        val result = intArrayOf(-1, -1)
        var hasFound = false
        var pivot: Int
        var left = 0
        var right = nums.size - 1

        while(left <= right){
            pivot = left + (right - left) /2
            when {
                nums[pivot] == target -> {
                    hasFound = true
                    right = pivot
                }
                target < nums[pivot] ->
                    right = pivot - 1
                else ->
                    left = pivot + 1
            }
            if((left == right) && hasFound){
                result[0] = left
                break
            }
        }

        if(!hasFound) return result

        hasFound = false
        right = nums.size

        while(left <= right){
            pivot = left + (right - left) /2
            when {
                nums[pivot] == target ->{
                    hasFound = true
                    left = pivot + 1
                }
                target < nums[pivot] ->
                    right = pivot
                else ->
                    left = pivot + 1
            }
            if(hasFound && (left == right)){
                result[1] = left -1
                break
            }
        }

        return result
    }
}