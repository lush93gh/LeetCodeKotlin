package treesAndGraphs.binarysearchtree

import TreeNode

class ValidateBinarySearchTree {
    fun isValidBST(root: TreeNode?): Boolean {
        return traverse(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    fun traverse(root: TreeNode?, lower: Long, upper: Long): Boolean{
        root?.let{
            val value = root.`val`.toLong()
            if(value <= lower || value >= upper) return false

            return traverse(root.left, lower, value)
                    && traverse(root.right, value, upper)
        }
        return true
    }
}