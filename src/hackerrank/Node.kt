package hackerrank

data class Node(
    val data: Int,
    var left: Node? = null,
    var right: Node? = null
) {
    fun insert(root: Node?, data: Int): Node {
        return if (root == null) {
            Node(data)
        } else {
            val cur: Node
            if (data <= root.data) {
                cur = insert(root.left, data)
                root.left = cur
            } else {
                cur = insert(root.right, data)
                root.right = cur
            }
            root
        }
    }
}