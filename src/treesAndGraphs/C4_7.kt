package treesAndGraphs

import java.util.*

class C4_7 {
    fun order(projects: List<String>, dep: List<List<String>>): List<String> {
        val graph = buildGraph(projects, dep)
        val freeNodes = projects.filter { proj -> proj !in dep.map { it[1] } }
        val queue: Queue<String> = LinkedList()
        val visited = mutableSetOf<String>()
        freeNodes.forEach {
            queue.offer(it)
            visited.add(it)
        }
        val result = mutableListOf<String>()
        while (queue.isNotEmpty()) {
            for (i in queue.indices) {
                val node = queue.poll()
                result.add(node)
                graph[node]!!.forEach {
                    if (!visited.contains(it)) {
                        queue.offer(it)
                        visited.add(it)
                    }
                }
            }
        }
        return result
    }

    fun buildGraph(projects: List<String>, dep: List<List<String>>): Map<String, List<String>> {
        val result = mutableMapOf<String, List<String>>()
        projects.forEach { result[it] = emptyList() }
        dep.forEach {
            result[it[0]] = result[it[0]]!! + it[1]
        }
        return result
    }
}