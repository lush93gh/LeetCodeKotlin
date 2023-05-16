package treesAndGraphs.binarysearchtree

import TreeNode
import kotlin.math.max
import kotlin.math.min

// 98. Validate Binary Search Tree
class M98 {
    fun isValidBST(root: TreeNode?): Boolean {
        return traverse(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    fun traverse1(root: TreeNode?): Triple<Boolean, Int, Int> {
        return root?.let {
            if (it.left == null && it.right == null) {
                Triple(true, it.`val`, it.`val`)
            } else if (it.left == null) {
                val rightResult = traverse1(it.right)
                val result = rightResult.first && it.`val` < rightResult.second
                Triple(result, min(it.`val`, rightResult.second), max(it.`val`, rightResult.third))
            } else if (it.right == null) {
                val leftResult = traverse1(it.left)
                val result = leftResult.first && it.`val` > leftResult.third
                Triple(result, min(it.`val`, leftResult.second), max(it.`val`, leftResult.third))
            } else {
                val leftResult = traverse1(it.left)
                val rightResult = traverse1(it.right)
                val result =
                    leftResult.first && rightResult.first && it.`val` > leftResult.third && it.`val` < rightResult.second
                val min = min(leftResult.second, rightResult.second)
                val max = max(leftResult.third, rightResult.third)
                Triple(result, min(it.`val`, min), max(it.`val`, max))
            }
        } ?: Triple(true, 0, 0)
    }

    private fun traverse(root: TreeNode?, lower: Long, upper: Long): Boolean {
        return root?.let {
            val value = root.`val`.toLong()
            value in (lower + 1) until upper
                    && traverse(it.left, lower, value)
                    && traverse(it.right, value, upper)
        } ?: true
    }
}