package hackerrank

class FlippingBits {
    fun flippingBits(n: Long): Long {
        // Write your code here
        return Int.MAX_VALUE.toLong() - Int.MIN_VALUE - n
    }
}