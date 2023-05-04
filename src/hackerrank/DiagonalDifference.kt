package hackerrank

import kotlin.math.abs

class DiagonalDifference {
    fun diagonalDifference(arr: Array<Array<Int>>): Int {
        var main = 0L
        var vice = 0L
        for (i in arr.indices) {
            main += arr[i][i]
            vice += arr[i][arr.size - 1 - i]
        }
        return abs(main - vice).toInt()
    }
}