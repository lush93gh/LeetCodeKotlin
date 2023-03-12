package recursionAndDynamicProgramming.dp

class E509 {
    fun fib(n: Int): Int {
        var a = 0
        var b = 1
        var c = a + b
        if (n == 0) return a
        if (n == 1) return b
        for (i in 2..n) {
            c = a + b
            a = b
            b = c
        }
        return c
    }

    private val cache = HashMap<Int, Int>()
    fun fib2(N: Int): Int {
        if (cache.containsKey(N)) return cache[N]!!

        val result = if (N < 2) N else fib(N - 1) + fib(N - 2)
        cache[N] = result

        return result
    }
}