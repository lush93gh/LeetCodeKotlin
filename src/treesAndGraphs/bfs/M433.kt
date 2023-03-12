package treesAndGraphs.bfs

import java.util.*

class M433 {
    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
        val map = buildBank(bank, mapOf())
        val Q: Queue<Pair<String, Int>> = LinkedList()
        val visited = mutableSetOf<String>()
        Q.add(startGene to 0)

        while (Q.isNotEmpty()) {
            for (j in Q.indices) {
                val mutations = Q.poll()
                val lastGene = mutations.first
                val currentDepth = mutations.second
                if (lastGene == endGene) {
                    return currentDepth
                }
                visited.add(lastGene)
                for (i in lastGene.indices) {
                    val mutation = lastGene.substring(0, i) + "-" + lastGene.substring(i + 1, lastGene.length)
                    map[mutation]?.forEach {
                        if (!visited.contains(it)) {
                            Q.add(it to currentDepth + 1)
                        }
                    }
                }
            }
        }
        return -1
    }

    private fun buildBank(bank: Array<String>, map: Map<String, List<String>>): Map<String, List<String>> {
        val mutableMap = map.toMutableMap()
        bank.forEach { gene ->
            for (i in gene.indices) {
                val mutation = gene.substring(0, i) + "-" + gene.substring(i + 1, gene.length)
                mutableMap.putIfAbsent(mutation, listOf())
                mutableMap[mutation] = mutableMap[mutation]!! + gene
            }
        }
        return mutableMap
    }
}