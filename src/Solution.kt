import array.M167

class Solution {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = M167()
            val list = intArrayOf(
                -1,0
            )
            a.twoSum(
                list,
                -1
            ).forEach {
                println("$it")
            }
        }
    }
}




