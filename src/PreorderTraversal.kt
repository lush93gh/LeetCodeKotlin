class PreorderTraversal {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        root?.let{
            val result = mutableListOf(root.`val`)
            if(root.left!= null) result.addAll(preorderTraversal(root.left))
            if(root.right!= null) result.addAll(preorderTraversal(root.right))

            return result.toList()
        }
        return listOf<Int>()
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}