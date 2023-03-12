package treesAndGraphs.bfs

import java.util.*

class M433 {
    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
        var min = Int.MAX_VALUE
        val map = buildBank(bank, mapOf())
        val Q: Queue<List<String>> = LinkedList()
        val visited = mutableSetOf<String>()
        Q.add(listOf(startGene))

        while (Q.isNotEmpty()) {
            val mutations = Q.poll()
            val lastGene = mutations.last()
            if (lastGene == endGene && mutations.size - 1 < min) {
                min = mutations.size - 1
                continue
            }
            if (!visited.contains(lastGene)) {
                visited.add(lastGene)
                for (i in lastGene.indices) {
                    val mutation = lastGene.substring(0, i) + "-" + lastGene.substring(i + 1, lastGene.length)
                    map[mutation]?.forEach {
                        Q.add(mutations + it)
                    }
                }
            }
        }
        return if (min == Int.MAX_VALUE) -1 else min
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