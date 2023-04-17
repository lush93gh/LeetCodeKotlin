package mathAndLogicPuzzles

// 650. 2 Keys Keyboard
class M650 {
    fun minSteps(n: Int): Int {
        val arr = IntArray(n + 1) { Int.MAX_VALUE }
        arr[1] = 0
        for (num in 2..n) {
            for (factor in 1 until num) {
                if (num % factor == 0) {
                    val steps = arr[factor] + num / factor
                    if (steps < arr[num]) {
                        arr[num] = steps
                    }
                }
            }
        }
        return arr[n]
    }

    fun minSteps2(n: Int): Int {
        var num = n
        var steps = 0
        var factor = 2
        while (num > 1) {
            while (num % factor == 0) {
                steps += factor
                num /= factor
            }
            factor++
        }
        return steps
    }
}