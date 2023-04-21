package treesAndGraphs.binarysearchtree

class M96 {
    val visited = mutableSetOf<Set<Int>>()
    private val table = IntArray(19) { 0 }
    fun numTrees(n: Int): Int {
        table[0] = 1
        table[1] = 1
        for (i in 2..n) {
            var sum = 0
            for (j in 0 until i) {
                sum += table[j] * table[i - 1 - j]
            }
            table[i] = sum
        }
        return table[n]
    }

    fun dfs(index: Int, n: Int, track: Set<Int>): Int {
        if (n == 0) {
            return if (visited.contains(track)) 0
            else {
                visited.add(track)
                1
            }
        }
        val left = dfs(index * 2, n - 1, track.toMutableSet().apply { add(index * 2) })
        val right = dfs(index * 2 + 1, n - 1, track.toMutableSet().apply { add(index * 2 + 1) })
        val both = if (n >= 2) {
            dfs(
                index * 2, n - 2,
                track.toMutableSet().apply {
                    add(index * 2)
                    add(index * 2 + 1)
                }
            )
            +dfs(
                index * 2 + 1, n - 1,
                track.toMutableSet().apply {
                    add(index * 2)
                    add(index * 2 + 1)
                }
            )
        } else 0
        return left + right + both
    }
}