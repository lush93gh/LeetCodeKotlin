package treesAndGraphs.dfs

import TreeNode

class E226 {
    fun invertTree(root: TreeNode?): TreeNode? {
        return root?.let {
            val left: TreeNode? = it.left
            val right: TreeNode? = it.right
            invertTree(left)
            invertTree(right)
            it.left = right
            it.right = left
            it
        }
    }
}