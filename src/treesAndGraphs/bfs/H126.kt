package treesAndGraphs.bfs

import java.util.*

class H126 {
    fun findLadders_WA(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        var min = Int.MAX_VALUE
        var currentLevel = 1
        val result = mutableSetOf<List<String>>()
        val words = buildWords(wordList).toMutableMap()
        val Q = LinkedList<List<String>>()
        val visited = mutableSetOf<String>()
        Q.offer(listOf(beginWord))
        while (Q.isNotEmpty()) {
            val ladders = Q.poll()
            val word = ladders.last()
            if (ladders.size >= currentLevel) {
                println(ladders.size)
                currentLevel = ladders.size
                if (ladders.size - 2 >= 0) {
                    visited.add(ladders[ladders.size - 2])
                }
            }
            if (ladders.size <= min && !visited.contains(word)) {
                // println(ladders)
                if (word == endWord) {
                    if (ladders.size < min) {
                        min = ladders.size
                        result.clear()
                    }
                    result.add(ladders)
                } else {
                    if (ladders.size + 1 <= min) {
                        for (i in word.indices) {
                            val variant = word.substring(0, i) + "-" + word.substring(i + 1, word.length)
                            val newList = mutableListOf<String>()
                            words.getOrDefault(variant, listOf()).forEach { nextWord ->
                                if (nextWord == endWord) {
                                    if (ladders.size + 1 < min) {
                                        min = ladders.size + 1
                                        result.clear()
                                    }
                                    result.add(ladders + nextWord)
                                }
                                val condition = (ladders.size + 1 == min && nextWord != endWord)
                                if (!condition && !ladders.contains(nextWord) && !visited.contains(nextWord)) {
                                    Q.offer(ladders + nextWord)
                                }
                                if (!ladders.dropLast(1).contains(nextWord)) {
                                    newList.add(nextWord)
                                }
                            }
                            words[variant] = newList
                        }
                    }
                }
            }
        }
        return result.toList()
    }

    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        val words = buildWords(wordList)
        val result = mutableListOf<List<String>>()
        val queue1: Queue<List<String>> = LinkedList()
        val visited1 = mutableMapOf<String, List<String>>()
        queue1.offer(listOf(beginWord))

        val queue2: Queue<List<String>> = LinkedList()
        val visited2 = mutableMapOf<String, List<String>>()
        if (wordList.contains(endWord)) {
            queue2.offer(listOf(endWord))
        }
        var minLength = Int.MAX_VALUE
        while ((queue1.isNotEmpty() || queue2.isNotEmpty())) {
            for (j in queue1.indices) {
                val list = queue1.poll()
                val word = list.last()
                //  println("front $word ${list}")
                if (visited2.contains(word)) {
                    val newList = list + visited2[word]!!.dropLast(1).reversed()
                    if (newList.size <= minLength) {
                        result.add(newList)
                        minLength = newList.size
                    }
                    println("front ${list.size} " + newList)
                    println("front ${list} " + visited2[word]!!)
                    // continue
                }
                visited1[word] = list
                for (i in word.indices) {
                    val variant = word.substring(0, i) + "-" + word.substring(i + 1, word.length)
                    words[variant]?.let {
                        it.forEach { nextWord ->
                            if (!visited1.contains(nextWord)) {
                                val nextList = list + nextWord
                                queue1.offer(nextList)
                                visited1[nextWord] = nextList
                                println("front $word ${nextWord}")
                            }
                        }
                    }
                }
            }
            for (j in queue2.indices) {
                val list = queue2.poll()
                val word = list.last()
                if (visited1.contains(word)) {
                    val newList = visited1[word]!! + list.dropLast(1).reversed()
                    if (newList.size <= minLength) {
                        result.add(newList)
                        minLength = newList.size
                    }
                    // hasFound = true
                    println("back ${list.size} " + newList)
                    println("back ${visited1[word]!!} " + list)
                    //   continue
                }
                visited2[word] = list
                for (i in word.indices) {
                    val variant = word.substring(0, i) + "-" + word.substring(i + 1, word.length)
                    words[variant]?.let {
                        it.forEach { nextWord ->
                            if (!visited2.contains(nextWord)) {
                                val nextList = list + nextWord
                                queue2.offer(nextList)
                                visited2[nextWord] = nextList
                            }
                        }
                    }
                }
            }
        }

        return result.toSet().toList()
    }

    private fun buildWords(wordList: List<String>): Map<String, List<String>> {
        val map = mutableMapOf<String, List<String>>()
        wordList.forEach { word ->
            map.putIfAbsent(word, emptyList())
            for (i in word.indices) {
                val variation = word.substring(0, i) + "-" + word.substring(i + 1, word.length)
                map[variation] = (map[variation] ?: emptyList()) + word
            }
        }
        return map
    }
}