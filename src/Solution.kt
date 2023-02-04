import math.M2217

class Solution {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = M2217()
            println(a.scaleCount(1234, 7))
            val result = a.kthPalindrome(
                intArrayOf(1,2,3,4,5,6,7,8,9,10, 11, 20,89,90,91,1234,9000,9001),
                7
            ).forEach {
                print("$it,")
            }
        }
    }
}
//1000001,1001001,1002001,1003001,1004001,1005001,1006001,1007001,1008001,1009001,1010101,1019101,1088801,1089801,1090901,2233322,9999999,-1




