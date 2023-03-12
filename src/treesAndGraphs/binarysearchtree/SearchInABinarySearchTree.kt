package treesAndGraphs.binarysearchtree

import TreeNode

class SearchInABinarySearchTree {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        root?.let{
            val value = root.`val`
            return when {
                `val` == value -> root
                `val` > value -> searchBST(root.right, `val`)
                else -> searchBST(root.left, `val`)
            }
        }
        return root
    }
}