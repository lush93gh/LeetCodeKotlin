package hackerrank

class PlusMinus {
    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    fun plusMinus(arr: Array<Int>): Unit {
        var positiveCount = 0F
        var negativeCount = 0F
        var zeroCount = 0F

        arr.forEach {
            if (it > 0) positiveCount++
            else if (it < 0) negativeCount++
            else zeroCount++
        }

        println(String.format("%.6f", positiveCount / arr.size))
        println(String.format("%.6f", negativeCount / arr.size))
        println(String.format("%.6f", zeroCount / arr.size))
    }
}