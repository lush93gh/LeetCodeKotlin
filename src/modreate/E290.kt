package modreate

class E290 {
    fun wordPattern(pattern: String, s: String): Boolean {
        val tokens = s.split(" ")
        if (tokens.size != pattern.length) return false
        val tokenMap = mutableMapOf<Char, String>()
        val patternMap = mutableMapOf<String, Char>()
        tokens.forEachIndexed { index, token ->
            val currentPattern = pattern[index]
            val targetToken = tokenMap[currentPattern]
            val targetPattern = patternMap[token]
            val tokenMatched = if (targetToken == null) {
                tokenMap[currentPattern] = token
                true
            } else {
                targetToken == token
            }
            val patternMatched = if (targetPattern == null) {
                patternMap[token] = currentPattern
                true
            } else {
                targetPattern == currentPattern
            }
            if (!tokenMatched || !patternMatched) return false
        }
        return true
    }
}