package arraysAndStrings.string

import kotlin.math.min

class M2131 {
    fun longestPalindrome(words: Array<String>): Int {
        val map = mutableMapOf<String, Int>()
        words.forEach {
            map[it] = (map[it] ?: 0) + 1
        }

        var ans = 0
        map.forEach { (word, count) ->
            if (word[0] != word[1]) {
                val pairedCount = map["${word[1]}${word[0]}"] ?: 0
                val realCount = min(count, pairedCount)
                ans += 2 * realCount
            }
        }

        map.forEach { (word, count) ->
            if (word[0] == word[1]) {
                ans += (count / 2 * 2) * 2
                if ((ans / 2) % 2 == 0 && count % 2 == 1) {
                    ans += 2
                }
            }
        }

        return ans
    }
}