package arraysAndStrings.string

class E1844 {
    fun replaceDigits(s: String): String {
        var ans = ""
        s.forEachIndexed { index, c ->
            ans += if (index % 2 == 0) c
            else shift(s[index - 1], Character.getNumericValue(c))
        }
        return ans
    }

    private fun shift(c: Char, x: Int): Char = c.plus(x).coerceAtMost('z')
}