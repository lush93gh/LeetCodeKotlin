package arraysAndStrings.string

class M2384 {
    fun largestPalindromic(num: String): String {
        val counts = IntArray(10) { 0 }
        num.forEach {
            counts[it - '0']++
        }

        var result = ""
        for (i in 9 downTo 0) {
            val count = counts[i]
            if (result.length % 2 == 0 && count % 2 == 1) {
                result = result.take(result.length / 2) + "$i" + result.takeLast(result.length / 2)
                counts[i]--
            }
        }

        for (i in counts.indices) {
            if (i > 0 || counts.drop(1).any { it >= 2 }) {
                var count = counts[i]
                while (count > 1) {
                    result = "$i" + result + "$i"
                    count -= 2
                }
            } else if (result.isEmpty()) {
                result = "0"
            }
        }

        return result
    }
}