package binarysearchtree

import TreeNode

class InsertIntoABinarySearchTree {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        root?.let{
            val value = root.`val`
            when {
                `val` > value -> root.right = insertIntoBST(root.right, `val`)
                else -> root.left = insertIntoBST(root.left, `val`)
            }
            return root
        }
        return TreeNode(`val`)
    }
}