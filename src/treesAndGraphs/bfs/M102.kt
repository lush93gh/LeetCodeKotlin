package treesAndGraphs.bfs

import TreeNode
import java.util.*

class M102 {
    fun levelOrder0313(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val queue: Queue<TreeNode> = LinkedList()
        root?.let { queue.add(it) }
        while (queue.isNotEmpty()) {
            val level = mutableListOf<Int>()
            for (i in 0 until queue.size) {
                val node = queue.poll()
                level.add(node.`val`)
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
            result.add(level)
        }
        return result
    }

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        return root?.let {
            val result = mutableListOf<List<Int>>()
            val queue: Queue<TreeNode> = LinkedList()
            queue.offer(root)
            while (queue.isNotEmpty()) {
                val level = mutableListOf<Int>()
                for (i in queue.indices) {
                    val node = queue.poll()
                    level.add(node.`val`)
                    node.left?.let { queue.offer(it) }
                    node.right?.let { queue.offer(it) }
                }
                result.add(level)
            }
            result
        } ?: emptyList()
    }
}