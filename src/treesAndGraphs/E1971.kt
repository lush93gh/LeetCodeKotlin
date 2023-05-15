package treesAndGraphs

import java.util.*


// 1971. Find if Path Exists in Graph
class E1971 {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        //val graph = buildGraph(edges)
        //return hasPathStack(graph, source, destination)
        val disjointSet = buildDisJointSet(n, edges)
        return disjointSet.comparison(source, destination)
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

    private fun buildDisJointSet(n: Int, edges: Array<IntArray>): DisjointSet {
        val disjointSet = DisjointSet(n)
        edges.forEach { edge ->
            val a = edge[0]
            val b = edge[1]
            disjointSet.union(a, b)
        }
        return disjointSet
    }

    private fun hasPathDFS(graph: Map<Int, List<Int>>, visited: MutableSet<Int>, current: Int, target: Int): Boolean {
        if (current == target) {
            return true
        } else {
            graph[current]?.let { neighbors ->
                neighbors.forEach { neighbor ->
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor)
                        val hasPath = hasPathDFS(graph, visited, neighbor, target)
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

    private fun hasPathStack(graph: Map<Int, List<Int>>, current: Int, target: Int): Boolean {
        val stack = Stack<Int>()
        val visited = mutableSetOf<Int>()
        stack.push(current)
        visited.add(current)

        while (stack.isNotEmpty()) {
            val node = stack.pop()
            if (node == target) return true
            graph[node]?.forEach { neighbor ->
                if (!visited.contains(neighbor)) {
                    if (neighbor == target) return true
                    stack.push(neighbor)
                    visited.add(neighbor)
                }
            }
        }
        return false
    }
}