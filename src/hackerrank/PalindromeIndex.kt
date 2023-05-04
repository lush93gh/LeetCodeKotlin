package hackerrank

class PalindromeIndex {
    fun palindromeIndex(s: String): Int {
        // Write your code here
        var result = -1
        var i = 0
        var j = s.length - 1
        while (i < j) {
            val isValid = isValid(s, i, j)
            if (s[i] == s[j]) {
                i++
                j--
            } else {
                if (!isValid) return -1
                else {
                  //  isValid = false
                    if (s[i + 1] == s[j]) {
                        result = i
                        i += 2
                        j--
                    } else if (s[i] == s[j - 1]) {
                        result = j
                        i++
                        j -= 2
                    }
                }
            }
        }
        return result
    }

    fun isValid(s: String, i: Int, j: Int): Boolean {
        return (i < j && s[i] == s[j]) || isValid(s, i + 1, j) || isValid(s, i, j - 1)
    }
}