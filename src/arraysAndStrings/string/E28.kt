package arraysAndStrings.string

class E28 {
    fun strStr(haystack: String, needle: String): Int {
        val f = IntArray(needle.length) { 0 }
        for (i in 1 until needle.length) {
            var prev = f[i - 1]
            while (prev > 0 && needle[i] != needle[prev]) {
                prev = f[prev - 1]
            }
            if (needle[i] == needle[prev]) {
                prev++
            }
            f[i] = prev
        }

        var i = 0
        var j = 0
        while (i <= haystack.length) {
            if (haystack[i] == needle[j]) {
                i++
                j++
                if (j == needle.length) return i - needle.length
            } else if (j > 0) {
                j = f[j - 1]
            } else {
                i++
            }
        }
        return -1
    }
}