import array.H218
import array.H699

class Solution {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var c = H699()
            val a = c.fallingSquares(
                arrayOf(
                    intArrayOf(4, 1),
                    intArrayOf(6, 9),
                    intArrayOf(6, 8),
                    intArrayOf(1, 9),
                    intArrayOf(9, 8)
                )
            )
            println(a)
        }
    }


}

//[[1,2],[2,3],[6,1]]
//[[100,100],[200,100]]
//[[9,7],[1,9],[3,1]]
//[[6,1],[9,2],[2,4]]
//[[4,1],[6,9],[6,8],[1,9],[9,8]]

