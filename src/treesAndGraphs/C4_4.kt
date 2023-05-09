package treesAndGraphs

import TreeNode
import kotlin.math.abs
import kotlin.math.max

// 110. Balanced Binary Tree
class C4_4 {
    fun isBalanced(root: TreeNode?): Boolean {
        val result = traverse(root)
        return result.second
    }

    private fun traverse(root: TreeNode?): Pair<Int, Boolean> {
        return root?.let {
            if (it.left == null && it.right == null) {
                1 to true
            } else {
                val leftResult = it.left?.let { traverse(it) } ?: (0 to true)
                val rightResult = it.right?.let { traverse(it) } ?: (0 to true)
                1 + max(leftResult.first, rightResult.first) to
                        (leftResult.second && rightResult.second && abs(leftResult.first - rightResult.first) <= 1)
            }
        } ?: (0 to true)
    }
}