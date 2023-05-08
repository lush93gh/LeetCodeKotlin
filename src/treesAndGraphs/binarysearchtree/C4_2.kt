package treesAndGraphs.binarysearchtree

import kotlin.math.ceil
import kotlin.math.log
import kotlin.math.pow

class C4_2 {
    fun buildTree1(arr: List<Int>): List<Int> {
        val h = ceil(log(arr.size.toDouble(), 2.0)).toInt()
        return if (h == 0) arr
        else {
            val leftNodes = (2F.pow(h - 1) - 1).toInt()
            val left = if (leftNodes > 0) buildTree1(arr.take(leftNodes)) else emptyList()
            val right =
                if (arr.size - 1 - leftNodes > 0) buildTree1(arr.takeLast(arr.size - 1 - leftNodes)) else emptyList()
            listOf(arr[leftNodes]) + left + right
        }
    }

    fun buildTree(arr: List<Int>): List<Int> {
        return if (arr.size == 1) arr
        else {
            val rootIndex = arr.size / 2
            val left = if (rootIndex > 0) buildTree(arr.take(rootIndex)) else emptyList()
            val right =
                if (arr.size - 1 - rootIndex > 0) buildTree(arr.takeLast(arr.size - 1 - rootIndex)) else emptyList()
            listOf(arr[rootIndex]) + left + right
        }
    }
}