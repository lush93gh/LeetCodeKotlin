import treesAndGraphs.bfs.M210

class Solution {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = M210()



            val lsit = a.findOrder(
                4, arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(2, 0),
                    intArrayOf(3, 1),
                    intArrayOf(3, 2)
                )
            )
            lsit.forEach {
                println(it)
            }
        }
    }
}






