package treesAndGraphs

import TreeNode
import java.util.*

// 107. Binary Tree Level Order Traversal II
class M107 {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        root?.let {
            val queue: Queue<TreeNode> = LinkedList()
            queue.offer(it)
            while (queue.isNotEmpty()) {
                val level = mutableListOf<Int>()
                for (i in queue.indices) {
                    val node = queue.poll()
                    level.add(node.`val`)
                    node.left?.let { queue.offer(it) }
                    node.right?.let { queue.offer(it) }
                }
                result.add(0, level)
            }
        }
        return result
    }
}