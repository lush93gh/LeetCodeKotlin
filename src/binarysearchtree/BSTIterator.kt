package binarysearchtree

import TreeNode

class BSTIterator(root: TreeNode?) {
    private val stack = mutableListOf<TreeNode>()
    var node = root
    var result = root

    /** @return the next smallest number */
    fun next(): Int {
        if(stack.isNotEmpty() || node!=null){
            while(node!=null){
                stack.add(node!!)
                node = node!!.left
            }

            node = stack.last()
            result = stack.last()
            stack.removeAt(stack.size - 1)

            node = node!!.right
        }

        return result!!.`val`
    }

    /** @return whether we have a next smallest number */
    fun hasNext(): Boolean {
        return (stack.isNotEmpty() || node!=null)
    }
}