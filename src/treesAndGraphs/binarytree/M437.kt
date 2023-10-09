package treesAndGraphs.binarytree

import TreeNode

// 437. Path Sum III
class M437 {
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        return rootSum(root, targetSum.toLong()).toInt()
    }

    private fun find(root: TreeNode?, targetSum: Long): Long {
        return if (root == null) 0
        else {
            var result = 0L
            if (root.`val`.toLong() == targetSum) {
                result++
            }
            result += find(root.left, targetSum - root.`val`)
            result += find(root.right, targetSum - root.`val`)
            result
        }
    }

    private fun rootSum(p: TreeNode?, targetSum: Long): Long {
        return if (p == null) 0
        else {
            var result = 0L
            result += find(p, targetSum)
            result += rootSum(p.left, targetSum)
            result += rootSum(p.right, targetSum)
            result
        }
    }
}