package treesAndGraphs.binarytree

import TreeNode

// 572. Subtree of Another Tree
class E572 {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) return true
        else if (root == null) return false
        else if (subRoot == null) return false
        else {
            val candidate = find(root, subRoot)
            println(candidate?.`val`)
            val result = areTreesSame(candidate, subRoot)
            if (result) return result
            else {
                val leftResult = isSubtree(root.left, subRoot)
                if (leftResult) return leftResult
                val rightResult = isSubtree(root.right, subRoot)
                if (rightResult) return rightResult
                return false
            }
        }
    }

    fun find(t1: TreeNode?, t2: TreeNode?): TreeNode? {
        if (t1?.`val` == t2?.`val`) return t1
        val left = t1?.left?.let { find(it, t2) }
        if (left != null) return left
        return t1?.right?.let { find(it, t2) }
    }

    fun areTreesSame(r1: TreeNode?, r2: TreeNode?): Boolean {
        return if (r1 == null && r2 == null) true
        else if (r1 == null) false
        else if (r2 == null) false
        else {
            if (r1.`val` != r2.`val`) false
            else areTreesSame(r1.left, r2.left) &&
                    areTreesSame(r1.right, r2.right)
        }
    }
}