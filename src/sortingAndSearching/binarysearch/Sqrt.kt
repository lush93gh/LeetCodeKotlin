package sortingAndSearching.binarysearch

class Sqrt {
    fun mySqrt(x: Int): Int {
        var pivot = 1L
        var left = 1L
        var right = x.toLong()
        val target = x.toLong()

        while(left <= right){
            pivot = left + (right - left) /2
            val pivotSquare = pivot * pivot
            when {
                target == pivotSquare -> return pivot.toInt()
                target < pivotSquare ->
                    right = pivot - 1
                else ->
                    left = pivot +1
            }
        }
        return right.toInt()
    }
}