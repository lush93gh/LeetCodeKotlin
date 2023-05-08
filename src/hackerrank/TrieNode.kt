package hackerrank

data class TrieNode(
    val char: Char,
    var children: List<TrieNode> = emptyList()
)