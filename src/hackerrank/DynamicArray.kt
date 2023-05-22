package hackerrank

class DynamicArray {
    fun dynamicArray(n: Int, queries: Array<Array<Int>>): Array<Int> {
        // Write your code here
        val answers = mutableListOf<Int>()
        val arr = Array(n) { mutableListOf<Int>() }
        var lastAnswer = 0
        queries.forEach {
            val type = it[0]
            val x = it[1]
            val y = it[2]
            val idx = (x xor lastAnswer) % n
            if (type == 1) {
                arr[idx].add(y)
            } else {
                lastAnswer = arr[idx][y % arr[idx].size]
                answers.add(lastAnswer)
            }
        }
        return answers.toTypedArray()
    }
}