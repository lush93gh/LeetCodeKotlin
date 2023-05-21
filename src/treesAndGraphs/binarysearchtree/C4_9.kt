package treesAndGraphs.binarysearchtree

class C4_9 {
    fun ways(nums: IntArray): Int {
        return recursive(nums.toList()).toInt()
    }

    fun factorial(n: Int): Long {
        return if (n == 1 || n == 0) 1L
        else n * factorial(n - 1)
    }

    fun combine(m: Int, n: Int): Long {
        return factorial(m) / factorial(n) / factorial(m - n)
    }

    fun recursive(nums: List<Int>): Long {
        if (nums.size <= 1) return 1L
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
            return left * right * combine(leftList.size + rightList.size, leftList.size)
        }
    }
}