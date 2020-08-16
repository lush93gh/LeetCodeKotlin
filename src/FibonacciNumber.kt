class FibonacciNumber {
    private val cache = HashMap<Int, Int>()

    fun fib(N: Int): Int {
        if(cache.containsKey(N)) return cache[N]!!

        val result = if(N<2) N else fib(N-1) + fib(N-2)
        cache[N] = result

        return result
    }
}