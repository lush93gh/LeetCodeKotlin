package hackerrank

class SubarrayDivision1 {
    fun birthday1(s: Array<Int>, d: Int, m: Int): Int {
        // Write your code here
        var result = 0
        for (i in 0..s.size - m) {
            var sum = 0
            for (j in i until i + m) {
                sum += s[j]
            }
            if (sum == d) {
                result++
            }
        }
        return result
    }

    fun birthday(s: Array<Int>, d: Int, m: Int): Int {
        // Write your code here
        val prefixSum = IntArray(s.size)
        prefixSum[0] = s[0]
        for (i in 1 until s.size) {
            prefixSum[i] = s[i] + prefixSum[i - 1]
        }

        var result = 0
        if (m <= s.size && prefixSum[m - 1] == d) {
            result++
        }

        for (i in m until s.size) {
            if (prefixSum[i] - prefixSum[i - m] == d) {
                result++
            }
        }
        return result
    }
}