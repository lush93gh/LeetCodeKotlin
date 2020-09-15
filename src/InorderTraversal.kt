class InorderTraversal {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        root?.let{
            val result = mutableListOf<Int>()
            if(root.left!= null) result.addAll(inorderTraversal(root.left))
            result.add(root.`val`)
            if(root.right!= null) result.addAll(inorderTraversal(root.right))

            return result.toList()
        }
        return listOf<Int>()
    }
}