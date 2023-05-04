package hackerrank

class MiniMaxSum {
    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    fun miniMaxSum1(arr: Array<Int>): Unit {
        arr.sort()
        var minSum = 0L
        var maxSum = 0L

        arr.forEachIndexed { index, num ->
            if (index < arr.size - 1) {
                minSum += num
            }
            if (index > 0) {
                maxSum += num
            }
        }

        println("$minSum $maxSum")
    }

    fun miniMaxSum2(arr: Array<Int>): Unit {
        var sum = 0L
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE

        arr.forEachIndexed { index, num ->
            sum += num
            if (num < min) {
                min = num
            }
            if (num > max) {
                max = num
            }
        }

        println("${sum - max} ${sum - min}")
    }
}