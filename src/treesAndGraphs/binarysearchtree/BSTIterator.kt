package treesAndGraphs.binarysearchtree

import TreeNode

class BSTIterator(root: TreeNode?) {
    private val stack = mutableListOf<TreeNode>()

    init{
        traverseLeft(root)
    }

    private fun traverseLeft(root: TreeNode?){
        var node = root
        while(node!=null){
            stack.add(node)
            node = node.left
        }
    }

    /** @return the next smallest number */
    fun next(): Int {
        val node = stack.last()
        stack.removeAt(stack.size - 1)
        traverseLeft(node.right)
        return node.`val`
    }

    /** @return whether we have a next smallest number */
    fun hasNext(): Boolean {
        return stack.isNotEmpty()
    }
}