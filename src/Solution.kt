import array.M15

class Solution {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = M15()
            val list = intArrayOf(
                1,2,-2,-1
            )
            //  a.buildWords(list)
            //
            println(a.threeSum(list))
        }
    }
}




