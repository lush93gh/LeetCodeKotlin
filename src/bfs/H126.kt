package bfs

import java.util.*

class H126 {
    val words = mutableMapOf<String, List<String>>()
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        var min = Int.MAX_VALUE
        var currentLevel = 1
        val result = mutableSetOf<List<String>>()
        buildWords(wordList)
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