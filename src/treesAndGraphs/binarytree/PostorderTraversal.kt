package treesAndGraphs.binarytree

import TreeNode

class PostorderTraversal {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        root?.let{
            val result = mutableListOf<Int>()
            if(root.left!= null)result.addAll(postorderTraversal(root.left))
            if(root.right!= null) result.addAll(postorderTraversal(root.right))
            result.add(root.`val`)

            return result.toList()
        }
        return listOf<Int>()
    }
}