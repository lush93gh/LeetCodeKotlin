class SearchForARange {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var pivot: Int
        var left = 0
        var right = nums.size - 1
        var hasFound = false
        val result = intArrayOf(-1, -1)

        while(left < right){
            pivot = left + (right - left) /2
            when {
                nums[pivot] == target ->{
                    hasFound = true
                    right = pivot
                }
                target < nums[pivot] ->
                    right = pivot
                else ->
                    left = pivot +1
            }
        }

        if(!hasFound) return result
        else{
            result[0] = left
            right = nums.size - 1

            while(left <= right){
                pivot = left + (right - left) /2
                when {
                    nums[pivot] == target -> left = pivot + 1
                    target < nums[pivot] ->
                        right = pivot - 1
                    else ->
                        left = pivot + 1
                }
            }


        }
        return result
    }
}