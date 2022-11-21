package dp

class E70 {
    fun climbStairs(n: Int): Int {
        var a = 1
        var b = 2
        var c = a + b
        if (n == 1) return a
        if (n == 2) return b
        for (i in 3..n) {
            c = a + b
            a = b
            b = c
        }
        return c
    }

    fun climbStairs2(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2
        return climbStairs(n-1) + climbStairs(n-2)
    }

    private val cache = HashMap<Int, Int>()

    fun climbStairs3(n: Int): Int {
        if(cache.containsKey(n)) return cache[n]!!

        val result = if(n<=2) n else climbStairs(n-1) + climbStairs(n-2)
        cache[n] = result

        return result
    }
}