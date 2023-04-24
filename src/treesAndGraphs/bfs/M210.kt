package treesAndGraphs.bfs

import java.util.*

class M210 { //23:25
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        if (prerequisites.isEmpty()) {
            return (0 until numCourses).toList().toIntArray()
        }
        val nodes = (0 until numCourses).toMutableList()
        val graph = mutableMapOf<Int, Set<Int>>()
        prerequisites.forEach {
            graph[it[1]] = (graph[it[1]] ?: emptySet()).toMutableSet().apply {
                add(it[0])
                nodes.remove(it[0])
            }
        }
        println(graph)
        graph.forEach {
            run breaking@{
                val list = mutableListOf<Int>()
                val queue: Queue<Int> = LinkedList()
                val visited = mutableSetOf<Int>()
                queue.offer(it.key)
                visited.add(it.key)
                list.add(it.key)
                while (!queue.isEmpty()) {
                    for (i in queue.indices) {
                        val node = queue.poll()
                        visited.add(node)
                        graph[node]?.forEach { neighbor ->
                            if (visited.contains(neighbor)) {
                                return@breaking
                            }
                            if (!visited.contains(neighbor)) {
                                list.add(neighbor)
                                queue.add(neighbor)
                            }
                        }
                    }
                }
                val result = nodes + list
                if (result.size >= numCourses) {
                    return result.take(numCourses).toIntArray()
                }
            }
        }
        return intArrayOf(0)
    }
}