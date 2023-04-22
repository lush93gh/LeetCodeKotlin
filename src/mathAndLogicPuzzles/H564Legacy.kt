package mathAndLogicPuzzles

import kotlin.math.ceil
import kotlin.math.min

// 564. Find the Closest Palindrome
class H564Legacy {
    fun nearestPalindromic(n: String): String {
        val nLong = n.toLong()
        var resultMinus = n
        while (resultMinus.toLong() >= nLong || !isPalindromic(resultMinus)) {
            val attempt = palindromicArithmetic(resultMinus, -1)
            if (attempt.toLong() >= nLong) continue
            else {
                resultMinus = attempt
            }
        }
        var resultPlus = n
        while (resultPlus.toLong() <= nLong || !isPalindromic(resultPlus)) {
            val attempt = palindromicArithmetic(resultPlus, 1)
            if (attempt.toLong() <= nLong) continue
            else {
                resultPlus = attempt
            }
        }
        val differenceMinus = nLong - resultMinus.toLong()
        val differencePlus = resultPlus.toLong() - nLong

        return if (differenceMinus <= differencePlus) resultMinus else resultPlus
    }

    private fun isPalindromic(n: String): Boolean {
        val a = n.toCharArray()
        for (i in 0..a.size / 2) {
            if (a[i] != a[a.size - 1 - i]) return false
        }
        return true
    }

    private fun palindromicArithmetic(n: String, num: Int): String {
        val nLong = n.toLong()
        if (num > 0) {
            if (findPalindromic(n).toLong() > nLong) return findPalindromic(n)
            else {
                return if (nLong + num < 10) (nLong + num).toString()
                else if ((nLong + num) == 10L) "11"
                else {
                    val upper = n.substring(0, ceil(n.length.toFloat() / 2).toInt()).toLong()
                    val lower = n.substring(ceil(n.length.toFloat() / 2).toInt(), n.length)
                    val a = (upper + num).toString()
                    var result = a
                    for (i in lower.length - 1 downTo 0) {
                        val index = min(i, a.length -1)
                        result += a.toCharArray()[index]
                    }
                    result
                }
            }
        } else {
            if (findPalindromic(n).toLong() < nLong) return findPalindromic(n)
            else {
                return if (nLong + num < 10) (nLong + num).toString()
                else if ((nLong + num) == 10L) "9"
                else {
                    val upper = n.substring(0, ceil(n.length.toFloat() / 2).toInt()).toLong()
                    val lower = n.substring(ceil(n.length.toFloat() / 2).toInt(), n.length)
                    val a = (upper + num).toString()
                    var result = a
                    for (i in lower.length - 1 downTo 0) {
                        val index = min(i, a.length -1)
                        result += a.toCharArray()[index]
                    }
                    result
                }
            }
        }
    }

    private fun findPalindromic(n: String): String {
        val a = n.toCharArray()
        for (i in 0..a.size / 2) {
            a[a.size - 1 - i] = a[i]
        }
        return String(a)
    }
}