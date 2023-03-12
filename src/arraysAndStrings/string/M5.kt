package arraysAndStrings.string

// 5. Longest Palindromic Substring
class M5 {
    fun longestPalindrome(s: String): String {
        val arr = s.toCharArray()
        var max = Int.MIN_VALUE
        var start = 0
        var end = 0
        for (i in arr.indices) {
            var p = 0
            while (i - p >= 0 && i + p < arr.size) {
                val checkOne = isPalindromic(s, i - p, i + p)
                if (checkOne) {
                    if (2 * p + 1 > max) {
                        max = 2 * p + 1
                        start = i - p
                        end = i + p
                    }
                    p++
                } else {
                    break
                }
            }

            p = 0
            while (i - p >= 0 && i + 1 + p < arr.size) {
                val checkRight = isPalindromic(s, i - p, i + 1 + p)
                if (checkRight) {
                    if (2 * p + 2 > max) {
                        max = 2 * p + 2
                        start = i - p
                        end = i + 1 + p
                    }
                    p++
                } else {
                    break
                }
            }
        }
        return String(arr, start, end - start + 1)
    }

    private fun isPalindromic(s: String, start: Int, end: Int): Boolean {
        val a = s.toCharArray()
        for (i in start..(start + end) / 2) {
            if (a[i] != a[end - (i - start)]) return false
        }
        return true
    }
}