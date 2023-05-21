package treesAndGraphs.binarysearchtree

import kotlin.math.min

// 1569. Number of Ways to Reorder Array to Get Same BST
@OptIn(ExperimentalUnsignedTypes::class)
class H1569 {
    private val mod = 1_000_000_007UL
    fun numOfWays(nums: IntArray): Int {
        return recursive(nums.toList()).toInt() - 1
    }

    private val c = Array(1001) { ULongArray(1001) { 0UL } }

    private fun combine(m: Int, n: Int): ULong {
        return if (m == n || n == 0) 1UL
        else if (n == 1) m.toULong()
        else if (c[m][n] != 0UL) c[m][n]
        else ((combine(m - 1, n - 1) % mod + combine(m - 1, n) % mod) % mod).also {
            c[m][n] = it
        }
    }

    private fun recursive(nums: List<Int>): ULong {
        if (nums.size <= 1) return 1UL
        else {
            val root = nums[0]
            val leftList = mutableListOf<Int>()
            val rightList = mutableListOf<Int>()
            for (i in 1 until nums.size) {
                val num = nums[i]
                if (num < root) {
                    leftList.add(num)
                } else {
                    rightList.add(num)
                }
            }
            val left = recursive(leftList)
            val right = recursive(rightList)
            val min = min(leftList.size, rightList.size)
            return (left * (right * (combine(leftList.size + rightList.size, min) % mod) % mod) % mod)
        }
    }
}