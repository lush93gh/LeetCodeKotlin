package mathAndLogicPuzzles

// isStrictlyPalindromic
class M2396 {
    fun isStrictlyPalindromic(n: Int): Boolean {
        for (i in 2..n - 2) {
            if (!isPalindromic(base(n, i))) return false
        }
        return true
    }

    private fun base(n: Int, base: Int): String {
        var result = ""
        var num = n
        while (num > 0) {
            result = "${num % base}$result"
            num /= base
        }
        return result
    }

    private fun isPalindromic(s: String): Boolean {
        val charArray = s.toCharArray()
        for (i in 0..charArray.size / 2 + 1) {
            if (charArray[i] != charArray[charArray.size - 1 - i])
                return false
        }
        return true
    }
}