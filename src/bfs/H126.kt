package bfs

import java.util.*

class H126 {
    val words = mutableMapOf<String, List<String>>()
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        var min = Int.MAX_VALUE
        var currentLevel = 1
        val result = mutableSetOf<List<String>>()
        buildWords(wordList)
        val Q = LinkedList<Pair<String, List<String>>>()
        val visited = mutableMapOf<String, Boolean>()
        Q.offer(beginWord to listOf(beginWord))
        while (Q.isNotEmpty()) {
            val (word, ladders) = Q.poll()
            if (ladders.size >= currentLevel) {
                currentLevel = ladders.size
                if (ladders.size - 2 >= 0) {
                    visited[ladders[ladders.size - 2]] = true
                }
            }
            if (ladders.size <= min && !visited.contains(word)) {
                println(ladders)
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
                                    Q.offer(nextWord to ladders + nextWord)
                                }
                            }
                        }
                    }
                }
            }
        }
        return result.toList()
    }

    fun buildWords(wordList: List<String>) {
        wordList.forEach { word ->
            for (i in word.indices) {
                val variant = word.substring(0, i) + "-" + word.substring(i + 1, word.length)
                val list = words.getOrDefault(variant, listOf()).toMutableList().apply {
                    add(word)
                }
                words[variant] = list
            }
        }
    }
}