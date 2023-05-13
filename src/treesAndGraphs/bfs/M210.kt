package treesAndGraphs.bfs

import java.util.*

class M210 { //23:25
    fun findOrder1(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        // Has Bugs
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

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val graph = buildGraph(numCourses, prerequisites)
        val depGraph = buildDepGraph(numCourses, prerequisites)
        val freeNodes = (0 until numCourses).filter { c -> c !in prerequisites.map { it[0] } }
        val queue: Queue<Int> = LinkedList()
        val visited = mutableSetOf<Int>()
        freeNodes.forEach {
            queue.offer(it)
            visited.add(it)
        }
        val result = mutableListOf<Int>()
        while (queue.isNotEmpty()) {
            for (i in queue.indices) {
                val node = queue.poll()
                result.add(node)
                graph[node]!!.forEach {
                    if (!visited.contains(it)) {
                        if (depGraph[it]!!.all { visited.contains(it) }) {
                            queue.offer(it)
                            visited.add(it)
                        }
                    }
                }
            }
        }
        return if(result.size != numCourses) intArrayOf() else result.toIntArray()
    }

    fun buildGraph(numCourses: Int, prerequisites: Array<IntArray>): Map<Int, List<Int>> {
        val result = mutableMapOf<Int, List<Int>>()
        for (i in 0 until numCourses) {
            result[i] = emptyList()
        }
        prerequisites.forEach {
            result[it[1]] = result[it[1]]!! + it[0]
        }
        return result
    }

    fun buildDepGraph(numCourses: Int, prerequisites: Array<IntArray>): Map<Int, List<Int>> {
        val result = mutableMapOf<Int, List<Int>>()
        for (i in 0 until numCourses) {
            result[i] = emptyList()
        }
        prerequisites.forEach {
            result[it[0]] = result[it[0]]!! + it[1]
        }
        return result
    }
}