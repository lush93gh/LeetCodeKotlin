package string

class M647 {
    fun countSubstrings(s: String): Int {
        var count = 0
        for (i in s.indices) {
            count += extend(s, i, i)
            count += extend(s, i, i + 1)
        }
        return count
    }

    private fun extend(s: String, l: Int, r: Int): Int {
        var count = 0
        var left = l
        var right = r
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            count++
            left--
            right++
        }
        return count
    }


    var count = 0
    fun countSubstrings1(s: String): Int {
        count = 0
        dfs(0, s, "")
        return count
    }

    private fun dfs(index: Int, s: String, curS: String, toTerminate: Boolean = false) {
        if (index >= s.length || (toTerminate && curS.isNotEmpty())) {
            if (isPalindromic(curS)) {
                count++
            }
        } else {
            dfs(index + 1, s, curS + s[index])
            dfs(index + 1, s, curS, true)
        }
    }

    private fun isPalindromic(s: String): Boolean {
        if (s.isEmpty()) return false
        for (i in 0..s.length / 2) {
            if (s[i] != s[s.length - 1 - i])
                return false
        }
        return true
    }
}