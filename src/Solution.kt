import treesAndGraphs.dfs.E1971

class Solution {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = E1971()

            println(
                a.validPath(
                    n = 3,
                    edges = arrayOf(
                        intArrayOf(0,1),
                        intArrayOf(1,2),
                        intArrayOf(2,0)
                    ),
                    source= 0,
                    destination = 2
//                    listOf(
//                        listOf(1, 0, 1, 1, 0, 0),
//                        listOf(1, 1, 0, 0, 0, 0),
//                        listOf(0, 1, 1, 0, 0, 0),
//                        listOf(0, 0, 0, 1, 0, 1),
//                        listOf(1, 0, 0, 0, 1, 0),
//                        listOf(0, 1, 0, 0, 0, 1)
//                    ),
//                    3, 4
                )
            )
        }
    }
}






