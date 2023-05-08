package hackerrank

class TreePreorderTraversal {
    fun preOrder(root: Node?) {
        val result = traverse(root)
        println(result.trimEnd())
    }

    fun traverse(root: Node?): String {
        return root?.let {
            it.data.toString() + " " + traverse(it.left) + traverse(it.right)
        } ?: ""
    }
}