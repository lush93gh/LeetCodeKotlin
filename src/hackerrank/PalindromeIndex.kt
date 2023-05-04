package hackerrank

class PalindromeIndex {
    fun palindromeIndex(s: String): Int {
        var i = 0
        var j = s.length - 1
        var firstInvalidI = 0
        var firstInvalidJ = 0
        var failedCount = 0
        while (i < j) {
            if (s[i] == s[j]) {
                i++
                j--
            } else {
                firstInvalidI = i
                firstInvalidJ = j
                println("$firstInvalidI $firstInvalidJ")
                failedCount++
                break
            }
        }
        if(failedCount == 0) return -1

        i = firstInvalidI + 1
        j = firstInvalidJ
        while (i < j) {
            if (s[i] == s[j]) {
                i++
                j--
            } else {
                failedCount++
                println("$failedCount $i $j")
                break
            }
        }
        if (failedCount == 1) return firstInvalidI


        i = firstInvalidI
        j = firstInvalidJ - 1
        while (i < j) {
            if (s[i] == s[j]) {
                i++
                j--
            } else {
                return -1
            }
        }
        return firstInvalidJ
    }
}