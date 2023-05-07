package treesAndGraphs.dfs


class E1971 {
    private val visited = mutableSetOf<Int>()
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val graph = buildGraph(edges)
        println(graph)
        return hasPath(graph, source, destination)
    }

    private fun buildGraph(edges: Array<IntArray>): Map<Int, List<Int>> {
        val graph = mutableMapOf<Int, List<Int>>()
        edges.forEach { edge ->
            val a = edge[0]
            val b = edge[1]
            graph[a] = (graph[a] ?: emptyList()) + b
            graph[b] = (graph[b] ?: emptyList()) + a
        }
        return graph
    }

    private fun hasPath(graph: Map<Int, List<Int>>, current: Int, target: Int): Boolean {
        if (current == target) {
            return true
        } else {
            visited.add(current)
            graph[current]?.let { neighbors ->
                for (index in neighbors.indices) {
                    val neighbor = neighbors[index]
                    if (!visited.contains(neighbor)) {
                        val hasPath = hasPath(graph, neighbor, target)
                        if (hasPath) return true
                    }
                }
            }
            return false
        }
    }
}