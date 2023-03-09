package string

import kotlin.math.max

class M1143 {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val table = Array(text1.length + 1) {
            IntArray(text2.length + 1) {
                0
            }
        }
        for (i in text1.indices) {
            for (j in text2.indices) {
                val row = i + 1
                val col = j + 1
                if (text1[i] == text2[j]) {
                    table[row][col] = table[row - 1][col - 1] + 1
                } else {
                    table[row][col] = max(table[row - 1][col], table[row][col - 1])
                }
            }
        }
        return table[text1.length][text2.length]
    }
}