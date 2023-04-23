package arraysAndStrings.string

// 438. Find All Anagrams in a String
class M438 {
    fun findAnagrams(s: String, p: String): List<Int> {
        val results = mutableListOf<Int>()
        val pLen = p.length
        if (s.length < pLen) return emptyList()
        val countP = mutableMapOf<Char, Int>()
        val countS = mutableMapOf<Char, Int>()
        for (i in p.indices) {
            val charP = p[i]
            val charS = s[i]
            countP[charP] = (countP[charP] ?: 0) + 1
            countS[charS] = (countS[charS] ?: 0) + 1
        }

        if (countS == countP) {
            results.add(0)
        }

        for (i in 1..s.length - pLen) {
            val char = s[i + pLen - 1]
            val prevChar = s[i - 1]
            countS[prevChar] = countS[prevChar]!! - 1
            if (countS[prevChar] == 0) {
                countS.remove(prevChar)
            }
            countS[char] = (countS[char] ?: 0) + 1

            if (countS == countP) {
                results.add(i)
            }
        }
        return results
    }
}