package binarysearch

// 704. Binary Search
class E704 {
    fun search1(nums: IntArray, target: Int): Int {
        var pivot: Int
        var left = 0
        var right = nums.size - 1

        while(left <= right){
            pivot = left + (right - left) /2
            when {
                nums[pivot] == target -> return pivot
                target < nums[pivot] ->
                    right = pivot - 1
                else ->
                    left = pivot +1
            }
        }
        return -1
    }
    fun search(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1

        while (low <= high) {
            val mid = (low + high).ushr(1)
            val midVal = nums[mid]
            if (target < midVal)
                high = mid - 1
            else if (target > midVal)
                low = mid + 1
            else return mid
        }
        return -1
    }
}