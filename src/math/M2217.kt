package math

import kotlin.math.pow

class M2217 {
    fun kthPalindrome(queries: IntArray, intLength: Int): LongArray {
        val result = LongArray(queries.size)
        queries.forEachIndexed { index, query ->
            if (!isValid(query, intLength)) {
                result[index] = -1
            } else {
                var ans = 0
                var length = intLength

            }
        }
        return longArrayOf(1L)
    }

    fun addNumbers(query: Int, intLength: Int): Long {
        var ans = 0L
        for (len in intLength downTo 1 step 2) {
            val digit = computeDigit(query, intLength)
            ans += (digit + digit * pow(len - 1)) * pow((intLength - len) / 2)
        }
        return ans
    }

    fun pow(n: Int): Long {
        return 10F.pow(n - 1).toLong()
    }

    fun isValid(query: Int, intLength: Int): Boolean {
        return query <= 9 * 10F.pow((intLength - 1) / 2)
    }

    fun computeDigit(n: Int, intLength: Int): Int {
        val result = (n - 1) / 10 + 1
        return if (intLength <= 2 && result == 0) 1
        else result
    }
}