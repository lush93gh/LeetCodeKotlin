package treesAndGraphs.binarytree

import TreeNode

// 437. Path Sum III
class M437 {
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        return recursive(root, targetSum.toLong()).toInt()
    }

    fun find(root: TreeNode?, sum: Long): Long {
        if (root == null) return 0
        else {
            var result = 0L
            if (root.`val`.toLong() == sum) {
                result++
            }
            result += find(root.left, sum - root.`val`)
            result += find(root.right, sum - root.`val`)
            return result
        }
    }

    fun recursive(root: TreeNode?, sum: Long): Long {
        if (root == null) return 0
        else {
            var result = 0L
            result += find(root, sum)
            result += recursive(root.left, sum)
            result += recursive(root.right, sum)
            return result
        }
    }
}