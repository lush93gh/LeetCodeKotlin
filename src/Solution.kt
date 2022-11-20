import array.H218
import array.H699

class Solution {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var c = Poker()
            for (i in 0..51)
            println(c.draw())
        }
    }


}

//[[1,2],[2,3],[6,1]]
//[[100,100],[200,100]]
//[[9,7],[1,9],[3,1]]
//[[6,1],[9,2],[2,4]]
//[[4,1],[6,9],[6,8],[1,9],[9,8]]

