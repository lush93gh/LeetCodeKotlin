package treesAndGraphs.binarysearchtree

import TreeNode
import java.util.*
import kotlin.math.max
import kotlin.math.min

// 98. Validate Binary Search Tree
class M98 {
    fun isValidBST(root: TreeNode?): Boolean {
        return traverseIterative(root)
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

    private fun traverseRecursive(root: TreeNode?, lower: Long, upper: Long): Boolean {
        return root?.let {
            val value = root.`val`.toLong()
            value in (lower + 1) until upper
                    && traverseRecursive(it.left, lower, value)
                    && traverseRecursive(it.right, value, upper)
        } ?: true
    }

    private fun traverseIterative(root: TreeNode?): Boolean {
        return root?.let {
            val stack = Stack<Triple<TreeNode?, Long, Long>>()
            val visited = mutableSetOf<TreeNode?>()
            stack.push(Triple(root, Long.MIN_VALUE, Long.MAX_VALUE))
            visited.add(root)
            while (stack.isNotEmpty()) {
                val (node, lower, upper) = stack.pop()
                node?.`val`?.let { value ->
                    if (value !in (lower + 1) until upper) return false
                    else {
                        if (!visited.contains(node.left)) {
                            stack.push(Triple(node.left, lower, value.toLong()))
                            visited.add(node.left)
                        }
                        if (!visited.contains(node.right)) {
                            stack.push(Triple(node.right, value.toLong(), upper))
                            visited.add(node.right)
                        }
                    }
                }
            }
            return true
        } ?: true
    }
}