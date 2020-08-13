class BinarySearch {
    fun search(nums: IntArray, target: Int): Int {
        var pivot: Int
        var left = 0
        var right = nums.size-1

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
}