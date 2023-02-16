package string

class M567 {
    fun checkInclusion1(s1: String, s2: String): Boolean {
        val s2CharArray = s2.toCharArray()
        for (i in 0..s2.length - s1.length) {
            val table = mutableMapOf<Char, Int>()
            for (j in i until i + s1.length) {
                val char = s2CharArray[j]
                table.putIfAbsent(char, 0)
                table[char] = table[char]!! + 1
            }
            val s1CharArray = s1.toCharArray()
            for (j in s1.indices) {
                val char = s1CharArray[j]
                if (table.containsKey(char)) {
                    table[char] = table[char]!! - 1
                }
            }
            if (table.any { it.value != 0 }) continue
            else return true
        }
        return false
    }
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s2.length < s1.length) return false
        val s2CharArray = s2.toCharArray()
        val table1 = mutableMapOf<Char, Int>()
        val table2 = mutableMapOf<Char, Int>()
        for (i in s1.indices) {
            val char1 = s1[i]
            table1.putIfAbsent(char1, 0)
            table1[char1] = table1[char1]!! + 1

            val char2 = s2[i]
            table2.putIfAbsent(char2, 0)
            table1[char2] = table1[char2]!! + 1
        }
        for (i in 0..s2.length - s1.length) {
            if (table1.any { table2[it.key] != it.value }) {
                val remove = s2[i]
                val add = s2[i + s1.length]
                table2[remove] = table2[remove]!! - 1
            }
            else return true
            val table = mutableMapOf<Char, Int>()
            for (j in i until i + s1.length) {
                val char = s2CharArray[j]
                table.putIfAbsent(char, 0)
                table[char] = table[char]!! + 1
            }
            val s1CharArray = s1.toCharArray()
            for (j in s1.indices) {
                val char = s1CharArray[j]
                if (table.containsKey(char)) {
                    table[char] = table[char]!! - 1
                }
            }
            if (table.any { it.value != 0 }) continue
            else return true
        }
        return false
    }
}