package arraysAndStrings.string

class M2452 {
    fun twoEditWords(queries: Array<String>, dictionary: Array<String>): List<String> {
        val result = mutableListOf<String>()
        for (i in queries.indices) {
            val query = queries[i]
            for (j in dictionary.indices) {
                val word = dictionary[j]
                var count = 0
                for (k in word.indices) {
                    if (count > 2) break
                    if (query[k] != word[k]) {
                        count++
                    }
                }
                if (count <= 2) {
                    result.add(query)
                    break
                }
            }
        }
        return result
    }
}