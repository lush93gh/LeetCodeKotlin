import java.util.*

class LevelOrder {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val queue: Queue<TreeNode> = LinkedList()

        root?.let{
            queue.offer(root)

            while(queue.isNotEmpty()){
                val list = mutableListOf<Int>()

                for(i in queue.indices){
                    val node = queue.poll()
                    list.add(node.`val`)

                    if(node.left!= null) queue.offer(node.left)
                    if(node.right!= null) queue.offer(node.right)
                }

                result.add(list)
            }

            return result.toList()
        }
        return listOf<List<Int>>()
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}