package mathAndLogicPuzzles

import kotlin.math.abs
import kotlin.math.sqrt

// 1362. Closest Divisors
class M1362 {
    fun closestDivisors(num: Int): IntArray {
        val result = intArrayOf(0, Int.MAX_VALUE)
        val sqrt = sqrt(num.toDouble() + 2).toInt() + 1
        listOf(num + 1, num + 2).forEach { number ->
            for (factor in sqrt downTo 2) {
                if (number % factor == 0) {
                    val remains = number / factor
                    if (abs(remains - factor) < abs(result[0] - result[1])) {
                        result[0] = factor
                        result[1] = remains
                    }
                    break
                }
            }
        }
        return result
    }
}