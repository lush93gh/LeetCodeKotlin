package treesAndGraphs.binarytree

import TreeNode

class C4_8 {
    var lowest: TreeNode? = null
    fun find(root: TreeNode?, n1: TreeNode, n2: TreeNode, n1Found: Boolean, n2Found: Boolean): Pair<Boolean, Boolean> {
        if (root == null) return false to false
        else {
            val findN1 = (root == n1) || n1Found
            val findN2 = (root == n2) || n2Found
            val leftResult = if (root.left != null && (!findN1 || !findN2))
                find(root.left, n1, n2, n1Found, n2Found) else false to false
            val rightResult =
                if (root.right != null && (!findN1 || !findN2) && (!leftResult.first || !leftResult.second))
                    find(root.right, n1, n2, n1Found, n2Found) else false to false

            val result =
                (findN1 || leftResult.first || rightResult.first) to (findN2 || leftResult.second || rightResult.second)
            if (result.first && result.second && lowest == null) {
                lowest = root
            }
            return result
        }
    }

    fun lowest(root: TreeNode?, n1: TreeNode?, n2: TreeNode?): TreeNode? {
        return if (root == null || n1 == null || n2 == null) {
            null
        } else {
            find(root, n1, n2, n1Found = false, n2Found = false)
            lowest
        }
    }
}