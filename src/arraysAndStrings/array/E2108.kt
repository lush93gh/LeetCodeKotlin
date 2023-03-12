package arraysAndStrings.array

class E2108 {
    fun firstPalindrome(words: Array<String>): String {
        words.forEach { word ->
            var hasFound = true
            for (index in 0 until word.length / 2) {
                if (word[index] != word[word.length - 1 - index]) {
                    hasFound = false
                    break
                }
            }
            if (hasFound) return word
        }
        return ""
    }
}