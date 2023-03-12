package arraysAndStrings.string

class M2002 {

    private var max = Int.MIN_VALUE

    private fun isPalindromic(s: String): Boolean {
        if (s.isEmpty()) return false
        for (i in 0..s.length / 2) {
            if (s[i] != s[s.length - 1 - i])
                return false
        }
        return true
    }

    fun maxProduct(s: String): Int {
        max = Int.MIN_VALUE
        search(s, 0, "", "")
        return max
    }

    private fun search(s: String, index: Int, s1: String, s2: String) {
        if (index < s.length) {
            search(s, index + 1, s1 + s[index], s2)
            search(s, index + 1, s1, s2 + s[index])
            search(s, index + 1, s1, s2)
        } else {
            if (isPalindromic(s1) && isPalindromic(s2)) {
                val mul = s1.length * s2.length
                if (mul > max) {
                    max = mul
                }
            }
        }
    }

    private var candidates = mutableListOf<List<Int>>()
    fun maxProduct1(s: String): Int {
        candidates = mutableListOf()
        search1(s, listOf(), 0)
        return calculate()
    }

    private fun calculate(): Int {
        var max = Int.MIN_VALUE
        for (i in candidates.indices) {
            val p1 = candidates[i]
            for (j in i + 1 until candidates.size) {
                val p2 = candidates[j]
                if (!p1.any { it in p2 }) {
                    val mul = p1.size * p2.size
                    if (mul > max) {
                        max = mul
                    }
                }
            }
        }
        return max
    }

    private fun search1(s: String, list: List<Int>, curIndex: Int) {
        if (curIndex < s.length) {
            val newList = list.toMutableList()
            search1(
                s,
                newList.apply { add(curIndex) },
                curIndex + 1
            )
            search1(s, list, curIndex + 1)
        } else {
            var result = ""
            list.forEach {
                result += s[it]
            }
            if (isPalindromic(result)) {
                candidates.add(list)
            }
        }
    }
}