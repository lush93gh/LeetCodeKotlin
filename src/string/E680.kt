package string

class E680 {
    fun validPalindrome(s: String): Boolean {
        var toRemove = false
        var lastIndex = 0
        for (index in 0 until s.length / 2) {
            if (s[index] != s[s.length - 1 - index]) {
                toRemove = true
                lastIndex = index
                break
            }
        }

        var left = true
        var right = true
        if (toRemove) {
            for (index in lastIndex until s.length / 2) {
                if (s[index + 1] != s[s.length - 1 - index]) {
                    left = false
                    break
                }
            }

            for (index in lastIndex until s.length / 2) {
                if (s[index] != s[s.length - 2 - index]) {
                    right = false
                    break
                }
            }
        }

        return left || right
    }

    fun validPalindrome2(s: String): Boolean {
        var toRemove = false
        var result1 = true
        var result2 = true

        for (i in 0 until s.length / 2) {
            if (!toRemove && s[i] != s[s.length - 1 - i])
                toRemove = true
            if (result1 && toRemove && s[i + 1] != s[s.length - 1 - i])
                result1 = false
            if (result2 && toRemove && s[i] != s[s.length - 1 - i - 1])
                result2 = false
        }

        return result1 || result2
    }
}