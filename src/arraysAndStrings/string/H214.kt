package arraysAndStrings.string

class H214 {
    var min = Int.MAX_VALUE
    private var minP1 = Int.MAX_VALUE
    private var minP2 = Int.MAX_VALUE
    fun shortestPalindrome(s: String): String {
        min = Int.MAX_VALUE
        minP1 = s.length
        minP2 = s.length
        for (i in s.length / 2 downTo 0) {
            println(i)
            if (find(s, i, i) || find(s, i - 1, i)) break
        }
        var result = s
        if (minP1 == minP2) {
            for (i in 2 * minP1 + 1 until s.length) {
                result = s[i] + result
            }
        } else {
            for (i in 2 * minP2 until s.length) {
                result = s[i] + result
            }
        }
        return result
    }

    private fun find(s: String, p1: Int, p2: Int): Boolean {
        var i = p1
        var j = p2
        while (i >= 0 && j < s.length && s[i] == s[j]) {
            i--
            j++
        }
        val prevI = i + 1
        val prevJ = j - 1
        if (prevI == 0 && prevJ < s.length) {
            if (p1 == p2) {
                val len = 2 * (s.length - p1 - 1) + 1
                if (len < min) {
                    min = len
                    minP1 = p1
                    minP2 = p2
                    return true
                }
            } else {
                val len = 2 * (s.length - p2 - 1) + 2
                if (len < min) {
                    min = len
                    minP1 = p1
                    minP2 = p2
                    return true
                }
            }
        }
        return false
    }
}