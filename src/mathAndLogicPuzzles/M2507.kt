package mathAndLogicPuzzles

// 2507. Smallest Value After Replacing With Sum of Prime Factors
class M2507 {
    fun smallestValue(n: Int): Int {
        var number = n
        var primeFactors = findPrimeFactors(n)
        while (primeFactors.size > 1) {
            val sum = primeFactors.sum()
            if (sum == number) return number
            number = sum
            primeFactors = findPrimeFactors(number)
        }
        return number
    }

    private fun findPrimeFactors(n: Int): List<Int> {
        val result = mutableListOf<Int>()
        var number = n
        var factor = 2
        while (number > 1) {
            while (number % factor == 0) {
                result.add(factor)
                number /= factor
            }
            factor++
        }
        return result
    }
}