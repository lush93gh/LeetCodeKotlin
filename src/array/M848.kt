package array

class M848 {
    fun shiftingLetters(s: String, shifts: IntArray): String {
        var sum = 0
        val ans = s.toCharArray()
        val maxIndex = s.length - 1
        for (index in s.indices) {
            sum = (sum + shifts[maxIndex - index] % 26)
            ans[maxIndex - index] = ((ans[maxIndex - index].toInt() + sum - 97) % 26 + 97).toChar()
        }
        return String(ans)
    }
}