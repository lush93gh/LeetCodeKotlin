package math

import kotlin.math.pow

class M2217 {
    fun kthPalindrome(queries: IntArray, intLength: Int): LongArray {
        val result = LongArray(queries.size)
        queries.forEachIndexed { index, query ->
            if (!isValid(query, intLength)) {
                result[index] = -1
            } else {
                val isEven = intLength % 2 == 0
                val midDigit = intLength / 2
                var digitPointer = midDigit
                val digit = if (intLength > 2) (query - 1) % 10 else query
                var ans = if (isEven) "$digit$digit" else "$digit"
                digitPointer += 1
                while (digitPointer < intLength) {
                    ans = if (digitPointer == intLength - 1) {
                        val digit = scaleCount(query, intLength)
                        "$digit" + ans + "$digit"
                    } else {
                        val digit = (query - 1) / pow(digitPointer - midDigit) % 10
                        "$digit" + ans + "$digit"
                    }
                    digitPointer += 1
                }
                result[index] = ans.toLong()
            }
        }
        return result
    }

    private fun pow(n: Int): Long {
        return 10F.pow(n).toLong()
    }

     fun scaleCount(query: Int, intLength: Int): Long {
        return (query - 1) / pow((intLength - 1) / 2) + 1
    }

    private fun isValid(query: Int, intLength: Int): Boolean {
        return query <= 9 * 10F.pow((intLength - 1) / 2)
    }
}