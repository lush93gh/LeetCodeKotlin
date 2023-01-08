import weivretni.ta.TwoSumLessThanK

class Solution {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val a = MaximumDistinct()
//            var s = a.getMaximumDistinctCount(
//                arrayOf(2, 3, 3, 2, 2),
//                arrayOf(1, 3, 2, 4, 1),
//                2
//            )
//            println(s)
//            val v = intArrayOf(1, 2, 4, 5)

            val a = TwoSumLessThanK()
           // val result = a.twoSumLessThanK(intArrayOf(1, 2, 3, 4), 4)
        //    val result = a.twoSumLessThanK(intArrayOf(1, 2, 3), 3)
            val result = a.twoSumLessThanK(intArrayOf(1, 2, 2, 3, 4), 5)
            result.forEach {
                it.forEach {
                    print(it)
                    print(" ")
                }
                println()
            }
        }
    }
}





