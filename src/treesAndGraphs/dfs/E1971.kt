package treesAndGraphs.dfs

import java.util.*


// 1971. Find if Path Exists in Graph
class E1971 {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val graph = buildGraph(edges)
        return hasPath(graph, mutableSetOf(source), source, destination)
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

    private fun hasPath(graph: Map<Int, List<Int>>, visited: MutableSet<Int>, current: Int, target: Int): Boolean {
        if (current == target) {
            return true
        } else {
            graph[current]?.let { neighbors ->
                neighbors.forEach { neighbor ->
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor)
                        val hasPath = hasPath(graph, visited, neighbor, target)
                        if (hasPath) return true
                    }
                }
            }
            return false
        }
    }

    private fun hasPathBFS(graph: Map<Int, List<Int>>, current: Int, target: Int): Boolean {
        val queue: Queue<Int> = LinkedList()
        val visited = mutableSetOf<Int>()
        queue.offer(current)
        visited.add(current)
        while (queue.isNotEmpty()) {
            for (i in queue.indices) {
                val node = queue.poll()
                if (node == target) return true
                graph[node]?.forEach { neighbor ->
                    if (!visited.contains(neighbor)) {
                        if (neighbor == target) return true
                        visited.add(neighbor)
                        queue.offer(neighbor)
                    }
                }
            }
        }
        return false
    }
}