package hackerrank

class NoPrefixSet {
    val root = TrieNode('^', emptyList())
    fun noPrefix(words: Array<String>): Unit {
        // Write your code here
        for (i in words.indices) {
            val word = words[i]
            val result = buildTree(word)
            // println(word)
            //println(root)
            if (!result) {
                println("BAD SET")
                println(word)
                return
            }
        }
        println("GOOD SET")
    }

    fun buildTree(word: String): Boolean {
        var node = root
        for (i in word.indices) {
            val char = word[i]
            if (node.children.any { it.char == '*' }) {
                return false
            } else if (node.children.any { it.char == char }) {
                for (j in node.children.indices) {
                    val childNode = node.children[j]
                    if (childNode.char == char) {
                        node = childNode
                        break
                    }
                }
            } else {
                val child = TrieNode(char = char)
                node.children = node.children.toMutableList().apply {
                    add(child)
                }
                node = child
            }
        }
        if (node.children.isEmpty()) {
            node.children = listOf(TrieNode(char = '*'))
        } else {
            return false
        }
        return true
    }
}