class Sqrt {
    fun mySqrt(x: Int): Int {
        var pivot = 1L
        var left = 1L
        var right = x.toLong()
        val target = x.toLong()

        while(left <= right){
            pivot = left + (right - left) /2
            when {
                target == pivot * pivot -> return pivot.toInt()
                target < pivot * pivot ->
                    right = pivot - 1
                else ->
                    left = pivot +1
            }
        }
        return right.toInt()
    }
}