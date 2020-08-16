import kotlin.math.max

class MaximumDepthOfBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        root?.let{
            var left = 0
            var right = 0
            if(root.left != null) left = maxDepth(root.left)
            if(root.right != null) right = maxDepth(root.right)

            return max(left, right) + 1
        }
        return 0
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}