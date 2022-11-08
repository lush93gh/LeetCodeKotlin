import array.H218

class Solution {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var c = H218()
            val a = c.getSkyline(
                arrayOf(
//                    intArrayOf(2,9,10),
//                    intArrayOf(3,7,15),
//                    intArrayOf(5,12,12),
//                    intArrayOf(15,20,10),
//                    intArrayOf(19,24,8)
                 //   intArrayOf(0,2147483647,2147483647)
                    intArrayOf(0,3,3),
                    intArrayOf(1,5,3),
                    intArrayOf(2,4,3),
                    intArrayOf(3,7,3)
                )
            )
            println(a)
        }
    }


}


