package mathAndLogicPuzzles

class M2572 {
    fun squareFreeSubsets(nums: IntArray): Int {
        val subset = nums.filter {
            isSquareFree(it)
        }

        return combinations(subset)
    }

    fun isSquareFree(num: Int): Boolean {
        val factors = findPrimeFactors(num)
        return !factors.groupBy { it }.values.any { it.size > 1 }
    }

    private fun findPrimeFactors(num: Int): List<Int> {
        val factors = mutableListOf<Int>()
        var number = num
        var factor = 2
        while (number > 1) {
            while (number % factor == 0) {
                factors.add(factor)
                number /= factor
            }
            factor++
        }
        return factors
    }

    fun combinations(list: List<Int>, taken: Boolean = false, hasSameFactor: Boolean = false): Int {
        return if (list.isEmpty()) {
            if (hasSameFactor) 1
            else 0
        } else if (list.size == 1) {
            if (taken) 2 else 1
        } else combinations(
            list.filter { num ->
                val factors = findPrimeFactors(list.first())
                num != 1 && !factors.any { factor -> num % factor == 0 }
            },
            true,
            list.filter { num ->
                val factors = findPrimeFactors(list.first())
                num != 1 && factors.any { factor -> num % factor == 0 }
            }.size > 1
        ) + combinations(list.drop(1), taken)
    }
}