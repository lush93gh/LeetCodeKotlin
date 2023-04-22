package mathAndLogicPuzzles

import kotlin.math.abs

// 564. Find the Closest Palindrome
class H564 {
    fun nearestPalindromic(n: String): String {
        val number = n.toLong()
        val reflect = reflect(n)
        val plus = plus(n)
        val minus = minus(n)
        var dist = Long.MAX_VALUE
        var ans = Long.MAX_VALUE.toString()
        listOf(reflect, plus, minus).filter { it != n }.forEach {
            val intNum = it.toLong()
            val abs = abs(number - intNum)
            if (abs < dist || (abs == dist) && intNum < ans.toLong()) {
                dist = abs
                ans = it
            }
        }
        return ans
    }

    private fun reflect(n: String): String {
        val len = n.length
        return if (len % 2 == 1) {
            val upper = n.substring(0, len / 2)
            upper + n[len / 2] + upper.reversed()
        } else {
            val upper = n.substring(0, len / 2)
            upper + upper.reversed()
        }
    }

    private fun plus(n: String): String {
        val len = n.length
        return if (len % 2 == 1) {
            val upper = n.substring(0, len / 2)
            val plusUpper = ((upper + n[len / 2]).toLong() + 1).toString() + upper
            reflect(plusUpper)
        } else {
            val upper = n.substring(0, len / 2)
            val plusUpper = (upper.toLong() + 1).toString() + upper
            reflect(plusUpper)
        }
    }

    private fun minus(n: String): String {
        val len = n.length
        return if (len == 2 && n[0] == '1') {
            if (n == "11") "9"
            else reflect((n.toLong() - 1).toString())
        } else if (len % 2 == 1) {
            val upper = n.substring(0, len / 2)
            val minusUpper = ((upper + n[len / 2]).toLong() - 1).toString()
            val result = minusUpper.padEnd(minusUpper.length + upper.length, minusUpper.last())
            reflect(result)
        } else {
            val upper = n.substring(0, len / 2)
            val minusUpper = (upper.toLong() - 1).toString()
            val result = minusUpper.padEnd(minusUpper.length + upper.length, minusUpper.last())
            reflect(result)
        }
    }
}