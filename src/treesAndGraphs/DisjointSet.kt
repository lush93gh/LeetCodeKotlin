package treesAndGraphs

class DisjointSet(
    val size: Int
) {
    private val root = IntArray(size) { it }
    private val rank = IntArray(size) { it }

    fun find(x: Int): Int {
        return if (x == root[x]) x
        else find(root[x]).also {
            root[x] = it
        }
    }

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX != rootY) {
            if (rank[rootY] < rank[rootX]) {
                root[rootY] = rootX
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY
            } else {
                root[rootX] = rootY
                rank[rootY]++
            }
        }
    }

    fun comparison(x: Int, y: Int): Boolean {
        return find(x) == find(y)
    }
}