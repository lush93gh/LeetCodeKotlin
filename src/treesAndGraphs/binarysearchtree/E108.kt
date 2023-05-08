package treesAndGraphs.binarysearchtree

import TreeNode
import kotlin.math.ceil
import kotlin.math.log

class E108 {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return buildTree(nums.toList())
    }

    private fun buildTree(arr: List<Int>): TreeNode? {
        val h = ceil(log(arr.size.toDouble(), 2.0)).toInt()
        return if (h == 0) TreeNode(arr[0])
        else {
            val rootIndex = arr.size / 2
            val left = if (rootIndex > 0) buildTree(arr.take(rootIndex)) else null
            val right = if (arr.size - 1 - rootIndex > 0) buildTree(arr.takeLast(arr.size - 1 - rootIndex)) else null
            listOf(arr[rootIndex]) + left + right
            TreeNode(arr[rootIndex]).apply {
                this.left = left
                this.right = right
            }
        }
    }
}