package mathAndLogicPuzzles

class M2521 {
    fun distinctPrimeFactors(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        nums.forEach {
            if (it > max) {
                max = it
            }
        }
        val primes = mutableSetOf<Int>()
        for (i in 2..max) {
            var isPrime = true
            for (j in 2 until i) {
                if (i % j == 0) isPrime = false
            }
            if (isPrime) {
                primes.add(i)
            }
        }
        val set = mutableSetOf<Int>()
        nums.forEach { num ->
            primes.forEach { prime ->
                if (prime <= num && num % prime == 0) {
                    set.add(prime)
                }
            }
        }
        return set.size
    }
}