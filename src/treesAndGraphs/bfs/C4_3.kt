package treesAndGraphs.bfs

import java.util.*

class C4_3 {
    private data class Node(
        val data: Int = 0,
        var next: Node? = null
    )

    private data class TreeNode(
        val data: Int = 0,
        var left: TreeNode? = null,
        var right: TreeNode? = null
    )

    private fun levelOrderTraversal(root: TreeNode?): List<Node> {
        return root?.let {
            val result = mutableListOf<Node>()
            val queue: Queue<TreeNode> = LinkedList()
            queue.offer(root)
            while (queue.isNotEmpty()) {
                val levelRoot = Node()
                var pointer = levelRoot
                for (i in queue.indices) {
                    val node = queue.poll()
                    pointer.next = Node(node.data)
                    pointer = pointer.next!!
                    node.left?.let { queue.offer(it) }
                    node.right?.let { queue.offer(it) }
                }
                levelRoot.next?.let { result.add(it) }
            }
            result
        } ?: emptyList()
    }
}