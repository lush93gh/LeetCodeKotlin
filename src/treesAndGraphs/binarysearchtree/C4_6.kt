package treesAndGraphs.binarysearchtree

import TreeNode
import kotlin.math.max

class C4_6 {
    private class TreeNode(var `val`: Int) {
        var parent: TreeNode? = null
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private fun nextNumber(root: TreeNode?): Int {
        return root?.let {
            val parent = if (it.parent != null) traverseP(it, it.`val`) else Int.MIN_VALUE
            val right = if (it.right != null) traverseR(it.right!!) else Int.MIN_VALUE
            val result = max(parent, right)
            if (result == Int.MIN_VALUE) -1 else result
        } ?: -1
    }

    private fun traverseR(root: TreeNode): Int {
        return if (root.left == null) {
            root.`val`
        } else {
            traverseR(root.left!!)
        }
    }

    private fun traverseP(root: TreeNode, source: Int): Int {
        return if (root.parent == null) {
            if (root.`val` > source) root.`val` else Int.MIN_VALUE
        } else {
            if (root.parent!!.`val` > root.`val`) {
                root.parent!!.`val`
            } else {
                traverseP(root.parent!!, source)
            }
        }
    }
}