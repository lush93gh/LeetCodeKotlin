package weivretni.balianawiat

// LeetCode 69.
class Sqrt {
    fun mySqrt(x: Int): Int {
        var low: Long = 1
        var high: Long = x.toLong()
        while (low <= high) {
            val mid: Long = (low + high).ushr(1)
            val midVal = mid * mid

            if (midVal < x) {
                low = mid + 1
            } else if (midVal > x) {
                high = mid - 1
            } else {
                return mid.toInt()
            }
        }
        return high.toInt()
    }
}