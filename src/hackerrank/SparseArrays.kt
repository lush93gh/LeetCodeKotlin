package hackerrank

class SparseArrays {
    fun matchingStrings(strings: Array<String>, queries: Array<String>): Array<Int> {
        val map = mutableMapOf<String, Int>()
        strings.forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        return queries.map { map[it] ?: 0 }.toTypedArray()
    }
}