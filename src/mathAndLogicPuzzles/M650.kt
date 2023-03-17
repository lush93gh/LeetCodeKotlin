package mathAndLogicPuzzles

class M650 {
    fun minSteps(n: Int): Int {
        val arr = IntArray(n + 1) { 0 }
        for (i in 2..n) {
            var min = Int.MAX_VALUE
            for (j in 2..i) {
                if (j == i) {
                    if (i < min) {
                        min = i
                    }
                } else if (i % j == 0) {
                    val value = arr[j] + 1 + (i / j - 1)
                    if (value < min) {
                        min = value
                    }
                }
            }
            arr[i] = min
        }
        return arr[n]
    }
}