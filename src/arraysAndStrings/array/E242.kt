package arraysAndStrings.array

class E242 {
    fun isAnagram(s: String, t: String): Boolean {
        val table = IntArray(26)
        s.forEach {
            table[it - 'a']++
        }
        t.forEach {
            table[it - 'a']--
        }
        return !table.any { it != 0 }
    }
}