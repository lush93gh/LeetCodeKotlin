package treesAndGraphs.bfs

import java.util.*

// 127. Word Ladder
class H127 {
    fun ladderLengthBFS(beginWord: String, endWord: String, wordList: List<String>): Int {
        val words = buildWords(wordList)
        val queue: Queue<Pair<String, Int>> = LinkedList()
        val visited = mutableSetOf<String>()
        queue.offer(beginWord to 1)
        visited.add(beginWord)
        while (queue.isNotEmpty()) {
            for (j in queue.indices) {
                val (word, depth) = queue.poll()
                if (word == endWord) return depth
                for (i in word.indices) {
                    val variation = word.substring(0, i) + "-" + word.substring(i + 1, word.length)
                    words[variation]?.let { list ->
                        list.forEach { nextWord ->
                            if (!visited.contains(nextWord)) {
                                visited.add(nextWord)
                                queue.offer(nextWord to depth + 1)
                            }
                        }
                    }
                }

            }
        }
        return 0
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

    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val words = buildWords(wordList)
        val queue1: Queue<Pair<String, Int>> = LinkedList()
        val visited1 = mutableMapOf<String, Int>()
        queue1.offer(beginWord to 1)
        visited1[beginWord] = 1

        val queue2: Queue<Pair<String, Int>> = LinkedList()
        val visited2 = mutableMapOf<String, Int>()
        if (wordList.contains(endWord)) {
            queue2.offer(endWord to 1)
            visited2[endWord] = 1
        }

        while (queue1.isNotEmpty() || queue2.isNotEmpty()) {
            for (j in queue1.indices) {
                val (word, depth) = queue1.poll()
                if (visited2.contains(word)) return depth + visited2[word]!!
                for (i in word.indices) {
                    val variation = word.substring(0, i) + "-" + word.substring(i + 1, word.length)
                    words[variation]?.let { list ->
                        list.forEach { nextWord ->
                            if (!visited1.contains(nextWord)) {
                                queue1.offer(nextWord to depth + 1)
                                visited1[nextWord] = depth
                            }
                        }
                    }
                }
            }

            for (j in queue2.indices) {
                val (word, depth) = queue2.poll()
                if (visited1.contains(word)) return depth + visited1[word]!!
                for (i in word.indices) {
                    val variation = word.substring(0, i) + "-" + word.substring(i + 1, word.length)
                    words[variation]?.let { list ->
                        list.forEach { nextWord ->
                            if (!visited2.contains(nextWord)) {
                                queue2.offer(nextWord to depth + 1)
                                visited2[nextWord] = depth
                            }
                        }
                    }
                }
            }
        }
        return 0
    }
}