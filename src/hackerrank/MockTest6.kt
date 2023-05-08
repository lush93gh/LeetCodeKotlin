package hackerrank

import java.util.*

class MockTest6 {
    fun bfs(n: Int, m: Int, edges: Array<Array<Int>>, s: Int): Array<Int> {
        // Write your code here
        val shortestPaths = Array(n) { 0 }
        val graph = buildGraph(edges)
        println(graph)
        val queue: Queue<Int> = LinkedList()
        val visited = mutableSetOf<Int>()
        queue.offer(s)
        visited.add(s)
        var layer = 0
        while (queue.isNotEmpty()) {
            layer++
            for (i in queue.indices) {
                val node = queue.poll()
                graph[node]?.forEach { neighbor ->
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor)
                        visited.add(neighbor)
                        shortestPaths[neighbor - 1] = 6 * layer
                    }
                }
            }
        }
        val result = Array(n - 1) { 0 }
        var i = 0
        shortestPaths.forEachIndexed { index, num ->
            if (index != s-1) {
                result[i] = if (num != 0) num else -1
                i++
            }
        }

        return result
    }

    private fun buildGraph(edges: Array<Array<Int>>): Map<Int, Set<Int>> {
        val graph = mutableMapOf<Int, Set<Int>>()
        edges.forEach { edge ->
            graph[edge[0]] = (graph[edge[0]] ?: emptySet()) + edge[1]
            graph[edge[1]] = (graph[edge[1]] ?: emptySet()) + edge[0]
        }
        return graph
    }
}