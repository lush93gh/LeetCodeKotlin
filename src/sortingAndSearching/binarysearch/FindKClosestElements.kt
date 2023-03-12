package sortingAndSearching.binarysearch

class FindKClosestElements {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        var numCandidate = k
        var pivot = 0
        var left = 0
        var right = arr.size - 1
        val result = mutableListOf<Int>()

        loop@ while(left <= right){
            pivot = left + (right - left) / 2
            when {
                arr[pivot] == x -> break@loop
                arr[pivot] > x -> right = pivot - 1
                else -> left = pivot + 1
            }
        }

        left = pivot
        right = pivot
        val range = if(arr[pivot] == x) k - 1 else k
        for(i in 0 until range){
            var leftDiff = Integer.MAX_VALUE
            var rightDiff = Integer.MAX_VALUE

            if(left - 1 >= 0){
                left--
                leftDiff = kotlin.math.abs(x - arr[left])
            }
            if(right + 1 <= arr.size - 1){
                right++
                rightDiff = kotlin.math.abs(arr[right] - x)
            }

            if(leftDiff <= rightDiff){
                right--
            }
            else if(leftDiff > rightDiff){
                left++
            }
        }

        for(i in left..right)
            result.add(arr[i])

        return result
    }
}