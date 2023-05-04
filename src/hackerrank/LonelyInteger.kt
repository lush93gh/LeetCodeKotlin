package hackerrank

class LonelyInteger {
    fun lonelyinteger1(a: Array<Int>): Int {
        val counts = IntArray(101) { 0 }
        a.forEach {
            counts[it]++
        }
        counts.forEachIndexed { index, i ->
            if (i == 1) return index
        }
        return 0
    }

    fun lonelyinteger(a: Array<Int>): Int {
        var result = 0
        a.forEach {
            result = result.xor(it)
        }

        return result
    }
}