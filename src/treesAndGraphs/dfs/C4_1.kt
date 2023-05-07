package treesAndGraphs.dfs

class C4_1 {
    val visited = mutableSetOf<Int>()
    fun hasPath(graph: List<List<Int>>, current: Int, target: Int): Boolean {
        if (current == target) {
            return true
        } else {
            visited.add(current)
            val neighbors = graph[current]
            for (index in neighbors.indices) {
                val neighbor = neighbors[index]
                if (neighbor == 1 && !visited.contains(index)) {
                    val hasPath =  hasPath(graph, index, target)
                    if (hasPath) return true
                }
            }
            return false
        }
    }
}