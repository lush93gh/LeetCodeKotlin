package treesAndGraphs.binarysearchtree

import TreeNode
import kotlin.math.max
import kotlin.math.min

class C4_5 {
    fun isBST(root: TreeNode?): Boolean {
        return traverse(root).first
    }

    fun traverse(root: TreeNode?): Triple<Boolean, Int, Int> {
        return root?.let {
            if (it.left == null && it.right == null) {
                Triple(true, it.`val`, it.`val`)
            } else if (it.left == null) {
                val rightResult = traverse(it.right)
                val result = rightResult.first && it.`val` < rightResult.second
                Triple(result, min(it.`val`, rightResult.second), max(it.`val`, rightResult.third))
            } else if (it.right == null) {
                val leftResult = traverse(it.left)
                val result = leftResult.first && it.`val` > leftResult.third
                Triple(result, min(it.`val`, leftResult.second), max(it.`val`, leftResult.third))
            } else {
                val leftResult = traverse(it.left)
                val rightResult = traverse(it.right)
                val result = leftResult.first && rightResult.first && it.`val` > leftResult.third && it.`val` < rightResult.second
                val min = min(leftResult.second, rightResult.second)
                val max = max(leftResult.third, rightResult.third)
                Triple(result, min(it.`val`, min), max(it.`val`, max))
            }
        } ?: Triple(true, 0, 0)
    }
}