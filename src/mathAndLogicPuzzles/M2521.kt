package mathAndLogicPuzzles

// 2521. Distinct Prime Factors of Product of Array
class M2521 {
    fun distinctPrimeFactors(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        nums.forEach {
            if (it > max) {
                max = it
            }
        }

        var count = 0
        for (prime in 2..max) {
            var isPrime = true
            for (j in 2 until prime) {
                if (prime % j == 0) {
                    isPrime = false
                    break
                }
            }
            if (isPrime) {
                run loop@{
                    nums.forEach { num ->
                        if (num % prime == 0) {
                            count++
                            return@loop
                        }
                    }
                }
            }
        }

        return count
    }
}