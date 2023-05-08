package hackerrank

class LegoBlocks {
    private val mod = 1_000_000_007
    private val table = LongArray(1001).apply {
        this[0] = 1
        this[1] = 1
        this[2] = 2
        this[3] = 4
        this[4] = 8
    }
    private val coffTable = mutableMapOf<Int, List<Long>>().apply {
        this[0] = listOf(1L)
    }

    fun legoBlocks(n: Int, m: Int): Int {
        // Write your code here
        val coefficients = calculateCoff(m - 1)
        var result = 0L
        var sign = 1
        var width = m
        coefficients.forEach { coefficient ->
            result += coefficient * sign * power(layer(width), n.toLong())
            result %= mod
            sign *= -1
            width--
        }
        return result.toInt()
    }

     fun layer(m: Int): Long {
        return if (table[m] != 0L) return table[m]
        else {
            val result = (((layer(m - 4) + layer(m - 3)) % mod + layer(m - 2)) % mod + layer(m - 1)) % mod
            table[m] = result
            result
        }
    }

    private fun power(n: Long, m: Long): Long {
        var result = 1L
        for (i in 0 until m) {
            result *= n
            result %= mod
        }
        return result
    }

    private fun calculateCoff(n: Int): List<Long> {
        return if (coffTable.contains(n)) coffTable[n]!!
        else {
            val prevLayer = calculateCoff(n - 1)
            val result = mutableListOf<Long>()
            result.add(1)
            for (i in 1 until prevLayer.size) {
                val sum = prevLayer[i] + prevLayer[i - 1]
                result.add(sum)
            }
            result.add(1)
            coffTable[n] = result
            result
        }
    }
}