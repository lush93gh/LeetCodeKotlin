package hackerrank

class MaxMin {
    fun maxMin(k: Int, arr: Array<Int>): Int {
        arr.sort()
        var unfairness = Int.MAX_VALUE
        for (i in 0..arr.size - k) {
            val u = arr[i + k - 1] - arr[i]
            if (u < unfairness) {
                unfairness = u
            }
        }
        return unfairness
    }
}