package treesAndGraphs.binarysearchtree

import TreeNode


// 653. Two Sum IV - Input is a BST
class E653 {

    private lateinit var list: MutableList<Int>

    fun findTarget(root: TreeNode?, k: Int): Boolean {
        root?.let {
            list = mutableListOf()
            inorder(root)
            var i = 0
            var j = list.size - 1
            while (i < j) {
                val sum = list[i] + list[j]
                if (sum == k) return true
                else if (sum < k) i++
                else j--
            }
        }
        return false
    }

    private fun inorder(root: TreeNode?) {
        root?.let {
            inorder(it.left)
            list.add(it.`val`)
            inorder(it.right)
        }
    }

    private lateinit var set: MutableSet<Int>

    fun findTarget2(root: TreeNode?, k: Int): Boolean {
        root?.let {
            set = mutableSetOf()
            return dfs(root, k)
        }
        return false
    }

    private fun dfs(node: TreeNode?, k: Int): Boolean {
        node?.let {
            val target = k - it.`val`
            if (set.contains(target)) return true
            set.add(it.`val`)
            return dfs(it.left, k) || dfs(it.right, k)
        }
        return false
    }

    fun findTarget1(root: TreeNode?, k: Int): Boolean {
        root?.let {
            return traverse(root, k, root)
        }
        return false
    }

    private fun traverse(node: TreeNode?, k: Int, treeRoot: TreeNode?): Boolean {
        node?.let {
            val target = k - it.`val`
            return search(treeRoot, target, it) || traverse(it.left, k, treeRoot) || traverse(it.right, k, treeRoot)
        }
        return false
    }

    private fun search(treeRoot: TreeNode?, k: Int, sourceNode: TreeNode?): Boolean {
        treeRoot?.let {
            return if (it == sourceNode) false
            else if (it.`val` == k) true
            else if (it.`val` > k) search(it.left, k, sourceNode)
            else search(it.right, k, sourceNode)
        }
        return false
    }
}