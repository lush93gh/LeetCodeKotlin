package treesAndGraphs.binarytree

import TreeNode

class C4_12 {
    fun find(root: TreeNode?, sum: Int): List<List<Int>> {
        if (root == null) return emptyList()
        else {
            val result = mutableListOf<List<Int>>()
            if (root.`val` == sum) {
                result.add(listOf(root.`val`))
            } else {
                val leftResult = find(root.left, sum - root.`val`)
                val rightResult = find(root.right, sum - root.`val`)
                leftResult.forEach {
                    result.add(it.toMutableList().apply {
                        add(0, root.`val`)
                    })
                }
                rightResult.forEach {
                    result.add(it.toMutableList().apply {
                        add(0, root.`val`)
                    })
                }
            }
            return result
        }
    }

    fun recursive(root: TreeNode?, sum: Int): List<List<Int>> {
        if (root == null) return emptyList()
        else {
            val result = mutableListOf<List<Int>>()
            val found = find(root, sum)
            result.addAll(found)
            result.addAll(recursive(root.left, sum))
            result.addAll(recursive(root.right, sum))
            return result
        }
    }

    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        return recursive(root, sum)
    }
}