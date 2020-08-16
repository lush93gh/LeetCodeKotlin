import java.util.*

class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        root?.let{
            val list = levelOrder(root)
            for(l in list){
                for(j in 0 until l.size/2){
                    if(l[j] != l[l.size-1-j]) return false
                }
            }
        }
        return true
    }

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val queue: Queue<TreeNode?> = LinkedList()

        root?.let{
            queue.offer(root)

            while(queue.isNotEmpty()){
                val list = mutableListOf<Int>()

                for(i in queue.indices){
                    val node = queue.poll()
                    if(node != null){
                        list.add(node.`val`)

                        queue.offer(node.left)
                        queue.offer(node.right)
                    }
                    else list.add(Int.MIN_VALUE)
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