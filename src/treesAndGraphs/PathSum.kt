package treesAndGraphs

class PathSum {
    var hasFound = false

    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        traverse(root, sum, 0)
        return hasFound
    }

    fun traverse(root: TreeNode?, sum: Int, accu:Int): Int{
        root?.let{
            val result = root.`val` + accu
            if(root.left!= null) traverse(root.left, sum, result)
            if(root.right!= null) traverse(root.right, sum, result)

            if(root.left == null && root.right == null && result == sum)
                hasFound = true

            return result
        }
        return 0
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}