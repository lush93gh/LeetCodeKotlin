import array.M454

class Solution {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = M454()
            val list = intArrayOf(
                0, 0, 0
            )
            println(
                a.fourSumCount(
                    intArrayOf(0,1,-1),
                    intArrayOf(-1,1,0),
                    intArrayOf(0,0,1),
                    intArrayOf(-1,1,1)
                )
            )
        }
    }
}




