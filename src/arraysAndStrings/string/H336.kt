package arraysAndStrings.string

class H336 {
    fun palindromePairs(words: Array<String>): List<List<Int>> {
        val results = mutableListOf<List<Int>>()
        for (i in words.indices) {
            for (j in i + 1 until words.size) {
                val word1 = words[i]
                val word2 = words[j]
                if (find(word1, word2)) {
                    results.add(listOf(i, j))
                }
                if (find(word2, word1)) {
                    results.add(listOf(j, i))
                }
            }
        }
        return results
    }

    fun find(word1: String, word2: String): Boolean {
        val len = word1.length + word2.length
        var i = if (len % 2 == 0) len / 2 - 1 else len / 2
        var j = len / 2

        while (i >= 0 && j < len) {
            val char1 = if (i < word1.length) word1[i] else word2[i - word1.length]
            val char2 = if (j < word1.length) word1[j] else word2[j - word1.length]
            if (char1 == char2) {
                i--
                j++
            } else {
                return false
            }
        }
        return true
    }
}