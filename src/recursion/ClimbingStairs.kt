package recursion

class ClimbingStairs {
    private val cache = HashMap<Int, Int>()

    fun climbStairs(n: Int): Int {
        if(cache.containsKey(n)) return cache[n]!!

        val result = if(n<=2) n else climbStairs(n-1) + climbStairs(n-2)
        cache[n] = result

        return result
    }
}