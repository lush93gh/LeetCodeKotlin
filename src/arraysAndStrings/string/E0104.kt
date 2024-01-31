package arraysAndStrings.string

class E0104 {
    fun canPermutePalindrome(s: String): Boolean {
        return s.groupBy { it }.filter { it.value.size % 2 == 1 }.size <= 1
    }
}