package treesAndGraphs.binarytree

class C4_11(size: Int) {
    var tree = IntArray(size) { -1 }

    fun expandTree() {
        val newTree = IntArray(tree.size * 2) { -1 }
        for (i in tree.indices) {
            newTree[i] = tree[i]
        }
        tree = newTree
    }

    fun insert(num: Int) {
        var hasInserted = false
        for (i in 1 until tree.size) {
            if (tree[i] == -1) {
                tree[i] = num
                hasInserted = true
                break
            }
        }
        if (!hasInserted) {
            expandTree()
            insert(num)
        }
    }

    fun search(num: Int): Int {
        for (i in tree.indices) {
            if (tree[i] == num) {
                return i
            }
        }
        return -1
    }

    fun delete(num: Int) {
        val index = search(num)
        if (index != -1) {
            tree[index] = -1
        }
    }

    fun getRandomNode(): Int {
        return tree.filter { it == -1 }.random()
    }
}