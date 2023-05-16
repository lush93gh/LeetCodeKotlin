package hackerrank

import kotlin.math.min

class DrawingBook {
    fun pageCount(n: Int, p: Int): Int {
        // Write your code here
        val candidate = if (n % 2 == 0) (n - (p - 1)) / 2 else (n - p) / 2
        return min(p / 2, candidate)
    }
}