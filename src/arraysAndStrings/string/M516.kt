package arraysAndStrings.string

import kotlin.math.max

// 516. Longest Palindromic Subsequence
class M516 {
    fun longestPalindromeSubseq(s: String): Int {
        val s2 = s.reversed()
        val array = Array(s.length + 1) {
            IntArray(s.length + 1) { 0 }
        }
        for (i in 1..s.length) {
            for (j in 1..s.length) {
                if (s[i - 1] == s2[j - 1]) {
                    array[i][j] = array[i - 1][j - 1] + 1
                } else {
                    array[i][j] = max(array[i - 1][j], array[i][j - 1])
                }
            }
        }
        return array[s.length][s.length]
    }
}