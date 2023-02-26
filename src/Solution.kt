import array.M16

class Solution {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = M16()
            val list = intArrayOf(
                0,0,0
            )
            println(a.threeSumClosest(list, 1))
        }
    }
}




